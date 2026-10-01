package b01_syntax;

import java.util.Scanner;

/**
 * Задача 1. Статус доставки
 *
 * Курьерская служба хранит расстояние до клиента и признак оплаты заказа.
 * По этим данным нужно определить, можно ли передавать заказ курьеру.
 *
 * Входные данные:
 * - целое число distanceKm — расстояние до клиента в километрах;
 * - boolean isPaid — оплачен ли заказ.
 *
 * Правила:
 * - заказ можно передавать, если он оплачен и находится не дальше 10 км;
 * - во всех остальных случаях заказ нужно задержать.
 *
 * Выходные данные:
 * Выведите одну строку:
 * - "READY", если заказ можно передавать;
 * - "HOLD", если заказ нужно задержать.
 *
 * Примеры:
 * distanceKm = 7, isPaid = true  -> READY
 * distanceKm = 12, isPaid = true -> HOLD
 * distanceKm = 3, isPaid = false -> HOLD
 */
public class Task01DeliveryStatus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int distanceKm = scanner.nextInt();
        boolean isPaid = scanner.nextBoolean();

        if (distanceKm <=10 && isPaid){
            System.out.println("READY");
        } else {
            System.out.println("HOLD");
        }

    }

}
