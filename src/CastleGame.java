import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CastleGame {
    private String[][] castleDisplay;
    private Room[][] castleRooms;
    private int currentfL;
    private int currentRoom;
    private PlayersClass player;
    private int roomsCompleted;
    private String userName;


    public CastleGame(UserLogin gameClient)
    {
        gameClient.setUpGUI();
        gameClient.setUpButtonListeners();
        try{
            File playerData = new File("src/players.data");
            playerData.createNewFile();
            FileWriter inputGet = new FileWriter("src/players.data");
            inputGet.write(userName + "\n");
            inputGet.write("" + roomsCompleted);
            inputGet.close();
        }
        catch(IOException io)
        {
            System.out.println("Unable to create file");
            io.printStackTrace();
        }
    }


    public String toString2DArray(String[][] input)
    {

        String ret = "";
        for(int r = 0;r<input.length;r++)
        {
            for(int c = 0; c < input[r].length;c++)
            {
                ret += "[" + input[r][c] + "]";
            }
            ret += "\n";
        }
        return ret;


    }

    private void setCastleRooms()
    {
         for(int r = castleRooms.length-1; r >= 0;r--)
        {
            for(int c = 0; c < castleRooms[r].length-1;c++)
            {
                castleRooms[c][r] = new Room((int)(Math.random()*3));
            }
            castleRooms[castleRooms[r].length-1][r] = new Room(3);
        }
    }

    private void adjustArray()
    {
        for(int r = castleDisplay.length-1; r >= 0;r--)
        {
            for(int c = 0; c < castleDisplay[r].length;c++)
            {
                if(c >= currentRoom && r <= currentfL)
                {
                    castleDisplay[r][c] = "❌";
                }

            }
        }
    }


    private void displayMap()
    {
        adjustArray();
        for(int r = castleDisplay.length-1; r >= 0;r--)
        {
            for(int c = 0; c <= currentRoom; c++)
            {
                if(c == currentRoom && r == currentfL) {
                    castleDisplay[r][c] = "\uD83D\uDE00"; //✅ <-- use this for cleared rooms
                }
            }
        }
        System.out.println("MAP");
        System.out.print(toString2DArray(castleDisplay));
        System.out.println("------------------------------");
    }




    private void nextRoom()
    {
        if(currentRoom == castleRooms[0].length-1)
        {
            currentRoom = 0;
            nextFloor();
        }
        else {
            currentRoom++;
        }
    }

    private void setRoomsCompleted(int value)
    {
        roomsCompleted = value;
    }

    private void nextFloor()
    {
        currentfL--;
    }

    public int getCurrentfL()
    {
        return currentfL;
    }

    public int getCurrentRoom()
    {
        return currentRoom;
    }

    public void play()
    {
        Scanner asker = new Scanner(System.in);
        String difficultyMode = "";
        while(!(difficultyMode.equals("easy") || difficultyMode.equals("normal") || difficultyMode.equals("hard"))) {
        System.out.println("WELCOME TO CASTLE HASSLE!\nPlease choose your difficulty before proceeding forward! (type \"easy\" for easy mode, \"normal\" for normal mode, and \"hard\" for hard mode)");
        difficultyMode = asker.nextLine();
        }
        if(difficultyMode.equals("easy"))
        {
            int random = (int)(Math.random()*1)+3;
            castleDisplay =  new String[random][random];
            castleRooms = new Room[random][random];
            setCastleRooms();
            adjustArray();
            currentfL = castleRooms.length - 1;
            currentRoom = 0;
        }
        if(difficultyMode.equals("normal"))
        {
            int random = (int)(Math.random()*2)+3;
            castleDisplay = new String[random][random];
            castleRooms = new Room[random][random];
            setCastleRooms();
            adjustArray();
            currentfL = castleRooms.length - 1;
            currentRoom = 0;
        }
        if(difficultyMode.equals("hard"))
        {
            int random = (int)(Math.random()*3)+3;
            castleDisplay = new String[random][random];
            castleRooms = new Room[random][random];
            setCastleRooms();
            adjustArray();
            currentfL = castleRooms.length - 1;
            currentRoom = 0;
        }
        System.out.println("What will be your character's name??");
        String myNameIs = asker.nextLine(); //chicka chicka slim shady
        String chosenClass = "";
        while(!(chosenClass.equals("Pirate") || chosenClass.equals("Knight") || (chosenClass.equals("Ninja")))) {
            System.out.println("Hello, " + myNameIs + ", what is your class? (Pirate, Knight, Ninja)");
            chosenClass = asker.nextLine();
        }
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
            player = new Ninja(myNameIs);
            System.out.println("");
        }
        while(player.getHP() > 0 && !(castleRooms[castleRooms[0].length-1][0].getObjectiveCompleted()))
        {
            displayMap();
            player.displayStats();
            castleRooms[currentRoom][currentfL].roomAction(player);
            if(castleRooms[currentRoom][currentfL].getObjectiveCompleted())
            {
                castleDisplay[currentfL][currentRoom] = "✅";
                nextRoom();
            }
        }
        if(player.getHP() <= 0)
        {
            System.out.println("YOU ARE DECEASED!\n You reached Floor: " + ((castleRooms.length) - getCurrentfL()) + ", Room: " + (getCurrentRoom() + 1));
            setRoomsCompleted((((castleRooms.length) - getCurrentfL()) * (getCurrentRoom() + 1) - 1));
        }
        if(player.getHP() > 0)
        {
            System.out.println("YOU WON!");
        }
    }
}
