package JavaForBegginers.myTasks.AutoParkAbstract;

public class Car extends Vehicle{
    protected int doorsCount;
    public Car(String brand, int fuelLevel, int doorsCount){
        super(brand, fuelLevel);
        this.doorsCount = doorsCount;
    }
    void move(){
        System.out.println(this.brand+" едет по дороге");
    }
    @Override
    protected void getInfo(){
        super.getInfo();
        System.out.println("кол-во дверей = "+this.doorsCount);
    }

}
