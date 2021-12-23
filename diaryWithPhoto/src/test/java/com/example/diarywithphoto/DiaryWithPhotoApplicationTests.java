package com.example.diarywithphoto;

import com.example.diarywithphoto.domain.Member;
import com.example.diarywithphoto.dto.MemberDto;
import com.example.diarywithphoto.repository.MemberRepository;
import com.example.diarywithphoto.service.MemberService;
import io.swagger.annotations.Authorization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
class SecurityConfigTest {

    @Test
    void context() {

    }
}