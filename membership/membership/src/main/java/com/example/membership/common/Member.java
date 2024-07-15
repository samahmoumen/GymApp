package com.example.membership.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private int id;
    private String firstName; // Adjusted from 'name' to 'firstName'
    private String lastName;
    private String address;
   private String email;
    private String phoneNumber;




}