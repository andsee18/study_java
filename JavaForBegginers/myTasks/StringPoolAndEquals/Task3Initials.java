package myTasks.StringPoolAndEquals;

import java.util.Scanner;

public class Task3Initials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        initials(words);
    }

    public static void initials(String string) {
        try {
            string = string.trim();
            int spaceCount = 0;
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == ' ') {
                    spaceCount++;
                    if (spaceCount > 2) throw new Exception("Слишком много слов!");
                }
            }
            StringBuilder sb = new StringBuilder();
            String[] words = string.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    char first = Character.toUpperCase(word.charAt(0));
                    sb.append(first).append(".");
                }
            }
            System.out.println("Инициалы: " + sb.toString());

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}