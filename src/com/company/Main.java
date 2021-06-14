package com.company;
import  java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
public class Main {

    static VisualInterface fr;
    public static void main(String[] args) throws InterruptedException {
       fr =  new VisualInterface();
       fr.startNewGame();


       long heroTimer;
       long knightTimer = 0;
       long clericTimer = 0;
       long gunnerTimer = 0;
       long mageTimer = 0;
       long monsterTimer = 0;

        heroTimer = 10000/fr.hero.getAttackSpeed();
        if(fr.knight != null) {knightTimer = 1000/fr.knight.getAttackSpeed();}
        if(fr.cleric != null) {clericTimer = 1000/fr.cleric.getAttackSpeed();}
        if(fr.gunner != null) {gunnerTimer = 1000/fr.gunner.getAttackSpeed();}
        if(fr.mage != null) {mageTimer = 1000/fr.mage.getAttackSpeed();}

       while(true)
       {
           while(((fr.monster.getHp()) > 0) && (!fr.checkForAlive()))
           {
               if((10000/fr.hero.getAttackSpeed()) <= heroTimer) {
                   heroTimer = 0;
                  fr.heroAttacks();
               }
               else
               {
                   heroTimer += 100;
               }

               if((fr.knight != null) && ((10000/fr.knight.getAttackSpeed() <= knightTimer)))
               {
                   knightTimer = 0;
                  fr.knightAttacks();
               }
               else
               {
                   knightTimer += 100;
               }

               if((fr.cleric != null) && (10000/fr.cleric.getAttackSpeed() <= clericTimer))
               {
                   clericTimer = 0;
                   fr.clericAttacks();
               }
               else
               {
                   clericTimer += 100;
               }

               if((fr.gunner != null) && (10000/fr.gunner.getAttackSpeed() <= gunnerTimer))
               {
                   gunnerTimer = 0;
                  fr.gunnerAttacks();
               }
               else
               {
                   gunnerTimer += 100;
               }

               if((fr.mage != null) && (10000/fr.mage.getAttackSpeed() <= mageTimer))
               {
                   mageTimer = 0;
                   fr.mageAttacks();
               }
               else
               {
                   mageTimer += 100;
               }

               if(monsterTimer == 1000)
               {
                   monsterTimer = 0;
                   fr.attackHeroes();
               }
               else
               {
                   monsterTimer += 100;
               }
               Thread.sleep(100);
           }
           fr.hideMonster();
           fr.setNewMonster();
           if(fr.checkForAlive())
           {
               fr.setLowerLevel();
           }
           else
           {
               fr.setNewLvl();
           }
           fr.setNewMoney();
           for(int i = 7; i > 0; i--)
           {
               Thread.sleep(1000);
              fr.nextRoundTimerCount(i - 2);
           }
           fr.setNextRoundTimerHide();
       }
    }
}


