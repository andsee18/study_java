package myTasks.serialization.task1;

public class Task1 {
    public static void main(String[] args) {
        DevProgress dp1 = new DevProgress("сериализация",1,"в процессе");
        dp1.saveProgress();
        System.out.println(dp1.loadProgress());

    }
}
