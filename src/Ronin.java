public class Ronin extends Ninja{

    public Ronin(String name)
    {
        super(name);
        setHP(135);
        setDefense(45);
        setAttack(55);
        setCritChance(0);
        setLuck(.05);
        setSecondarySpecial("SENSEI'S GAMBLE");
    }

    public void useSpecial(Enemy killMe, String whichSpecialToUse)
    {
        if(whichSpecialToUse.equals("secondary")) {
            int strikeOne = (int) (Math.random() * 16) + 30;
            int strikeTwo = (int) (Math.random() * getAttack()) + 5;
            double doubleStrikeChance = Math.random();
            System.out.println(getName() + " used their special, SENSEI'S GAMBLE!");
            if (doubleStrikeChance >= .5) {
                int totalDmg = (int) ((strikeOne + strikeTwo) * (100.0 / (100.0 + killMe.getDefense())));
                attackEnemy(killMe, totalDmg);
                System.out.println(getName() + " managed to land two hits on " + killMe.getName() + ", dealing " + (strikeOne + strikeTwo) + " damage!");
                if(killMe.getHp() > 0) {
                    System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
                }
                else
                {
                    System.out.println("------------------------------");
                }
            } else {
                int totalDmg = (int) ((strikeOne) * (100.0 / (100.0 + killMe.getDefense())));
                System.out.println(getName() + " only hit " + killMe.getName() + " once, dealing a measly " + strikeOne + " damage!");
                attackEnemy(killMe, totalDmg);
                if(killMe.getHp() > 0) {
                    System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
                }
                else
                {
                    System.out.println("------------------------------");
                }
            }
        }
        if(whichSpecialToUse.equals("primary"))
        {
            super.useSpecial(killMe,whichSpecialToUse);
        }
    }
}
