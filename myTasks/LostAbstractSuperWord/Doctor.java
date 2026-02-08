package myTasks.LostAbstractSuperWord;

public class Doctor extends Survivor {
    public Doctor(String name){
        super(name);

    }
    @Override
    void perfomRole(){
        System.out.println(super.name + " лечит раненых");
    }
}
