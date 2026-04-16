package JavaCollectionsFramework.stack;

import java.util.Stack;

/**
 * Задание 3 (Стек - Самое сложное):
 * Задача: Вычисление арифметических выражений, записанных в обратной польской нотации (RPN).
 * <p>
 * Дан массив строк (токенов), в котором содержатся числа и операторы ("+", "-", "*", "/").
 * Пример: ["2", "1", "+", "3", "*"] означает выражение ((2 + 1) * 3) = 9
 * Пример: ["4", "13", "5", "/", "+"] означает выражение (4 + (13 / 5)) = 6 (целочисленное деление).
 * Вычислите это выражение и верните результат.
 */
public class Task3 {
    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"}; // 9
        String[] tokens2 = {"4", "13", "5", "/", "+"}; // 6

        System.out.println("Result 1: " + evaluateRPN(tokens1) + " (ожидается 9)");
        System.out.println("Result 2: " + evaluateRPN(tokens2) + " (ожидается 6)");
    }

    public static int evaluateRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int d = stack.pop();
                    int c = stack.pop();
                    stack.push(c / d);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
