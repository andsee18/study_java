package myTasks.Day13MyDop;

public class Loader extends Robot implements Charge{
    public Loader(int serialNumber,int batteryCharge){
        super(serialNumber, batteryCharge);
    }
    @Override
    public void mainTask(){
        System.out.println("дрон грузчик начал работу. с номером " +super.getSerialNumber());
    }

    @Override
    public void ChargeRobotOne() {
        System.out.println("дрон грузчик начал зарядку. с номером " +super.getSerialNumber());
    }
}
