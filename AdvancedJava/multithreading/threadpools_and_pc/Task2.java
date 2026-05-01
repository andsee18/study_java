package multithreading.threadpools_and_pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Task2 {
    // Задача 2: Producer-Consumer (Ресторан)
    // 
    // Условие:
    // В ресторане работает Официант (Producer) и Повар (Consumer). 
    // Стол раздачи между ними вмещает максимум 3 заказа. Если стол заполнен, официант не может передать заказ 
    // и должен ждать, пока повар его заберет. Если стол пуст, повар ждет, пока появится новый заказ.
    // 
    // Требуется:
    // 1. Использовать очередь с ограниченной вместимостью размером в 3 элемента (ArrayBlockingQueue).
    // 2. Официант (1 поток) должен сгенерировать 15 заказов. Он делает это быстро (без пауз), кладет заказ в очередь 
    //    и выводит в консоль "Официант добавил заказ N".
    // 3. Повар (1 поток) берет заказы из очереди по одному. При взятии заказа он выводит "Повар взял заказ N" 
    //    и готовит его ровно 1 секунду (имитация работы).
    // 4. Запустите потоки и пронаблюдайте за блокировкой официанта, когда место на столе (в очереди) заканчивается, 
    //    и как он продолжает работу, как только повар забирает 1 заказ.
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void produce() throws InterruptedException {
        for (int i = 1; i < 16; i++) {
            queue.put(i);
            System.out.println("Официант добавил заказ N " + i);
        }
        queue.put(-1);
    }

    private static void consumer() throws InterruptedException {
        while (true) {
            int order = queue.take();
            if (order == -1){
                break;
            }
            System.out.println("Повар взял заказ N " + order);
            Thread.sleep(1000);
        }
    }
}

