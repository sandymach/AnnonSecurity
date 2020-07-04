package com.javatpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebSecurity  
@ComponentScan("com.javatpoint") 
public class WebSecurityConfig implements WebMvcConfigurer {  
      
    @Bean  
    public UserDetailsService userDetailsService() throws Exception {  
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
        manager.createUser(User.withDefaultPasswordEncoder().username("javatpoint").  
        password("java123").roles("ADMIN").build());  
        return manager;  
    }  
      
	/*
	 * protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http .antMatcher("/index") .authorizeRequests()
	 * .anyRequest().hasRole("ADMIN") .and() .httpBasic(); }
	 */
    
    
  
    protected void configure(HttpSecurity http) throws Exception {  
                  
        http.antMatcher("/index")                            
        .authorizeRequests()  
            .anyRequest().hasRole("USER")  
            .and().formLogin().and()  
        .httpBasic()  
        .and()  
        .logout()  
        .logoutUrl("/j_spring_security_logout")  
        .logoutSuccessUrl("/home")  
        ;  
    }  
    


	 
}  
