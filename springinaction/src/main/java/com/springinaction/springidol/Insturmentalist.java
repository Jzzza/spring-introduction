package com.springinaction.springidol;

public class Insturmentalist implements Perfromer {
    private String song;
    private Instrument instrument;

    public Insturmentalist() {
    }

    public void perform() throws PerformerException {
        System.out.println("Playing " + song + " : ");
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
}
