package Pokemons;

import Attacks.*;
import ru.ifmo.se.pokemon.*;

public final class Keldeo extends Pokemon {
    public Keldeo(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.FIGHTING);
        setStats(91, 72, 90, 129, 90, 108);
        setMove(new AquaJet(), new CalmMind(), new AquaTail(), new DoubleTeam());
    }
}
