import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RunsCastleHassle {
    public static void main(String[] args) {
        UserLogin castleGameLogin = new UserLogin(500,500);
        castleGameLogin.setUpGUI();
        castleGameLogin.setUpButtonListeners();
    }
}
