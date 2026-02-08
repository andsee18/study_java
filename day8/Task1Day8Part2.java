package day8;

public class Task1Day8Part2 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        StringBuilder s = new StringBuilder("");
        for(int i = 0;i<20001;i++){
            s.append(i).append(" ");
        }
        System.out.println(s);
        long stopTime = System.currentTimeMillis();
        System.out.println("Длительность работы, в мс.: " + (stopTime - startTime));
    }
}
