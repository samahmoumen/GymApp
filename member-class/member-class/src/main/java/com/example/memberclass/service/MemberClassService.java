package com.example.memberclass.service;

import com.example.memberclass.model.MemberClass;

import java.util.List;

public interface MemberClassService {
    MemberClass createMemberClass(MemberClass memberClass);
    MemberClass getMemberClassById(int id);
    List<MemberClass> getAllMemberClasses();
    // Additional method signatures can be added here for update, delete, etc.
}
