package multithreading.volatileandsynchronized;

/**
 * Задание 1. Проблема видимости (volatile).
 * 
 * 1. Создайте класс-поток (наследующий Thread).
 * 2. В этом классе должно быть булево поле `running` (по умолчанию true) и метод `stopRunning()`, который меняет его на false.
 * 3. В методе `run()` сделайте бесконечный цикл `while(running)`, внутри которого ничего не пишите (или просто объявляйте пустую переменную).
 * 4. В главном потоке (main) запустите этот поток.
 * 5. Подождите 1 секунду (Thread.sleep(1000)).
 * 6. Вызовите метод `stopRunning()`, чтобы остановить запущенный поток.
 * 7. Запустите программу без volatile и посмотрите, остановится ли она (скорее всего зависнет).
 * 8. Добавьте `volatile` к полю `running` и проверьте, как изменится поведение (программа должна успешно завершиться).
 */
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.stopRunning();
    }
}

class MyThread extends Thread{
    private volatile boolean running = true;
    @Override
    public void run() {
        while(running){
            int x;
        }
    }

    public void stopRunning(){
        running = false;
    }
}

