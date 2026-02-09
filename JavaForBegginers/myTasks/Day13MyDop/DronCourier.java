package JavaForBegginers.myTasks.Day13MyDop;

public class DronCourier extends Robot implements Flight, Charge{
    public DronCourier(int serialNumber, int batteryCharge){
        super(serialNumber, batteryCharge);
    }
    @Override
    public void mainTask(){
        System.out.println("дрон курьер с номером " + getSerialNumber() +" переносит мелкие посылки по воздуху");
    }

    @Override
    public void ChargeRobotOne() {
        System.out.println("дрон курьер начал зарядкуы. с номером " +super.getSerialNumber());

    }
    @Override
    public void Fly() {
        System.out.println("дрон курьер начал полет. номер "+ getSerialNumber());
    }
}
