public class Archer extends Knight{

    public Archer(String name)
    {
        super(name);
        setAttack(36);
        setEvasive(.34);
        setLuck(0.0);
        setCritChance(0);
        setSecondarySpecial("ARROW TO THE KNEE");
    }

    public void useSpecial(Enemy killMe, String whichSpecialIsUsed)
    {
        if(whichSpecialIsUsed.equals("secondary")) {
            int defenseDecreased = (int) (Math.random() * 21) + 15;
            System.out.println(getName() + " used their special, ARROW TO THE KNEE!");
            System.out.println(killMe.getName() + " became more sluggish and had their defense decreased by " + defenseDecreased + "\n------------------------------!");
            killMe.setDefense(killMe.getDefense() - defenseDecreased);
            killMe.setEvasive(killMe.getEvasive() - .03);
        }
        if(whichSpecialIsUsed.equals("primary"))
        {
            super.useSpecial(killMe,whichSpecialIsUsed);
        }
    }
}
