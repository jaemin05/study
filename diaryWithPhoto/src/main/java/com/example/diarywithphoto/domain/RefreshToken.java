package com.example.diarywithphoto.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RefreshToken {

    @Id
    private String username;

    private String refreshToken;

    private Long refreshExpiration;

    public RefreshToken update(Long refreshExp) {
        this.refreshExpiration = refreshExp;
        return this;
    }
}
