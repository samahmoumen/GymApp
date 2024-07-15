package com.example.membership.service;



import com.example.membership.common.Member;
import com.example.membership.common.Payment;
import com.example.membership.common.TransactionRequest;
import com.example.membership.common.TransactionResponse;
import com.example.membership.model.Membership;
import com.example.membership.repository.MembershipRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;



    @Autowired
    private RestTemplate template;


    @Override
    public Membership createMembership(Membership.MembershipType type, LocalDate membershipStartDate) {


        Membership membership = new Membership();
        membership.setMembershipType(type);
        membership.setMembershipStartDate(membershipStartDate);


        // No need to manually set the cost here, as it will be retrieved when needed

        return membershipRepository.save(membership);
    }




    @Override
    public TransactionResponse payMembership(TransactionRequest request) {
        String response = "";

        //Member member = request.getMember();
        Membership membership = request.getMembership();
        Payment payment = request.getPayment();

       // Member memberDetails= template.postForObject("http://localhost:8091/members/add",member, Member.class);




        if (membership == null || membership.getMembershipId() == null) {
            throw new IllegalArgumentException("Invalid membership details");
        }

        // Validate member details response
      /* if (memberDetails == null || memberDetails.getId() == 0) {
           throw new IllegalArgumentException("Invalid membership details");
      }*/

        // Link the payment to the membership and member details


        payment.setMembershipId(membership.getMembershipId());
        payment.setAmount(membership.getCostMembership());

        // Send payment details to external payment service
        Payment paymentResponse = template.postForObject("http://payment/payment/doPayment", payment, Payment.class);

        // Check response from payment service and create response message
        if (paymentResponse != null && "success".equalsIgnoreCase(paymentResponse.getPaymentStatus())) {
            response = "Payment processing successful";
        } else {
            response = "Payment processing failed";
        }

        // Save the membership to the database
        membershipRepository.save(membership);


        // Return a transaction response with the results
        return new TransactionResponse(membership, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }


}
