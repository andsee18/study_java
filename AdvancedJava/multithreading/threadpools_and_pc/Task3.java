package multithreading.threadpools_and_pc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Task3 {
    // Задача 3: Логистический центр (Producer-Consumer + Thread Pool)
    // 
    // Условие:
    // Поставщики привозят товары на склад, а грузчики склада эти товары забирают и расставляют.
    // Место на разгрузочном пандусе (в очереди) ограничено — максимум 10 ящиков.
    // 
    // Требуется:
    // 1. Создать очередь с ограничением в 10 элементов.
    // 2. Создать 3 потока-Поставщика (Producers). Каждый из них привозит по 15 ящиков (выводит сообщение "Поставщик X привез ящик Y"). 
    //    Для реалистичности каждый поставщик делает паузу 300мс перед каждой новой доставкой.
    // 3. Создать Пул потоков (ExecutorService) из 5 Грузчиков (Consumers).
    // 4. Грузчики в бесконечном цикле (или до прерывания) берут ящики с пандуса (из очереди). 
    //    При взятии ящика грузчик выводит "Грузчик X забрал ящик Y" и тратит 1 секунду на его расстановку.
    // 5. ДОПОЛНИТЕЛЬНАЯ СЛОЖНОСТЬ (подумай над этим сам): как сделать так, чтобы пул грузчиков корректно 
    //    был остановлен (shutdown), когда все поставщики закончат свою работу и все ящики будут перенесены (очередь станет пустой)?
    public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        List<Thread> producers = new ArrayList<>(3);
        ExecutorService consumer = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            producers.add(i, new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        produce();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }));
        }
        for (Thread thr : producers) {
            thr.start();
        }
        for(int i =0;i<5;i++)
            consumer.submit(new Consumer());
        consumer.shutdown();
        for (Thread thr : producers) {
            try {
                thr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < 5; i++) {
            queue.put(-1);
        }

        consumer.awaitTermination(1, TimeUnit.DAYS);


    }

    public static void produce() throws InterruptedException {
        for (int i = 1; i < 16; i++) {
            queue.put(i);
            System.out.println("Поставщик N " + Thread.currentThread().getId() + " привёз ящик " + i);
            Thread.sleep(300);
        }
    }
}

class Consumer implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                int value = Task3.queue.take();
                if (value == -1) {
                    break;
                } else {
                    System.out.println("грузчик " + Thread.currentThread().getId() + " забрал ящик " + value);
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
