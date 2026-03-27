package Repeat.FirstTopics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        Developer dev1 = new Developer(150000);
        Electrician el1 = new Electrician(40,1500);
        staff.add(dev1);
        staff.add(el1);
        int totalBudget = 0;
        for (Employee value:staff){
            totalBudget+=value.getSalary();
        }
        System.out.println(totalBudget);
    }
}
