package com.springinaction.springidol;

import org.springframework.beans.factory.annotation.Configurable;

//public abstract class Insturmentalist implements Perfromer {
@Configurable("pianist")
public class Insturmentalist implements Perfromer {
    private String song;
    private Instrument instrument;
    private Integer age;

    public Insturmentalist() {
    }

//    public abstract Instrument getInstrument();

    public void perform() throws PerformerException {
        System.out.print("Playing " + song + " : ");
//        getInstrument().play();
        instrument.play();
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public String screamSong() {
        return song;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
