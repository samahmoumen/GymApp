package com.example.membership.controller;

import com.example.membership.common.Member;
import com.example.membership.common.Payment;
import com.example.membership.common.TransactionRequest;
import com.example.membership.common.TransactionResponse;
import com.example.membership.model.Membership;
import com.example.membership.service.MembershipService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/membership")
@Slf4j
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @Autowired
    private RestTemplate template;
    private static final Logger logger = LoggerFactory.getLogger(TransactionRequest.class);

    @PostMapping("/createMembership")
    public ResponseEntity<?> createMembership(@RequestBody TransactionRequest request) {
        try {
            Membership membership = request.getMembership();
            //Member member = request.getMember();

           // Member memberDetails= template.postForObject("http://localhost:8092/members/add",member, Member.class);

            if (membership == null) {
                return new ResponseEntity<>("Invalid request: Membership information is missing", HttpStatus.BAD_REQUEST);
            }

            // Save the member first
            //memberRepository.save(member);

            // Set the member for the membership entity
            //membership.setMember(member);
            Membership.MembershipType type = membership.getMembershipType();
            LocalDate startDate = membership.getMembershipStartDate();

            if (type == null || startDate == null) {
                return new ResponseEntity<>("Invalid request: Membership type or start date is missing", HttpStatus.BAD_REQUEST);
            }

            // Now save the membership
            Membership createdMembership = membershipService.createMembership(type, startDate);
            return new ResponseEntity<>(createdMembership, HttpStatus.OK);

        } catch (Exception e) {
            // Log the exception details to help diagnose the issue
            logger.error("Error creating membership: " + e.getMessage(), e);
            return new ResponseEntity<>("Failed to create membership: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/payMembership")
    @CircuitBreaker(name="payment" , fallbackMethod = "fallbackMethod")
    public TransactionResponse payMembership(@RequestBody TransactionRequest request){

       return membershipService.payMembership(request);

    }

    @PostMapping("/getMembershipCost")
    public ResponseEntity<?> getMembershipCost(@RequestBody Membership membership) {
        try {
            double cost = membership.getCostMembership();
            return new ResponseEntity<>(cost, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve membership cost: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public CompletableFuture<String> fallbackMethod(TransactionRequest request, RuntimeException runtimeException) {
        log.info("Cannot Place Order Executing Fallback logic");
        return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong, please try after some time!");
    }


}
