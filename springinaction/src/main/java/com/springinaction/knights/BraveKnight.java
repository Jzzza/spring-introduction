package com.springinaction.knights;

public class BraveKnight implements Knight {
    private Quest quest;

    // Пример внедрения зависмости через конструктор
    public BraveKnight(Quest quest){
        this.quest = quest; // Внедрение сценария подвига
    }

    public void  embarkOnQuest() throws QuestException {
        quest.embark();
    }
}
