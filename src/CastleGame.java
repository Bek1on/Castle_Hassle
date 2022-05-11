import java.util.Scanner;
public class CastleGame {
    private String[][] castle;

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
        System.out.println("WELCOME TO CASTLE HASSLE!\nPlease choose your difficulty before proceeding forward! (type \"easy\" for easy mode, \"normal\" for normal mode, and \"hard\" for hard mode)");
        String input = asker.nextLine();
        CastleGame game = new CastleGame(input);
        System.out.println("Please select your class!");
    }
}
