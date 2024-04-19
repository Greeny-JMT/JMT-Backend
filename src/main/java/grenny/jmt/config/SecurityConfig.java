package grenny.jmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@EnableWebFluxSecurity
@Slf4j
public class SecurityConfig {

//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity security) {
//        security.csrf().disable()
//            .cors().disable()
//            .formLogin().disable()
//            .httpBasic().disable()
//            .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
//            .exceptionHandling()
//            .authenticationEntryPoint(serverAuthenticationEntryPoint())
//            .and()
//            .authorizeExchange()
//            .pathMatchers(NO_AUTH_LIST)
//            .permitAll()
//            .anyExchange()
//            .authenticated()
//            .and()
//            .anonymous().disable()
//            .logout().disable()
//            .headers()
//            .frameOptions()
//            .mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN)
//            .and()
//            .addFilterBefore(authenticationWebFilter(), SecurityWebFiltersOrder.AUTHENTICATION);
//        return security.build();
//    }
//
//    private ServerAuthenticationEntryPoint serverAuthenticationEntryPoint(){
//        return (exchange, authEx) -> {
//            String requestPath = exchange.getRequest().getPath().value();
//
//            log.error("Unauthorized error: {}", authEx.getMessage());
//            log.error("Requested path    : {}", requestPath);
//
//            ServerHttpResponse serverHttpResponse = exchange.getResponse();
//            serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//            serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
//
//            ErrorMessage errorMessage = new ErrorMessage(HttpStatus.UNAUTHORIZED.value()
//                , LocalDateTime.now()
//                , authEx.getMessage()
//                , requestPath);
//
//            try {
//                byte[] errorByte = new ObjectMapper()
//                    .registerModule(new JavaTimeModule())
//                    .writeValueAsBytes(errorMessage);
//                DataBuffer dataBuffer = serverHttpResponse.bufferFactory().wrap(errorByte);
//                return serverHttpResponse.writeWith(Mono.just(dataBuffer));
//            } catch (JsonProcessingException e) {
//                log.error(e.getMessage(), e);
//                return serverHttpResponse.setComplete();
//            }
//        };
//    }
}
