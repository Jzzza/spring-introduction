import com.springinaction.scripting.ICoconut

class Coconut implements ICoconut {
    void drinkThemBothUp() {
        println "You put the lime in the coconut..."
        println "and drink 'em both up..."
        println "You put the lime in the coconut..."
        lime.drink()
    }

    com.springinaction.scripting.Lime lime;
}