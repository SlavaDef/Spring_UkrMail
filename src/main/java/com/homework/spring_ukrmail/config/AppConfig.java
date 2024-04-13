/*package com.homework.spring_ukrmail.config;

import com.homework.spring_ukrmail.models.Remittance;
import com.homework.spring_ukrmail.service.RemittanceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry
        //     .addResourceHandler("/static/**") // якщо йде запит на такі файли
        //    .addResourceLocations("/WEB-INF/static/"); //  кажемо де шукати
    }

    @Bean
    public CommandLineRunner demo(final RemittanceService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Remittance remittance;

                remittance = new Remittance(222.4, "444444", "somethhing");
                service.addRem(remittance);


            }
        };
    }
}
*/