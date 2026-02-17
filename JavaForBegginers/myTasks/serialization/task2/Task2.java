package myTasks.serialization.task2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        Serilization[] people = {
                new Serilization("Андрей",1,20),
                new Serilization("Олег",2,12),
                new Serilization("Иван",3,17)
        };
        Serilization.saveArray(people);
        Serilization.loadArray(people);
        System.out.println(Arrays.toString(people));
    }
}
