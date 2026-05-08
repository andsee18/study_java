package multithreading.locks_and_synchronizers;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Задание 2: CountDownLatch (Гонка).
 * <p>
 * Условие:
 * В гонке участвуют 5 автомобилей (потоков).
 * <p>
 * Автомобили должны запуститься (начать выполнение метода run),
 * но не начинать "ехать" (выводить текст на экран), пока не будет
 * дана общая команда старта.
 * <p>
 * Команда старта дается главным потоком (Main), который отсчитывает:
 * "На старт!", "Внимание!", "Марш!" (используйте Thread.sleep() для задержки).
 * <p>
 * После команды "Марш!" все машины должны одновременно начать движение.
 * Главный поток должен дождаться, пока все машины доедут до финиша,
 * и только после этого вывести "Гонка завершена!".
 * <p>
 * Используйте CountDownLatch! В задаче вам может понадобиться два таких счетчика
 * (один для старта, один для финиша).
 */
public class Task2_Latch {
    static CountDownLatch latch2 = new CountDownLatch(5);
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch1 = new CountDownLatch(1);
        Condition condition = new Condition();
        ExecutorService cars = Executors.newFixedThreadPool(5);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    latch1.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                condition.drive();
            }
        };
        for (int i = 0; i < 5; i++)
            cars.submit(runnable);
        cars.shutdown();

        System.out.println("На старт!");
        Thread.sleep(2000);
        System.out.println("Внимание!");
        Thread.sleep(2000);
        System.out.println("Марш!");
        latch1.countDown();
        latch2.await();
        System.out.println("Гонка завершена!");



    }
}

class Condition {

    public void drive() {
        System.out.println("Поток с id N "+ Thread.currentThread().getId()+" начал движение!");
        Task2_Latch.latch2.countDown();
    }

}

