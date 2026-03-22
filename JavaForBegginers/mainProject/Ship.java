package mainProject;

public class Ship {
    private int length;
    private int x;
    private int y;

    public Ship (int x, int y, int length){
        this.x = x;
        this.y = y;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}
