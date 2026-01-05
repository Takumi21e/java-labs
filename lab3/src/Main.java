import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Weather curWeather = Weather.randomWeather();
        System.out.println("Погода: " + curWeather);

        House house = new House(Position.origin());
        System.out.println("Создан: " + house);

        Clay claySource = new Clay(51.0);
        System.out.println(claySource);

        List<Swallow> swallows = new ArrayList<>();
        System.out.println("Создание стаи ласточек:");
        for (int i = 0; i < 3; i++) {
            Position swPos = Position.randomPos(100, 100);
            double strength = Math.random() * 30 + 20;

            Swallow swallow = new Swallow("Ласточка-" + i, swPos, strength);
            swallows.add(swallow);

            double distance = swPos.distanceTo(house.getPosition());
            System.out.printf("%s, расстояние до дома: %.2f, сила: %.2f%n",
                    swallow.getName(), distance, strength);
        }
        System.out.println();

        for (Swallow swallow : swallows) {
            swallow.fly(house.getPosition(), curWeather);
        }
        System.out.println();

        for (Swallow swallow : swallows) {
            swallow.takeClay(claySource);
        }
        System.out.println();

        for (Swallow swallow : swallows) {
            swallow.circle(house.getPosition());
            swallow.chirp();
        }
        System.out.println();

        int count = 0;
        boolean houseFullyCovered = false;
        int maxCycles = 100;

        while (!houseFullyCovered && count < maxCycles) {
            System.out.println("\n--- Цикл клевания " + (count + 1) + " ---");

            if ((count + 1) % 3 == 0) {
                curWeather = curWeather.next();
                System.out.println("Погода изменилась на: " + curWeather);
            }

            for (Swallow swallow : swallows) {
                if (swallow.getCarriedClay() > 0) {
                    swallow.coverHouse(house, curWeather);
                    if (house.isFullyCovered()) {
                        houseFullyCovered = true;
                        break;
                    }
                } else {
                    System.out.printf("%s израсходовала всю глину%n", swallow.getName());
                    swallow.takeClay(claySource);
                }
            }

            count++;
            System.out.println("Осталось " + claySource);
            System.out.printf("Покрытие %.2f%n", house.getClayCoverageThickness());

            double allClay = 0;
            for (Swallow swallow : swallows) {
                allClay += swallow.getCarriedClay();
            }
            if (houseFullyCovered) {
                System.out.println("УСПЕХ, дом покрыт полностью");
                break;
            } else if (!claySource.hasClay() && allClay == 0) {
                System.out.println("НЕУДАЧА, глина в источнике закончилась");
                break;
            }
        }
    }
}