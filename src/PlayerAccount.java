import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
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

    public void setUserName(String name)
    {
        userName = name;
    }

    public void setRoomsCleared(int roomsCleared)
    {
        this.roomsCleared = roomsCleared;
    }

    public void save()
    {
        try{
            File playerData = new File("src/players.data");
            playerData.createNewFile();
            FileWriter fw = new FileWriter("src/players.data");
            fw.write(userName + "\n");
            fw.write("" + roomsCleared);
            fw.close();
        }
        catch(IOException e)
        {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
