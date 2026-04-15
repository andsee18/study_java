package JavaCollectionsFramework.LinkedList;

import java.util.LinkedList;

/**
 * Задание 3:
 * Реализуйте простой класс, эмулирующий работу Очереди (Queue), используя только LinkedList.
 * Класс должен иметь 3 метода:
 * - enqueue(String element) — добавляет элемент в конец очереди.
 * - dequeue() — возвращает первый элемент и удаляет его из очереди.
 * - first() — возвращает первый элемент, не удаляя его из очереди.
 * Протестируйте работу вашей очереди в методе main.
 */
public class Task3 {
    //  "addLast()", "removeFirst()".
    private static final LinkedList<String> queue = new LinkedList<>();
    public static void main(String[] args) {
        Task3.enqueue("первый");
        Task3.enqueue("второй");
        Task3.enqueue("третий");
        System.out.println("Текущая очередь: " + queue);
        System.out.println("Извлекли из очереди: " + dequeue());
        System.out.println("Только посмотрели на первый: " + Task3.first());
        System.out.println("Итоговая очередь: " + queue);
    }

    public static void enqueue(String element) {
        queue.addLast(element);
    }
    public static String dequeue(){
        String elem = queue.getFirst();
        queue.removeFirst();
        return elem;
    }
    public static String first(){
        return queue.getFirst();
    }
}
