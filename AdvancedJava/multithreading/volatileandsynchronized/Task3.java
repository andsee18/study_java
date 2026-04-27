package multithreading.volatileandsynchronized;

/**
 * Задание 3. Синхронизация блока кода (synchronized block).
 * <p>
 * 1. Создайте класс BankAccount с балансом (например, 10_000).
 * 2. Добавьте метод `withdraw(int amount)`, который снимает деньги со счета. Метод НЕ должен быть `synchronized` целиком.
 * 3. Внутри метода `withdraw` сделайте небольшую паузу (Thread.sleep(1)), а затем синхронизируйте только логику изменения баланса через `synchronized(this) { ... }`, или создав специальный `private final Object lock = new Object();`.
 * 4. Создайте несколько потоков, каждый из которых пытается снять, допустим, 500 рублей много раз подряд (например, 10 раз).
 * 5. В main запустите эти потоки и дождитесь их завершения (join).
 * 6. Выведите итоговый баланс. Убедитесь, что никто не снял лишних денег и счет сходится.
 */
public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc1 = new BankAccount();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    acc1.withdraw(500);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    acc1.withdraw(500);
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    acc1.withdraw(500);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("Итоговый баланс = "+ acc1.getBalance());

    }
}

class BankAccount {
    private int balance = 100000;

    public void withdraw(int amount) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this) {
            balance = balance - amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}

