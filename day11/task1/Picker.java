package day11.task1;

public class Picker implements Worker{
    int salary;
    boolean isPayed;
    public Picker(){
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
        salary+=80;
        warehouse.countPickedOrders++;
        if (warehouse.countPickedOrders>=10000 && !this.isPayed){
            System.out.println("Доступен бонус");
        }
    }
    @Override
    public void bonus(Warehouse warehouse){
        if (this.isPayed){
            System.out.println("Бонус уже выплачен");
        } else {
            if (warehouse.countPickedOrders<10000){
                System.out.println("Бонус пока не доступен");
            } else {
                System.out.println("Выплата бонуса)");
                this.salary+=70000;
                this.isPayed = true;
            }
        }
    }
}
