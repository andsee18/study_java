package b01_syntax;

/**
 * Задача 3. Отчет по температуре оборудования
 * <p>
 * Датчик записал температуру оборудования за несколько часов работы.
 * Нужно посчитать, сколько измерений вышло за безопасный диапазон.
 * <p>
 * Входные данные:
 * - массив целых чисел temperatures;
 * - безопасный диапазон: от 15 до 30 градусов включительно.
 * <p>
 * Выходные данные:
 * Выведите:
 * - количество опасных измерений;
 * - затем через пробел все опасные температуры в том порядке,
 * в котором они встретились в массиве.
 * <p>
 * Если опасных измерений нет, после количества выведите "OK".
 * <p>
 * Примеры:
 * temperatures = {18, 31, 22, 12, 30}
 * Результат: 2 31 12
 * <p>
 * temperatures = {20, 25, 30}
 * Результат: 0 OK
 * <p>
 * Для обхода массива используйте цикл for.
 */
public class Task03TemperatureReport {
    public static void main(String[] args) {
        int[] temperatures = {20, 25, 30};
        int sum = 0;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < 15 || temperatures[i] > 30) {
                sum++;
            }
        }
        if (sum == 0) {
            System.out.println(sum + " ОК");
        } else {
            System.out.print(sum + " ");
            for (int i = 0; i < temperatures.length; i++) {
                if (temperatures[i] < 15 || temperatures[i] > 30) {
                    System.out.print(temperatures[i] + " ");
                }
            }
        }
    }
}
