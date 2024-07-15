package com.example.memberclass.controller;

import com.example.memberclass.model.MemberClass;
import com.example.memberclass.service.MemberClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/member-classes")
public class MemberClassController {

    @Autowired
    private MemberClassService memberClassService;

    // POST endpoint to create a new class
    @PostMapping("/create")
    public ResponseEntity<MemberClass> createMemberClass(@RequestBody MemberClass memberClass) {
        try {
            // Setting the description according to the class type from the static map
            memberClass.setDescription(MemberClass.getDescriptionForClassType(memberClass.getClassType()));
            MemberClass createdClass = memberClassService.createMemberClass(memberClass);
            return new ResponseEntity<>(createdClass, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET endpoint to fetch a class by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<MemberClass> getMemberClassById(@PathVariable int id) {
        MemberClass memberClass = memberClassService.getMemberClassById(id);
        if (memberClass != null) {
            return new ResponseEntity<>(memberClass, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<MemberClass>> getAllMemberClasses() {
        List<MemberClass> classes = memberClassService.getAllMemberClasses();
        if (!classes.isEmpty()) {
            return new ResponseEntity<>(classes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
