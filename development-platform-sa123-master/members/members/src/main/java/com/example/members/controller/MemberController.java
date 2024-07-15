package com.example.members.controller;


import com.example.members.model.Member;

import com.example.members.service.MemberService;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/members")

public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public String add(@RequestBody Member member) {
        memberService.saveMember(member);
        return "New member is added";
    }

    @GetMapping("/getAll")
    public List<Member> getAllmembers() {
        return memberService.getAllMembers();
    }

    @PutMapping("/update/{id}")
    public Member updateMember( @RequestBody Member newMember, @PathVariable int id) {
        return memberService.updateMember(newMember, id);


    }



    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable int id) {
        return memberService.getMemberById(id);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
    }
}
