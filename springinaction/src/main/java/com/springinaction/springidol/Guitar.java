package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("stringed")
public class Guitar implements Instrument {
    public Guitar() {
    }

    public void play() {
        System.out.println("TR TR TR");
    }
}
