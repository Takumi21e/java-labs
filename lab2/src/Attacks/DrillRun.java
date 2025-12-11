package Attacks;

import ru.ifmo.se.pokemon.*;

public class DrillRun extends PhysicalMove {
    public DrillRun() {
        super(Type.GROUND, 80, 95);
    }

    @Override
    protected double calcCriticalHit(Pokemon var1, Pokemon var2) {
        if ((double) 1.0F / (double) 8.0F > Math.random()) {
            System.out.println("Критический удар!");
            return (double) 2.0F;
        } else {
            return (double) 1.0F;
        }
    }

    @Override
    protected String describe() {
        return "использует Drill Run";
    }
}
