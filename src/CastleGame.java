import java.util.Scanner;
public class CastleGame {
    private String[][] castleDisplay;
    private Room[][] castleRooms;
    private int currentfL;
    private int currentRoom;
    private Archetype player;

    public CastleGame(String difficultyMode)
    {
        if(difficultyMode.equals("easy"))
        {
            int random = (int)(Math.random()*3)+3;
            castleDisplay =  new String[random][random];
            castleRooms = new Room[random][random];
            setCastleRooms();
            adjustArray();
            currentfL = castleRooms.length - 1;
            currentRoom = 0;

        }
        if(difficultyMode.equals("normal"))
        {
            int random = (int)(Math.random()*3)+4;
            castleDisplay = new String[random][random];
            castleRooms = new Room[random][random];
            setCastleRooms();
            adjustArray();
            currentfL = castleRooms.length - 1;
            currentRoom = 0;
        }
        if(difficultyMode.equals("hard"))
        {
            int random = (int)(Math.random()*4)+5;
            castleDisplay = new String[random][random];
            castleRooms = new Room[random][random];
            setCastleRooms();
            adjustArray();
            currentfL = castleRooms.length - 1;
            currentRoom = 0;
        }
    }

    private String toString2DArray(String[][] input)
    {
        String ret = "";
        for(int r = input.length-1; r >= 0;r--)
        {
            for(int c = 0; c < input[r].length;c++)
            {
                ret += "[" + input[r][c] + "]";
                if(c == input[r].length-1)
                {
                    ret += "\n";
                }
            }
        }
        return ret;
    }

    private void setCastleRooms()
    {
        for(int r = 0; r < castleRooms.length;r++)
        {
            for(int c = 0; c < castleRooms[r].length;c++)
            {
                if(c != castleRooms[r].length - 1)
                {
                    castleRooms[r][c] = new Room((int)(Math.random()*3));
                }
                else
                {
                    castleRooms[r][c] = new Room(3);
                }
            }
        }
    }

    private void adjustArray()
    {
        for(int r = castleDisplay.length-1; r >= 0;r--)
        {
            for(int c = 0; c < castleDisplay[r].length;c++)
            {
                if(r <= currentfL && c < currentRoom)
                {
                    castleDisplay[r][c] = "✅";
                }
                else {
                    castleDisplay[r][c] = "❌";
                }
            }
        }
    }

    private void nextRoom()
    {
        currentRoom++;
    }

    private void nextFloor()
    {
        currentfL++;
    }

    public void play()
    {
        Scanner asker = new Scanner(System.in);
        System.out.println("What is your name?");
        String myNameIs = asker.nextLine(); //chicka chicka slim shady
        System.out.println("Hello, " + myNameIs + ", what is your class? (Pirate, Knight, Ninja)");
        String chosenClass = asker.nextLine();
        if(chosenClass.equals("Pirate"))
        {
            String archo = "";
            while(!(archo.equals("Drunkard") || archo.equals("Plunderer") || archo.equals("Cannoneer")))
            {
                System.out.println("Choose an archetype!(Drunkard, Plunderer, Cannoneer)");
                archo = asker.nextLine();
            }
            if(archo.equals("Drunkard"))
            {
                player = new Drunkard(myNameIs);
                System.out.println("");
            }
            if(archo.equals("Cannoneer"))
            {
                player = new Cannoneer(myNameIs);
                System.out.println("");
            }
            if(archo.equals("Plunderer"))
            {
                player = new Plunderer(myNameIs);
                System.out.println("");
            }
        }
        if(chosenClass.equals("Knight"))
        {
            player = new Knight(myNameIs);
            System.out.println("");
        }
        if(chosenClass.equals("Ninja"))
        {
            //player = new Ninja(myNameIs);
        }
        displayMap();
        displayEvent();
        displayInventory();
        if(player.getHP() == 0)
        {
            System.out.println("DECEASED!");
        }
    }

    private void displayMap()
    {
        adjustArray();
        for(int r = castleDisplay.length-1; r >= currentfL; r--)
        {
            for(int c = 0; c <= currentRoom; c++)
            {
                if(c == currentRoom && r == currentfL) {
                    castleDisplay[r][c] = "\uD83D\uDE00"; //✅ <-- use this for cleared rooms
                }
            }
       }
        System.out.print(toString2DArray(castleDisplay));
        System.out.println("------------------------------");
    }

    private void displayEvent()
    {
        String roomType = castleRooms[currentRoom][currentfL].getRoomType();

    }

    private void displayInventory()
    {

    }


}
