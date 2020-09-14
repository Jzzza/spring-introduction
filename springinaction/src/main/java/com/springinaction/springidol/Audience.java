package com.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect // Указывает, что Audience не обычный класс, а аспект
public class Audience {
    @Pointcut(  // Определение среза
            "execuion(* com.springinaction.springidol.Performer.perform(..))"
    )   // Определение среза множества точек сопряжения
    public void performance(){
    }

    // Определение советов
    @Before("performance()") // Выполняется перед вызовом целевого метода
    public void takeSeats() {  // Перед выступлением
        System.out.println("The audience is taking their seats.");
    }

    @Before("performance()") // Выполняется перед вызовом целевого метода
    public void turnOffCellPhones() { // Перед выступлением
        System.out.println("The audience is turning off their cellphones");
    }

    @AfterReturning("performance()")  // Выполняется в случае благополучного завершения следующего метода
    public void applaud() {  // После выступления
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")  // Выполняется в случае появления исключения
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
