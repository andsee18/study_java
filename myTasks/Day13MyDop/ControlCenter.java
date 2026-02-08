package myTasks.Day13MyDop;

import java.util.ArrayList;
import java.util.List;

public class ControlCenter {
    public static List<Robot> robots = new ArrayList<>();
    public static void addRobots(Robot robot){
        robots.add(robot);
    }
    public static void generalWork(){
        for(Robot x: robots){
            x.mainTask();
        }
    }
    public static void airWarning(){
        for(Robot y: robots){
            if (y instanceof Flight f){
                f.Fly();
            }
        }
    }
    public static void chargeDay(){
        for(Robot x: robots){
            if(x instanceof Charge c){
                c.ChargeRobotOne();
            }
        }
    }

}
