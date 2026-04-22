package multithreading;

public class Task1 {
    // Вводное задание: Основы многопоточности
    // Задача:
    // 1. Создай свой класс, который наследуется от класса Thread. 
    //    В его методе run() выведи в консоль числа от 1 до 10. После каждого вывода числа поток должен засыпать на 500 миллисекунд (используй Thread.sleep).
    //
    // 2. Создай второй класс, который реализует интерфейс Runnable.
    //    В его методе run() выведи в консоль числа в обратном порядке от 10 до 1 (или буквы от A до J). После каждого вывода поток также должен засыпать на 500 миллисекунд.
    //
    // 3. В методе main() создай потоки из этих двух классов и запусти их так, чтобы они работали параллельно.
    //
    // 4. Запусти программу и понаблюдай за тем, как их вывод перемешивается в консоли.

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10;i>0;i--){
                    System.out.println(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        MyThread thread1 = new MyThread();
        thread.start();
        thread1.start();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

