import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
public class PlayersClass {
    private int hp;
    private int defense;
    private int attackDmg;
    private double evasive;
    private double luck;
    private double critChance;
    private String name;
    private ArrayList<Item> inventory;
    private int gold;


    public PlayersClass(String playerName)
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

    public void useSpecial(Enemy killMe)
    {
        System.out.println("I HAVE NO USE"); //<-- always overwritten
    }

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

    public void useItem(String usedItem)
    {
        for(int i = 0; i < inventory.size();i++)
        {
            if(usedItem.equals(inventory.get(i).getName()))
            {
                inventory.remove(i);
                break;
            }
        }
            if(usedItem.equals("blood"))
            {
                setHP(getHP() + 40);
                System.out.println(getName() + " just drank blood to gain 40 HP!");
            }
            if(usedItem.equals("juice"))
            {
                int hpIncrease = (int)(Math.random()*31) + 25;
                setHP(getHP() + hpIncrease);
                System.out.println(getName() + " just drank juice to gain " + hpIncrease + " HP!");
            }
            if(usedItem.equals("shield"))
            {
                setDefense(getDefense() + 10);
                System.out.println(getName() + " just used a shield to increase their defense by 10!");
            }
            if(usedItem.equals("corpse"))
            {
                setHP(getHP() + 60);
                setEvasive(getEvasive() - 0.05);
                System.out.println(getName() + " just ate a corpse to gain 60 HP, growing sluggish in the process!");
            }
            if(usedItem.equals("ant"))
            {
                setAttack(getAttack() + 10);
                System.out.println(getName() + " just ate an ant to increase their damage by 10!");
            }
            if(usedItem.equals("iron"))
            {
                setAttack(getAttack() + 20);
                System.out.println(getName() + " just used a piece of iron to upgrade their weapon, increasing their damage by 20!");
            }
            if(usedItem.equals("amulet"))
            {
                setLuck(getLuck() + 0.02);
                System.out.println(getName() + " is feeling lucky!");
            }
            if(usedItem.equals("scope"))
            {
                setCritChance(getCritChance() + .01);
                System.out.println(getName() + " just attached a scope to their eyeballs, increasing their chance for a critical strike by 1%!");
            }
            if(usedItem.equals("cloak"))
            {
                setEvasive(getEvasive() + 0.01);
                System.out.println(getName() + " is feeling extra light!");
            }
            if(usedItem.equals("cheese"))
            {
                setHP(getHP() + 20);
                setDefense(getDefense() + 5);
                setAttack(getAttack() + 10);
                setEvasive(getEvasive() - 0.01);
                System.out.println(getName() + " IS BUFFED!");
            }

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

    public double getLuck()
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

    public void setCritChance(double value)
    {
        critChance = value;
    }

    public String getName()
    {
        return name;
    }
}
