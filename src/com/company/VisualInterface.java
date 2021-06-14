package com.company;

import Upgrades.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import Creatures.*;
import AdditionalData.*;

public class VisualInterface extends JFrame  implements VisualInterfaceFunc
{
    JPanel menuBar;
    JPanel mainPanel;
    JPanel upgradeMenuHelpers;
    JPanel upgradeMenuHero;

    JButton heroButton;
    JButton helpers;
    JButton closeUpgrages;
    JButton upgradesHero[];
    JButton upgradesHelpers[];

    JLabel words;
    JLabel upVis[];
    JLabel priceHero[];
    JLabel priceHelpers[];
    JLabel heroStats[];
    JLabel moneyVision;
    JLabel lvlVision;
    JLabel heroIm;
    JLabel clericIm;
    JLabel mageIm;
    JLabel knightIm;
    JLabel gunnerIm;
    JLabel monsterIm;
    JLabel nextRoundTimer;


    //Hp and energy bars
    JLabel hpBarHero;
    JLabel energyBarHero;

    JLabel hpBarKnight;
    JLabel energyBarKnight;

    JLabel hpBarCleric;
    JLabel energyBarCleric;

    JLabel hpBarGunner;
    JLabel energyBarGunner;

    JLabel hpBarMage;
    JLabel energyBarMage;

    JLabel hpBar;
    //Hp and energy bars

    ImageIcon image;
    Dimension size;

    Lvl lvl;
    Money money;

    Hero hero;
    Knight knight;
    Cleric cleric;
    Gunner gunner;
    Mage mage;
    Monsters monster;

    HeroUpPrice heroUp;
    HelpersUpPrice helpersUp;

    int upLvl[];

