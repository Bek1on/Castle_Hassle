public class Ninja extends PlayersClass {

    public Ninja(String name)
    {
        super(name);
        setEvasive(.45);
    }

    public void useSpecial() {
        Item randomItem = new Item();
        System.out.println(getName() + "used their special, FORBIDDEN TECHNIQUE: OBJECT PRODUCTION!\nランダムな出現! " + getName() + " produces a(n)" + randomItem.getName() + "out of thin air! The item is added to their inventory!");
        addToInventory(randomItem);
    }
}
