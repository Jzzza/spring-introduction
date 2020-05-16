package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
    public static void main(String[] args) {
        //Загрузка контекста Spring
        ApplicationContext context
                = new ClassPathXmlApplicationContext("knights.xml");

        // Получение компонента knight
        Knight knight = (Knight) context.getBean("knight");
        // Использование компонента knight
        knight.embarkOnQuest();
    }
}
