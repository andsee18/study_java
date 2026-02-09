package JavaForBegginers.day08;

public class Task1Day8 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        String s = "";
        for (int i= 0; i< 20001;i++){
            s += i +" ";
        }
        System.out.println(s);
        long stopTime = System.currentTimeMillis();
        System.out.println("длительность работы, в мс: "+ (stopTime-startTime));
    }
}
