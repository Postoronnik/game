package Upgrades;
import Creatures.*;
public class HelpersUpPrice{
    double knightCoef = 1.3;
    double clericCoef = 1.4;
    double gunnerCoef = 1.5;
    double mageCoef   = 1.6;


    public int getKnightUp() {
        return (int)Knight;
    }

    public int getClericUp() {
        return (int)Cleric;
    }

    public int getGunnerUp() {
        return (int)Gunner;
    }

    public int getMageUp() {
        return (int)Mage;
    }

    double Knight = 300;
    double Cleric = 500;
    double Gunner = 700;
    double Mage = 900;

    public int getKnightBuy() {
        return knight;
    }

    public int getClericBuy() {
        return cleric;
    }

    public int getGunnerBuy() {
        return gunner;
    }

    public int getMageBuy() {
        return mage;
    }

    int knight = 600;
    int cleric = 800;
    int gunner = 1000;
    int mage = 1200;

    public void upKnight(){
        Knight = (int)(knightCoef*Knight);
    };
    public void upCleric(){
        Cleric = (int)(clericCoef*Cleric);
    };
    public void upGunner(){
        Gunner = (int)(gunnerCoef*Gunner);
    };
    public void upMage(){
        Mage  =  (int)(mageCoef*Mage);
    };
}