package myTasks.AutoParkAbstract;

public class TaskMain {
    public static void main(String[] args){
        Vehicle[] garage = {
                new Car("BMW", 30,4),
                new Plane("Марка",20,3000),
                new Car("мерс",88,2)
        };

        showAllVehicles(garage);

    }
    public static void showAllVehicles(Vehicle[] array){
        for (Vehicle v : array) {
            v.move();
            v.getInfo();
            System.out.println("----------------");
        }
    }
}
