package JavaForBegginers.day09.task1;

public class Student extends Human {
    protected String groupName;
    public Student(String name, String groupName){
        super(name);
        this.groupName = groupName;
    }
    public String getGroup(){
        return this.groupName;
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Этот студент с именем "+ name);
    }

}
