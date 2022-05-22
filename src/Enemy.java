public class Enemy {
    private int hp;
    private int defense;
    private int attackDmg;
    private int goldCarried;
    private double evasive;
    private String name;
    private boolean isAlive;
    private final String[] enemyAdjectives = {"Angry","Malicious","Hungry","Foolish","Ratty","Greedy","Goofy","Bleeding","Chill","Evil"};
    private final String[] enemyNames = {"Crab","Demon","Mimic","Rat","Thief","Hooligan","Wraith","Lobster","Serpent","Grunt"};

    public Enemy()
    {
        int randomAdj = (int)(Math.random()*10);
        int randomNames = (int)(Math.random()*10);
        name = enemyAdjectives[randomAdj] + " " + enemyNames[randomNames];
        goldCarried = (int)(Math.random()*41) + 10;
        defense = (int)(Math.random()*71) + 5;
        hp = (int)(Math.random()*91) + 30;
        evasive = (Math.random()*31) + 20;
        isAlive = true;
    }



}
