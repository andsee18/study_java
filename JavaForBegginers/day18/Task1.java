package day18;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = new int[50];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        System.out.println(Task1.recursionSum(numbers));

    }

    public static int recursionSum(int[]numbers){
        return helper(numbers, 0);
    }

    public static int helper(int[] numbers, int index){
        if( index == numbers.length){
            return 0;
        }
        return numbers[index]+helper(numbers,index+1);
    }



}
