package multithreading.wait_notify;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Задание 1: Пинг-Понг.
 * <p>
 * Условие:
 * Создайте два потока. Один поток должен печатать слово "Ping", а другой - слово "Pong".
 * Необходимо синхронизировать потоки с помощью методов wait() и notify() так,
 * чтобы вывод в консоль был строго по очереди:
 * Ping
 * Pong
 * Ping
 * Pong
 * ... и так 10 раз.
 * <p>
 * Требования:
 * - Использовать один общий объект для синхронизации.
 * - Использовать методы wait() и notify() или notifyAll().
 */
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        PingPong pp = new PingPong();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pp.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pp.consume();
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

class PingPong {
    private Object lock = new Object();
    private boolean isPingTurn = false;

    public void produce() throws InterruptedException {
        int count = 0;
        while (count < 10) {
            synchronized (lock) {
                while (!isPingTurn) {
                    System.out.println("Ping");
                    count++;
                    isPingTurn = true;
                    lock.notify();
                }
                if (count < 10) {
                    lock.wait();
                }
            }
        }

    }

    public void consume() throws InterruptedException {
        int count = 0;
        while (count < 10) {
            synchronized (lock) {
                while (isPingTurn) {
                    System.out.println("Pong");
                    count++;
                    isPingTurn = false;
                    lock.notify();
                }
                if (count < 10) {
                    lock.wait();
                }
            }
        }
    }
}

