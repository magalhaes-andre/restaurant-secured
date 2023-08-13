package com.magalhaes.crud.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class TokenHandler {
    private static final Logger logger = LoggerFactory.getLogger(TokenHandler.class);

    String jwtSecret = "thebigsecretkeythatnooneexpectedahhhhsobigohmygodsobigwaswas";
    Long expirationInMS = new Long(500000);

    public String generateJwtToken(Authentication auth) {
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(prepareExpiraton())
                .signWith(keyFromSecret(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Date prepareExpiraton() {
        return new Date(new Date().getTime() + expirationInMS);
    }

    private Key keyFromSecret() {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(keyFromSecret()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(keyFromSecret()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }
}
