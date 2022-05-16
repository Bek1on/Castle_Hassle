import java.util.Scanner;
public class CastleGame {
    private String[][] castle;
    private Archetype player;

    public CastleGame(String difficultyMode)
    {
        if(difficultyMode.equals("easy"))
        {
            castle =  new String[(int)(Math.random()*3)+1][(int)(Math.random()*3)+1];
            for(int r = 0; r < castle.length;r++)
            {
                for(int c = 0; c < castle[r].length;c++)
                {
                    castle[r][c] = "";
                }
            }
        }
        if(difficultyMode.equals("normal"))
        {
            castle = new String[(int)(Math.random()*3)+4][(int)(Math.random()*3)+4];
            for(int r = 0; r < castle.length;r++)
            {
                for(int c = 0; c < castle[r].length;c++)
                {
                    castle[r][c] = "";
                }
            }
        }
        if(difficultyMode.equals("hard"))
        {
            castle = new String[(int)(Math.random()*4)+5][(int)(Math.random()*4)+5];
            for(int r = 0; r < castle.length;r++)
            {
                for(int c = 0; c < castle[r].length;c++)
                {
                    castle[r][c] = "";
                }
            }
        }
    }

    private String toString2DArray(String[][] input)
    {
        String ret = "";
        for(int r = 0; r < input.length;r++)
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
            for(int r = castle.length-1; r >= 0; r--)
            {
                for(int c = 0; c < castle[r].length; c++)
                {
                    if(c == 0) {
                        castle[r][c] = "\uD83D\uDE0A";
                    }
                     if(c > 0)
                    {
                        castle[r][c-1] = "";
                        castle[r][c] = "\uD83D\uDE0A";
                    }
                     if(r > 0 && c == 0)
                    {
                        castle[r-1][castle[r-1].length-1] = "";
                    }
                }
            }
        System.out.print(toString2DArray(castle));
        if(player.getHP() == 0)
        {
            System.out.println("DECEASED!");
        }
    }


}
