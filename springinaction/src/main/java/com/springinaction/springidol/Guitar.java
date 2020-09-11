package com.springinaction.springidol;

import com.springinaction.springidol.qualifiers.StringedInstrument;

@StringedInstrument
public class Guitar implements Instrument {
    public Guitar() {
    }

    public void play() {
        System.out.println("TR TR TR");
    }
}
