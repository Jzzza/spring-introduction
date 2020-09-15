package com.springinaction.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

    @DeclareParents(
            value = "com.springinaction.springidol.Performer+", // Эквивалент types-matching.
                                                                // Определение типа компонентов,
                                                                // в которые должены быть внедрен интерфейс
            defaultImpl = GraciousContestant.class              // Эквивалент атрибута defaultImpl
                                                                // определяет класс
                                                                // реализующий внедряемый интерфейс
    )
    public static Contestant contestant;                        // Определяет внедряемый интерфейс
}
