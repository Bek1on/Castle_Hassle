import java.util.Scanner;
public class CastleGame {
    private String[][] castle;
    private int currentfL;
    private int currentRoom;
    private Archetype player;

    public CastleGame(String difficultyMode)
    {
        if(difficultyMode.equals("easy"))
        {
            castle =  new String[(int)(Math.random()*3)+1][(int)(Math.random()*3)+1];
            clearArray();

        }
        if(difficultyMode.equals("normal"))
        {
            castle = new String[(int)(Math.random()*3)+4][(int)(Math.random()*3)+4];
            clearArray();
        }
        if(difficultyMode.equals("hard"))
        {
            castle = new String[(int)(Math.random()*4)+5][(int)(Math.random()*4)+5];
            clearArray();
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

    private void clearArray()
    {
        for(int r = 0; r < castle.length;r++)
        {
            for(int c = 0; c < castle[r].length;c++)
            {
                castle[r][c] = "";
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
            }
            if(archo.equals("Cannoneer"))
            {
                player = new Cannoneer(myNameIs);
            }
            if(archo.equals("Plunderer"))
            {
                player = new Plunderer(myNameIs);
            }
        }
        if(chosenClass.equals("Knight"))
        {
            player = new Knight(myNameIs);
        }
        if(chosenClass.equals("Ninja"))
        {
            //player = new Ninja(myNameIs);
        }
        displayMap();
        if(player.getHP() == 0)
        {
            System.out.println("DECEASED!");
        }
    }

    private void displayMap()
    {
        clearArray();
        for(int r = castle.length-1; r >= currentfL; r--)
        {
            for(int c = 0; c <= currentRoom; c++)
            {
                if(c == currentRoom && r == currentfL) {
                    castle[r][c] = "\uD83E\uDDD2";
                }
            }
       }
        System.out.print(toString2DArray(castle));
    }


}
