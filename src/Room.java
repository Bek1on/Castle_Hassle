import java.util.Scanner;
import java.util.Arrays;
public class Room {
    private final String[] ROOM_TYPES = {"enemy","shop","treasure","boss"};
    private String roomType;
    private boolean objectiveCompleted;

    public Room(int chosenTypeIndex)
    {
        objectiveCompleted = false;
        roomType = ROOM_TYPES[chosenTypeIndex];
    }

    public String getRoomType()
    {
        return roomType;
    }

    public void roomAction(Archetype player)
    {
        if(getRoomType().equals(ROOM_TYPES[1])) {
            Scanner asker = new Scanner(System.in);
            Item[] shopsItems = new Item[5];
            for(int i = 0; i < shopsItems.length;i++)
            {
                shopsItems[i] = new Item();
            }
            String[] itemNames = new String[5];
            for (int i = 0; i < shopsItems.length; i++) {
                itemNames[i] = shopsItems[i].getName();
            }
            String input = "";
            while(!(input.equals("buy") || input.equals("exit")))
            {
                System.out.println("WHAT YOU GONNA DO?");
                System.out.println(Arrays.toString(itemNames));
                System.out.println("-I'd like to buy something...(say \"buy\" to buy an item)\n-I think I'm good, I'm gonna head out...(say \"exit\" to leave the shop and advance to the next room)");
                input = asker.nextLine();
            }
            if(input.equals("buy")) {
                String wantedItem = "";
                while(!isInArray(wantedItem, itemNames))
                {
                    System.out.println("WHACHU BUYING!?!\n" + Arrays.toString(itemNames));
                    wantedItem = asker.nextLine();
                }
                for (int i = 0; i < itemNames.length; i++) {
                    if (itemNames[i].equals(wantedItem) && player.getGold() >= shopsItems[i].getPrice()) {
                        System.out.println("A WISE CHOICE!");
                        player.addToInventory(shopsItems[i]);
                        player.setGold(player.getGold() - shopsItems[i].getPrice());
                        break;
                    }
                    if (itemNames[i].equals(wantedItem) && player.getGold() < shopsItems[i].getPrice()) {
                        System.out.println("GET OUTTA ERE, YOU POOR PERSON!");
                        break;
                    }
                }
                setObjectiveCompleted(true);
            }
            else
            {
                System.out.println("SEE YA WHENEVER!");
                setObjectiveCompleted(true);
            }

        }
        if(getRoomType().equals(ROOM_TYPES[0]))
        {
            Scanner asker = new Scanner(System.in);
            Enemy fightMe = new Enemy();
            System.out.println(fightMe.getName() + " challenges you to a fight!");
            while(fightMe.getHp() > 0) {
                String input = "";
                while (!(input.equals("fight") || input.equals("item") || input.equals("special"))) {
                    System.out.println("What's your move?\n-I strike (say \"fight\")\n-I use an item (say \"item\")\n-I use my special (say \"special\")");
                    input = asker.nextLine();
                }
                if(input.equals("fight"))
                {
                    duel(player,fightMe);
                }
                if(input.equals("item"))
                {
                    String itemUsed = "";
                    String[] currentItems = new String[player.getInventory().size()];
                    for(int i = 0; i < player.getInventory().size();i++)
                    {
                        currentItems[i] = player.getInventory().get(i).getName();
                    }
                    while(!isInArray(itemUsed,currentItems))
                    {
                        System.out.println("What item do you wish to use?");
                        itemUsed = asker.nextLine();
                    }

                }
            }
        }
        if(getRoomType().equals(ROOM_TYPES[2]))
        {

        }
        if(getRoomType().equals(ROOM_TYPES[3]))
        {

        }
    }

    private void setObjectiveCompleted(boolean value)
    {
        objectiveCompleted = value;
    }

    public boolean getObjectiveCompleted()
    {
        return objectiveCompleted;
    }

    private boolean isInArray(String userInput, String[] items)
    {
        for(int i = 0; i < items.length;i++)
        {
            if(items[i].equals(userInput))
            {
                return true;
            }
        }
        return false;
    }

    private void duel(Archetype player, Enemy killMe)
    {
        double playerEvade = (Math.random());
        double enemyEvade = (Math.random());
        if(player.getEvasive() < playerEvade)
        {
            int totalDmg = (int)(killMe.getAttackDmg() * (100 / (100 + player.getDefense())));
            killMe.attackPlayer(player,totalDmg);
            System.out.println(killMe.getName() + " just did " + totalDmg + " damage!");
        }
        else
        {
            System.out.println(player.getName() + " just dodged!");
        }
        if(killMe.getEvasive() < enemyEvade)
        {
            int totalDmg = (int)(player.getAttack() * (100 / (100 + killMe.getDefense())));
            double playerCrit = (Math.random());
            if(player.getCritChance() >= playerCrit)
            {
                totalDmg *= 2;
            }
            player.attackEnemy(killMe,totalDmg);
            System.out.println(player.getName() + " just did " + totalDmg + " damage!");
        }
        else
        {
            System.out.println(killMe.getName() + " just dodged!");
        }
    }
}
