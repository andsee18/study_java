package JavaCollectionsFramework.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Задание 2 (Очередь - Среднее):
 * Задача: Игра "Горячая картошка"
 * Суть: Есть N детей, стоящих в кругу. Они передают друг другу картошку
 * по кругу каждый ход. После K передач, ребенок, у которого оказалась картошка,
 * выбывает из игры. Игра продолжается до тех пор, пока не останется только 1 победитель.
 * <p>
 * Напишите код, который определит победителя игры для заданного массива имен и числа K.
 */
public class Task2 {
    public static void main(String[] args) {
        String[] children = {"Иван", "Мария", "Сергей", "Анна", "Петр", "Елена"};
        int passes = 3; // (Передач через K-человек до выбывания).
        Queue<String> childrenQueue = new LinkedList<>();
        childrenQueue.addAll(Arrays.asList(children));
        int count = 0;
        while (childrenQueue.size()!=1) {
            if (count == passes) {
                System.out.println("ребенок " + childrenQueue.poll()+ " проиграл");
                count = 0;
            } else {
                String name = childrenQueue.peek();
                childrenQueue.poll();
                childrenQueue.add(name);
                count++;
            }
        }
        System.out.println("ребенок "+ childrenQueue.poll()+ " выиграл!");
    }
}
