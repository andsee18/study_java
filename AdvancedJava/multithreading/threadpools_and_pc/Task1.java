package multithreading.threadpools_and_pc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task1 {
    // Задача 1: Пул потоков (Фабрика игрушек)
    // 
    // Условие:
    // На фабрике собирают игрушки. Всего нужно собрать 50 игрушек.
    // У фабрики есть всего 4 конвейера (потока), которые могут работать одновременно.
    // 
    // Требуется:
    // 1. Создать пул потоков фиксированного размера (4 потока).
    // 2. Отправить в пул 50 задач. Каждая задача — это сборка одной конкретной игрушки (от 1 до 50).
    // 3. Во время сборки поток выводит сообщение: "Сборка игрушки N начата потоком X" 
    //    (где N — номер игрушки, X — имя потока).
    // 4. Сборка одной игрушки длится 500 миллисекунд.
    // 5. После сборки выводится сообщение: "Игрушка N готова."
    // 6. Главный поток должен корректно завершить работу пула потоков и дождаться, пока все 50 задач не будут выполнены, 
    //    после чего вывести "Фабрика закончила работу."

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 1; i < 51; i++)
            executor.submit(new ToyTask(i));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Фабрика закончила работу");

    }
}

class ToyTask implements Runnable {
    private int toyId;

    public ToyTask(int toyId){
        this.toyId = toyId;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Сборка игрушки N " + toyId + " начата потоком " + name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Игрушка N " + toyId + " готова.");
    }
}

