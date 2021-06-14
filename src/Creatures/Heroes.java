package Creatures;

import Creatures.Creature;

public class Heroes extends Creature {
    double armor;
    double attackSpeed;
    double energy;
    double maxEnergy;
    boolean deadMark;


    public void setDeadMark(boolean deadMark) {
        this.deadMark = deadMark;
    }
    public boolean getDeadMark(){
       return deadMark;
    }

    public long getMaxEnergy(){return (long)maxEnergy;}
    public long getEnergy(){return (long)energy;}
    public void setMaxEnergy(long value){ maxEnergy = value;}
    public void setEnergy(long value){energy = value;}
    public long getArmor() { return (long)armor; }
    public void setArmor(long value){armor = value;}
    public long getAttackSpeed() { return (long)attackSpeed; }
    public void setAttackSpeed(long attackSpeed) { this.attackSpeed = attackSpeed; }

    public void upgradeArmor(double coef) {
        armor = (long) (armor * coef);
    }

    public void upgradeAttacSpeed(double coef) {
        attackSpeed = (long) (attackSpeed * coef);
    }

    public void upgradeMaxEnergy(double coef){
        maxEnergy = (long)(maxEnergy * coef);
        energy = maxEnergy;
    }
}
