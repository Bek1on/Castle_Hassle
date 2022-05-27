public class Heretic extends Knight{

    public Heretic(String name)
    {
        super(name);
        setAttack(55);
        setEvasive(.3);
        setLuck(.2);
        setCritChance(0.02);
    }
}
