package myTasks.StringPoolAndEquals;

import java.util.Scanner;

public class Task2Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String s = scanner.nextLine();
                if (s.isEmpty()) {
                    throw new IllegalArgumentException("пустое значение");
                }
                if (s.equals("exit")) {
                    break;
                }
                System.out.println(isPalindrome(s));
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isPalindrome(String string) {
        String s = string.toLowerCase();
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (Character.isLetterOrDigit(letter)) {
                build.append(letter);
            }
        }
        int left = 0;
        int right = build.length() - 1;
        while (left < right) {
            if (build.charAt(left) != build.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}


