package com.springinaction.springidol;

import java.util.Collection;

public class OneManBand implements Perfromer {
    public OneManBand() {
    }

    public void perform() throws PerformerException {
        for (Instrument instrument:instruments) {
            instrument.play();
        }
    }

    private Collection<Instrument> instruments;


    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments; // Внедрение коллекции инструментов
    }
}
