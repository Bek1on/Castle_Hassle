public class Plunderer extends Pirate{

    public Plunderer(String name)
    {
        super(name);
        setHP(150);
        setDefense(50);
        setAttack(35);
        setEvasive(.4);
    }

    public void useSpecial(Enemy killMe)
    {
        System.out.println(getName() + " ");
    }
}
