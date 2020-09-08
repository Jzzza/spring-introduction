package com.springinaction.chapter3.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

public class Fuddifier implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();

        try {
            for (int i = 0;i < fields.length; i++) {  // Преобразует все
                if(fields[i].getType().equals(java.lang.String.class)){  // строковые свойства компонента
                    fields[i].setAccessible(true);
                    String original = (String) fields[i].get(bean);
                    fields[i].set(bean,fuddify(original));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }

    private String fuddify(String orig){ // Преобразует все строковые свойства компонентов
        if(orig == null) return orig;
        return orig.replaceAll("(r|l)","w")
                .replaceAll("(R|L)","W");
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException { // Перед инициализацией ничего не делает
        return bean;
    }
}
