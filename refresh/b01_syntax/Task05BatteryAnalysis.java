package b01_syntax;

/**
 * Задача 5. Анализ показаний датчика
 * <p>
 * Датчик записал пять значений уровня заряда батареи робота.
 * <p>
 * Входные данные:
 * - массив int[] batteryLevels из пяти целых чисел от 0 до 100.
 * <p>
 * Выходные данные:
 * Выведите:
 * - максимальный уровень заряда;
 * - минимальный уровень заряда;
 * - количество измерений, в которых заряд был ниже 20%.
 * <p>
 * Формат вывода:
 * Максимум: <значение>
 * Минимум: <значение>
 * Ниже 20%: <количество>
 * <p>
 * Пример:
 * batteryLevels = {85, 17, 42, 12, 90}
 * <p>
 * Максимум: 90
 * Минимум: 12
 * Ниже 20%: 2
 * <p>
 * Для анализа массива используй один цикл for.
 */
public class Task05BatteryAnalysis {
    public static void main(String[] args) {
        int[] batteryLevels = {85, 17, 42, 12, 90};
        int count = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < batteryLevels.length; i++) {
            if (i == 0) {
                min = batteryLevels[i];
            }
            if (batteryLevels[i] > max) {
                max = batteryLevels[i];
            }
            if (batteryLevels[i] < min) {
                min = batteryLevels[i];
            }
            if (batteryLevels[i] < 20) {
                count++;
            }
        }
        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
        System.out.println("Ниже 20%: " + count);
    }
}
