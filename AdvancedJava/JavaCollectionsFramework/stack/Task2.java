package JavaCollectionsFramework.stack;

import java.util.Stack;

/**
 * Задание 2 (Стек - Среднее):
 * Задача: Проверка правильной скобочной последовательности.
 * Дан текст, содержащий различные типы скобок: '(', ')', '[', ']', '{', '}'.
 * Определите, являются ли скобки в строке сбалансированными (то есть для каждой открывающей скобки есть соответствующая ей закрывающая, и они вложены правильно).
 * <p>
 * Например:
 * "({[]})" -> true
 * "([)]"   -> false
 * "()[]{}" -> true
 * "[(]"    -> false
 * "((("    -> false
 */
public class Task2 {
    public static void main(String[] args) {
        String test1 = "({[]})";
        String test2 = "([)]";
        String test3 = "()[]{}";
        String test4 = "[(]";

        System.out.println("test1 = " + isBalanced(test1) + " (ожидается true)");
        System.out.println("test2 = " + isBalanced(test2) + " (ожидается false)");
        System.out.println("test3 = " + isBalanced(test3) + " (ожидается true)");
        System.out.println("test4 = " + isBalanced(test4) + " (ожидается false)");
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openChar = stack.pop();
                if ((ch == ')' && openChar != '(') ||
                    (ch == ']' && openChar != '[') ||
                    (ch == '}' && openChar != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
