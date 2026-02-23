package day18.task1;

public class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public void printNode(){
        System.out.println("Значение узла: "+ value);
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
    @Override
    public String toString(){
        return "Node{ "+
                "value="+value+
                ", leftChild="+leftChild+
                ", rightChild="+rightChild+
                "}";
    }

}
