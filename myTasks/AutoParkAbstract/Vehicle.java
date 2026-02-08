package myTasks.AutoParkAbstract;

public abstract class Vehicle {
    protected String brand;
    protected int fuelLevel;
    public Vehicle(String brand, int fuelLevel){
        this.brand = brand;
        this.fuelLevel = fuelLevel;
    }
    protected void getInfo(){
        System.out.println("топливо = " + this.fuelLevel);
        System.out.println("марка = "+ this.brand);
    }
    abstract void move();
}
