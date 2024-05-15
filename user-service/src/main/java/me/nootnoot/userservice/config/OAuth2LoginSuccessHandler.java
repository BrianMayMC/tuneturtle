package me.nootnoot.userservice.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.nootnoot.userservice.entities.RegistrationSource;
import me.nootnoot.userservice.entities.User;
import me.nootnoot.userservice.entities.UserRole;
import me.nootnoot.userservice.managers.UserManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final UserManager userManager;

    @Value("${frontend.url}")
    private String frontendUrl;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        if("github".equalsIgnoreCase(token.getAuthorizedClientRegistrationId())){
            DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
            Map<String, Object> attributes = principal.getAttributes();
            System.out.println(attributes);
            String email = "";
            Object obj = attributes.getOrDefault("email", "");
            if(obj != null){
                email = (String) obj;
            }

            String name = attributes.getOrDefault("login", "").toString();
            String finalEmail = email;
            userManager.findByName(name)
                    .ifPresentOrElse(user -> {
                        DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(user.getRole().name())),
                                attributes, "id");
                        Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(user.getRole().name())),
                                token.getAuthorizedClientRegistrationId());
                        SecurityContextHolder.getContext().setAuthentication(securityAuth);
                    }, ()->{
                        User userEntity = new User(name, finalEmail, UserRole.ROLE_USER, RegistrationSource.GITHUB);
                        userManager.save(userEntity);


                        DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
                                attributes, "id");
                        Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
                                token.getAuthorizedClientRegistrationId());
                        SecurityContextHolder.getContext().setAuthentication(securityAuth);
                    });
        }else if("google".equalsIgnoreCase(token.getAuthorizedClientRegistrationId())){
//            DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
//            System.out.println(principal);
//            Map<String, Object> attributes = principal.getAttributes();
//            System.out.println(attributes);
//            String email = "";
//            Object obj = attributes.getOrDefault("email", "");
//            if(obj != null){
//                email = (String) obj;
//            }
//
//            String name = attributes.getOrDefault("given_name", "").toString();
//            String finalEmail = email;
//            userManager.findByEmail(email)
//                    .ifPresentOrElse(user -> {
//                        DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(user.getRole().name())),
//                                attributes, "sub");
//                        Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(user.getRole().name())),
//                                token.getAuthorizedClientRegistrationId());
//                        SecurityContextHolder.getContext().setAuthentication(securityAuth);
//                    }, ()->{
//                        UserEntity userEntity = new UserEntity(name, finalEmail, UserRole.ROLE_USER, RegistrationSource.GOOGLE);
//                        userManager.save(userEntity);
//
//
//                        DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
//                                attributes, "sub");
//                        Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority(userEntity.getRole().name())),
//                                token.getAuthorizedClientRegistrationId());
//                        SecurityContextHolder.getContext().setAuthentication(securityAuth);
//                    });
        }
        this.setAlwaysUseDefaultTargetUrl(true);
//        this.setDefaultTargetUrl(frontendUrl);
        this.setDefaultTargetUrl("/api/user/");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
