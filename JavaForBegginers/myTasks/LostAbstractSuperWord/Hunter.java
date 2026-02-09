package JavaForBegginers.myTasks.LostAbstractSuperWord;

public class Hunter extends Survivor{
    public Hunter(String name){
        super(name);
    }
    @Override
    void perfomRole(){
        System.out.println(super.name + " охотится на кабанов");
    }
}
