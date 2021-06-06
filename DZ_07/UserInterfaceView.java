package DZ_07;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scaner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города на русском");
            String city = scaner.nextLine();

            System.out.println("Введите опцию: 1-получить текущую погоду, 5-получить прогноз на 5 дней");
            String command = scaner.nextLine();

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
