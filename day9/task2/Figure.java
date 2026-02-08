package day9.task2;

public abstract class Figure {
    protected String color;
    public Figure(String color){
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }
    public abstract double area();
    public abstract double perimetr();
}
