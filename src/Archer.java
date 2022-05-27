public class Archer extends Knight{

    public Archer(String name)
    {
        super(name);
        setAttack(36);
        setEvasive(.34);
        setLuck(0.0);
        setCritChance(0);
    }
}
