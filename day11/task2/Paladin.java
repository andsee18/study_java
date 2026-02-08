package day11.task2;

public class Paladin extends Hero implements PhysAttack, Healer{
    public Paladin(){
        this.health = MAX_HEALTH;
        this.physDef = 0.5;
        this.magicDef = 0.2;
    }

    @Override
    public void healHimself() {
        if (this.health == MIN_HEALTH){
            System.out.println("уже умер паладин");
        } else {
            this.health+=25;
        }
        if (this.health>MAX_HEALTH){
            this.health = MAX_HEALTH;
        }
    }
    @Override
    public void healTeammate(Hero hero) {
        if (hero.health == MIN_HEALTH){
            System.out.println("умер дружок уже");
        } else {
            hero.health+=10;
        }
        if (hero.health>MAX_HEALTH){
            hero.health = MAX_HEALTH;
        }
    }
    @Override
    public void physicalAttack(Hero hero) {
        double damage = 15 * (1 - hero.physDef);
        hero.health-=damage;
        if (hero.health<MIN_HEALTH){
            hero.health = MIN_HEALTH;
        }
    }
    @Override
    public String toString(){
        return "Paladin{health = "+this.health +"}";
    }
}
