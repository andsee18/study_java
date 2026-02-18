package day18;

public class Task2_2 {
    public static void main(String[] args) {
        int numb = 77787;
        System.out.println(Task2_2.count7(numb));

    }

    public static int count7(int i){
        return recursion(Integer.toString(i),0);
    }
    public static int recursion(String text,int index){
        if (index == text.length()){
            return 0;
        }
        int c = (text.charAt(index)=='7')? 1 : 0;
        return c+recursion(text,index+1);
    }

}
