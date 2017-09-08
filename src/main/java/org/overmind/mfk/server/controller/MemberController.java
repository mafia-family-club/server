package org.overmind.mfk.server.controller;

import org.overmind.mfk.server.exception.MemberNotFoundException;
import org.overmind.mfk.server.entry.Member;
import org.overmind.mfk.server.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.05.2017 18:31
 */
@RestController
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Member findOne(@PathVariable("id") Long id) throws MemberNotFoundException {
        return memberService.findOne(id);
    }

    @PostMapping
    public Member save(@RequestBody Member member) {
        return memberService.save(member);
    }

}
