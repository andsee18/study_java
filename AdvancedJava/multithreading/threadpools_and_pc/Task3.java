package multithreading.threadpools_and_pc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    public static  BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {
        ExecutorService consumer = Executors.newFixedThreadPool(5);
        List<Thread> threads = new ArrayList<>(3);
        for(Thread thr: threads){
            thr.
        }




//        Scanner scanner = new Scanner(System.in);
        while(true)
            consumer.submit(new Consumers());
        consumer.shutdown();



    }

    public static void produce() throws InterruptedException {
        for(int i=1;i<16;i++){
            queue.put(i);
            System.out.println("Поставщик N "+ Thread.currentThread().getId()+" привёз ящик " + i);
            Thread.sleep(300);
        }
    }
}

class Consumer implements Runnable{

    @Override
    public void run() {
        try {
            Task3.queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

