package JavaForBegginers.day11.task2;

public class Magican extends Hero implements MagicAttack, PhysAttack{
    public Magican(){
        this.health = MAX_HEALTH;
        this.physDef = 0;
        this.magicDef = 0.8;
    }
    @Override
    public void magicalAttack(Hero hero) {
        double damage = 20 * (1 - hero.magicDef);
        hero.health-=damage;
        if (hero.health<MIN_HEALTH){
            System.out.println("умер братик");
            hero.health = MAX_HEALTH;
        }
    }
    @Override
    public void physicalAttack(Hero hero) {
        double damage = 5 * (1 - hero.physDef);
        hero.health-=damage;
        if(hero.health<MIN_HEALTH){
            hero.health = MIN_HEALTH;
        }
    }
    @Override
    public String toString(){
        return "Magican{health="+this.health+"}";
    }
}
