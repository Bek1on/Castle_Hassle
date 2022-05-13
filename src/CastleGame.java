import java.util.Scanner;
public class CastleGame {
    private String[][] castle;
    private Archetype player;

    public CastleGame(String difficultyMode)
    {
        if(difficultyMode.equals("easy"))
        {
            castle =  new String[(int)(Math.random()*3)+1][(int)(Math.random()*3)+1];
        }
        if(difficultyMode.equals("normal"))
        {
            castle = new String[(int)(Math.random()*3)+4][(int)(Math.random()*3)+4];
        }
        if(difficultyMode.equals("hard"))
        {
            castle = new String[(int)(Math.random()*4)+5][(int)(Math.random()*4)+5];
        }
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
        while(player.getHP() > 0)
        {
            for(int r = castle.length-1; r >= 0; r--)
            {
                for(int c = 0; c < castle[r].length; c++)
                {
                    castle[r][c] = "0\n/|\\\n/\\";
                    System.out.println(castle);
                }
            }
        }
        if(player.getHP() == 0)
        {
            System.out.println("DECEASED!");
        }
    }
}
