

public class PlayerAccount {
    private String userName;
    private int roomsCleared;

    public PlayerAccount()
    {
        userName = "";
        roomsCleared = 0;
    }

    public PlayerAccount(String userName, int roomsCleared)
    {
        this.userName = userName;
        this.roomsCleared = roomsCleared;
    }

    public String getUserName()
    {
        return userName;
    }

    public int getRoomsCleared()
    {
        return roomsCleared;
    }


    public void setRoomsCleared(int roomsCleared)
    {
        this.roomsCleared = roomsCleared;
    }


}
