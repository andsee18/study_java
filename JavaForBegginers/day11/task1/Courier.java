package JavaForBegginers.day11.task1;

public class Courier implements Worker{
    int salary;
    boolean isPayed;
    public Courier(){
        this.isPayed = false;
        this.salary = 0;
    }
    public int getSalary(){
        return this.salary;
    }
    public boolean isPayed() {
        return this.isPayed;
    }
    @Override
    public String toString(){
        return "заработная плата = "+this.salary +
                "\n бонус = " + this.isPayed;
    }
    @Override
    public void doWork(Warehouse warehouse){
        salary+=100;
        warehouse.countDeliveredOrders++;
        if (warehouse.countDeliveredOrders>=10000 && !this.isPayed){
            System.out.println("Доступен бонус");
        }
    }
    @Override
    public void bonus(Warehouse warehouse){
        if (this.isPayed){
            System.out.println("Бонус уже выплачен");
        } else if (warehouse.countDeliveredOrders<10000){
            System.out.println("Бонус пока не доступен");
        } else {
            this.salary+=50000;
            this.isPayed = true;
            System.out.println("Выплата бонуса)");
        }
    }
}
