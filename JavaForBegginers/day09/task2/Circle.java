package JavaForBegginers.day09.task2;

public class Circle extends Figure{
    protected double r;
    public Circle(String color, double r){
        super(color);
        this.r = r;
    }
    @Override
    public double area(){
        double s = Math.PI * Math.pow(this.r, 2);
        return s;
    }
    @Override
    public double perimetr(){
        return 2*Math.PI*this.r;
    }
}
