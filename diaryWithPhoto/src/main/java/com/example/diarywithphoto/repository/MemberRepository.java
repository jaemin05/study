package com.example.diarywithphoto.repository;

import com.example.diarywithphoto.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
