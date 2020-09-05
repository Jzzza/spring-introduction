package com.springinaction.springidol;

public class Magician {
    private String magicWords;

    private MagicBox magicBox;
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
}
