package com.example.membership.service;


import com.example.membership.common.Member;
import com.example.membership.common.TransactionRequest;
import com.example.membership.common.TransactionResponse;
import com.example.membership.model.Membership;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;



public interface MembershipService {
    Membership createMembership(Membership.MembershipType type, LocalDate membershipStartDate);

    TransactionResponse payMembership(TransactionRequest request);


}
