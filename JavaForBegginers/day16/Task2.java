package JavaForBegginers.day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task2 {
    static void main() {
        File file1 = new File("JavaForBegginers/day16/file1.txt");
        File file2 = new File("JavaForBegginers/day16/file2.txt");
        file1.getParentFile().mkdirs();
        file2.getParentFile().mkdirs();
        try (PrintWriter pw1 = new PrintWriter(file1, StandardCharsets.UTF_8);
             PrintWriter pw2 = new PrintWriter(file2, StandardCharsets.UTF_8)) {
            int[] numbers = new int[1000];
            int count = 0;
            int array = 0;
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) (Math.random() * 100);
                pw1.print(numbers[i] + " ");
            }
            for (int x : numbers) {
                array += x;
                count++;
                if (count == 20) {
                    double numberFile2 = (double) array / count;
                    pw2.print(numberFile2 + " ");
                    count = 0;
                    array = 0;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        } catch (IOException e) {
            System.out.println("проблема входных данных");
        }
        System.out.println(printResult(file2));

    }
    public static int printResult(File file) {
        double totalSum = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                totalSum += Double.parseDouble(scanner.next());
            }
            return (int) totalSum;
        } catch (FileNotFoundException e) {
            return -1;
        }
    }
}
