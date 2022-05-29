public class Plunderer extends Pirate{

    public Plunderer(String name)
    {
        super(name);
        setHP(150);
        setDefense(50);
        setAttack(35);
        setEvasive(.32);
    }

    public void useSpecial(Enemy killMe, String whichSpecialToUse)
    {
        if(whichSpecialToUse.equals("secondary")) {
            int totalDmg = (int) (((Math.random() * 21) + getAttack()) * (100.0 / (100.0 + killMe.getDefense())));
            int goldGained = (int) (Math.random() * 26) + killMe.getGoldCarried() / 2;
            attackEnemy(killMe, totalDmg);
            setGold(getGold() + goldGained);
            System.out.println(getName() + " used their special, ASSAULT AND ROBBERY! EMPTY YOUR POCKETS " + killMe.getName() + "!");
            System.out.println(getName() + " dealt " + totalDmg + " damage and stole " + goldGained + " gold from " + killMe.getName() + "!");
            if(killMe.getHp() > 0) {
                System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
            }
            else
            {
                System.out.println("------------------------------");
            }
        }
        if(whichSpecialToUse.equals("primary"))
        {
            super.useSpecial(killMe,whichSpecialToUse);
        }
    }
}
