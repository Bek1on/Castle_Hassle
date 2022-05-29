public class Drunkard extends Pirate{

    public Drunkard(String name)
    {
        super(name);
        setHP(185);
        setDefense(75);
        setAttack(30);
        setEvasive(.05);
    }

    public void useSpecial(Enemy killMe,String whichSpecialIsUsed)
    {
        if(whichSpecialIsUsed.equals("secondary")) {
            int hpGained = ((int) (Math.random() * 41) + 10) + (int) (.1 * getHP());
            setHP(getHP() + hpGained);
            System.out.println(getName() + " used their special, CITRUS RUM! GLUG GLUG GLUG!");
            System.out.println(getName() + " heals " + hpGained + " HP!");
            System.out.println(getName() + " now has " + getHP() + " HP!\n------------------------------");

        }
        if(whichSpecialIsUsed.equals("primary"))
        {
            super.useSpecial(killMe, whichSpecialIsUsed);
        }
    }


}
