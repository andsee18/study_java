package multithreading.locks_and_synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Задание 1: ReentrantLock (Банковский счет).
 * <p>
 * Условие:
 * Реализуйте класс BankAccount, хранящий баланс (int balance).
 * У счета должны быть методы:
 * - deposit(int amount)
 * - withdraw(int amount)
 * <p>
 * Доступ к изменению баланса должен быть защищен с помощью ReentrantLock.
 * Создайте 5 потоков, которые делают по 1000 операций пополнения на 10 рублей,
 * и 5 потоков, которые делают по 1000 операций снятия по 10 рублей.
 * <p>
 * В конце работы всех потоков выведите итоговый баланс. Если всё сделано верно,
 * итоговый баланс должен быть равен начальному.
 */
public class Task1_Lock {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc1 = new BankAccount();
        ExecutorService threadsProduce = Executors.newFixedThreadPool(5);
        ExecutorService threadsConsume = Executors.newFixedThreadPool(5);

        Runnable depositTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    acc1.deposit(10);
            }
        };

        Runnable withDraw = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++)
                    acc1.withdraw(10);
            }
        };

        for (int i = 0; i < 5; i++)
            threadsProduce.submit(depositTask);

        for (int i = 0; i < 5; i++)
            threadsConsume.submit(withDraw);


        threadsProduce.shutdown();
        threadsConsume.shutdown();

        threadsConsume.awaitTermination(1, TimeUnit.DAYS);
        threadsProduce.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Баланс = " + acc1.getBalance());


    }
}

class BankAccount {
    private Lock lock = new ReentrantLock();
    private int balance;

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}

