package practice.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import practice.hellospring.service.MemberService;

public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
