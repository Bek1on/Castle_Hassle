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
                    if(player.getHP() <= 0)
                    {
                        break;
                    }
                }
                if(input.equals("item"))
                {
                    if(player.getInventory().size() == 0)
                    {
                        System.out.println("YOU GOT NO ITEMS TO USE");
                    }
                    else {
                        String itemUsed = "";
                        String[] currentItems = new String[player.getInventory().size()];
                        for (int i = 0; i < player.getInventory().size(); i++) {
                            currentItems[i] = player.getInventory().get(i).getName();
                        }
                        while (!isInArray(itemUsed, currentItems)) {
                            System.out.println("What item do you wish to use?");
                            System.out.println(Arrays.toString(currentItems));
                            itemUsed = asker.nextLine();
                        }
                        player.useItem(itemUsed);
                    }
                }
            }
            if(fightMe.getHp() <= 0 && player.getHP() > 0) {
                System.out.println(fightMe.getName() + " has been slain!\n" + player.getName() + " has received " + fightMe.getGoldCarried() + " gold!");
                player.setGold(player.getGold() + fightMe.getGoldCarried());
                setObjectiveCompleted(true);
            }
        }
        if(getRoomType().equals(ROOM_TYPES[2]))
        {
            Scanner asker = new Scanner (System.in);
            System.out.println("LUCKY YOU, YOU JUST WALKED INTO A TREASURE ROOM!");
            int chestOpened = 0;
            while(chestOpened != 1 && chestOpened != 2)
            {
                System.out.println("IN FRONT OF YOU ARE TWO CHESTS, WHICH ONE DO YOU OPEN? (Say \"1\" or \"2\")");
                chestOpened = asker.nextInt();
            }
            int goldChest = (int)(Math.random()*2)+1;
            if(chestOpened == 1)
            {
                if(goldChest == 1)
                {
                    int goldGained = (int)(Math.random()*21) + 10;
                    double lucky = (Math.random());
                    if((1 - player.getLuck()) < lucky)
                    {
                        System.out.println("You got lucky and found twice the amount of gold!");
                       goldGained *= 2;
                       System.out.println(player.getName() +" has received " + goldGained + " gold!");
                       player.setGold(player.getGold() + goldGained);
                    }
                    else
                    {
                        System.out.println(player.getName() +" has received " + goldGained + " gold!");
                        player.setGold(player.getGold() + goldGained);
                    }
                    setObjectiveCompleted(true);
                }
                else
                {
                    Item chestItem = new Item();
                    System.out.println("You have found a(n) " + chestItem.getName() + "!");
                    System.out.println("It will be added to your inventory!");
                    player.addToInventory(chestItem);
                    setObjectiveCompleted(true);
                }
            }
            if(chestOpened == 2)
            {
                if(goldChest == 2)
                {
                    int goldGained = (int)(Math.random()*21) + 10;
                    double lucky = (Math.random());
                    if((1 - player.getLuck()) < lucky)
                    {
                        System.out.println("You got lucky and found twice the amount of gold!");
                        goldGained *= 2;
                        System.out.println(player.getName() +" has received " + goldGained + " gold!");
                        player.setGold(player.getGold() + goldGained);
                    }
                    else
                    {
                        System.out.println(player.getName() +" has received " + goldGained + " gold!");
                        player.setGold(player.getGold() + goldGained);
                    }
                    setObjectiveCompleted(true);
                 }
                {
                    Item chestItem = new Item();
                    System.out.println("You have found a(n) " + chestItem.getName() + "!");
                    System.out.println("It will be added to your inventory!");
                    player.addToInventory(chestItem);
                    setObjectiveCompleted(true);
                }
            }
        }
        if(getRoomType().equals(ROOM_TYPES[3]))
        {
            Scanner asker = new Scanner(System.in);
            Boss bigEnemy = new Boss();
            System.out.println("HERE COMES A BOSS! ITS THE " + bigEnemy.getName());
            while(bigEnemy.getHp() > 0) {
                String input = "";
                while (!(input.equals("fight") || input.equals("item") || input.equals("special"))) {
                    System.out.println("What's your move?\n-I strike (say \"fight\")\n-I use an item (say \"item\")\n-I use my special (say \"special\")");
                    input = asker.nextLine();
                }
                if(input.equals("fight"))
                {
                    duel(player,bigEnemy);
                    if(player.getHP() <= 0)
                    {
                        break;
                    }
                }
                if(input.equals("item"))
                {
                    if(player.getInventory().size() == 0)
                    {
                        System.out.println("YOU GOT NO ITEMS TO USE");
                    }
                    else {
                        String itemUsed = "";
                        String[] currentItems = new String[player.getInventory().size()];
                        for (int i = 0; i < player.getInventory().size(); i++) {
                            currentItems[i] = player.getInventory().get(i).getName();
                        }
                        while (!isInArray(itemUsed, currentItems)) {
                            System.out.println("What item do you wish to use?");
                            System.out.println(Arrays.toString(currentItems));
                            itemUsed = asker.nextLine();
                        }
                        player.useItem(itemUsed);
                    }
                }
            }
            if(bigEnemy.getHp() <= 0 && player.getHP() > 0) {
                System.out.println(bigEnemy.getName() + " has been slain!\n" + player.getName() + " has received " + bigEnemy.getGoldCarried() + " gold!");
                player.setGold(player.getGold() + bigEnemy.getGoldCarried());
                setObjectiveCompleted(true);
            }
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
        String enemyAttacks = "The " + killMe.getName() + " attacks!";
        String playerAttacks = player.getName() + " attacks!";
        double playerEvade = (Math.random());
        double enemyEvade = (Math.random());
        boolean enemyIsBoss = killMe instanceof Boss;
        System.out.println(player.getName() + " HP: " + player.getHP() + "\n" + killMe.getName() + " HP: " + killMe.getHp() + "\n");
        if(!enemyIsBoss) {
            if ((1.0 - player.getEvasive()) > playerEvade) {
                System.out.println(enemyAttacks);
                int totalDmg = (int) (killMe.getAttackDmg() * (100.0 / (100.0 + player.getDefense())));
                killMe.attackPlayer(player, totalDmg);
                System.out.println(killMe.getName() + " just did " + totalDmg + " damage!");
                System.out.println(player.getName() + " now has " + player.getHP() + " HP!\n------------------------------");
            } else {
                System.out.println(enemyAttacks);
                System.out.println(" but " + player.getName() + " just dodged!\n------------------------------");
            }
        }
        else
        {
            double enemyUsesSpecial = (Math.random());
            if(enemyUsesSpecial >= .85)
            {
                killMe.useSpecial(player);
            }
            if ((1.0 - player.getEvasive()) > playerEvade) {
                System.out.println(enemyAttacks);
                int totalDmg = (int) (killMe.getAttackDmg() * (100.0 / (100.0 + player.getDefense())));
                killMe.attackPlayer(player, totalDmg);
                System.out.println(killMe.getName() + " just did " + totalDmg + " damage!");
                System.out.println(player.getName() + " now has " + player.getHP() + " HP!\n------------------------------");
            } else {
                System.out.println(enemyAttacks);
                System.out.println(" but " + player.getName() + " just dodged!\n------------------------------");
            }
        }
        if((1.0-killMe.getEvasive()) > enemyEvade)
        {
            System.out.println(playerAttacks);
            int totalDmg = (int)(player.getAttack() * (100.0 / (100.0 + killMe.getDefense())));
            double playerCrit = (Math.random());
            if(player.getCritChance() >= playerCrit)
            {
                totalDmg *= 2;
                System.out.println(player.getName() + " just landed a critical hit!");
            }
            player.attackEnemy(killMe,totalDmg);
            System.out.println(player.getName() + " just did " + totalDmg + " damage!");
            System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
        }
        else
        {
            System.out.println(playerAttacks);
            System.out.println(" but " + killMe.getName() + " just dodged!\n------------------------------");
        }
    }
}
