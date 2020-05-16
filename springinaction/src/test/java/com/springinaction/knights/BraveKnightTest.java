package com.springinaction.knights;

import static org.mockito.Mockito.*;

import org.junit.Test;

class BraveKnightTest{
    @Test
    public void knightShouldEmbarkOnQuest() throws QuestException{
        Quest mockQuest = mock(Quest.class); // Создание фиктивного объекта Quest

        BraveKnight knight = new BraveKnight(mockQuest); // Внедрение
        knight.embarkOnQuest();

        verify(mockQuest, times(1)).embark();
    }
}