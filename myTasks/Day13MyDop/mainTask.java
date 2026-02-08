package myTasks.Day13MyDop;

public class mainTask {
    public static void main(String[] args) {
        Loader loader = new Loader(1,100);
        ReconnaissanceDrone dr1 = new ReconnaissanceDrone(2,77);
        DronCourier dr2 = new DronCourier(3,55);
        ControlCenter.addRobots(loader);
        ControlCenter.addRobots(dr1);
        ControlCenter.addRobots(dr2);

        ControlCenter.airWarning();
        ControlCenter.chargeDay();
        ControlCenter.generalWork();
    }
}
