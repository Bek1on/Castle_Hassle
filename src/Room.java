public class Room {
    private final static String[] roomTypes = {"enemy","shop","treasure","boss"};
    private String roomType;

    public Room(int chosenTypeIndex)
    {
        roomType = roomTypes[chosenTypeIndex];
    }

    public String getRoomType()
    {
        return roomType;
    }



}
