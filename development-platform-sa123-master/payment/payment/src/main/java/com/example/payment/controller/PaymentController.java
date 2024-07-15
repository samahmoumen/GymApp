package com.example.payment.controller;

import com.example.payment.model.Payment;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment){


        return paymentService.doPayment(payment);
    }

    public String paymentProcessing(){
        return new Random().nextBoolean()?"sucess":"false";
    }

    @GetMapping("/{membershipId}")
    public Payment findPaymentHistoryByMembershipId(@PathVariable int membershipId){
        return paymentService.findPaymentHistoryByMembershipId(membershipId);
    }
}
