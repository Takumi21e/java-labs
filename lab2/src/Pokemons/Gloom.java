package Pokemons;

import Attacks.*;
import ru.ifmo.se.pokemon.*;

public class Gloom extends Oddish {
    public Gloom(String name, int level) {
        super(name, level);
        setType(Type.GRASS, Type.POISON);
        setStats(60, 65, 70, 85, 75, 40);
        setMove(new DoubleTeam(), new Venoshock(), new Absorb());
    }
}
