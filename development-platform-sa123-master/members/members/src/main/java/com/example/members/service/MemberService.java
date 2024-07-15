package com.example.members.service;


import com.example.members.model.Member;


import java.util.List;
import java.util.Optional;

public interface MemberService {
    public Member saveMember(Member member);
    public List<Member> getAllMembers();
    public Member updateMember(Member member, int id);
    public Member getMemberById(int id);

    public void deleteMember(int id);








}
