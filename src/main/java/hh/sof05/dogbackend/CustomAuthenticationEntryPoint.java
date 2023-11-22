package hh.sof05.dogbackend;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final String redirectUrl;

    public CustomAuthenticationEntryPoint(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendRedirect(redirectUrl);
    }

}
