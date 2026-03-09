package day19.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("resources/taxi.txt");
        try (Scanner sc = new Scanner(file)) {
            HashMap<Integer, Point> taxiMap = new HashMap<>();
            while (sc.hasNext()) {
                int index = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                taxiMap.put(index, new Point(x, y));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scan = new Scanner(System.in);
        for (Map.Entry<Integer, Point> entry : taxiMap.entrySet())
            int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);


    }
}
