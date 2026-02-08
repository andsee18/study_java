package day11.task2;

public class Shaman extends Hero implements Healer, PhysAttack, MagicAttack{
    public Shaman(){
        this.health=MAX_HEALTH;
        this.physDef=0.2;
        this.magicDef=0.2;
    }

    @Override
    public void healHimself() {
        if(this.health == MIN_HEALTH){
            System.out.println("ты умер бро");
        } else {
            this.health+=50;
        }
        if (this.health>MAX_HEALTH){
            this.health=MAX_HEALTH;
        }
    }
    @Override
    public void healTeammate(Hero hero) {
        if(hero.health==0){
            System.out.println("умер он уже");
        } else {
            hero.health+=30;
        }
        if(hero.health>MAX_HEALTH){
            hero.health=MAX_HEALTH;
        }
    }
    @Override
    public void magicalAttack(Hero hero) {
        double damage = 15 * ( 1- hero.magicDef);
        hero.health-=damage;
        if(hero.health<MIN_HEALTH){
            hero.health=MIN_HEALTH;
        }
    }
    @Override
    public void physicalAttack(Hero hero) {
        double damage = 10 * (1-hero.physDef);
        hero.health-=damage;
        if (hero.health<MIN_HEALTH){
            hero.health=MIN_HEALTH;
        }
    }
    @Override
    public String toString(){
        return "Shaman{health="+this.health+"}";
    }
}
