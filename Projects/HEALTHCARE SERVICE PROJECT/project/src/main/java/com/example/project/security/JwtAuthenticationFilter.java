package com.example.project.security;


import com.example.project.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserAuthService userAuthService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");

        String userName=null;
        String jwtToken;

        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
        {
            jwtToken = requestTokenHeader.substring(7);

            try{
               userName =  this.jwtUtil.extractUsername(jwtToken);

            }catch (Exception e){
                e.printStackTrace();
            }
            UserDetails userDetails = this.userAuthService.loadUserByUsername(userName);

            if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
            {
              UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                      new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
              usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

              SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }else{
                System.out.println("Token is not validated............");
            }


        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
