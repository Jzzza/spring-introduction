package com.springinaction.springidol;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class OneManBand implements Perfromer {
    public OneManBand() {
    }

    public void perform() throws PerformerException {
        for (String key:instruments.keySet()) {
            System.out.println(key + " : ");
            Instrument instrument = instruments.get(key);
            instrument.play();
        }
    }

    private Map<String, Instrument> instruments;
//    private Properties instruments;


    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments; // Внедрение коллекции инструментов
    }

    /*public void setInstruments(Properties instruments) {
        this.instruments = instruments; // Внедрение коллекции инструментов
    }*/
}
