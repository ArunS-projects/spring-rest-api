package org.practice.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import org.practice.auth.AuthenticationService;
import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init executed.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        try {
//            Authentication auth = AuthenticationService.getAuthentication(httpRequest);
//            SecurityContextHolder.getContext().setAuthentication(auth);

            // Log request details
            System.out.println("Inside filter-Request URI: " + httpRequest.getRequestURI());
            System.out.println("Inside filter-Remote Address: " + httpRequest.getRemoteAddr());

            // Proceed with the next filter in the chain or the target resource
            chain.doFilter(request, response);
        } catch (Exception ex) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        }

        // Log after response is sent
        System.out.println("Response sent to client.");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy executed.");
    }
}