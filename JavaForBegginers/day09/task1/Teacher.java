package JavaForBegginers.day09.task1;

public class Teacher extends Human{
    protected String subjectName;
    public String getSubjectName(){
        return this.subjectName;
    }
    public Teacher(String name, String subjectName){
        super(name);
        this.subjectName = subjectName;
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Этот преподователь с именем "+ name);
    }

}
