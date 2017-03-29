package br.edu.ufcg.computacao.si1.model.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by gersonsales on 26/03/17.
 */
public class AuthenticationHandler implements AuthenticationSuccessHandler{

    private RedirectStrategy redirectStrategy;

    public AuthenticationHandler() {
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        handle(httpServletRequest, httpServletResponse, authentication);
        clearAuthenticationAttribustes(httpServletRequest);
    }

    private void clearAuthenticationAttribustes(final HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession(false);
        if (httpSession != null) {
            httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }

    }

    private void handle(final HttpServletRequest httpServletRequest,
                        final HttpServletResponse httpServletResponse,
                        final Authentication authentication) throws IOException {

        String targetUrl = determineTargetUrl(authentication);

        if (httpServletResponse.isCommitted()) {
            System.out.println("Error while redirecting " + targetUrl);
        }else {
            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, targetUrl);
        }

    }

    private String determineTargetUrl(final Authentication authentication) {
        return "/advertisement/form";
    }



}
