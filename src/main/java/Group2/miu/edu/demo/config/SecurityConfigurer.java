package Group2.miu.edu.demo.config;

import Group2.miu.edu.demo.filter.JwtFilter;
import Group2.miu.edu.demo.service.userDetails.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


@Service
@EnableWebSecurity
@CrossOrigin("*")
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests() //
                //.antMatchers( "/admin/**").hasRole("ADMIN")
                .antMatchers("/", "/h2/**").permitAll()
//                .antMatchers("/api/auth/authenticate/**").permitAll()
                .antMatchers("/**/authenticate").permitAll()
                .antMatchers("/**/users").permitAll()
//                .antMatchers("/**/products").permitAll()
                .antMatchers("/**/products/**").permitAll()
                .antMatchers("/**/products").permitAll()
//                .antMatchers("/users/**").hasAuthority("ADMIN")
//                .antMatchers("/**/admin").hasAuthority("ADMIN")
//                .antMatchers("/**/orders").hasAuthority("CUSTOMER")
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().sameOrigin(); // to show my database
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
