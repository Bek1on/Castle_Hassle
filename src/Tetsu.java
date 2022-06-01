public class Tetsu extends Ninja{

    public Tetsu(String name)
    {
        super(name);
        setHP(135);
        setDefense(55);
        setAttack(53);
        setCritChance(0.0);
        setLuck(0);
        setSecondarySpecial("POCKET SMOKE");
    }

    public void useSpecial(Enemy killMe, String whichSpecialToUse)
    {
        if(whichSpecialToUse.equals("secondary")) {
            System.out.println(getName() + " used their special, POCKET SMOKE! Feast your eyes on this," + killMe.getName() + "!");
            System.out.println(killMe.getName() + " got more sluggish!\n------------------------------");
            killMe.setEvasive(killMe.getEvasive() - .35);
        }
        if(whichSpecialToUse.equals("primary"))
        {
            super.useSpecial(killMe,whichSpecialToUse);
        }
    }
}
