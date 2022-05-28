import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class UserLogin
{
    private ArrayList<PlayerAccount> playerAccounts;
    private PlayerAccount loggedIn;
    private String userName;
    private int roomsCompleted;
    private JFrame frame;
    private JLabel label;
    private JLabel createNewAccountPrompt;
    private JTextField userInput;
    private JButton newAccount;
    private JButton login;
    private int width;
    private int height;

    public UserLogin(int w, int h)
    {
        frame = new JFrame();
        createNewAccountPrompt = new JLabel();
        label = new JLabel("Username");
        userInput = new JTextField(10);
        login = new JButton("Login");
        newAccount = new JButton("Create Account");
        width = w;
        height = h;
        load();
    }


    public void setUpGUI()
    {
        Container cont = frame.getContentPane();
        FlowLayout flow = new FlowLayout();
        cont.setLayout(flow);
        frame.setSize(width,height);
        frame.setTitle("Login Info");
        createNewAccountPrompt.setBounds(100,100,100,100);
        cont.add(userInput);
        cont.add(label);
        cont.add(login);
        cont.add(newAccount);
        cont.add(createNewAccountPrompt);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public void setUpButtonListeners()
    {
        ActionListener buttonListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                Object buttonPressed = event.getSource();
                if(buttonPressed == login)
                {
                    userName = userInput.getText();
                    if(isAnExistingAccount(userName))
                    {
                        frame.setVisible(false);
                        loggedIn = getPlayerAccount(userName);
                        CastleGame game = new CastleGame(loggedIn);
                        game.play();
                        save();
                        System.exit(0);
                    }
                    else
                    {
                        createNewAccountPrompt.setText("Username does not exist!");
                    }
                }
                if(buttonPressed == newAccount)
                {
                    userName = userInput.getText();
                    roomsCompleted = 0;
                    if(isAnExistingAccount(userName))
                    {
                        createNewAccountPrompt.setText("Username already used!");
                    }
                    else
                    {
                        PlayerAccount newAccount = new PlayerAccount(userName, roomsCompleted);
                        playerAccounts.add(newAccount);
                        createNewAccountPrompt.setText("Account successfully created!");
                    }
                }
            }
        };
        login.addActionListener(buttonListener);
        newAccount.addActionListener(buttonListener);
    }

    public void load()
    {
        try
        {
            playerAccounts = new ArrayList<PlayerAccount>();
            File data = new File("src/players.data");
            Scanner checkLine = new Scanner(data);
            while(checkLine.hasNextLine())
            {
                String lineOfData = checkLine.nextLine();
                String[] userInfo = lineOfData.split("\\|");
                PlayerAccount addThis = new PlayerAccount(userInfo[0],Integer.parseInt(userInfo[1]));
                playerAccounts.add(addThis);
            }
            checkLine.close();
        }
        catch(FileNotFoundException error)
        {
            playerAccounts = new ArrayList<PlayerAccount>();
        }
    }

    public void save()
    {
        try {

            File playerData = new File("src/players.data");
            playerData.createNewFile();
            FileWriter fw = new FileWriter("src/players.data");
            String data = "";
            for (int i = 0; i < playerAccounts.size(); i++) {
                data = playerAccounts.get(i).getUserName() + "|" + playerAccounts.get(i).getRoomsCleared();
                fw.write(data + "\n");
            }
            fw.close();
        }
        catch(IOException e)
        {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }

    public boolean isAnExistingAccount(String userName)
    {
        for(int i = 0; i < playerAccounts.size();i++)
        {
            if(userName.equals(playerAccounts.get(i).getUserName()))
            {
                return true;
            }
        }
        return false;
    }

    public PlayerAccount getPlayerAccount(String userName)
    {
        for(int i = 0; i < playerAccounts.size();i++)
        {
            if(userName.equals(playerAccounts.get(i).getUserName()))
            {
                return playerAccounts.get(i);
            }
        }
        return null;
    }





}








