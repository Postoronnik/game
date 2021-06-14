package AdditionalData;

public class Money extends Lvl {
    long money;
    public Money()
    {
       money = 20000;
    }

    public long getMoney(){return money;}
    public void moneyGet(int lvl)
    {
        money += lvl * 10;
    }
    public void setMoney(long money){this.money  = money;};
}
