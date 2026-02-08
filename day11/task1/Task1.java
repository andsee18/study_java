package day11.task1;

public class Task1 {
    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse();
        Picker picker1 = new Picker();
        Courier courier1 = new Courier();
        businessProcess(picker1, warehouse1);
        businessProcess(courier1, warehouse1);
        System.out.println(warehouse1);
        System.out.println(picker1);
        System.out.println(courier1);
        Warehouse warehouse2 = new Warehouse();
        Picker picker2 = new Picker();
        Courier courier2 = new Courier();
        businessProcess(picker2, warehouse2);
        System.out.println(warehouse1);
        System.out.println(warehouse2);
    }

    static void businessProcess(Worker worker, Warehouse warehouse){
        int i=0;
        while(i<10000){
            worker.doWork(warehouse);
            i++;
        }
        worker.bonus(warehouse);
    }
}