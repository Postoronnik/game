package Creatures;

import Upgrades.HeroUpPrice;

public class Hero  extends Heroes {

    public Hero()
    {
        setMaxHp(600);
        setHp(600);
        setMaxEnergy(100);
        setEnergy(100);
        setDamage(20);
        setArmor(5);
        setAttackSpeed(10);
        setDeadMark(false);
    }
}
