package com.springinaction.chapter3.postprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorMain {
    public static void main(String[] args){

        BeanPostProcessor fuddifier = new Fuddifier();
        ApplicationContext context
                = new ClassPathXmlApplicationContext("beanprocessor.xml");
    }
}
