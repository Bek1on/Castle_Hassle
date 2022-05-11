public class Archetype {
    private int hp;
    private int defense;
    private int attackDmg;
    private double evasive;
    private double luck;
    private double critChance;
    private String name;

    public Archetype(String playerName)
    {
        name = playerName;
    }

    public int getHP()
    {
        return hp;
    }

    public void setHP(int value)
    {
        hp = value;
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int value)
    {
        defense = value;
    }

    public int getAttack()
    {
        return attackDmg;
    }

    public void setAttack(int value)
    {
        attackDmg = value;
    }

    public double getEvasive()
    {
        return evasive;
    }

    public void setEvasive(double value)
    {
        evasive = value;
    }

    private double getLuck()
    {
        return luck;
    }

    public void setLuck(double value)
    {
        luck = value;
    }

    public double getCritChance()
    {
        return critChance;
    }

    public void setCritChance()
    {
        critChance = luck / 2;
    }

    public String getName()
    {
        return name;
    }
}
