package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformerMain {
    public static void main(String[] args) throws PerformerException {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-idol.xml");
        Perfromer perfromer = (Perfromer) ctx.getBean("poeticDuke");
        perfromer.perform();
    }
}
