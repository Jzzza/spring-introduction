package com.springinaction.chapter3.postprocessor;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.logging.Logger;


public class BeanCounter implements BeanFactoryPostProcessor {
    private final Logger LOGGER = Logger.getLogger(BeanCounter.class.getName());

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        LOGGER.info("BEAN COUNT: " + configurableListableBeanFactory.getBeanDefinitionCount());
    }
}
