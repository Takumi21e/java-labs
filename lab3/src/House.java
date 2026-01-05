import java.util.Objects;

public class House {

    private final Position position;
    private double clayCoverageThickness;

    public House(Position position) {
        this.position = position;
        this.clayCoverageThickness = 0.0;
    }

    public Position getPosition() {
        return position;
    }

    public double getClayCoverageThickness() {
        return clayCoverageThickness;
    }

    public void addClayCoverage(double thickness) {
        clayCoverageThickness += thickness;
    }

    public boolean isFullyCovered() {
        return clayCoverageThickness >= 50;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        House house = (House) obj;
        return Objects.equals(position, house.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return String.format("Дом на позиции %s (толщина глины: %.2f)",
                position,    clayCoverageThickness);
    }
}