package JavaForBegginers.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("people.txt");
        System.out.println(parseFileToStringList(file));
    }
    public static List<String> parseFileToStringList(File file){
        List<String> people = new ArrayList<>();
        try {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            int age = Integer.parseInt(words[1]);
            if (age<0){
                throw new Exception("некорректный входной файл");
            } else {
            people.add(line);}
        }
        scanner.close();
        return people;
    } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
