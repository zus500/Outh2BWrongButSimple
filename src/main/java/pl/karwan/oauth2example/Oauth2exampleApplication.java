package pl.karwan.oauth2example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class Oauth2exampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2exampleApplication.class, args);

        }
        @Bean
        public FilterRegistrationBean filterRegistrationBean() {
            FilterRegistrationBean filterRegistrationBean1 = new FilterRegistrationBean();
            filterRegistrationBean1.setFilter(new JwtFilter());
            filterRegistrationBean1.setUrlPatterns(Collections.singleton("/api"));
            return filterRegistrationBean1;
        }
    }


