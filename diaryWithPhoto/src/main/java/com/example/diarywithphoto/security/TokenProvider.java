package com.example.diarywithphoto.security;

import com.example.diarywithphoto.Exception.TokenFailedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;


@Component
@RequiredArgsConstructor
public class TokenProvider {

    private final String secretKey = "secretKey";
    private final CustomUserDetailsService customUserDetailsService;

    private long ACCESS_TOKEN_VALID_TIME = 30 * 60 * 1000L;
    private long REFRESH_TOKEN_VALID_TIME = 60 * 60 * 24 * 7 * 1000L;

    protected String init() {
        return Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createJwtAccessToken(String username) {
        return Jwts.builder()
                .setHeaderParam("typ", "jwt")
                .setSubject(username)
                .claim("type", "access")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, init())
                .compact();
    }

    public String createJwtRefreshToken(String username) {
        return Jwts.builder()
                .setHeaderParam("typ", "jwt")
                .setSubject(username)
                .claim("type", "refresh")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, init())
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(getUsername(token).getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());//
    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return null;
    }

    public Claims getUsername(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(init())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw TokenFailedException.Exception;
        }
    }

    public boolean validateToken(String token) {
        String type = Jwts.parser().setSigningKey(init()).parseClaimsJws(token).getBody().get("type", String.class);
        return type.equals("access");
    }

    public boolean isRefreshToken(String refreshToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(init())
                    .parseClaimsJws(refreshToken)
                    .getBody();

            return claims.get("type").equals("refresh") && !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            throw TokenFailedException.Exception;
        }
    }
}
