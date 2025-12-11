package Attacks;

import ru.ifmo.se.pokemon.*;

public class X_Scissor extends PhysicalMove {
    public X_Scissor() {
        super(Type.BUG, 80, 100);
    }

    @Override
    protected String describe() {
        return "использует X-Scissor";
    }
}
