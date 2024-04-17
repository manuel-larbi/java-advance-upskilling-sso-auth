package org.manuel.ssoauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Value("${spring.security.oauth2.client.registration.github.client-id}")
//    private String clientId;
//    @Value("${spring.security.oauth2.client.registration.github.client-secret}")
//    private String secret;
//    @Value("${spring.security.oauth2.client.registration.github.redirect-uri}")
//    private String redirectURI;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/", "/error", "/webjars/**","/api/**").permitAll();
                    auth.anyRequest().permitAll();
                })
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .logout(l -> l.logoutSuccessUrl("/").permitAll())
                .oauth2Login(withDefaults())
                .build();
    }

//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//            return new InMemoryClientRegistrationRepository(githubClientRegistration());
//    }
//    private ClientRegistration githubClientRegistration() {
//        System.out.println("Github client registration");
//        return CommonOAuth2Provider.GITHUB.getBuilder("github")
//                .clientId(clientId)
//                .clientSecret(secret)
//                .redirectUri("{baseUrl}" +redirectURI)
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
////                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .build();
//    }
//
}