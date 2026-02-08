package day9.task1;

public class Human {
    protected String name;
    public Human(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void printInfo(){
        System.out.println("Этот человек с именем "+ this.name);
    }
}
