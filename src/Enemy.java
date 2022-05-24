public class Enemy {
    private int hp;
    private int defense;
    private int attackDmg;
    private int goldCarried;
    private double evasive;
    private String name;
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
        evasive = ((int)(Math.random()*21) + 20) / 100.0;
        attackDmg = (int)(Math.random()*21) + 30;
    }

    public void attackPlayer(Archetype player, int dmg)
    {
        player.setHP(player.getHP()-dmg);
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int value)
    {
        hp = value;
    }

    public int getAttackDmg()
    {
        return attackDmg;
    }

    public void setAttackDmg(int value){attackDmg = value;}

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int value){defense = value;}

    public double getEvasive()
    {
        return evasive;
    }

    public void setEvasive(double value) {evasive = value;}

    public int getGoldCarried()
    {
        return goldCarried;
    }

    public void setGoldCarried(int value){goldCarried = value;}

    public String getName()
    {
        return name;
    }

    public void setName(String value) {name = value;}

    public void useSpecial(Archetype player) //overwritten
    {
        System.out.println("");
    }



}
