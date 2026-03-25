package mainProject;

import java.util.Scanner;
import java.util.Random;

public class SeaBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game player1Ctx = new Game();
        Game player2Ctx = new Game();

        System.out.println("Игрок 1, расставьте корабли!");
        placeShips(player1Ctx, scanner);

        clearConsole();

        System.out.println("Игрок 2, расставьте корабли!");
        placeShips(player2Ctx, scanner);

        clearConsole();

        Random random = new Random();
        boolean player1Turn = random.nextBoolean();
        System.out.println("Первым ходит Игрок " + (player1Turn ? "1" : "2"));

        while (true) {
            Game currentBoard = player1Turn ? player1Ctx : player2Ctx;
            Game enemyBoard = player1Turn ? player2Ctx : player1Ctx;
            String currentPlayerName = player1Turn ? "Игрок 1" : "Игрок 2";

            System.out.println("\nХодит " + currentPlayerName);

            System.out.println("Введите координаты выстрела (x,y):");
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length != 2) {
                System.out.println("Неверный формат. Введите x,y");
                continue;
            }

            try {
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());

                int result = enemyBoard.shoot(x, y);

                if (result == 0) {
                    System.out.println("Мимо!");
                    player1Turn = !player1Turn; // Switch turn
                } else if (result == 1) {
                    System.out.println("Попадание!");
                    if (enemyBoard.checkWin()) {
                        System.out.println("Победил " + currentPlayerName + "!");
                        break;
                    }
                } else if (result == 2) {
                    System.out.println("Утопил!");
                    if (enemyBoard.checkWin()) {
                        System.out.println("Победил " + currentPlayerName + "!");
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void placeShips(Game game, Scanner scanner) {
        // 1 корабль размером 4
        // 2 корабля размером 3
        // 3 корабля размером 2
        // 4 корабля размером 1
        int[] sizes = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        // или структурированный цикл

        for (int size : sizes) {
            game.printField();
            while (true) {
                System.out.println("Введите координаты " + size + "-палубного корабля (формат: x,y;x,y...):");
                String input = scanner.nextLine();
                try {
                    game.placeShip(input, size);
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }
        game.printField();
        System.out.println("Расстановка завершена. Нажмите Enter...");
        scanner.nextLine();
    }

    private static void clearConsole() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
