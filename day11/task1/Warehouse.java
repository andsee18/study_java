package day11.task1;

public class Warehouse {
    public int countPickedOrders;
    public int countDeliveredOrders;
    public int getCountPickedOrders(){
        return this.countPickedOrders;
    }
    public int getCountDeliveredOrders(){
        return this.countDeliveredOrders;
    }
    @Override
    public String toString(){
        String string = "колво собранных заказов = "+this.countPickedOrders+
                        "\n колво доставленных заказов = "+this.countDeliveredOrders;
        return string;
    }
}