package JavaForBegginers.myTasks.LostAbstractSuperWord;

public class LostTaskAbstract {
    public static void main(String[] args){
        Survivor[] camp = new Survivor[2];
        camp[0]=new Doctor("Джек Щепард");
        camp[1]=new Hunter("джон локк");

        for(Survivor c: camp){
            c.perfomRole();
        }
    }
}
