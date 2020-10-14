package config;

import org.springframework.context.annotation.Bean;

//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;



//@EnableWebFluxSecurity
public class UserWebSecurityConfig {
//	 @Bean
//    public MapReactiveUserDetailsService userDetailsService() {
//        UserDetails user = User
//            .withUsername("admin")
//            .password(passwordEncoder().encode("password"))
//            .roles("ADMIN")
//            .build();
//        return new MapReactiveUserDetailsService(user);
//    }
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http.csrf()
//            .disable()
//            .authorizeExchange()
//            .pathMatchers(HttpMethod.POST, "/employees/update")
//            .hasRole("ADMIN")
//            .pathMatchers("/**")
//            .permitAll()
//            .and()
//            .httpBasic();
//        return http.build();
//    }
//    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//    	return new BCryptPasswordEncoder();
//    }
}
