public class Pirate extends Archetype{

    public Pirate(String name)
    {
        super(name);
        setLuck(.3);
        setCritChance(.15);
    }

    public void useSpecial(Enemy killMe)
    {
        System.out.println(getName() + " used their special, CANNON BARRAGE!\nBATHE'EM IN IRON HAHHAHAHAHAHA");
        attackEnemy(killMe,(int)(Math.random()+41)+(getAttack()+5));
    }
}
