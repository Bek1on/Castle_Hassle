import java.util.ArrayList;
public class Archetype {
    private int hp;
    private int defense;
    private int attackDmg;
    private double evasive;
    private double luck;
    private double critChance;
    private String name;
    private ArrayList<Item> inventory;
    private int gold;


    public Archetype(String playerName)
    {
        name = playerName;
        inventory = new ArrayList<Item>();
        gold = 0;
    }

    public int getHP()
    {
        return hp;
    }

    public void attackEnemy(Enemy killMe,int dmg)
    {
        killMe.setHp(killMe.getHp()-dmg);
    }

    public void setHP(int value)
    {
        hp = value;
    }

    public int getGold(){return gold;}

    public void setGold(int value) {gold = value;}

    public void addToInventory(Item added)
    {
        inventory.add(added);
    }

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }


    public void displayStats()
    {
        String display = "Inventory\n";
        String stats = "Name: " + getName() + "\nHP: " + getHP() + "\nDefense: " + getDefense() + "\nAttack Damage: " + getAttack() + "\nCrit Chance: " + getCritChance() + "\nGold: " + getGold();
        for(int i = 0; i < inventory.size();i++)
        {
            display += "[" + inventory.get(i).getName() + "]";
        }
        if(display.equals("Inventory\n"))
        {
            System.out.println("You currently have no items!\n" + stats  + "\n------------------------------");
        }
        else
        {
            System.out.println(display + "\n" + stats + "\n------------------------------");
        }
    }

    public void useItem()
    {

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
