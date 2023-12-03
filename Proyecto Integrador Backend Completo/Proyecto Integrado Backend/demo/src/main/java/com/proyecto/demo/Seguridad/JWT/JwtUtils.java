package com.proyecto.demo.Seguridad.JWT;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;




@Component
@Slf4j
public class JwtUtils {


    @Value("${jwt.secret.key}")
    private String secretKey;
    
    
    
    
    
    @Value("${jwt.time.expiration}")
    private String timeExpiration;



    //crear un token metodo

    public String generatedAccesToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
                .signWith(getSignaturKey(), SignatureAlgorithm.HS256  )
                .compact();

    }

    //Validar el token de acceso

    public boolean isTokenValid(String token){


        try{
            Jwts.parserBuilder()
                        .setSigningKey(getSignaturKey())
                        .build()
                        .parseClaimsJws(token)
                        .getBody();
                        return true;

        }catch(Exception e){
            log.error("Token Invalido" .concat(e.getMessage()));
            return false;


        }
    }



    //Obtener el suername del token
    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }


    //obtener firma del token

    public Key getSignaturKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);

        return Keys.hmacShaKeyFor(keyBytes);
    }


    //obenter un siolo claim
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){

        Claims claims = extractAlClaims(token);
        return claimsTFunction.apply(claims);
    }







    //obtener todos los claims

    public Claims extractAlClaims(String token){

       return Jwts.parserBuilder()
                        .setSigningKey(getSignaturKey())
                        .build()
                        .parseClaimsJws(token)
                        .getBody();
                      
    }


    
}
