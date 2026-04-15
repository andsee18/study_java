package JavaCollectionsFramework.comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Задание 3 (Сложное - несколько Comparator):
 * 1. Создайте в этом файле класс Employee с тремя полями: `name` (String), `age` (int), `salary` (double).
 * 2. Создайте список, добавьте 4-5 сотрудников.
 * 3. Напишите два отдельных Компаратора (отдельные классы вне Task3 или анонимные
 * классы внутри main, как вам удобнее):
 * - Первый сортирует сотрудников по их `возрасту` (по возрастанию).
 * - Второй сортирует сотрудников по их `зарплате` (строго по убыванию — богатые первыми).
 * 4. Отсортируйте список по очереди каждым компаратором и выведите оба результата на экран.
 */
public class Task3 {
    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee("Анна",22,70000.0));
        staff.add(new Employee("Георгий",44,55000.0));
        staff.add(new Employee("Иннокентий",36,44000.0));
        staff.add(new Employee("Иван",29,25000.0));
        staff.add(new Employee("Андрей",18,60000.0));

        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getAge()>o2.getAge()){
                    return 1;
                } else if (o1.getAge()<o2.getAge()){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("Сортировка по возрасту: " +staff);

        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary()< o2.getSalary()){
                    return 1;
                } else if (o1.getSalary()>o2.getSalary()){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println("Сортировка по зп: "+ staff);


    }
}

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}


