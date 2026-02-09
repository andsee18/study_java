package JavaForBegginers.myTasks.Day13MyDop;

public abstract class Robot {
    private int serialNumber;
    private int batteryCharge;

    public Robot(int serialNumber, int batteryCharge) {
        setSerialNumber(serialNumber);
        this.batteryCharge = batteryCharge;
    }

    public void setSerialNumber(int serialNumber) {
        if (serialNumber < 0) {
            System.out.println("ошибка");
        } else {
            this.serialNumber = serialNumber;
        }
    }

    public int getBatteryCharge() {
        return batteryCharge;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public abstract void mainTask();
}
