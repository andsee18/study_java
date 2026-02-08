package day14.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {
        File file = new File("people.txt");
        System.out.println(parseFileToObjList(file));
    }
    public static List<Human> parseFileToObjList(File file){
        List<Human> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] info = line.split(" ");
                int age = Integer.parseInt(info[1]);
                if (age<0){
                    throw new Exception("некорректный входной файл");
                }
                Human human = new Human(info[0],age);
                people.add(human);
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

