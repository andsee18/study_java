package day18;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введи число");
        while (!scanner.hasNextInt()){
            System.out.println("error");
        }
        int numb = scanner.nextInt();
        System.out.println(count7(numb));

    }

    public static int count7(int i) {
        String number = Integer.toString(i);
        return recursion(number);
    }

    public static int recursion(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        char c = number.charAt(number.length() - 1);
        String text = number.substring(0, number.length() - 1);
        if (Character.toString(c).equals("7")) {
            return 1 + recursion(text);
        } else {
            return 0 + recursion(text);
        }
    }
}

