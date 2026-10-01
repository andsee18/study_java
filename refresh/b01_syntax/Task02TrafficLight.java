package b01_syntax;

import java.util.Scanner;

import static java.lang.Thread.sleep;

/**
 * Задача 2. Сигнал светофора
 * <p>
 * Контроллер перекрестка получает код текущего сигнала и должен вывести
 * действие для водителя.
 * <p>
 * Входные данные:
 * - строка signal: "RED", "YELLOW" или "GREEN".
 * <p>
 * Выходные данные:
 * Выведите:
 * - "STOP" для "RED";
 * - "WAIT" для "YELLOW";
 * - "GO" для "GREEN";
 * - "UNKNOWN" для любого другого значения.
 * <p>
 * Дополнительное требование:
 * После определения действия выведите номера трех ближайших секунд ожидания
 * отдельными строками: 3, 2, 1. Для этого используйте цикл while.
 * <p>
 * Пример:
 * signal = "YELLOW"
 * <p>
 * WAIT
 * 3
 * 2
 * 1
 */
public class Task02TrafficLight {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String signal = scanner.nextLine();
        switch (signal) {
            case "RED":
                System.out.println("STOP");
                break;
            case "YELLOW":
                System.out.println("WAIT");
                break;
            case "GREEN":
                System.out.println("GO");
                break;
            default:
                System.out.println("UNKNOWN");
        }
        int x = 3;
        while(x>=1){
            sleep(1000);
            System.out.println(x);
            x--;
        }
    }
}
