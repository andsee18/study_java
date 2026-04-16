package JavaCollectionsFramework.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Задание 1 (Очередь - Базовое):
 * Задача: Моделирование очереди в магазине/больнице.
 * Вы должны создать обычную очередь обслуживания клиентов (Queue<String>).
 * 1. Создайте экземпляр Queue (обычно через интерфейс Queue и реализацию LinkedList или ArrayDeque).
 * 2. Добавьте в нее имена 4-5 "людей" / клиентов.
 * 3. Используя цикл while(!queue.isEmpty()), начните "обслуживать" клиентов:
 *    - Извлекайте их по одному с помощью poll() и выводите сообщение "Обслужен клиент: {имя}".
 *    - Попутно попробуйте вывести того, кто стоит следующим в очереди без извлечения (используя peek()).
 */
public class Task1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Bob");
        queue.add("Carrol");
        queue.add("Elena");
        queue.add("Jack");
        queue.add("Sofia");
        while(!queue.isEmpty()){
            System.out.println("обслужен клиент " + queue.poll());
            System.out.println(queue.peek());
        }

    }
}

