public class Cannoneer extends Pirate{

    public Cannoneer(String name)
    {
        super(name);
        setHP(125);
        setDefense(35);
        setAttack(60);
        setEvasive(.35);
    }

    public void useSpecial(Enemy killMe, String whichSpecialIsUsed)
    {
        if(whichSpecialIsUsed.equals("secondary")) {
            int totalDmg = (int) (((Math.random() * 36) + getAttack()) * (100.0 / (100.0 + killMe.getDefense())));
            int defenseDecrease = (int) (Math.random() * 15) + 2;
            System.out.println(getName() + " uses their special, THE BIG ONE, to whip out a huge cannon and blast " + killMe.getName() + " with it!");
            System.out.println(getName() + " deals " + totalDmg + " damage and " + killMe.getName() + " has their defense decreased by " + defenseDecrease + "!");
            System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
        }
        if(whichSpecialIsUsed.equals("primary"))
        {
            super.useSpecial(killMe, whichSpecialIsUsed);
        }
    }
}
