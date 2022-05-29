public class LaunchesCastleGame {
    public static void main(String[] args) {
        UserLogin castleGameLogin = new UserLogin(500,500);
        castleGameLogin.loadCastleGameClient();
        castleGameLogin.setUpLoginButtons();
    }
}
