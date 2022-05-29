public class Enkaku extends Ninja{

    public Enkaku(String name)
    {
        super(name);
        setHP(110);
        setAttack(59);
        setDefense(25);
        setCritChance(.01);
        setLuck(0);
    }

    public void useSpecial(Enemy killMe, String whichSpecialToUse)
    {
        if(whichSpecialToUse.equals("secondary")) {
            int defenseDecrease = (int) (Math.random() * getAttack()) + 15;
            double executeChance = Math.random();
            System.out.println(getName() + " used their special, SNIPING SHRED!");
            if (executeChance >= .98) {
                System.out.println(getName() + " hit a clean shot on " + killMe.getName() + "'s head, instantly killing them!\n------------------------------");
                killMe.setHp(0);
            } else {
                System.out.println(killMe.getName() + " has their defense dropped by " + defenseDecrease + "!\n------------------------------");
                killMe.setDefense(killMe.getDefense() - defenseDecrease);
            }
        }
        if(whichSpecialToUse.equals("primary"))
        {
            super.useSpecial(killMe, whichSpecialToUse);
        }

    }
}
