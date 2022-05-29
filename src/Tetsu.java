public class Tetsu extends Ninja{

    public Tetsu(String name)
    {
        super(name);
        setHP(135);
        setDefense(55);
        setAttack(53);
        setCritChance(0.0);
        setLuck(0);
    }

    public void useSpecial(Enemy killMe)
    {
        System.out.println(getName() + " used their special, POCKET SMOKE! Feast your eyes on this," + killMe.getName() + "!");
        System.out.println(killMe.getName() + " got more sluggish!");
        killMe.setEvasive(getEvasive() - .1);
    }
}
