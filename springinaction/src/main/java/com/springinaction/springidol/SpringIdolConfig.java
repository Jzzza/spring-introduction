package com.springinaction.springidol;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIdolConfig {
    // Здесь находятся методы, определяющие компоненты
    @Bean
    public Perfromer duke(){
        return new Juggler();
    }

    @Bean
    public Perfromer duke15(){
        return new Juggler(15);
    }
}
