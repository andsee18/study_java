package mainProject;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int[][] field = new int[10][10];
    private List<Ship> ships = new ArrayList<>();

    private static final int EMPTY = 0;
    private static final int SHIP = 1;
    private static final int HALO = 2;
    private static final int HIT = 3;
    private static final int MISS = 4;

    public void placeShip(String coordinatesStr, int expectedSize) throws Exception {
        String[] parts = coordinatesStr.split(";");
        if (parts.length != expectedSize) {
            throw new Exception("Неверное количество координат для данного типа корабля.");
        }

        List<int[]> currCoords = new ArrayList<>();

        for (String part : parts) {
            String[] xy = part.split(",");
            if (xy.length != 2) {
                throw new Exception("Координата должна состоять из двух чисел, разделенных запятой (x,y).");
            }
            try {
                int x = Integer.parseInt(xy[0].trim());
                int y = Integer.parseInt(xy[1].trim());

                if (x < 0 || x > 9 || y < 0 || y > 9) {
                    throw new Exception("Координаты должны быть от 0 до 9.");
                }

                if (field[y][x] != EMPTY) {
                    throw new Exception("В данном месте уже нельзя разместить корабль (занято или ореол).");
                }

                for(int[] c : currCoords) {
                     if(c[0] == x && c[1] == y) throw new Exception("Дубликат координат.");
                }

                currCoords.add(new int[]{x, y});
            } catch (NumberFormatException e) {
                throw new Exception("Координаты должны быть числами.");
            }
        }

        if (!isValidShipShape(currCoords)) {
             throw new Exception("Корабль должен быть расположен в линию и быть неразрывным.");
        }

        Ship newShip = new Ship(currCoords);
        ships.add(newShip);

        for (int[] coord : currCoords) {
            field[coord[1]][coord[0]] = SHIP;
        }

        for (int[] coord : currCoords) {
            markHalo(coord[0], coord[1]);
        }
    }

    private boolean isValidShipShape(List<int[]> coords) {
        if (coords.size() == 1) return true;

        boolean sameX = true;
        boolean sameY = true;
        int firstX = coords.get(0)[0];
        int firstY = coords.get(0)[1];

        for (int[] c : coords) {
            if (c[0] != firstX) sameX = false;
            if (c[1] != firstY) sameY = false;
        }

        if (!sameX && !sameY) return false; // Not a line

        if (sameX) {
            // Sort by y
            coords.sort((a,b) -> Integer.compare(a[1], b[1]));
            for (int i = 0; i < coords.size() - 1; i++) {
                if (coords.get(i+1)[1] - coords.get(i)[1] != 1) return false;
            }
        } else {
            // Sort by x
            coords.sort((a,b) -> Integer.compare(a[0], b[0]));
            for (int i = 0; i < coords.size() - 1; i++) {
                if (coords.get(i+1)[0] - coords.get(i)[0] != 1) return false;
            }
        }

        return true;
    }

    private void markHalo(int x, int y) {
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 10) {
                    if (field[i][j] != SHIP && field[i][j] != HIT) {
                        field[i][j] = HALO;
                    }
                }
            }
        }
    }

    // Returns: 0 - Miss, 1 - Hit, 2 - Sunk
    public int shoot(int x, int y) throws Exception {
        if (x < 0 || x > 9 || y < 0 || y > 9) throw new Exception("Координаты вне поля!");
        if (field[y][x] == HIT || field[y][x] == MISS) {
             throw new Exception("Вы уже стреляли сюда!");
             // "право следующего хода остается" if hit.
        }

        if (field[y][x] == SHIP) {
            field[y][x] = HIT;
            // Find ship
            for (Ship ship : ships) {
                for(int[] c : ship.getCoordinates()) {
                    if(c[0] == x && c[1] == y) {
                        ship.hit(x,y);
                        if (ship.isSunk()) return 2;
                        return 1;
                    }
                }
            }
            return 1;
        } else {
            field[y][x] = MISS;
            return 0;
        }
    }

    public boolean checkWin() {
        for (Ship s : ships) {
            if (!s.isSunk()) return false;
        }
        return true;
    }

    public void printField() {
        System.out.print("  ");
        for(int i=0; i<10; i++) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                switch (field[i][j]) {
                    case EMPTY: System.out.print("⬜"); break;
                    case SHIP: System.out.print("\uD83D\uDEE5"); break; // 🛥
                    case HALO: System.out.print("\uD83D\uDFE6"); break; // 🟦
                    case HIT: System.out.print("\uD83D\uDFE5"); break; // 🟥
                    case MISS: System.out.print("MISS"); break;
                    default: System.out.print("?");
                }
            }
            System.out.println();
        }
    }

    // метод, скрывающий корабли для противника
    public void printFieldFogOfWar() {
         System.out.print("  ");
        for(int i=0; i<10; i++) System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                switch (field[i][j]) {
                    case EMPTY:
                    case HALO:
                    case SHIP:
                        System.out.print("⬜"); break; // скрываем
                    case HIT:
                        System.out.print("\uD83D\uDFE5"); break; // 🟥
                    case MISS:
                         System.out.print("o "); break; // отображение промаха
                    default: System.out.print("?");
                }
            }
            System.out.println();
        }
    }
}
