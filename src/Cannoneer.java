public class Cannoneer extends Pirate{

    public Cannoneer(String name)
    {
        super(name);
        setHP(125);
        setDefense(35);
        setAttack(60);
        setEvasive(.35);
    }

    public void useSpecial(Enemy killMe)
    {
        int totalDmg = (int)(((Math.random()*36)+getAttack()) * (100.0 / (100.0 + killMe.getDefense())));
        int defenseDecrease = (int)(Math.random()*15);
        System.out.println(getName() + " whips out a huge cannon and blasts " + killMe.getName() + " with it!");
        System.out.println(getName() + " deals " + totalDmg + " damage and " + killMe.getName() + " has their defense decreased by " + defenseDecrease + "!");
    }
}
