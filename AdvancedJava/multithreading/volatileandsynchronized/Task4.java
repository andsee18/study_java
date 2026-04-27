package multithreading.volatileandsynchronized;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 4. Итоговая симуляция "Игровой сервер".
 * <p>
 * 1. Создайте класс `GameServer` со следующими полями:
 * - `isServerRunning` (boolean, по умолчанию true) — флаг состояния сервера.
 * - `activePlayers` (int, по умолчанию 0) — счетчик онлайна.
 * <p>
 * 2. Добавьте методы в `GameServer`:
 * - `connectPlayer()` — безопасно увеличивает счетчик `activePlayers` на 1.
 * - `disconnectPlayer()` — безопасно уменьшает счетчик `activePlayers` на 1.
 * - `stopServer()` — переводит флаг `isServerRunning` в false.
 * - `getActivePlayers()` — возвращает текущее количество игроков.
 * - `isServerRunning()` — возвращает состояние сервера.
 * <p>
 * 3. Создайте поток-монитор. Он должен в цикле проверять состояние работы сервера, выводить на экран
 * "Текущий онлайн: " + getActivePlayers() и засыпать на 100 миллисекунд.
 * <p>
 * 4. Создайте 100 потоков-игроков. Логика каждого игрока:
 * - Подключается к серверу.
 * - Засыпает на случайное время от 100 до 300 миллисекунд.
 * - Отключается от сервера.
 * <p>
 * 5. В методе `main`:
 * - Создайте объект сервера.
 * - Запустите поток-монитор.
 * - Запустите 100 потоков-игроков.
 * - Дождитесь завершения всех 100 потоков-игроков.
 * - Остановите сервер.
 * - Дождитесь завершения потока-монитора и выведите "Сервер успешно выключен".
 */
public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        GameServer gameServer = new GameServer();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (gameServer.isServerRunning()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Текущ онлайн: " + gameServer.getActivePlayers());
                }
            }
        });
        thread1.start();
        List<Thread> threads = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    gameServer.connectPlayer();
                    try {
                        Thread.sleep((int) (Math.random() * 301));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    gameServer.disconnectPlayer();
                }
            }));
        }
        for (Thread thr : threads) {
            thr.start();
        }
        // Ждем пока все 100 игроков не закончат играть
        for (Thread thr : threads) {
            thr.join();
        }
        
        // Когда все игроки ушли, выключаем сервер
        gameServer.stopServer();
        
        // Ждем пока монитор осознает что сервер выключен и завершит свою работу
        thread1.join();
        System.out.println("сервер успещно выключен");

    }
}

class GameServer {
    private volatile boolean isServerRunning = true;
    private int activePlayers = 0;

    public void connectPlayer() {
        synchronized (this) {
            activePlayers++;
        }
    }

    public void disconnectPlayer() {
        synchronized (this) {
            activePlayers--;
        }
    }

    public void stopServer() {
        isServerRunning = false;
    }

    public int getActivePlayers() {
        return activePlayers;
    }

    public boolean isServerRunning() {
        return isServerRunning;
    }
}

