package JavaCollectionsFramework.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Задание 1 (Стек - Базовое):
 * Задача: Переворот строки с использованием стека (Stack).
 * 1. Создайте объект типа Stack<Character>.
 * 2. Пройдитесь по каждому символу переданной строки (например, "Hello World")
 * и поместите (push) каждый символ в стек.
 * 3. Затем извлекайте (pop) символы из стека и объединяйте их в новую строку.
 * 4. Выведите перевернутую строку на экран (должно получиться "dlroW olleH").
 */
public class Task1 {
    public static void main(String[] args) {
        String originalText = "Hello World";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < originalText.length(); i++) {
            char ch = originalText.charAt(i);
            stack.push(ch);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }
}

