package Repeat.FirstTopics;

public class Developer implements Employee {
    int fixedSalary;

    public Developer(int fixedSalary){
        this.fixedSalary = fixedSalary;
    }

    public int getSalary(){
        return fixedSalary;
    }
}
