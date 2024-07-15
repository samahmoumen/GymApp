package com.example.members.service;


import com.example.members.service.MemberService;
import com.example.members.exception.UserNotFoundException;
import com.example.members.model.Member;

import com.example.members.repository.MemberRepository;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@Service
public class MemberServiceImpl implements  MemberService{

    @Autowired
    private MemberRepository memberRepository;





    @Override
    public Member saveMember(Member member) {

        return memberRepository.save(member);

    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    @Override
    public Member updateMember( Member member, int id) {
        return memberRepository.findById(id).map(st-> {
            st.setFirstName(member.getFirstName());
            st.setLastName(member.getLastName());
            st.setAddress(member.getAddress());
            st.setEmail(member.getEmail());
            st.setPhoneNumber(member.getPhoneNumber());



            return memberRepository.save(st);
        }).orElseThrow(()-> new UserNotFoundException("this member is not found"));



    }

    @Override
    public Member getMemberById(int id) {

        return memberRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("this member is not found"));
    }
    @Override
    public void deleteMember(@PathVariable int id) {
        if(!memberRepository.existsById(id)){
            throw new UserNotFoundException("member not found");
        }
        memberRepository.deleteById(id);

    }




}
