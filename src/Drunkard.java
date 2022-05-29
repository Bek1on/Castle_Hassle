public class Drunkard extends Pirate{

    public Drunkard(String name)
    {
        super(name);
        setHP(185);
        setDefense(75);
        setAttack(30);
        setEvasive(.05);
    }

    public void useSpecial(Enemy killMe)
    {
        int hpGained = ((int)(Math.random()*41)+10) + (int)(.1 * getHP());
        System.out.println(getName() + " used their special, CITRUS RUM! GLUG GLUG GLUG!");
        System.out.println(getName() + " heals " + hpGained + " HP!");
        setHP(getHP() + hpGained);
    }


}
