public class Plunderer extends Pirate{

    public Plunderer(String name)
    {
        super(name);
        setHP(150);
        setDefense(50);
        setAttack(35);
        setEvasive(.4);
    }

    public void useSpecial(Enemy killMe)
    {
        int totalDmg = (int) (((Math.random()*21)+getAttack()) * (100.0 / (100.0 + killMe.getDefense())));
        int goldGained = (int)(Math.random()*26) + killMe.getGoldCarried();
        System.out.println(getName() + " used their special, ASSAULT AND ROBBERY! EMPTY YOUR POCKETS " + killMe.getName() + "!");
        System.out.println(getName() + " dealt " + totalDmg + " damage and stole " + goldGained + " from " + killMe.getName() + "!");
    }
}
