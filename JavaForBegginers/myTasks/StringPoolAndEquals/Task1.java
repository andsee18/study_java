package myTasks.StringPoolAndEquals;

public class Task1 {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = new String("Java");
        String str3 = str1;
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str2));
    }
}

