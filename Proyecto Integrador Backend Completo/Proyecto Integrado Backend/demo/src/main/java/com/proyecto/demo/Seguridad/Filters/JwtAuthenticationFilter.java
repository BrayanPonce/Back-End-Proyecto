package com.proyecto.demo.Seguridad.Filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.demo.Seguridad.JWT.JwtUtils;
import com.proyecto.demo.entity.Usuario;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {
    
    @Autowired
    private JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils){
        this.jwtUtils = jwtUtils;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
     HttpServletResponse response) throws AuthenticationException {

        Usuario usuario = null;
        String USERNAME;
        String PASSWORD;
       

        try {
            usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            USERNAME = usuario.getUSERNAME();
            PASSWORD = usuario.getPASSWORD();
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
           
        } catch(IOException e){
            
            throw new RuntimeException(e);

        }


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(USERNAME, PASSWORD);
       
        return getAuthenticationManager().authenticate(authenticationToken);
    }
    




    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                                 FilterChain chain,
                                                    Authentication authResult) throws IOException, 
                                                    ServletException {
        


           User  user = (User) authResult.getPrincipal();                                           

           String token = jwtUtils.generatedAccesToken(user.getUsername());

            response.addHeader("Authorization", token);       
            
            Map<String, Object> httpReponse = new HashMap<>();
            httpReponse.put("token", token);
            httpReponse.put("Message","Authenticacion Correcta");
            httpReponse.put("Username", user.getUsername());

            response.getWriter().write(new ObjectMapper().writeValueAsString(httpReponse));
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().flush();



        super.successfulAuthentication(request, response, chain, authResult);
    }

    
}
