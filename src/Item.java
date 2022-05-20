public class Item {
    private final String[] ITEMS = {"blood","juice","shield","corpse","ant","iron","amulet","scope","cloak","donkey cheese"};
    private final int[] PRICES = {10,15,25,35,45,55,65,75,85,200};
    private String name;
    private int price;

    public Item()
    {
        int randomItem = (int)(Math.random()*10);
        int randomPrice = (int)(Math.random()*10);
        if(randomItem == 9 || randomPrice == 9)
        {
            name = ITEMS[9];
            price = PRICES[9];
        }
        else if(randomItem != 9 && randomPrice < 9)
        {
            name = ITEMS[randomItem];
            price = PRICES[randomPrice];
        }
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

}