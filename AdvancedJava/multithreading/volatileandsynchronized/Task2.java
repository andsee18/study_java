package multithreading.volatileandsynchronized;

/**
 * Задание 2. Синхронизация общего счетчика (synchronized метод).
 * <p>
 * 1. Создайте класс Counter с числовым полем `count` = 0.
 * 2. Добавьте метод `increment()`, который увеличивает `count` на 1.
 * 3. Добавьте метод `getCount()`.
 * 4. В main создайте один общий объект Counter.
 * 5. Создайте два потока, в которых в цикле вызывается метод `increment()` по 100 000 раз.
 * 6. Запустите оба потока, дождитесь их завершения через `join()`.
 * 7. Выведите результат `getCount()`. В идеале должно быть 200 000.
 * 8. Убедитесь, что без `synchronized` результат бывает случайным. Добавьте `synchronized` к методу `increment()` и добейтесь правильного ответа.
 */
public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    counter.increment();
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    counter.increment();
                }
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
        System.out.println("значение = " + counter.getCount());

    }
}


class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}


