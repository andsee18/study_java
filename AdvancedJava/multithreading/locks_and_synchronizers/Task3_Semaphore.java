package multithreading.locks_and_synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Задание 3: Semaphore (Парковка).
 *
 * Условие:
 * Есть стоянка на 3 парковочных места.
 * К парковке подъезжают 10 автомобилей (каждый автомобиль - отдельный поток).
 * 
 * Если есть свободное место, автомобиль заезжает, выводит на экран 
 * "Автомобиль номер X припарковался", стоит на месте от 1 до 3 секунд 
 * (используйте Thread.sleep(какое-то время)), после чего выводит 
 * "Автомобиль номер X уехал" и освобождает место для других.
 * 
 * Если свободных мест нет, автомобиль должен ждать своей очереди, ничего 
 * не выводя (или выведя "Автомобиль X ждет место").
 * 
 * Используйте класс Semaphore для контроля количества свободных парковочных мест.
 */
public class Task3_Semaphore {
    static CountDownLatch latch1 = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {

                    semaphore.acquire();
                    Task3_Semaphore.action();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
            }
        };

        for (int i =0;i<10;i++)
            executorService.submit(runnable);
        executorService.shutdown();

        latch1.await();

        System.out.println("все уехали");

    }
    static void action() throws InterruptedException {
        System.out.println("Авто с ID "+ Thread.currentThread().getId()+" припарковалось");
        Thread.sleep(3000);
        System.out.println("Авто с ID "+ Thread.currentThread().getId()+" уехало");
        latch1.countDown();
    }

}



