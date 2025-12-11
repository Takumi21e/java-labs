package Pokemons;

import Attacks.*;
import ru.ifmo.se.pokemon.*;

public final class Excadrill extends Drilbur {
    public Excadrill(String name, int level) {
        super(name, level);
        setType(Type.STEEL);
        setStats(110, 135, 60, 50, 65, 88);
        setMove(new Confide(), new DrillRun(), new X_Scissor(), new BrutalSwing());
    }
}
