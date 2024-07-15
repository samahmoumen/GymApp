package com.example.memberclass.service;

import com.example.memberclass.model.MemberClass;
import com.example.memberclass.repository.MemberClassRepository;
import com.example.memberclass.service.MemberClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberClassServiceImpl implements MemberClassService {

    @Autowired
    private MemberClassRepository memberClassRepository;

    @Override
    public MemberClass createMemberClass(MemberClass memberClass) {
        // Here you can add business logic before saving the class
        return memberClassRepository.save(memberClass);
    }

    @Override
    public MemberClass getMemberClassById(int id) {
        return memberClassRepository.findById(id).orElse(null);
        // You can add more logic here, for example, handling business rules or additional checks
    }
    public List<MemberClass> getAllMemberClasses() {
        return memberClassRepository.findAll();
    }

    // Implement additional methods as needed
}
