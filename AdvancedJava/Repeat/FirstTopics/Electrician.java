package Repeat.FirstTopics;

public class Electrician implements Employee {
    int hours;
    int rate;

    public Electrician(int hours, int rate){
        this.hours = hours;
        this.rate = rate;
    }
    public int getSalary(){
        return hours*rate;
    }
}
