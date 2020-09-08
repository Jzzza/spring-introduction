package com.springinaction.tainingtext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

class TrainingTextMain{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("trainingtext.xml");
        Locale locale = Locale.US;
        String text = context.getMessage("computer", new Object[0], locale);
        System.out.println(text);
    }
}