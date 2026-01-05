import java.util.Objects;

public class Swallow extends Bird implements BirdBehavior, Builder {

    private final double STRENGTH;
    private double fatigue;
    private double carriedClay;

    public Swallow(String name, Position position, double strength) {
        super(name, position);
        this.STRENGTH = strength;
        this.fatigue = 0.0;
        this.carriedClay = 0.0;
    }

    @Override
    public void fly(Position target, Weather weather) {
        if (isExhausted()) {
            rest();
        } else {
            double distance = getPosition().distanceTo(target);
            fatigue += distance * 15 / STRENGTH * weather.getWeatherRatio();
            setPosition(target);
            System.out.printf("%s летит к позиции %s (усталость: %.2f)%n",
                    getName(), target, fatigue);
        }
    }

    @Override
    public void peck(House house) {
        if (isExhausted()) {
            rest();
        } else {
            fatigue += 0.05;
            System.out.printf("%s клюет дом (усталость: %.2f)%n", getName(), fatigue);
        }
    }

    @Override
    public void chirp() {
        if (isExhausted()) {
            rest();
        } else {
            fatigue += 0.01;
            System.out.printf("%s щебечет: курлык! (усталость: %.2f)%n", getName(), fatigue);
        }
    }

    @Override
    public void circle(Position center) {
        if (isExhausted()) {
            rest();
        } else {
            fatigue += 15 / STRENGTH;
            System.out.printf("%s кружится%n", getName());
        }
    }

    @Override
    public void rest() {
        fatigue = 0;
        System.out.printf("%s отдыхает%n", getName());
    }

    @Override
    public void takeClay(Clay clay) {
        if (isExhausted()) {
            rest();
        } else if (clay.hasClay()) {
            double amount = Math.min(STRENGTH / 3, clay.getAmount());
            clay.use(amount);
            carriedClay = amount;
            fatigue += amount / 2;
            System.out.printf("%s взяла %.2f глину (усталость: %.2f)%n", getName(), amount, fatigue);
        } else {
            System.out.println("Глина в источнике закончилась");
        }
    }

    @Override
    public void coverHouse(House target, Weather weather) {
        if (isExhausted()) {
            rest();
        } else {
            double usedClay = Math.min(carriedClay, STRENGTH / 9);
            target.addClayCoverage(usedClay);
            fatigue += usedClay / 2 * weather.getWeatherRatio();
            System.out.printf("%s добавляет %.2f глины (усталость: %.2f)%n", getName(), usedClay, fatigue);
            carriedClay -= usedClay;
        }
    }

    public double getCarriedClay() {
        return carriedClay;
    }

    public boolean isExhausted() {
        return fatigue >= 50;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Swallow swallow = (Swallow) obj;
        return Double.compare(swallow.STRENGTH, STRENGTH) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), STRENGTH);
    }

    @Override
    public String toString() {
        return String.format("Ласточка '%s' на %s, сила: %.2f, усталость: %.2f", getName(), getPosition(), STRENGTH, fatigue);
    }
}