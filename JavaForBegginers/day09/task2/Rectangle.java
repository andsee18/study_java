package JavaForBegginers.day09.task2;

public class Rectangle extends Figure{
    protected int a;
    protected int h;
    public Rectangle(String color, int a, int h){
        super(color);
        this.a = a;
        this.h = h;
    }
    @Override
    public double perimetr(){
        return 2*(this.h+this.a);
    }
    @Override
    public double area(){
        return this.a*this.h;
    }
}
