package pl.karwan.oauth2example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest =(HttpServletRequest) servletRequest;
      String header  = httpServletRequest.getHeader("authorization");

        if(httpServletRequest == null || !header.startsWith("Bearer ")){
            throw  new ServletException("Wrond or empty header");
        }else{

            String token = header.substring(7);
            Claims claims = Jwts.parser().setSigningKey("login").parseClaimsJws(token).getBody();
            servletRequest.setAttribute("claims" , claims);
        }
        filterChain.doFilter(servletRequest , servletResponse );
    }
}
