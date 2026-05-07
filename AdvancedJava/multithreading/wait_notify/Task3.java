package multithreading.wait_notify;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Задание 3: Producer-Consumer с очередью (Склад).
 * <p>
 * Условие:
 * Реализуйте склад, который может вместить максимум 3 товара.
 * В качестве хранилища товаров используйте обычный LinkedList или Queue (без использования классов из java.util.concurrent!).
 * <p>
 * Создайте класс Склад с двумя методами:
 * - добавитьТовар()
 * - забратьТовар()
 * <p>
 * Если склад заполнен (размер == 3), Производитель должен ждать (wait).
 * Если склад пуст (размер == 0), Потребитель должен ждать (wait).
 * <p>
 * Создайте один поток-Производитель, который бесконечно (или например 20 раз) производит товары,
 * и два потока-Потребителя, которые бесконечно их забирают.
 * Сделайте Thread.sleep() в потоках, чтобы процесс шел не слишком быстро и было удобно наблюдать за выводом.
 */
public class Task3 {
    static List<Integer> products = new LinkedList<>();

    public static void main(String[] args) {
        Warehouse wh = new Warehouse();
        Thread produce1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        wh.addProduct(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        Thread consume1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        wh.takeProduct();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        Thread consume2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        wh.takeProduct();
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        produce1.start();
        consume1.start();
        consume2.start();

        try {
            produce1.join();
            consume1.join();
            consume2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Warehouse {
    final Object lock = new Object();

    public void addProduct(int i) throws InterruptedException {
        synchronized (lock) {
            while (Task3.products.size() == 3) {
                lock.wait();
            }
            int value = i;
            Task3.products.add(value);
            System.out.println("Добавлен продукт N " + value);
            lock.notifyAll();
        }
    }

    public void takeProduct() throws InterruptedException {
        synchronized (lock) {
            while (Task3.products.isEmpty()) {
                lock.wait();
            }
            int value = Task3.products.removeLast();
            System.out.println("Забран продукт N " + value);
            lock.notifyAll();
        }
    }

}

