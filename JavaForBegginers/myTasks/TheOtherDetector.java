package JavaForBegginers.myTasks;

public class TheOtherDetector {
    public static void main(String[] args){
        Detector.checkPerson("Jack");
        Detector.checkPerson("Henry Gale");
        Detector.checkPerson("Kate");
        Detector.checkPerson("Andrew");
        Detector.checkPerson("Holy");
        Detector.checkPerson("Ksu");
        Detector.showStats();
        Detector.resetCounter();
        Detector.showStats();
    }
}

class Detector{
    private static int totalPasses;
    public static final int MAX_SAFE_PUSSES=5;

    public static void checkPerson(String name){
        if(totalPasses>=MAX_SAFE_PUSSES){
            System.out.println("Система перегружена! Проверьте датчики!");
        }
        totalPasses++;
        if (name.equals("Henry Gale")) {
            System.out.println("ВНИМАНИЕ! Это другой!");
        } else if (name.equals("Ethan")){
            System.out.println("ВНИМАНИЕ! Это другой!");
        } else {
            System.out.println("Проходи, "+name+ " , ты свой");
        }
    }
    public static void showStats(){
        System.out.println("Всего через дверь прошло человек: "+ totalPasses);
    }

    public static void resetCounter(){
        totalPasses = 0;
        System.out.println("Счетчик сброшен");
    }
}