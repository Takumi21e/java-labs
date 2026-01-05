import java.util.Objects;

public abstract class Bird {

    private final String name;
    private Position position;

    public Bird(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public abstract void fly(Position target, Weather weather);

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Bird bird = (Bird) obj;
        return Objects.equals(name, bird.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%s на позиции %s", name, position);
    }
}