package JavaForBegginers.day09.task2;

public class TestFigures {
    public static void main(String[] args){
        Figure[] figures = {
                new Triangle("Red",10,10,10),
                new Triangle("Green",10,20,30),
                new Triangle("Red",10,20,15),
                new Rectangle("Red",5,10),
                new Rectangle("Orange",40,15),
                new Circle("Red",4),
                new Circle("Red",10),
                new Circle("Blue",5)
        };
        System.out.println(calculateRedArea(figures));
        System.out.println(calculateRedPerimetr(figures));
    }
    public static double calculateRedPerimetr(Figure[] figures){
        double sum = 0;
        for (Figure x: figures){
            if ("Red".equals(x.getColor())){
                sum += x.perimetr();
            }
        }
        return sum;
    }
    public static double calculateRedArea (Figure[] figures){
        double sums = 0;
        for(Figure i: figures){
            if ("Red".equals(i.getColor())){
                sums+=i.area();
            }
        }
        return sums;
    }

}
