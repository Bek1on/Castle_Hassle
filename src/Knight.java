public class Knight extends PlayersClass {


    public Knight(String name)
    {
        super(name);
        setDefense(85);
        setHP(160);

    }

    public void useSpecial(Enemy killMe, String whichSpecialIsUsed)
    {
        System.out.println(getName() + "used their special, WAR ROAR!\nGRAHHHHHHHHHHH! The enemy has their defense and attack reduced!\n------------------------------");
        killMe.setDefense(killMe.getDefense() - ((int)(Math.random()+21)+5));
        killMe.setAttackDmg(killMe.getAttackDmg() - ((int)(Math.random()+11)+15));
    }





}
