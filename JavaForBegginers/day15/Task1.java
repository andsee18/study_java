package JavaForBegginers.day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "src" + separator + "main" + separator + "resources" + separator + "shoes.csv";
        File file = new File(path);
        File file1 = new File("src/main/resources/missing_shoes.txt");
        file1.getParentFile().mkdirs();

        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
             PrintWriter printWriter = new PrintWriter(file1, StandardCharsets.UTF_8)) {
            int count = 0;
            while (scanner.hasNextLine()) {
                count++;
                String line = scanner.nextLine();
                String[] info = line.split(";");
                if (info.length != 3) {
                    throw new Exception("неверные входные данные, строка N " + count);
                }
                if (Integer.parseInt(info[2]) == 0) {
                    printWriter.println(info[0] + ", " + info[1] + ", " + info[2]);
                }
            }
            System.out.println("запись выполнена!");

        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
