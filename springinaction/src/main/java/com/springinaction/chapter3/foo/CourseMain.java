package com.springinaction.chapter3.foo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("foo.xml");
        Course course = new Course();
        context.publishEvent(course);
    }
}
