package multithreading.locks_and_synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 * Разминочное задание: "Автомойка"
 *
 * Условие:
 * У нас есть автомойка, в которой всего 2 места для машин (боксы).
 * К нам приезжают 5 машин (каждая машина - это отдельный поток или задача для пула потоков).
 *
 * Требования:
 * 1. Используй Semaphore для того, чтобы ограничить количество машин, моющихся одновременно (ровно 2).
 *    Каждая машина должна:
 *      - Сообщить, что подъехала к мойке.
 *      - Получить разрешение (встать в бокс).
 *      - Мыться 1-2 секунды (Thread.sleep).
 *      - Закончить мытье и освободить бокс.
 * 2. Используй CountDownLatch в главном потоке, чтобы дождаться, пока все 5 машин закончат мыться.
 *    - После того как все помоются, главный поток должен вывести: "Все машины помыты. Автомойка закрывается!"
 *
 * Это задание поможет тебе вспомнить Семафор (ограничение ресурсов) и Latch (ожидание завершения всех потоков).
 */
public class WarmupTask {
    static CountDownLatch latch1 = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Semaphore semaphore = new Semaphore(2);
        CarWash carWash = new CarWash();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Машина ID " + Thread.currentThread().getId() + " подъехала к мойке...");
                try {
                    semaphore.acquire();
                    carWash.wash();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }

            }
        };
        for (int i = 0; i < 5; i++)
            executorService.submit(runnable);
        executorService.shutdown();
        latch1.await();


        System.out.println("Все машины помыты. Автомойка закрывается!");


    }
}

class CarWash {
    public void wash() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Машина ID " + Thread.currentThread().getId() + " помылась!");
        WarmupTask.latch1.countDown();
    }
}


