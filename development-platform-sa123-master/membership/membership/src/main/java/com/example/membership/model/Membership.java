package com.example.membership.model;

import com.example.membership.common.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

@Entity
@Table(name= "gymmembership")
@Data


public class Membership {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer membershipId;


    public enum MembershipType {
        Yearly, Three_months, One_month
    }

    @Enumerated(EnumType.STRING)

    private MembershipType membershipType;


    private LocalDate membershipStartDate;


    private static final Map<MembershipType, Double> membershipCosts = new EnumMap<>(MembershipType.class);

    static {
        // Initialize the costs for each membership type
        membershipCosts.put(MembershipType.Yearly, 1000.00);
        membershipCosts.put(MembershipType.Three_months, 600.00);
        membershipCosts.put(MembershipType.One_month, 300.00);
    }

 /*   private boolean isExpired;*/

    public Membership() {
    }

    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }


    public double getCostMembership() {
        if (membershipType == null) {
            throw new IllegalStateException("Membership type must be set before getting cost");
        }
        return membershipCosts.getOrDefault(membershipType, 0.0);
    }
}
