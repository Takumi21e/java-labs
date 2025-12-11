package Attacks;

import ru.ifmo.se.pokemon.*;

public class Absorb extends SpecialMove {
    private double heal;

    public Absorb() {
        super(Type.GRASS, 20, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon var1, double damage) {
        super.applyOppDamage(var1, damage);
        this.heal = damage * 0.5;
    }

    @Override
    protected void applySelfEffects(Pokemon var1) {
        if (heal > 0) {
            var1.setMod(Stat.HP, -(int) (heal));
        }
        heal = 0;
    }

    @Override
    protected String describe() {
        return "использует Absorb";
    }
}
