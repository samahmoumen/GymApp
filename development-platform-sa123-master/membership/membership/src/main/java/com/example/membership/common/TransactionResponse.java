package com.example.membership.common;

import com.example.membership.model.Membership;
import lombok.*;

@Data
@Getter
@Setter

public class TransactionResponse {

  // private Member member;
    private Membership membership;
    private double amount;
    private String transactionId;
    private String message;


    public TransactionResponse(Membership membership, double amount, String transactionId, String message) {
       // this.member = member;
        this.membership = membership;
        this.amount = amount;
        this.transactionId = transactionId;
        this.message = message;
    }


}
