package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void battle(){

        List<Hero> heroesList = new ArrayList<>();
        List<Beast> beastsList = new ArrayList<>();

        //Test 1
        heroesList.add(new Human("human 1", 200, 50));
        heroesList.add(new Hobbit("hobbit 1", 250, 70));
        heroesList.add(new Elf("elf 1", 170, 60));

        beastsList.add(new Orc("orc 1", 180, 60));
        beastsList.add(new Goblin("goblin 1", 150, 50));

        assertTrue(Game.battle(true, heroesList, beastsList).contains("HEROES WIN"));

        heroesList.clear();
        beastsList.clear();


        //Test 2
        heroesList.add(new Elf("elf 2", 220, 75));
        heroesList.add(new Human("human 2", 250, 65));

        beastsList.add(new Orc("orc 2", 200, 60));
        beastsList.add(new Goblin("goblin 2", 260, 95));


        assertTrue(Game.battle(true, heroesList, beastsList).contains("BEASTS WIN"));

        heroesList.clear();
        beastsList.clear();


        //Test 3
        heroesList.add(new Human("human 3", 200, 50));

        beastsList.add(new Orc("orc 3", 200, 50));

        assertTrue(Game.battle(true, heroesList, beastsList).contains("NOBODY WINS"));

        heroesList.clear();
        beastsList.clear();

    }

}