package multithreading.wait_notify;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Задание 2: Простой Producer-Consumer (Один товар).
 * <p>
 * Условие:
 * Есть магазин, в котором может храниться только один товар.
 * Создайте два потока: Производитель (Producer) и Потребитель (Consumer).
 * Производитель может положить товар в магазин, только если магазин пуст.
 * Потребитель может забрать товар из магазина, только если он там есть.
 * <p>
 * Пусть Производитель сделает 5 поставок, а Потребитель 5 покупок.
 * Выводите в консоль соответствующие сообщения: "Производитель положил товар", "Потребитель забрал товар".
 * <p>
 * Требования:
 * - Реализовать логику с использованием wait() и notify() в методах магазина (put и get).
 */
public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    shop.put();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    shop.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


    }
}

class Shop {
    private boolean isProduct = false;
    private final Object lock = new Object();

    public void put() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                while (isProduct) {
                    lock.wait();
                }
                isProduct = true;
                System.out.println("Производитель положил товар");
                lock.notify();
            }
        }
    }

    public void get() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                while (!isProduct) {
                    lock.wait();
                }
                isProduct = false;
                System.out.println("Потребитель забрал товар");
                lock.notify();
            }
        }
    }
}
