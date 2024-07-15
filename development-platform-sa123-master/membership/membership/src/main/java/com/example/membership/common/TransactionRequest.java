package com.example.membership.common;

import com.example.membership.model.Membership;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    //private Member member;
    private Membership membership;
    private Payment payment;
}
