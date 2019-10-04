package sample;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.security.web.server.savedrequest.NoOpServerRequestCache;

@EnableWebFluxSecurity
public class ServerConfig {

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {

        http.requestCache().requestCache(NoOpServerRequestCache.getInstance())
            .and().securityContextRepository(NoOpServerSecurityContextRepository.getInstance());

        http.httpBasic().disable();
        http.formLogin().disable();
        http.csrf().disable();
        http.logout().disable();

        http.authorizeExchange()
                .anyExchange()
                .authenticated().and()
                .oauth2Login();


        return http.build();
    }
}