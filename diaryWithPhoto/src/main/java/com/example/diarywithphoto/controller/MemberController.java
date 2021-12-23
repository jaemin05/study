package com.example.diarywithphoto.controller;

import com.example.diarywithphoto.domain.Member;
import com.example.diarywithphoto.dto.MemberDto;
import com.example.diarywithphoto.dto.SignUpDto;
import com.example.diarywithphoto.dto.TokenDto;
import com.example.diarywithphoto.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("member")
public class
MemberController {
    private final MemberService memberService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody SignUpDto signUpDto) {
        memberService.signUp(signUpDto);
    }

    @PutMapping("/")
    public TokenDto login(@RequestBody MemberDto memberDto) {
        return memberService.login(memberDto);
    }

    @GetMapping("/exist")
    public ResponseEntity<String> checkNameDuplicate(@RequestParam String username) {
        return ResponseEntity.ok(memberService.checkUsernameDuplicate(username));
    }

    @PutMapping("/reissue")
    public TokenDto reissue(@RequestHeader(name = "X-REFRESH-TOKEN") String token) {
        return memberService.reissue(token);
    }

}
