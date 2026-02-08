package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("File.txt");
        printSumDigits(file);
    }
    public static void printSumDigits(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            int[] numbers = new int[10];
            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                for (String number : words) {
                    if (counter < 10) {
                        numbers[counter] = Integer.parseInt(number);
                    }
                    counter++;
                }
            }
            if (counter != 10) {
                throw new Exception("некорректный входной файл");
            }
            int x = 0;
            for(int sum:numbers){
                x+=sum;
            }
            System.out.println("сумма чисел в массиве = "+ x);
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
