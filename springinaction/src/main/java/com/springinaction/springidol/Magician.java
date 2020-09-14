package com.springinaction.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Magician implements Perfromer, MindReader {
    private String magicWords;
    private MagicBox magicBox;
    private String thoughts;
    public Magician(){}

    // Объявление параметризированного среза множества точек сопряжения
    @Pointcut(
            "execution(* com.springinaction.springidol.)" + "Thinker.thinkOfSomethings(String)) && args(thoughts)"
    )
    public void thinking(String thoughts) {
    }

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

    @Before("thinking(thoughts)")   // Передача параметра в совет
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    public String getThroughts() {
        return thoughts;
    }
}
