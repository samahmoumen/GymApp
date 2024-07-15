package com.example.payment.service;

import com.example.payment.model.Payment;
import com.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){

        payment.setTransactionId(UUID.randomUUID().toString());

        return paymentRepository.save(payment);
    }
    public String paymentProcessing(){
        return new Random().nextBoolean()?"sucess":"false";
    }

    public Payment findPaymentHistoryByMembershipId(int membershipId) {
        return paymentRepository.findByMembershipId(membershipId);
    }
}
