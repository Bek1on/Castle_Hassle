import java.util.Scanner;
public class RunsCastleHassle {
    public static void main(String[] args) {
        Scanner asker = new Scanner(System.in);
        String input = "";
        while(!(input.equals("easy") || input.equals("normal") || input.equals("hard"))) {
            System.out.println("WELCOME TO CASTLE HASSLE!\nPlease choose your difficulty before proceeding forward! (type \"easy\" for easy mode, \"normal\" for normal mode, and \"hard\" for hard mode)");
            input = asker.nextLine();
        }
        CastleGame game = new CastleGame(input);
        game.play();


    }
}
