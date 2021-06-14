package Creatures;

import AdditionalData.Lvl;

public class Creature extends Lvl {
    double maxHp;
    double hp;

    double damage;

    public long getMaxHp(){return (long)maxHp;}
    public long getHp(){return (long)hp;}
    public void setMaxHp(long value){maxHp = value;}
    public void setHp(long value){hp = value;}


    public long getDamage(){return (long)damage;}
    public void setDamage(long value){damage = value;}

    public void upgradeDamage(double coef)
    {
        damage = (long)(damage *coef);
    }

    public void upgradeMaxHp(double coef)
    {
        maxHp = (long)(maxHp *coef);
        hp = maxHp;
    }

    public void decreaseDamage(double coef)
    {
        damage = (long)(damage /coef);
    }

    public void decreaseMaxHp(double coef)
    {
        maxHp = (long)(maxHp /coef);
        hp = maxHp;
    }
}
