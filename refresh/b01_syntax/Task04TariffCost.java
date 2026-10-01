package b01_syntax;

import java.util.Scanner;

/**
 * Задача 4. Стоимость тарифа
 * <p>
 * Интернет-провайдер получает название тарифа клиента и количество
 * дополнительных гигабайт.
 * <p>
 * Входные данные:
 * - строка tariff: "BASIC", "STANDARD" или "PREMIUM";
 * - целое число extraGb — количество дополнительных гигабайт.
 * <p>
 * Базовая стоимость тарифа:
 * - "BASIC" — 500 рублей;
 * - "STANDARD" — 800 рублей;
 * - "PREMIUM" — 1200 рублей.
 * <p>
 * Каждый дополнительный гигабайт стоит 50 рублей.
 * <p>
 * Выходные данные:
 * - для известного тарифа выведите: "Итог: <стоимость> руб.";
 * - для неизвестного тарифа выведите: "Неизвестный тариф".
 * <p>
 * Примеры:
 * tariff = "STANDARD", extraGb = 3 -> Итог: 950 руб.
 * tariff = "VIP", extraGb = 2      -> Неизвестный тариф
 * <p>
 * Для выбора базовой стоимости используй switch.
 */
public class Task04TariffCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tariff = scanner.nextLine();
        int extraGb = scanner.nextInt();
        int i = 0;
        if (extraGb > 0) {
            i = extraGb * 50;
        }
        switch (tariff) {
            case "BASIC":
                System.out.println(500 + i);
                break;
            case "STANDARD":
                System.out.println(800 + i);
                break;
            case "PREMIUM":
                System.out.println(1200 + i);
                break;
            default:
                System.out.println("Неизвестный тариф");
        }
    }
}
