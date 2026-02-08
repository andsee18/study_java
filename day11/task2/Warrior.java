package day11.task2;

public class Warrior extends Hero implements PhysAttack{
    public Warrior(){
        this.health = MAX_HEALTH;
        this.physDef = 0.8;
        this.magicDef = 0;
    }
    @Override
    public void physicalAttack(Hero hero){
        double damage = 30.0 *(1 - hero.physDef);
        hero.health-=damage;
        if (hero.health<MIN_HEALTH){
            hero.health = MIN_HEALTH;
            System.out.println(hero+ " умер");
        }
    }
    @Override
    public String toString(){
        return "Warrior{health = "+this.health+ "}";
    }
}
