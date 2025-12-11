package Attacks;

import ru.ifmo.se.pokemon.*;

public class Venoshock extends SpecialMove {
    public Venoshock() {
        super(Type.POISON, 65, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon var1, double var2) {
        if (var1.getCondition() == Status.POISON) {
            var1.setMod(Stat.HP, (int) Math.round(var2) * 2);
        } else {
            var1.setMod(Stat.HP, (int) Math.round(var2));
        }
    }

    @Override
    protected String describe() {
        return "использует Venoshock";
    }
}
