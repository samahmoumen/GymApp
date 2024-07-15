package com.example.membership.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {




    private Integer paymentId;
    private double amount;
    private String paymentStatus;
    private String transactionId;
    private int membershipId;
    //private int id;



}
