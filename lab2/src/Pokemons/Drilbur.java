package Pokemons;

import Attacks.*;
import ru.ifmo.se.pokemon.*;

public class Drilbur extends Pokemon {
    public Drilbur(String name, int level) {
        super(name, level);
        setType(Type.GROUND);
        setStats(60, 85, 40, 30, 45, 68);
        setMove(new Confide(), new DrillRun(), new X_Scissor());
    }
}
