package com.springinaction.springidol;

public class Volunteer implements Thinker{
    String thoughts;
    public void thinkSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
