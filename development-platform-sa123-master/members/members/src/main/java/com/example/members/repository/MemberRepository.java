package com.example.members.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.members.model.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {


}
