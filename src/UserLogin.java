import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class UserLogin
{
    private String userName;
    private String roomsCompleted;
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
    }

    public void setUpGUI()
    {
        Container cont = frame.getContentPane();
        FlowLayout flow = new FlowLayout();
        cont.setLayout(flow);
        frame.setSize(width,height);
        frame.setTitle("Login Info");
        cont.add(userInput);
        cont.add(label);
        cont.add(login);
        cont.add(newAccount);
        cont.add(createNewAccountPrompt);
        createNewAccountPrompt.setBounds(100,100,100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public String getUserInput()
    {
        return userInput.getText();
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
                    try {
                        File test = new File("src/players.data");
                        FileReader lookAtPlayerData = new FileReader("src/.players.data");
                        int line = 1;
                        int loopVar = 0;
                        String userName = "";
                        String roomsCompleted = "";
                        while((loopVar = lookAtPlayerData.read()) != -1)
                        {
                            String data = "" + ((char)loopVar);
                            if(line % 2 != 0)
                            {
                                userName = data;
                            }
                            if(line % 2 == 0)
                            {
                                roomsCompleted = data;
                            }
                            line++;
                        }

                    }
                    catch(IOException error)
                    {
                        createNewAccountPrompt.setText("Username not found!");
                    }
                }
                if(buttonPressed == newAccount)
                {
                    getUserInput();



                }
            }
        };
        login.addActionListener(buttonListener);
        newAccount.addActionListener(buttonListener);
    }



}