    VisualInterface() {
        super("Hero Route");
        setBounds(450,0,500,750);
        setMinimumSize(new Dimension(500,750));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(0,0,500,800);
        add(mainPanel);

        addMenuBar();
        addButtons();
        addHero();
        addUpgradeMenuHero();
        addUpgradeMenuHelpers();
        heroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgradeMenuHero.setVisible(true);
                upgradeMenuHelpers.setVisible(false);
                menuBar.setBounds(0,675,500,25);
                menuBar.setBounds(0,400,500,25);
                checkHeroVisible(false);
                checkOnExisting(false);
            }
        });

        helpers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgradeMenuHero.setVisible(false);
                upgradeMenuHelpers.setVisible(true);
                menuBar.setBounds(0,675,500,25);
                menuBar.setBounds(0,400,500,25);
                checkHeroVisible(false);
                checkOnExisting(false);
            }
        });
        closeUpgrages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgradeMenuHero.setVisible(false);
                upgradeMenuHelpers.setVisible(false);
                menuBar.setBounds(0,675,500,25);
                checkHeroVisible(true);
                checkOnExisting(true);
            }
        });

        upgradesHelpers[0].addActionListener(new ActionListener() {//Knight
            @Override
            public void actionPerformed(ActionEvent e) {
                if(upgradesHelpers[0].getText() == "Buy")
                {
                    if(checkMoney(helpersUp.getKnightBuy()))
                    {
                        addKnight();
                        buyKnight();
                        upgradesHelpers[0].setText("Upgrade");
                    }
                }
                else
                {
                    if(checkMoney(helpersUp.getKnightUp()))
                    {
                        upKnight();
                        helpersUp.upKnight();
                        hpBarKnight.setText(knight.getHp()+"/"+knight.getMaxHp());
                        hpBarKnight.setVisible(false);
                        energyBarKnight.setText(knight.getEnergy()+"/"+knight.getMaxEnergy());
                        energyBarKnight.setVisible(false);
                        priceHelpers[0].setText(""+helpersUp.getKnightUp());
                        setNewMoney();
                    }
                }
            }
        });
        upgradesHelpers[1].addActionListener(new ActionListener() {//Cleric
            @Override
            public void actionPerformed(ActionEvent e) {
                if(upgradesHelpers[1].getText() == "Buy")
                {
                    if(checkMoney(helpersUp.getClericBuy()))
                    {
                        addCleric();
                        buyCleric();
                        upgradesHelpers[1].setText("Upgrade");
                    }
                }
                else
                {
                    if(checkMoney(helpersUp.getClericUp()))
                    {
                        upCleric();
                        helpersUp.upCleric();
                        hpBarCleric.setText(cleric.getHp()+"/"+cleric.getMaxHp());
                        hpBarCleric.setVisible(false);
                        energyBarCleric.setText(cleric.getEnergy()+"/"+cleric.getMaxEnergy());
                        energyBarCleric.setVisible(false);
                        priceHelpers[1].setText(""+helpersUp.getClericUp());
                        setNewMoney();
                    }
                }
            }
        });
        upgradesHelpers[2].addActionListener(new ActionListener() {//Gunner
            @Override
            public void actionPerformed(ActionEvent e) {
                if(upgradesHelpers[2].getText() == "Buy")
                {
                    if(checkMoney(helpersUp.getGunnerBuy()))
                    {
                        addGunner();
                        buyGunner();
                        upgradesHelpers[2].setText("Upgrade");
                    }
                }
                else
                {
                    if(checkMoney(helpersUp.getGunnerUp()))
                    {
                        upGunner();
                        helpersUp.upGunner();
                        hpBarGunner.setText(gunner.getHp()+"/"+gunner.getMaxHp());
                        hpBarGunner.setVisible(false);
                        energyBarGunner.setText(gunner.getEnergy()+"/"+gunner.getMaxEnergy());
                        energyBarGunner.setVisible(false);
                        priceHelpers[2].setText(""+helpersUp.getGunnerUp());
                        setNewMoney();
                    }
                }
            }
        });
        upgradesHelpers[3].addActionListener(new ActionListener() {//Mage
            @Override
            public void actionPerformed(ActionEvent e) {
                if(upgradesHelpers[3].getText() == "Buy")
                {
                    if (checkMoney(helpersUp.getMageBuy()))
                    {
                        addMage();
                        buyMage();
                        upgradesHelpers[3].setText("Upgrade");
                    }
                }
                else
                {
                    if(checkMoney(helpersUp.getMageUp()))
                    {
                        upMage();
                        helpersUp.upMage();
                        hpBarMage.setText(mage.getHp()+"/"+mage.getMaxHp());
                        hpBarMage.setVisible(false);
                        energyBarMage.setText(mage.getEnergy()+"/"+mage.getMaxEnergy());
                        energyBarMage.setVisible(false);
                        priceHelpers[3].setText(""+helpersUp.getMageUp());
                        setNewMoney();
                    }
                }
            }
        });

        upgradesHero[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkMoney(heroUp.getLvlCost()))
                {
                    upLvl[0]++;
                    upVis[0].setText(""+upLvl[0]);
                    upgradeLvl();
                    priceHero[0].setText(""+heroUp.getLvlCost());
                    hpBarHero.setText(hero.getHp()+"/"+hero.getMaxHp());
                    hpBarHero.setVisible(false);
                    energyBarHero.setText(hero.getEnergy()+"/"+hero.getMaxEnergy());
                    energyBarHero.setVisible(false);
                    heroStats[0].setText(""+hero.getMaxHp());
                    heroStats[1].setText(""+hero.getDamage());
                    heroStats[2].setText(""+hero.getArmor());
                    heroStats[3].setText(""+hero.getMaxEnergy());
                    heroStats[4].setText(""+hero.getAttackSpeed());
                    setNewMoney();
                }
            }
        });
        upgradesHero[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkMoney(heroUp.getHpCost()))
                {
                    upLvl[1]++;
                    upVis[1].setText(""+upLvl[1]);
                    upgradeHp();
                    priceHero[1].setText(""+heroUp.getHpCost());
                    hpBarHero.setText(hero.getHp()+"/"+hero.getMaxHp());
                    hpBarHero.setVisible(false);
                    heroStats[0].setText(""+hero.getMaxHp());
                    setNewMoney();
                }
            }
        });
        upgradesHero[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkMoney(heroUp.getDamageCost()))
                {
                    upLvl[2]++;
                    upVis[2].setText(""+upLvl[2]);
                    upgradeDamage();
                    priceHero[2].setText(""+heroUp.getDamageCost());
                    hpBarHero.setText(hero.getHp()+"/"+hero.getMaxHp());
                    hpBarHero.setVisible(false);
                    heroStats[1].setText(""+hero.getDamage());
                    setNewMoney();
                }
            }
        });
        upgradesHero[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkMoney(heroUp.getArmorCost()))
                {
                    upLvl[3]++;
                    upVis[3].setText(""+upLvl[3]);
                    upgradeArmor();
                    priceHero[3].setText(""+heroUp.getArmorCost());
                    heroStats[2].setText(""+hero.getArmor());
                    setNewMoney();
                }
            }
        });
        upgradesHero[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkMoney(heroUp.getEnergyCost()))
                {
                    upLvl[4]++;
                    upVis[4].setText(""+upLvl[4]);
                    upgradeEnergy();
                    priceHero[4].setText(""+heroUp.getEnergyCost());
                    energyBarHero.setText(hero.getEnergy()+"/"+hero.getMaxEnergy());
                    energyBarHero.setVisible(false);
                    heroStats[3].setText(""+hero.getMaxEnergy());
                    setNewMoney();
                }
            }
        });
        upgradesHero[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkMoney(heroUp.getAttacSpeedCost()))
                {
                    upLvl[5]++;
                    upVis[5].setText(""+upLvl[5]);
                    upgradeAttacSpeed();
                    priceHero[5].setText(""+heroUp.getAttacSpeedCost());
                    heroStats[4].setText(""+hero.getAttackSpeed());
                    setNewMoney();
                }
            }
        });
    }

    //Upgrade hero
    void upgradeLvl(){
        hero.upgradeMaxHp(1.4);
        hero.upgradeMaxEnergy(1.1);
        hero.upgradeArmor(1.2);
        hero.upgradeDamage(1.29);
        hero.upgradeAttacSpeed(1.3);
        money.setMoney(money.getMoney() - heroUp.getLvlCost());
        heroUp.upLvl();
    }
    void upgradeHp(){
        hero.upgradeMaxHp(1.1);
        heroUp.upHp();
        money.setMoney(money.getMoney() - heroUp.getHpCost());
    }
    void upgradeDamage(){
        hero.upgradeDamage(1.15);
        money.setMoney(money.getMoney() - heroUp.getDamageCost());
        heroUp.upDamage();
    }
    void upgradeArmor(){
        hero.upgradeArmor(1.25);
        money.setMoney(money.getMoney() - heroUp.getArmorCost());
        heroUp.upArmor();
    }
    void upgradeEnergy(){
        hero.upgradeMaxEnergy(1.2);
        money.setMoney(money.getMoney() - heroUp.getEnergyCost());
        heroUp.upEnergy();
    }
    void upgradeAttacSpeed(){
        hero.upgradeAttacSpeed(1.2);
        money.setMoney(money.getMoney() - heroUp.getAttacSpeedCost());
        heroUp.upAttacSpeed();
    }
    //Upgrade hero

    //Upgrade helpers
    void upKnight(){
        knight.upgradeMaxHp(1.2);
        knight.upgradeArmor(1.3);
        knight.upgradeDamage(1.2);
        knight.upgradeAttacSpeed(1.1);
        knight.upgradeMaxEnergy(1.1);
        money.setMoney(money.getMoney() - helpersUp.getKnightUp());
    }
    void upCleric(){
        cleric.upgradeMaxHp(1.2);
        cleric.upgradeArmor(1.1);
        cleric.upgradeDamage(1.1);
        cleric.upgradeAttacSpeed(1.2);
        cleric.upgradeMaxEnergy(1.3);
        money.setMoney(money.getMoney() - helpersUp.getClericUp());
    }
    void upGunner() {
        gunner.upgradeMaxHp(1.1);
        gunner.upgradeArmor(1.1);
        gunner.upgradeDamage(1.5);
        gunner.upgradeAttacSpeed(1.3);
        gunner.upgradeMaxEnergy(1.1);
        money.setMoney(money.getMoney() - helpersUp.getGunnerUp());
    }
    void upMage(){
        mage.upgradeMaxHp(1.2);
        mage.upgradeArmor(1.1);
        mage.upgradeDamage(1.2);
        mage.upgradeAttacSpeed(1.1);
        mage.upgradeMaxEnergy(1.6);
        money.setMoney(money.getMoney() - helpersUp.getMageUp());
    }
    //Upgrade helpers

    //Upgrade monster
    void upMonster() {
        monster.upgradeMaxHp(1.05);
        monster.upgradeDamage(1.1);
        hpBar.setText(monster.getHp()+"/"+monster.getMaxHp());
    }
    void decreaseMonster() {
        monster.decreaseMaxHp(1.05);
        monster.decreaseDamage(1.1);
        hpBar.setText(monster.getHp()+"/"+monster.getMaxHp());
    }
    //Upgrade monster

    //Buy helpers
    boolean checkMoney(int price) {

        if(money.getMoney() < price)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    void buyKnight(){
        money.setMoney(money.getMoney() - knight.getPrice());
        priceHelpers[0].setText(""+ helpersUp.getKnightUp());
        setNewMoney();
    }
    void buyCleric(){
        money.setMoney(money.getMoney() - cleric.getPrice());
        priceHelpers[1].setText(""+helpersUp.getClericUp());
        setNewMoney();
    }
    void buyGunner(){
        money.setMoney(money.getMoney() - gunner.getPrice());
        priceHelpers[2].setText(""+helpersUp.getGunnerUp());
        setNewMoney();
    }
    void buyMage(){
        money.setMoney(money.getMoney() - mage.getPrice());
        priceHelpers[3].setText(""+helpersUp.getMageUp());
        setNewMoney();
    }
    //Buy helpers


    //Visual ads
    void checkHeroVisible(boolean var)
    {
        if(var == false)
        {
            heroIm.setVisible(false);
            hpBarHero.setVisible(false);
            energyBarHero.setVisible(false);
        }
        else
        {
            heroIm.setVisible(true);
            hpBarHero.setVisible(true);
            energyBarHero.setVisible(true);
        }
    }
    void checkOnExisting(boolean var)
    {
        if(knightIm != null)
        {
            if(var == false)
            {
                knightIm.setVisible(false);
                hpBarKnight.setVisible(false);
                energyBarKnight.setVisible(false);
            }
            else
            {
                knightIm.setVisible(true);
                hpBarKnight.setVisible(true);
                energyBarKnight.setVisible(true);
            }

        }
        if(clericIm != null)
        {
            if(var == false)
            {
                clericIm.setVisible(false);
                hpBarCleric.setVisible(false);
                energyBarCleric.setVisible(false);
            }
            else
            {
                clericIm.setVisible(true);
                hpBarCleric.setVisible(true);
                energyBarCleric.setVisible(true);
            }

        }
        if(gunnerIm != null)
        {
            if(var == false)
            {
                gunnerIm.setVisible(false);
                hpBarGunner.setVisible(false);
                energyBarGunner.setVisible(false);
            }
            else
            {
                gunnerIm.setVisible(true);
                hpBarGunner.setVisible(true);
                energyBarGunner.setVisible(true);
            }

        }
        if(mageIm != null)
        {
            if(var == false)
            {
                mageIm.setVisible(false);
                hpBarMage.setVisible(false);
                energyBarMage.setVisible(false);
            }
            else
            {
                mageIm.setVisible(true);
                hpBarMage.setVisible(true);
                energyBarMage.setVisible(true);
            }

        }
    }
    //Visual ads

    //Buttons & menu bar
    void addMenuBar() {
        menuBar = new JPanel(new GridLayout(1,3));
        menuBar.setBounds(0,675,500,25);
        menuBar.setVisible(true);
        mainPanel.add(menuBar);
    }
    void addButtons() {
        heroButton = new JButton("Hero");
        helpers = new JButton("Helpers");
        closeUpgrages = new JButton("Hide");
        menuBar.add(heroButton);
        menuBar.add(helpers);
        menuBar.add(closeUpgrages);
    }
    //Buttons & menu bar

    //Game base
    public void startNewGame()
    {
        setMoney();
        setLvl();
        addMonster();
        nextRoundTimerCreate();
        pack();
    }
    void setMoney(){
        money = new Money();
        moneyVision = new JLabel("Money: "+ money.getMoney());
        moneyVision.setBounds(400,0,100,50);
        moneyVision.setBackground(Color.ORANGE);
        moneyVision.setFont(new Font("serif",Font.BOLD,15));
        moneyVision.setOpaque(true);
        mainPanel.add(moneyVision);
    }
    void setNewMoney(){
        moneyVision.setText("Money:"+money.getMoney());
    }
    public void setLvl()
    {
        lvl = new Lvl();
        lvlVision = new JLabel("Level"+ lvl.getLvl());
        lvlVision.setBounds(250,0,100,50);
        lvlVision.setBackground(Color.CYAN);
        lvlVision.setOpaque(true);
        mainPanel.add(lvlVision);
    }
    public void setNewLvl()
    {
        lvl.increaseLvl();
        lvlVision.setText("Level:"+lvl.getLvl());
        upMonster();
        regenerateAll();
        money.moneyGet(lvl.getLvl());
    }
    public void setLowerLevel()
    {
        lvl.decreaseLvl();
        lvlVision.setText("Level:"+lvl.getLvl());
        decreaseMonster();
        regenerateAll();
    }
    public void regenerateAll(){
        monster.setHp(monster.getMaxHp());
        hero.setHp(hero.getMaxHp());
        hpBarHero.setText(hero.getHp()+"/"+hero.getMaxHp());
        hero.setEnergy(hero.getMaxEnergy());
        energyBarHero.setText(hero.getEnergy()+"/"+hero.getMaxEnergy());
        checkToRegen();
        hero.setDeadMark(false);
    }
    void checkToRegen()
    {
        if(knight != null)
        {
            knight.setHp(knight.getMaxHp());
            knight.setEnergy(knight.getMaxEnergy());
            hpBarKnight.setText(knight.getHp()+"/"+knight.getMaxHp());
            energyBarKnight.setText(knight.getEnergy()+"/"+knight.getMaxEnergy());
            knight.setDeadMark(false);
        }
        if(cleric != null)
        {
            cleric.setHp(cleric.getMaxHp());
            cleric.setEnergy(cleric.getMaxEnergy());
            hpBarCleric.setText(cleric.getHp()+"/"+cleric.getMaxHp());
            energyBarCleric.setText(cleric.getEnergy()+"/"+cleric.getMaxEnergy());
            cleric.setDeadMark(false);
        }
        if(gunner != null)
        {
            gunner.setHp(gunner.getMaxHp());
            gunner.setEnergy(gunner.getMaxEnergy());
            hpBarGunner.setText(gunner.getHp()+"/"+gunner.getMaxHp());
            energyBarGunner.setText(gunner.getEnergy()+"/"+gunner.getMaxEnergy());
            gunner.setDeadMark(false);
        }
        if(mage != null)
        {
            mage.setHp(mage.getMaxHp());
            mage.setEnergy(mage.getMaxEnergy());
            hpBarMage.setText(mage.getHp()+"/"+mage.getMaxHp());
            energyBarMage.setText(mage.getEnergy()+"/"+mage.getMaxEnergy());
            mage.setDeadMark(false);
        }
    }
    void nextRoundTimerCreate() {
        nextRoundTimer = new JLabel("Next round in: ");
        nextRoundTimer.setBounds(0,0,150,50);
        nextRoundTimer.setFont(new Font("serif",Font.BOLD,20));
        nextRoundTimer.setVisible(false);
        mainPanel.add(nextRoundTimer);
    }
    public void nextRoundTimerCount(long time) {
        nextRoundTimer.setText("Next round in:"+time);
        nextRoundTimer.setVisible(true);
    }
    public void setNextRoundTimerHide(){nextRoundTimer.setVisible(false);}
    //Game base

    //Creatures
    //Hero
    void addHero()
    {
        image = new ImageIcon("src/Game_files/Hero.png");
        setIconImage(image.getImage());
        getContentPane().add(new JLabel(image));
        heroIm = new JLabel(image);
        hero = new Hero();
        heroIm.setBounds(200,375,100,100);
        setHpBarHero();
        setEnergyBarHero();
        mainPanel.add(heroIm);
    }
    void setHpBarHero(){
        hpBarHero = new JLabel(hero.getHp()+"/"+hero.getMaxHp());
        hpBarHero.setBounds(220,475,70,20);
        hpBarHero.setBackground(Color.RED);
        hpBarHero.setOpaque(true);
        mainPanel.add(hpBarHero);
    }
    void setEnergyBarHero(){
        energyBarHero = new JLabel(hero.getEnergy()+"/"+hero.getMaxEnergy());
        energyBarHero.setBounds(220,475 + 20,70,20);
        energyBarHero.setBackground(Color.BLUE);
        energyBarHero.setOpaque(true);
        mainPanel.add(energyBarHero);
    }
    //Hero

    //Knight
    void addKnight()
    {
        image = new ImageIcon("src/Game_files/Knight.png");
        setIconImage(image.getImage());
        getContentPane().add(new JLabel(image));
        knightIm = new JLabel(image);
        knightIm.setBounds(100,375,100,100);
        knightIm.setVisible(false);
        mainPanel.add(knightIm);
        knight = new Knight();
        setHpBarKnight();
        setEnergyBarKnight();
    }
    void setHpBarKnight(){
        hpBarKnight = new JLabel(knight.getHp()+"/"+knight.getMaxHp());
        hpBarKnight.setBounds(120,475,70,20);
        hpBarKnight.setBackground(Color.RED);
        hpBarKnight.setVisible(false);
        hpBarKnight.setOpaque(true);
        mainPanel.add(hpBarKnight);
    }
    void setEnergyBarKnight(){
        energyBarKnight = new JLabel(knight.getEnergy()+"/"+knight.getMaxEnergy());
        energyBarKnight.setBounds(120,475 + 20,70,20);
        energyBarKnight.setBackground(Color.BLUE);
        energyBarKnight.setOpaque(true);
        energyBarKnight.setVisible(false);
        mainPanel.add(energyBarKnight);
    }
    //Knight

    //Cleric
    void addCleric()
    {
        image = new ImageIcon("src/Game_files/Cleric.png");
        setIconImage(image.getImage());
        getContentPane().add(new JLabel(image));
        clericIm = new JLabel(image);
        clericIm.setBounds(0,375,100,100);
        clericIm.setVisible(false);
        mainPanel.add(clericIm);
        cleric = new Cleric();
        setHpBarCleric();
        setEnergyBarCleric();
    }
    void setHpBarCleric(){
        hpBarCleric = new JLabel(cleric.getHp()+"/"+cleric.getMaxHp());
        hpBarCleric.setBounds(20,475,70,20);
        hpBarCleric.setBackground(Color.RED);
        hpBarCleric.setOpaque(true);
        mainPanel.add(hpBarCleric);
    }
    void setEnergyBarCleric(){
        energyBarCleric = new JLabel(cleric.getEnergy()+"/"+cleric.getMaxEnergy());
        energyBarCleric.setBounds(20,475 + 20,70,20);
        energyBarCleric.setBackground(Color.BLUE);
        energyBarCleric.setOpaque(true);
        mainPanel.add(energyBarCleric);
    }
    //Cleric

    //Gunner
    void addGunner()
    {
        image = new ImageIcon("src/Game_files/Gunner.png");
        setIconImage(image.getImage());
        getContentPane().add(new JLabel(image));
        gunnerIm = new JLabel(image);
        gunnerIm.setBounds(300,375,100,100);
        gunnerIm.setVisible(false);
        mainPanel.add(gunnerIm);
        gunner = new Gunner();
        setHpBarGunner();
        setEnergyBarGunner();
    }
    void setHpBarGunner(){
        hpBarGunner = new JLabel(gunner.getHp()+"/"+gunner.getMaxHp());
        hpBarGunner.setBounds(320,475,70,20);
        hpBarGunner.setBackground(Color.RED);
        hpBarGunner.setOpaque(true);
        mainPanel.add(hpBarGunner);
    }
    void setEnergyBarGunner(){
        energyBarGunner = new JLabel(gunner.getEnergy()+"/"+gunner.getMaxEnergy());
        energyBarGunner.setBounds(320,475 + 20,70,20);
        energyBarGunner.setBackground(Color.BLUE);
        energyBarGunner.setOpaque(true);
        mainPanel.add(energyBarGunner);
    }
    //Gunner

    //Mage
    void addMage()
    {
        image = new ImageIcon("src/Game_files/Mage.png");
        setIconImage(image.getImage());
        getContentPane().add(new JLabel(image));
        mageIm = new JLabel(image);
        mageIm.setBounds(400,375,100,100);
        mageIm.setVisible(false);
        mainPanel.add(mageIm);
        mage = new Mage();
        setHpBarMage();
        setEnergyBarMage();
    }
    void setHpBarMage(){
        hpBarMage = new JLabel(mage.getHp()+"/"+mage.getMaxHp());
        hpBarMage.setBounds(420,475,70,20);
        hpBarMage.setBackground(Color.RED);
        hpBarMage.setOpaque(true);
        mainPanel.add(hpBarMage);
    }
    void setEnergyBarMage(){
        energyBarMage = new JLabel(mage.getEnergy()+"/"+mage.getMaxEnergy());
        energyBarMage.setBounds(420,475 + 20,70,20);
        energyBarMage.setBackground(Color.BLUE);
        energyBarMage.setOpaque(true);
        mainPanel.add(energyBarMage);
    }
    //Mage

    //Monster
    void addMonster()
    {
        int randNum = new Random().nextInt(6) + 1;

        image = new ImageIcon("src/Game_files/Monster"+randNum+".png");
        setIconImage(image.getImage());
        getContentPane().add(new JLabel(image));
        monsterIm = new JLabel(image);
        monsterIm.setBounds(100,50,250,250);
        monster = new Monsters();
        setMonsterHpBar();
        mainPanel.add(monsterIm);

    }
    public void hideMonster(){monsterIm.setVisible(false);}
    public void setNewMonster()
    {
        int randNum = new Random().nextInt(6) + 1;
        image = new ImageIcon("src/Game_files/Monster"+randNum+".png");
        setIconImage(image.getImage());
        getContentPane().add(new JLabel(image));
        monsterIm.setIcon(image);
        monsterIm.setVisible(true);
    }
    void setMonsterHpBar(){
        hpBar = new JLabel(monster.getHp()+"/"+ monster.getMaxHp());
        hpBar.setBounds(100,300,300,20);
        hpBar.setBackground(Color.RED);
        hpBar.setOpaque(true);
        mainPanel.add(hpBar);
    }
    //Monster
    //Creatures

    //Updates bar
        //Hero
    void addUpgradeMenuHero() {
        int rowsNum = 6;
        upgradeMenuHero = new JPanel(null);
        upgradeMenuHero.setVisible(false);
        upgradeMenuHero.setBounds(0,425,500,375);
        String upNames[];
        upLvl = new int[rowsNum];
        upNames = new String[rowsNum];
        upNames[0] = "Lvl";
        upNames[1] = "Hp";
        upNames[2] = "Damage";
        upNames[3] = "Armor";
        upNames[4] = "Energy";
        upNames[5] = "Speed";

        int topStep = 30;
        upgradesHero = new JButton[rowsNum];
        upVis = new JLabel[rowsNum];
        priceHero = new JLabel[rowsNum];
        heroStats = new JLabel[rowsNum - 1];


        words = new JLabel("Type");
        words.setBounds(0,0,150,25);
        upgradeMenuHero.add(words);
        words = new JLabel("Up lvl");
        words.setBounds(100,0,50,25);
        upgradeMenuHero.add(words);
        words = new JLabel("Stats");
        words.setBounds(175,0,150,25);
        upgradeMenuHero.add(words);
        words = new JLabel("Price");
        words.setBounds(300,0,150,25);
        upgradeMenuHero.add(words);

        heroUp = new HeroUpPrice();

        priceHero[0] = new JLabel(""+heroUp.getLvlCost());
        priceHero[0].setBounds(300,30,80,25);
        upgradeMenuHero.add(priceHero[0]);

        priceHero[1] = new JLabel(""+heroUp.getHpCost());
        priceHero[1].setBounds(300,70,80,25);
        upgradeMenuHero.add(priceHero[1]);

        priceHero[2] = new JLabel(""+heroUp.getDamageCost());
        priceHero[2].setBounds(300,110,80,25);
        upgradeMenuHero.add(priceHero[2]);

        priceHero[3] = new JLabel(""+heroUp.getArmorCost());
        priceHero[3].setBounds(300,150,80,25);
        upgradeMenuHero.add(priceHero[3]);

        priceHero[4] = new JLabel(""+heroUp.getEnergyCost());
        priceHero[4].setBounds(300,190,80,25);
        upgradeMenuHero.add(priceHero[4]);

        priceHero[5] = new JLabel(""+heroUp.getAttacSpeedCost());
        priceHero[5].setBounds(300,230,80,25);
        upgradeMenuHero.add(priceHero[5]);


        heroStats[0] = new JLabel(""+hero.getMaxHp());
        heroStats[0].setBounds(175,70,150,25);
        upgradeMenuHero.add(heroStats[0]);

        heroStats[1] = new JLabel(""+hero.getDamage());
        heroStats[1].setBounds(175,110,150,25);
        upgradeMenuHero.add(heroStats[1]);

        heroStats[2] = new JLabel(""+hero.getArmor());
        heroStats[2].setBounds(175,150,150,25);
        upgradeMenuHero.add(heroStats[2]);

        heroStats[3] = new JLabel(""+hero.getMaxEnergy());
        heroStats[3].setBounds(175,190,150,25);
        upgradeMenuHero.add(heroStats[3]);

        heroStats[4] = new JLabel(""+hero.getAttackSpeed());
        heroStats[4].setBounds(175,230,150,25);
        upgradeMenuHero.add(heroStats[4]);


        for(int i = 0 ; i < rowsNum; i++)
        {
            words = new JLabel(upNames[i]);
            words.setBounds(0,topStep,150,25);
            upgradeMenuHero.add(words);

            upLvl[i] = 1;
            upVis[i] = new JLabel(""+upLvl[i]);
            upVis[i].setBounds(100,topStep,150,25);
            upgradeMenuHero.add(upVis[i]);

            upgradesHero[i] = new JButton("Upgrade");
            upgradesHero[i].setBounds(400,topStep,100,25);
            upgradeMenuHero.add(upgradesHero[i]);
            upgradesHero[i].setFont(new Font("serif",Font.BOLD,12));

            topStep += 40;
        }
        mainPanel.add(upgradeMenuHero);
    }
        //Hero

        //Helpers
        void addUpgradeMenuHelpers()
        {
            int rowsNum = 4;
            upgradeMenuHelpers = new JPanel(null);
            upgradeMenuHelpers.setVisible(false);
            upgradeMenuHelpers.setBounds(0,425,500,375);
            String upNames[];
            upNames = new String[rowsNum];
            upNames[0] = "Knight";
            upNames[1] = "Cleric";
            upNames[2] = "Gunner";
            upNames[3] = "Mage";

            String helpersDescribe[];
            helpersDescribe = new String[rowsNum];
            helpersDescribe[0] = "Take`s damage";
            helpersDescribe[1] = "Heal ur team";
            helpersDescribe[2] = "Deal massive damage";
            helpersDescribe[3] = "Enchant ur team";

            upgradesHelpers = new JButton[rowsNum];
            priceHelpers = new JLabel[rowsNum];
            helpersUp = new HelpersUpPrice();
            priceHelpers[0] = new JLabel(""+helpersUp.getKnightBuy());
            priceHelpers[0].setBounds(320,30,80,25);
            upgradeMenuHelpers.add(priceHelpers[0]);

            priceHelpers[1] = new JLabel(""+helpersUp.getClericBuy());
            priceHelpers[1].setBounds(320,70,80,25);
            upgradeMenuHelpers.add(priceHelpers[1]);

            priceHelpers[2] = new JLabel(""+helpersUp.getGunnerBuy());
            priceHelpers[2].setBounds(320,110,80,25);
            upgradeMenuHelpers.add(priceHelpers[2]);

            priceHelpers[3] = new JLabel(""+helpersUp.getMageBuy());
            priceHelpers[3].setBounds(320,150,80,25);
            upgradeMenuHelpers.add(priceHelpers[3]);


            words = new JLabel("Type");
            words.setBounds(0,0,150,25);
            upgradeMenuHelpers.add(words);
            words = new JLabel("Description");
            words.setBounds(150,0,150,25);
            upgradeMenuHelpers.add(words);
            words = new JLabel("Price");
            words.setBounds(325,0,150,25);
            upgradeMenuHelpers.add(words);

            int topStep = 30;
            for(int i = 0 ; i < rowsNum; i++)
            {
                words = new JLabel(upNames[i]);
                words.setBounds(0,topStep,150,25);
                upgradeMenuHelpers.add(words);

                words = new JLabel(helpersDescribe[i]);
                words.setBounds(150,topStep,150,25);
                upgradeMenuHelpers.add(words);

                upgradesHelpers[i] = new JButton("Buy");
                upgradesHelpers[i].setBounds(400,topStep,100,25);
                upgradeMenuHelpers.add(upgradesHelpers[i]);
                upgradesHelpers[i].setFont(new Font("serif",Font.BOLD,12));
                topStep += 40;
            }
            mainPanel.add(upgradeMenuHelpers);
        }
        //Helpers
    //Updates bar

    //Damage
    public void attackHeroes(){
        if(knight == null)
        {
            dealRandHeroDam();
        }
        else
        {
            if(knight.getHp() > 0)
            {
                dealKnightDam();
            }
            else
            {
                dealRandHeroDam();
            }
        }
    }

    void dealRandHeroDam(){
        int heroNum = arrSize();
        int heroArr[];
        int rand;
        heroArr = new int[heroNum];
        heroArr = findExistingHeroes();
        boolean out = false;
        rand = (int)(Math.random() * 4);
        for(int i = 0 ; i < heroNum; i++)
        {
            if(heroArr[i] == rand)
            {
                out = true;
                break;
            }
        }

        if(out == false)
        {
            rand = 0;
        }

        switch (rand)
        {
            case 0:
                hero.setHp((int)(hero.getHp() - monster.getDamage()* calculateArmorDef(hero.getArmor())));
                hpBarHero.setText(hero.getHp()+"/"+hero.getMaxHp());
                if(hero.getHp() <= 0)
                {
                    hero.setDeadMark(true);
                }
                break;

            case 1:
                cleric.setHp((int)(cleric.getHp() - monster.getDamage() * calculateArmorDef(cleric.getArmor())));
                hpBarCleric.setText(cleric.getHp()+"/"+cleric.getMaxHp());
                if(cleric.getHp() <= 0)
                {
                    cleric.setDeadMark(true);
                }
                break;

            case 2:
                gunner.setHp((int)(gunner.getHp() - monster.getDamage() * calculateArmorDef(gunner.getArmor())));
                hpBarGunner.setText(gunner.getHp()+"/"+gunner.getMaxHp());
                if(gunner.getHp() <= 0)
                {
                    gunner.setDeadMark(true);
                }
                break;

            case 3:
                mage.setHp((int)(mage.getHp() - monster.getDamage() * calculateArmorDef(mage.getArmor())));
                hpBarMage.setText(mage.getHp()+"/"+mage.getMaxHp());
                if(mage.getHp() <= 0)
                {
                    mage.setDeadMark(true);
                }
                break;
        }
    }

    public boolean checkForAlive() {
        if((hero.getDeadMark() == true) && (hero.getDeadMark() == true) && (hero.getDeadMark() == true)
                                        && (hero.getDeadMark() == true) && (hero.getDeadMark() == true))
        {
            return true;
        }
        return false;
    }

    int arrSize(){
        int heroNum = 1;
        if(cleric != null)
        {
            heroNum++;
        }
        if(gunner != null)
        {
            heroNum++;
        }
        if(mage != null)
        {
            heroNum++;
        }
        return heroNum;
    }

    int []findExistingHeroes() {
        int heroArr[];
        heroArr = new int[arrSize()];
        int heroNum = 1;
        heroArr[0] = 0;
        if(cleric != null)
        {
            heroArr[heroNum] = 1;
            heroNum++;
        }
        if(gunner != null)
        {
            heroArr[heroNum] = 2;
            heroNum++;
        }
        if(mage != null)
        {
            heroArr[heroNum] = 3;
            heroNum++;
        }
        return heroArr;
    }

    void dealKnightDam(){
        knight.setHp((int)(knight.getHp() - monster.getDamage()* calculateArmorDef(knight.getArmor())));
        hpBarKnight.setText(knight.getHp()+"/"+knight.getMaxHp());
        if(knight.getHp() <= 0)
        {
            knight.setDeadMark(true);
        }
    }

    double calculateArmorDef(double armorAmount){
        double damMult;
        damMult = 1 - ((0.052 * armorAmount)/(0.9 + 0.49 * armorAmount));
        return damMult;
    }

    public void heroAttacks(){
        if(!hero.getDeadMark())
        {
            monster.setHp((int)(monster.getHp() - hero.getDamage() * calculateArmorDef(0)));
            hpBar.setText(monster.getHp()+"/"+monster.getMaxHp());
        }
    }

    public void knightAttacks(){
        if(!knight.getDeadMark())
        {
            monster.setHp((int)(monster.getHp() - knight.getDamage() * calculateArmorDef(0)));
            hpBar.setText(monster.getHp()+"/"+monster.getMaxHp());
        }
    }

    public void clericAttacks(){
        if(!cleric.getDeadMark())
        {
            monster.setHp((int)(monster.getHp() - cleric.getDamage() * calculateArmorDef(0)));
            hpBar.setText(monster.getHp()+"/"+monster.getMaxHp());
        }
    }

    public void gunnerAttacks(){
        if(!gunner.getDeadMark())
        {
            monster.setHp((int)(monster.getHp() - gunner.getDamage() * calculateArmorDef(0)));
            hpBar.setText(monster.getHp()+"/"+monster.getMaxHp());
        }
    }

    public void mageAttacks(){
        if(!mage.getDeadMark())
        {
            monster.setHp((int)(monster.getHp() - mage.getDamage() * calculateArmorDef(0)));
            hpBar.setText(monster.getHp()+"/"+monster.getMaxHp());
        }
    }
    //Damage 
}
