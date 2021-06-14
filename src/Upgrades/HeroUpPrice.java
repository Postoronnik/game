package Upgrades;
import Creatures.*;
public class HeroUpPrice {

    double lvlCoef = 1.8;
    double hpCoef = 1.2;
    double energyCoef = 1.3;
    double damageCoef = 1.1;
    double attackSpeedCoef = 1.5;
    double armorCoef = 1.4;

    int lvlCost = 500;
    int hpCost = 150;
    int energyCost = 200;
    int damageCost = 100;
    int armorCost = 200;
    int attacSpeedCost = 800;

    public int getLvlCost() {
        return lvlCost;
    }

    public int getHpCost() {
        return hpCost;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public int getDamageCost() {
        return damageCost;
    }

    public int getArmorCost() {
        return armorCost;
    }

    public int getAttacSpeedCost() {
        return attacSpeedCost;
    }


    public int upLvl(){
        lvlCost *= lvlCoef;
        return (int)lvlCoef*lvlCost;
    }
    public int upHp(){
        hpCost *= hpCoef;
        return (int) hpCoef*hpCost;
    }
    public int upEnergy(){
        energyCost *= energyCoef;
        return (int)energyCoef*energyCost;
    }
    public int upDamage(){
        damageCost *= damageCoef;
        return (int)damageCoef*damageCost;
    }
    public int upArmor(){
        armorCost *= armorCoef;
        return (int)armorCoef*armorCost;
    }
    public int upAttacSpeed(){
        attacSpeedCost *= attackSpeedCoef;
        return (int)attackSpeedCoef*attacSpeedCost;
    }

}
