public class Pirate extends PlayersCharacter {

    public Pirate(String name)
    {
        super(name);
        setLuck(.3);
        setCritChance(.15);
    }

    public void useSpecial(Enemy killMe, String whichSpecialToUse)
    {
        int dmgDealt = (int)(Math.random()+41)+(getAttack() / 2);
        System.out.println(getName() + " used their special, CANNON BARRAGE! BATHE'EM IN IRON HAHHAHAHAHAHA");
        attackEnemy(killMe,dmgDealt);
        System.out.println(killMe.getName() + " got hit by a bunch of cannonballs and lost " + dmgDealt + " HP!");
        if(killMe.getHp() > 0) {
            System.out.println(killMe.getName() + " now has " + killMe.getHp() + " HP!\n------------------------------");
        }
        else
        {
            System.out.println("------------------------------");
        }
    }
}
