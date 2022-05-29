public class Ninja extends PlayersCharacter {

    public Ninja(String name)
    {
        super(name);
        setEvasive(.5);
    }

    public void useSpecial(Enemy killMe, String whichSpecialToUse) {
        Item randomItem = new Item();
        System.out.println(getName() + " used their special, FORBIDDEN TECHNIQUE: OBJECT PRODUCTION!\nランダムな出現! " + getName() + " produces a(n) " + randomItem.getName() + " out of thin air! The item is added to their inventory!\n------------------------------");
        addToInventory(randomItem);
    }
}
