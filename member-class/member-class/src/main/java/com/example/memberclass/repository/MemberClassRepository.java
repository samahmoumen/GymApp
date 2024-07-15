package com.example.memberclass.repository;

import com.example.memberclass.model.MemberClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberClassRepository extends JpaRepository<MemberClass, Integer> {
    // You can define custom methods here if needed
}