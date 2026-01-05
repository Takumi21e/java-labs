public enum Weather {
    SUNNY("Ясно", 1.0),
    CLOUDY("Облачно", 1.5),
    OVERCAST("Пасмурно", 2.0);

    private final String displayName;
    private final double weatherRatio;

    Weather(String displayName, double weatherRatio) {
        this.displayName = displayName;
        this.weatherRatio = weatherRatio;
    }

    public double getWeatherRatio() {
        return weatherRatio;
    }

    public static Weather randomWeather() {
        double random = Math.random();
        if (random < 0.5) return SUNNY;
        if (random < 0.8) return CLOUDY;
        return OVERCAST;
    }

    public Weather next() {
        return switch (this) {
            case SUNNY -> CLOUDY;
            case CLOUDY -> OVERCAST;
            case OVERCAST -> SUNNY;
        };
    }

    @Override
    public String toString() {
        return displayName;
    }
}