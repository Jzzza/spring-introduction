package com.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
    public void takeSeats() {  // Перед выступлением
        System.out.println("The audience is taking their seats.");
    }

    public void turnOffCellPhones() { // Перед выступлением
        System.out.println("The audience is turning off their cellphones");
    }

    public void applaud() {  // После выступления
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    public void demandRefund() { // После неудачного выступления
        System.out.println("Boo! We want our money back!");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            takeSeats();
            turnOffCellPhones();
            long start = System.currentTimeMillis(); // Перед выступлением

            joinPoint.proceed();

            long end = System.currentTimeMillis();
            applaud();
            System.out.println("The performance took " + (end - start) + " milliseconds.");
        } catch (Throwable throwable) {
            System.out.println("Boo! We want our money back!");
        }

    }
}
