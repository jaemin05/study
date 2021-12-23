package com.example.diarywithphoto.service;

import com.example.diarywithphoto.Exception.PasswordNotCorrectException;
import com.example.diarywithphoto.Exception.TokenFailedException;
import com.example.diarywithphoto.Exception.UserAlreadyExistsException;
import com.example.diarywithphoto.Exception.UserNotFoundException;
import com.example.diarywithphoto.domain.Member;
import com.example.diarywithphoto.domain.RefreshToken;
import com.example.diarywithphoto.domain.RefreshTokenRepository;
import com.example.diarywithphoto.dto.MemberDto;
import com.example.diarywithphoto.dto.SignUpDto;
import com.example.diarywithphoto.dto.TokenDto;
import com.example.diarywithphoto.repository.MemberRepository;
import com.example.diarywithphoto.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private long REFRESH_TOKEN_VALID_TIME = 60 * 60 * 24 * 7 * 1000L;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;


    @Transactional
    public void signUp(SignUpDto signUpDto) {
        memberRepository.save(Member.builder()
                .username(signUpDto.getUsername())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .nickname(signUpDto.getNickname())
                .build());
    }

    public TokenDto login(MemberDto memberDto) {
        Member member = memberRepository.findByUsername(memberDto.getUsername()).orElseThrow(() -> UserNotFoundException.Exception);

        if (!passwordEncoder.matches(memberDto.getPassword(), member.getPassword())) {
            throw PasswordNotCorrectException.Exception;
        }
        return createToken(memberDto.getUsername());
    }

    @Transactional
    public TokenDto reissue(String refreshToken) {
        if (!tokenProvider.isRefreshToken(refreshToken)) {
            throw TokenFailedException.Exception;
        }

        RefreshToken newRefreshToken = refreshTokenRepository.findByRefreshToken(refreshToken)
                .map(refresh -> refreshTokenRepository.save(
                        refresh.update(REFRESH_TOKEN_VALID_TIME)
                ))
                .orElseThrow(() -> TokenFailedException.Exception);

        return new TokenDto(tokenProvider.createJwtAccessToken(newRefreshToken.getUsername()), refreshToken);
    }

    @Transactional
    public TokenDto createToken(String username) {
        String accessToken = tokenProvider.createJwtAccessToken(username);
        String refreshToken = tokenProvider.createJwtRefreshToken(username);

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .username(username)
                        .refreshToken(refreshToken)
                        .refreshExpiration(REFRESH_TOKEN_VALID_TIME)
                        .build());

        return new TokenDto(accessToken, refreshToken);
    }

    public String checkUsernameDuplicate(String username) {
        Optional<Member> member = memberRepository.findByUsername(username);
        if (member.isPresent()) {
            throw UserAlreadyExistsException.Exception;
        }
        return "사용 가능한 이름입니다";
    }

}
