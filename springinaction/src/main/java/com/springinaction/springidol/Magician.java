package com.springinaction.springidol;

public class Magician implements Perfromer, MindReader {
    private String magicWords;
    private MagicBox magicBox;
    private String thoughts;
    public Magician(){}

    public void perform() throws PerformerException{
        System.out.println(magicWords);
        System.out.println("The magic box contains...");
        System.out.println(magicBox.getContents());
    }

    public void setMagicWords(String magicWords) {
        this.magicWords = magicWords;
    }

    public void setMagicBox(MagicBox magicBox) {
        this.magicBox = magicBox;
    }

    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    public String getThroughts() {
        return thoughts;
    }
}
