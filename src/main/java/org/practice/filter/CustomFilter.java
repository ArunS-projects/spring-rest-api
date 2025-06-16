package org.practice.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

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

        // Log request details
        System.out.println("Request URI: " + httpRequest.getRequestURI());
        System.out.println("Remote Address: " + httpRequest.getRemoteAddr());

        // Proceed with the next filter in the chain or the target resource
        chain.doFilter(request, response);

        // Log after response is sent
        System.out.println("Response sent to client.");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy executed.");
    }
}