package JavaForBegginers.myTasks.Day13MyDop;

public class ReconnaissanceDrone extends Robot implements Flight  {
    public ReconnaissanceDrone(int serialNumber,int batteryCharge){
        super(serialNumber, batteryCharge);
    }
    @Override
    public void mainTask(){
        System.out.println("дрон разведчик с номером " +super.getSerialNumber()+" сканирует территорию");
    }
    @Override
    public void Fly() {
        System.out.println("дрон разведчик с номером " +super.getSerialNumber() + " начал полет");
    }
}