package day19.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("resources/taxi.txt");
        try (Scanner sc = new Scanner(file)) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
