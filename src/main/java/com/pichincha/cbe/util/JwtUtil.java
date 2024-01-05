package com.pichincha.cbe.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUtil {


    private static final String SECRET = "superDuperSecretePhrase";
    private static final String ISSUER = "pichinchaAut1";

    private static final Algorithm ALGORITHM = Algorithm.HMAC512(SECRET);
    private static final JWTVerifier VERIFIER = JWT.require(ALGORITHM)
            .withIssuer(ISSUER)
            .build();


    private JwtUtil(){}

    public static String getToken(String user) throws JWTCreationException{
        return JWT.create()
                .withIssuer(ISSUER)
                .withClaim("UID", user)
                .sign(ALGORITHM);
    }

    public static boolean isValid(String token){
        try {
            VERIFIER.verify(token);
            return true;
        }catch (JWTVerificationException e){
            log.error("Jwt verification error: {}", e);
            return false;
        }
    }

}
