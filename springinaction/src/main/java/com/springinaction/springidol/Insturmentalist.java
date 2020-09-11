package com.springinaction.springidol;

import com.springinaction.springidol.qualifiers.StringedInstrument;
import com.springinaction.springidol.qualifiers.Strummed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import javax.inject.Named;

//public abstract class Insturmentalist implements Perfromer {
@Configurable("pianist")
public class Insturmentalist implements Perfromer {
    @Value("Eruption")
    private String song;

    @Inject
    @StringedInstrument
    @Strummed
    @Named("guitar")
    private Instrument instrument;
    private Integer age;

    public Insturmentalist() {
    }

    @Autowired
    public Insturmentalist(Instrument instrument) {
        this.instrument = instrument;
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

    @Autowired
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
