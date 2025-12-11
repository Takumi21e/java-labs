import Pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Pokemon[] allies = {new Keldeo("keldeo", 1), new Drilbur("drilbur", 1), new Excadrill("excadrill", 1)};
        Pokemon[] foes = {new Oddish("oddish", 1), new Gloom("gloom", 1), new Bellossom("bellossom", 1)};

        for (Pokemon p: allies){
            battle.addAlly(p);
        }
        for (Pokemon p: foes){
            battle.addFoe(p);
        }

        battle.go();
    }
}
