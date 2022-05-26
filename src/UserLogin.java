import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserLogin
{
    private String userName;
    private String roomsCompleted;
    private JFrame frame;
    private JLabel label;
    private JTextField userInput;
    private JButton newAccount;
    private JButton login;
    private int width;
    private int height;

    public UserLogin(int w, int h)
    {
        frame = new JFrame();
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

                }
                if(buttonPressed == newAccount)
                {
                    System.out.println("NEW ACCOUNT");
                }
            }
        };
        login.addActionListener(buttonListener);
        newAccount.addActionListener(buttonListener);
    }



}








