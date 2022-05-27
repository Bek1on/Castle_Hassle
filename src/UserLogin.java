import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;



public class UserLogin
{
    private String userName;
    private int roomsCompleted;
    private boolean isLoggedIn;
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
        isLoggedIn = false;
    }




    public JFrame getFrame()
    {
        return frame;
    }

    public boolean isLoggedIn()
    {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean value)
    {
        isLoggedIn = value;
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
                    boolean isIn = false;
                    try {
                        File test = new File("src/players.data");
                        Scanner checkData = new Scanner(test);
                        int line = 1;
                        while(checkData.hasNextLine())
                        {
                            String checkMe = checkData.nextLine();
                            if(line % 2 != 0)
                            {
                                if(userName.equals(checkMe))
                                {

                                    roomsCompleted = Integer.parseInt(checkData.nextLine());
                                    PlayerAccount loggedAccount = new PlayerAccount(userName, roomsCompleted);
                                    isIn = true;
                                    setLoggedIn(true);
                                    frame.setVisible(false);
                                    if(isLoggedIn())
                                    {
                                        CastleGame game = new CastleGame(loggedAccount);
                                        game.play();
                                    }
                                }
                            }
                            line++;
                        }
                        if(!isIn)
                        {
                            createNewAccountPrompt.setText("This username doesn't exist!");
                        }
                    }
                    catch(IOException error)
                    {
                        System.out.println("FILE CANNOT BE CREATED");
                    }
                }
                if(buttonPressed == newAccount)
                {
                    boolean addPlayer = true;
                    userName = userInput.getText();
                    roomsCompleted = 0;
                    PlayerAccount newAccount = new PlayerAccount(userName, roomsCompleted);
                    newAccount.save();
                }
            }
        };
        login.addActionListener(buttonListener);
        newAccount.addActionListener(buttonListener);
    }



}








