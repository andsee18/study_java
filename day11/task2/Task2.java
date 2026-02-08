package day11.task2;

public class Task2 {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Paladin paladin = new Paladin();
        Magican magican = new Magican();
        Shaman shaman = new Shaman();
        warrior.physicalAttack(paladin);
        System.out.println(paladin);
        paladin.physicalAttack(magican);
        System.out.println(magican);
        shaman.healTeammate(magican);
        System.out.println(magican);
        magican.magicalAttack(paladin);
        System.out.println(paladin);
        shaman.physicalAttack(warrior);
        System.out.println(warrior);
        paladin.healHimself();
        System.out.println(paladin);
        for (int i = 0; i<5; i++){
            warrior.physicalAttack(magican);
            System.out.println(magican);
        }
    }
}
