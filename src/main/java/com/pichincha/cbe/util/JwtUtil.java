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

    private JwtUtil(){}

    public static String getToken() throws JWTCreationException{
        Algorithm algorithm = Algorithm.HMAC512(SECRET);
        return JWT.create()
                .withIssuer(ISSUER)
                .sign(algorithm);
    }

    public static boolean isValid(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            verifier.verify(token);
            return true;
        }catch (JWTVerificationException e){
            log.error("Jwt verification error: {}", e);
            return false;
        }
    }

}
