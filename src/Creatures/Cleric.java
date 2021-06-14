package Creatures;

public class Cleric  extends Helpers {

    int heal;
    public Cleric()
    {
        setPrice(800);
        setMaxHp(600);
        setHp(600);
        setMaxEnergy(150);
        setEnergy(150);
        setDamage(5);
        setArmor(5);
        setAttackSpeed(5);
        setDeadMark(false);
        heal = 20;
    }
    int getHeal(){return heal; }
    void setHeal(int heal){this.heal = heal;}
}
