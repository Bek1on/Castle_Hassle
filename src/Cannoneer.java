public class Cannoneer extends Pirate{

    public Cannoneer(String name)
    {
        super(name);
        setHP(125);
        setDefense(35);
        setAttack(60);
        setEvasive(.35);

    }

    public void useSpecial(Enemy killMe)
    {
        System.out.println(getName() + " whips out a huge cannon and blasts " + killMe.getName() + " with it!");
    }
}
