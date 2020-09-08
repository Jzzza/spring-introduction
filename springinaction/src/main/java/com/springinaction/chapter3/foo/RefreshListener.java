package com.springinaction.chapter3.foo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class RefreshListener implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("invokeRefreshListener");
    }
}
