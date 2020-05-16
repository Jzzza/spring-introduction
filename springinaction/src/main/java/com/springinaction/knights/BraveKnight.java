package com.springinaction.knights;

public class BraveKnight implements Knight {
    private Quest quest;
    private Minstrel minstrel;

    // Пример внедрения зависмости через конструктор
    public BraveKnight(Quest quest, Minstrel minstrel){
        this.quest = quest; // Внедрение сценария подвига
        this.minstrel = minstrel;
    }

    public void  embarkOnQuest() throws QuestException {
        minstrel.singBeforeQuest(); // Должен ли рыцарь руководить своим менестрелем?
        quest.embark();
        minstrel.singAfterQuest();
    }
}
