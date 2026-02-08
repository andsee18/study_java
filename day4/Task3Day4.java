package day4;
import java.util.Random;
public class Task3Day4 {
    public static void main (String[] args){
        int[][] matrice = new int[12][8];
        Random random = new Random();
        int maxSum = 0;
        int maxSumIndex = 0;
        for (int i = 0; i < matrice.length;i++ ){
            int lineSum = 0;
            for (int j = 0; j < matrice[i].length;j++ ){
                matrice[i][j]= random.nextInt(50);
                lineSum = lineSum + matrice[i][j];
            }
            if (lineSum>=maxSum){
                maxSum = lineSum;
                maxSumIndex = i;
            }
        }
        System.out.println("индекс " + maxSumIndex);
    }
}
