
// 1. В консоли запросить имя пользователя.
// В зависимости от текущего времени, вывести приветствие вида 
// • "Доброе утро, <Имя>!", если время от 05:00 до 11:59
// • "Добрый день, <Имя>!", если время от 12:00 до 17:59;
// • "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
// • "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
import java.time.LocalTime;
import java.util.Scanner;

public class practice1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите Ваше Имя: ");
        String name = in.nextLine();
        in.close();
        System.out.println(name);
        LocalTime now = LocalTime.now();
        if (now.isBefore(LocalTime.parse("04:59"))) {
            System.out.printf("Доброй ночи, %s ", name);
        } else if (now.isBefore(LocalTime.parse("11:59"))) {
            System.out.printf("Доброе утро, %s ", name);
        } else if (now.isBefore(LocalTime.parse("17:59"))) {
            System.out.printf("Добрый день, %s ", name);
        } else if (now.isBefore(LocalTime.parse("22:59"))) {
            System.out.printf("Добрый вечер, %s ", name);
        }
    }
}
