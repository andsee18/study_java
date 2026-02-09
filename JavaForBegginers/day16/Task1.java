package JavaForBegginers.day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    static void main(String[] args) {
        String separator = File.separator;
        String path = "JavaForBegginers" + separator + "File.txt";
        File file = new File(path);
        printResult(file);
    }

    public static void printResult(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split(" ");
                int sum = 0;
                int count = 0;
                for (String number : numbers) {
                    sum += Integer.parseInt(number);
                    count++;
                }
                double average = (double) sum / count;
                System.out.print(average+" ---> ");
                System.out.printf("%.3f%n", average);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file.getAbsolutePath());
        }
    }

}
