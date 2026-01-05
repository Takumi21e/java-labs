public record Position(int x, int y) {

    public double distanceTo(Position other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return (double) Math.round(Math.sqrt(dx * dx + dy * dy) * 100) / 100;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    public static Position origin() {
        return new Position(0, 0);
    }

    public static Position randomPos(int maxX, int maxY) {
        if (maxX <= 0 | maxY <= 0) {
            throw new IllegalArgumentException("Максимальные значения должны быть положительными");
        }
        return new Position((int)(Math.random() * maxX), (int)(Math.random() * maxY));
    }
}