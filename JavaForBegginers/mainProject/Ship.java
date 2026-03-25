package mainProject;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<int[]> coordinates = new ArrayList<>();
    private List<int[]> hitCoordinates = new ArrayList<>();

    public Ship(List<int[]> coordinates) {
        this.coordinates = coordinates;
    }

    public List<int[]> getCoordinates() {
        return coordinates;
    }

    public void hit(int x, int y) {
        // проверяем, есть ли такая координата в корабле и не была ли она уже подбита
        for (int[] coord : coordinates) {
            if (coord[0] == x && coord[1] == y) {
                boolean alreadyHit = false;
                for (int[] hit : hitCoordinates) {
                    if (hit[0] == x && hit[1] == y) {
                        alreadyHit = true;
                        break;
                    }
                }
                if (!alreadyHit) {
                    hitCoordinates.add(new int[]{x, y});
                }
                return;
            }
        }
    }

    public boolean isSunk() {
        return hitCoordinates.size() == coordinates.size();
    }
}
