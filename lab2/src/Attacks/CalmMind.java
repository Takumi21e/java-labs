package Attacks;

import ru.ifmo.se.pokemon.*;

public class CalmMind extends StatusMove {
    public CalmMind() {
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon var1) {
        var1.setMod(Stat.SPECIAL_ATTACK, 1);
        var1.setMod(Stat.SPECIAL_DEFENSE, 1);
    }

    @Override
    protected String describe() {
        return "использует Calm Mind";
    }
}
