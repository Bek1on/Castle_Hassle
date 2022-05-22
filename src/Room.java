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
            while(Arrays.toString(itemNames).indexOf(input) != -1 || !input.equals("exit"))
            {
                System.out.println("WHAT WOULD YOU LIKE YA SCOUNDREL?");
                System.out.println(Arrays.toString(itemNames));
                System.out.println("-I'd like to buy...(insert item name)\n-I think I'm good, I'm gonna head out...(say \"exit\" to leave the shop and advance to the next room)");
                input = asker.nextLine();
            }
            if(!input.equals("exit")) {
                for (int i = 0; i < itemNames.length; i++) {
                    if (itemNames[i].equals(input) && player.getGold() >= shopsItems[i].getPrice()) {
                        System.out.println("A WISE CHOICE!");
                        player.addToInventory(shopsItems[i]);
                        player.setGold(player.getGold() - shopsItems[i].getPrice());
                        break;
                    }
                    if (itemNames[i].equals(input) && player.getGold() < shopsItems[i].getPrice()) {
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




}
