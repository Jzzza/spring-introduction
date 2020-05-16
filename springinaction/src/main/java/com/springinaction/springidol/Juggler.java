package com.springinaction.springidol;

public class Juggler implements Perfromer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    public void perform() throws PerformerException{
        System.out.println("JUGGLING " + beanBags + " BEANBAGS");
    }
}
