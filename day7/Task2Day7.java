package day7;
import java.util.Random;

public class Task2Day7 {
    public static void main(String[] args){
        Random random = new Random();
        int[] numbers = new int[7];
        for(int n = 0; n<numbers.length; n++){
            int x = random.nextInt(11)+90;
            numbers[n] = x;
        }
        Player player1 = new Player(numbers[0]);
        Player player2 = new Player(numbers[1]);
        Player player3 = new Player(numbers[2]);
        Player player4 = new Player(numbers[3]);
        Player player5 = new Player(numbers[4]);
        Player.info();
        Player player6 = new Player(numbers[5]);
        Player.info();
        Player player7 = new Player(numbers[6]);
        Player.info();
        while(player1.getStamina() > Player.MIN_STAMINA) {
            player1.run();
        }
        while(player2.getStamina() > Player.MIN_STAMINA) {
            player2.run();
        }
        Player.info();
        System.out.println(Player.getCountPlayers());
        System.out.println(player1.getStamina());
        System.out.println(player3.getStamina());
    }
}

class Player{
    private int stamina;
    public static final int MAX_STAMINA = 100;
    public static final int MIN_STAMINA = 0;
    public static int countPlayers;
    public static int overPlayers;
    //Геттеры
    public int getStamina(){
        return this.stamina;}

    public static int getCountPlayers(){ return countPlayers;}

    public Player(int stamina){
        if (stamina>MAX_STAMINA){
            this.stamina = MAX_STAMINA;
        }
        if (countPlayers == 6){
            this.stamina = stamina;
            overPlayers++;
        } else {
        this.stamina = stamina;
        countPlayers++;}
    }

    public void run(){
        if (stamina==MIN_STAMINA){
            System.out.println("выносливость уже 0");
        } else if (stamina == 1){
            stamina--;
            if (overPlayers>0){
                overPlayers--;
                countPlayers++;
                System.out.println("Игрок выдохся, происходит замена игрока");
            } else {
                countPlayers--;
                System.out.println("игрок уходит с поля так как выносливость = " + this.stamina);
            }
        } else {
            stamina--;
        }
    }
    public static void  info(){
        if (countPlayers<6){
            int g = 6 - countPlayers;
            String end;
            if (g == 1){
                end = "свободное место";
            } else if (g >=2 && g<=4){
                end = "свободных места";
            } else{
                end = "свободных мест";
            }
            System.out.println("Команды неполные. На поле еще есть " + g + " " + end);
        } else {
            System.out.println("На поле нет свободных мест, лишних игроков: "+ overPlayers);
        }
    }
}
