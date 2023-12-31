package id.co.indivara.miniproject.hospital.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableAspectJAutoProxy
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers("/api/auth/").permitAll()
                .antMatchers("/v2/").permitAll()
                .antMatchers("/webjars/").permitAll()
                .antMatchers("/api/v1/auth/").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/v3/api-docs").permitAll()
                .antMatchers("/v3/api-docs/").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/swagger-resources/").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/configuration/security").permitAll()
                .antMatchers("/swagger-ui/").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/").permitAll()
                .antMatchers("/auth/**") .permitAll()
                .antMatchers("/appointment/**").hasAnyAuthority("DOCTOR","ADMIN")
                .antMatchers("/medical/treatment/**").hasAnyAuthority("DOCTOR")
                .antMatchers("/medical/history/**").hasAnyAuthority("DOCTOR","ADMIN")
                .antMatchers("/address/**").hasAnyAuthority("ADMIN")
                .antMatchers("/appointment/save").hasAnyAuthority("ADMIN")
                .antMatchers("/doctor/**").hasAnyAuthority("ADMIN")
                .antMatchers("/patient/**").hasAnyAuthority("ADMIN")
                .antMatchers("/specialization/**").hasAnyAuthority("ADMIN")
                .antMatchers("/treatment/**").hasAnyAuthority("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
