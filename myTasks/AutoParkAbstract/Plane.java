package myTasks.AutoParkAbstract;

public class Plane extends Vehicle{
    protected int maxAltitude;
    public Plane(String brand, int fuelLevel, int maxAltitude){
        super(brand, fuelLevel);
        this.maxAltitude = maxAltitude;
    }
    void move(){
        System.out.println(this.brand+" летит в небе");
    }
    @Override
    protected void getInfo(){
        super.getInfo();
        System.out.println("высота =  "+this.maxAltitude);
    }
}

