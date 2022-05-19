import java.util.Scanner;
import java.util.Arrays;
public class Room {
    private final static String[] ROOM_TYPES = {"enemy","shop","treasure","boss"};
    private String roomType;

    public Room(int chosenTypeIndex)
    {
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
            String[] itemNames = new String[5];
            for (int i = 0; i < shopsItems.length; i++) {
                itemNames[i] = shopsItems[i].getName();
            }
            String input = "";
            while(Arrays.toString(itemNames).indexOf(input) != -1)
            {
                System.out.println("WHAT WOULD YOU LIKE YA SCOUNDREL?");
                System.out.println(Arrays.toString(itemNames));
                input = asker.nextLine();
            }


        }
        if(getRoomType().equals(ROOM_TYPES[0]))
        {

        }
        if(getRoomType().equals(ROOM_TYPES[2]))
        {

        }
        if(getRoomType().equals(ROOM_TYPES[3]))
        {

        }
    }
}
