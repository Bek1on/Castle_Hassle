public class Knight extends PlayersClass {


    public Knight(String name)
    {
        super(name);
        setDefense(85);
        setHP(160);

    }

    public void useSpecial(Enemy killMe)
    {
        System.out.println(getName() + "used their special, WAR ROAR!\nGRAHHHHHHHHHHH! The enemy has their defense and attack reduced!");
    }





}
