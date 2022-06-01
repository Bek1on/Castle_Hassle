import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
public class Room {
    private final String[] ROOM_TYPES = {"enemy","shop","treasure","boss"};
    private String roomType;
    private boolean objectiveCompleted;
    private boolean primarySpecialUsed;
    private boolean secondarySpecialUsed;

    public Room(int chosenTypeIndex)
    {
        objectiveCompleted = false;
        roomType = ROOM_TYPES[chosenTypeIndex];
        if(roomType.equals("enemy") || roomType.equals("boss"))
        {
            primarySpecialUsed = false;
            secondarySpecialUsed = false;
        }
    }

    public String getRoomType()
    {
        return roomType;
    }

    public void roomAction(PlayersCharacter player)
    {
        if(getRoomType().equals(ROOM_TYPES[1])) {
            Scanner asker = new Scanner(System.in);
            Item[] shopsItems = new Item[5];
            shopsItems[0] = new Item((int)(Math.random()*2));
            shopsItems[1] = new Item((int)(Math.random()*2) + 2);
            shopsItems[2] = new Item((int)(Math.random()*2) + 4);
            shopsItems[3] = new Item((int)(Math.random()*2) + 6);
            shopsItems[4] = new Item((int)(Math.random()*2) + 8);
            String[] itemNames = new String[5];
            for (int i = 0; i < shopsItems.length; i++) {
                itemNames[i] = shopsItems[i].getName();
            }
            String input = "";
            while(!(input.equals("buy") || input.equals("exit") || input.equals("sell")))
            {
                System.out.println("WHAT YOU GONNA DO?");
                System.out.println(Arrays.toString(itemNames));
                System.out.println("-I'd like to buy something...(say \"buy\" to buy an item)\n-I think I'm good, I'm gonna head out...(say \"exit\" to leave the shop and advance to the next room)\n-I'd like to sell you some of my wares...(say \"sell\" to sell an item in your inventory)");
                input = asker.nextLine();
            }
            if(input.equals("sell"))
            {
                if(player.getInventory().size() == 0)
                {
                    System.out.println("You got no items to sell!");
                }
                else
                {
                    String display = "Inventory\n";
                    String[] inventoryItems = new String[player.getInventory().size()];
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        inventoryItems[i] = player.getInventory().get(i).getName();
                        display += "[" + player.getInventory().get(i).getName() + "]";
                    }
                    String soldItem = "";
                    while(!isInArray(soldItem,inventoryItems)) {
                        System.out.println("WHATCHU U SELLING BOI???");
                        System.out.println(display);
                        soldItem = asker.nextLine();
                    }
                    for(int i = 0; i < player.getInventory().size();i++)
                    {
                        if(player.getInventory().get(i).getName().equals(soldItem))
                        {
                            System.out.println("Thanks for selling me this " + player.getInventory().get(i).getName() + "!");
                            System.out.println(player.getName() + " received " + player.getInventory().get(i).getPrice() + " gold!");
                            player.setGold(player.getGold() + player.getInventory().get(i).getPrice());
                            player.getInventory().remove(i);
                        }
                    }
                }
            }
            if(input.equals("buy")) {
                String wantedItem = "";
                while(!isInArray(wantedItem, itemNames))
                {
                    String prices = "";
                    System.out.println("WHACHU BUYING!?! CHOOSE WISELY, ONE PURCHASE ONLY, TRAVELER!\n" + Arrays.toString(itemNames));
                    for(int i = 0; i < shopsItems.length;i++)
                    {
                        prices += shopsItems[i].getName() + " Price: " + shopsItems[i].getPrice() + "\n";
                    }
                    System.out.print(prices);
                    wantedItem = asker.nextLine();
                }
                for (int i = 0; i < itemNames.length; i++) {
                    if (itemNames[i].equals(wantedItem) && player.getGold() >= shopsItems[i].getPrice()) {
                        System.out.println("A WISE CHOICE! CYA LATER!");
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
            if(input.equals("exit"))
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
                if(player.getHP() <= 0)
                {
                    break;
                }
                String input = "";
                while (!(input.equals("fight") || input.equals("item") || input.equals("special"))) {
                    displayStatsAlongSideEachOther(player,fightMe);
                    System.out.println("What's your move?\n-I strike (say \"fight\")\n-I use an item (say \"item\")\n-I use my special (say \"special\")");
                    input = asker.nextLine();
                    input = input.toLowerCase(Locale.ROOT);
                }
                if(input.equals("fight"))
                {
                    duel(player,fightMe);
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
                        System.out.println("------------------------------");
                        fightMe.duelWithPlayer(player);
                    }
                }
                if(input.equals("special"))
                {
                    String inputForSpecial = "";
                    while (!(inputForSpecial.equals("primary") || inputForSpecial.equals("secondary")))
                    {
                        System.out.println("Which of your special abilities do you wish to use? (say \"primary\" or \"secondary\", you can only use each special ability once a fight)");
                        inputForSpecial = asker.nextLine();
                        inputForSpecial = inputForSpecial.toLowerCase(Locale.ROOT);
                    }
                    if(inputForSpecial.equals("primary"))
                    {
                        if(primarySpecialUsed)
                        {
                            System.out.println("You can only use your primary special once a fight!");
                        }
                        if(!primarySpecialUsed)
                        {
                            player.useSpecial(fightMe,"primary");
                            fightMe.duelWithPlayer(player);
                            primarySpecialUsed = true;
                        }
                    }
                    if(inputForSpecial.equals("secondary"))
                    {
                        if(secondarySpecialUsed)
                        {
                            System.out.println("You can only use your secondary special once a fight!");
                        }
                        if(!secondarySpecialUsed)
                        {
                            player.useSpecial(fightMe,"secondary");
                            fightMe.duelWithPlayer(player);
                            secondarySpecialUsed = true;
                        }
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
                else
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
                if(player.getHP() <= 0)
                {
                    break;
                }
                String input = "";
                while (!(input.equals("fight") || input.equals("item") || input.equals("special"))) {
                    displayStatsAlongSideEachOther(player,bigEnemy);
                    System.out.println("What's your move?\n-I strike (say \"fight\")\n-I use an item (say \"item\")\n-I use my special (say \"special\")");
                    input = asker.nextLine();
                    input = input.toLowerCase(Locale.ROOT);
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
                        System.out.println("------------------------------");
                        bigEnemy.duelWithPlayer(player);
                    }
                }
                if(input.equals("special"))
                {
                    String inputForSpecial = "";
                    while (!(inputForSpecial.equals("primary") || inputForSpecial.equals("secondary")))
                    {
                        System.out.println("Which of your special abilities do you wish to use? (say \"primary\" or \"secondary\", you can only use each special ability once a fight)");
                        inputForSpecial = asker.nextLine();
                        inputForSpecial = inputForSpecial.toLowerCase(Locale.ROOT);
                    }
                    if(inputForSpecial.equals("primary"))
                    {
                        if(primarySpecialUsed)
                        {
                            System.out.println("You can only use your primary special once a fight!");
                        }
                        if(!primarySpecialUsed)
                        {
                            player.useSpecial(bigEnemy,"primary");
                            bigEnemy.duelWithPlayer(player);
                            primarySpecialUsed = true;
                        }
                    }
                    if(inputForSpecial.equals("secondary"))
                    {
                        if(secondarySpecialUsed)
                        {
                            System.out.println("You can only use your secondary special once a fight!");
                        }
                        if(!secondarySpecialUsed)
                        {
                            player.useSpecial(bigEnemy,"secondary");
                            bigEnemy.duelWithPlayer(player);
                            secondarySpecialUsed = true;
                        }
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

    private boolean isInArray(String userInput, String[] items) //String inputs
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

    private void displayStatsAlongSideEachOther(PlayersCharacter player, Enemy killMe)
    {
        System.out.println("CURRENT STATS");
        System.out.println(player.getName()  + " CURRENT HP: " + player.getHP());
        System.out.println(player.getName() + " CURRENT DEFENSE: " + player.getDefense());
        System.out.println(player.getName() + " CURRENT ATTACK: " + player.getAttack());
        System.out.println(killMe.getName()  + " CURRENT HP: " + killMe.getHp());
        System.out.println(killMe.getName() + " CURRENT DEFENSE: " + killMe.getDefense());
        System.out.println(killMe.getName() + " CURRENT ATTACK: " + killMe.getAttackDmg());
        System.out.println("------------------------------");
    }




    private void duel(PlayersCharacter player, Enemy killMe)
    {
        player.duelWithEnemy(killMe);
        killMe.duelWithPlayer(player);
    }
}
