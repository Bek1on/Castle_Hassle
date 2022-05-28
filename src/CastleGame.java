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
    private PlayerAccount userAccount;



    public CastleGame(PlayerAccount userAccount)
    {
        this.userAccount = userAccount;
        System.out.println("\nWelcome " + userAccount.getUserName() + " ! You've cleared a total of " + userAccount.getRoomsCleared() + " rooms!\n");
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
            String archo = "";
            while(!(archo.equals("Duelist") || archo.equals("Heretic") || archo.equals("Archer")))
            {
                System.out.println("Choose an archetype!(Duelist, Archer, Heretic)");
                archo = asker.nextLine();
            }
            if(archo.equals("Duelist"))
            {
                player = new Duelist(myNameIs);
                System.out.println("");
            }
            if(archo.equals("Heretic"))
            {
                player = new Heretic(myNameIs);
                System.out.println("");
            }
            if(archo.equals("Archer"))
            {
                player = new Archer(myNameIs);
                System.out.println("");
            }
        }
        if(chosenClass.equals("Ninja"))
        {
            String archo = "";
            while(!(archo.equals("Enkaku") || archo.equals("Tetsu") || archo.equals("Ronin")))
            {
                System.out.println("Choose an archetype!(Enkaku, Tetsu, Ronin)");
                archo = asker.nextLine();
            }
            if(archo.equals("Enkaku"))
            {
                player = new Enkaku(myNameIs);
                System.out.println("");
            }
            if(archo.equals("Tetsu"))
            {
                player = new Tetsu(myNameIs);
                System.out.println("");
            }
            if(archo.equals("Ronin"))
            {
                player = new Ronin(myNameIs);
                System.out.println("");
            }

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
            userAccount.setRoomsCleared((((castleRooms.length) - getCurrentfL()) * (getCurrentRoom() + 1) - 1) + userAccount.getRoomsCleared());

        }
        if(player.getHP() > 0)
        {
            System.out.println("YOU WON!");
            userAccount.setRoomsCleared((((castleRooms.length) - getCurrentfL()) * (getCurrentRoom() + 1) - 1) + userAccount.getRoomsCleared());
        }
    }
}
