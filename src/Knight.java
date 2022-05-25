public class Knight extends Archetype{
    private boolean isGonnaParry;

    public Knight(String name)
    {
        super(name);
        setDefense(85);
        setHP(160);
        isGonnaParry = false;
    }

    public void useSpecial(Enemy killMe)
    {
        System.out.println(getName() + "used their special, PARRY!\nSTAND READY! The next enemy attack will have the damage reflected towards the enemy!");
    }

    public void setGonnaParry(boolean value)
    {
        isGonnaParry = value;
    }



}
