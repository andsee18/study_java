package JavaForBegginers.day09.task2;

public class Triangle extends Figure{
    protected int a;
    protected int b;
    protected int c;
    public Triangle(String color, int a, int b, int c){
        super(color);
        this.a=a;
        this.b=b;
        this.c=c;
    }
    @Override
    public double area(){
        double p =(this.a+this.b+this.c)/2.0;
        return Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c));
    }

    @Override
    public double perimetr() {
        return this.a+this.b+this.c;
    }
}
