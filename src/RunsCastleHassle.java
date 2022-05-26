import java.util.Scanner;

public class RunsCastleHassle {
    public static void main(String[] args) {
        CastleGame game = new CastleGame(new UserLogin(500,500));
        game.play();
    }
}
