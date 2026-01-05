import java.util.Objects;

public class Clay {

    private double amount;

    public Clay(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Количество глины не может быть отрицательным");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void use(double usedClay) {
        double actualUsed = Math.min(usedClay, amount);
        amount -= actualUsed;
    }

    public boolean hasClay() {
        return amount > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Clay clay = (Clay) obj;
        return Double.compare(clay.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.format("Глина: количество %.2f единиц", amount);
    }
}