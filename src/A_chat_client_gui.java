import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;

public class A_chat_client_gui {

    //public static A_Chat_Client ChatClient;
    public static String UserName = "Annonymous";
    public static JFrame mainwindow = new JFrame();
    public static JButton about = new JButton();
    public static JButton b_connect = new JButton();
    public static JButton b_disconnect = new JButton();
    public static JButton b_help = new JButton();
    public static JButton b_send = new JButton();
    public static JLabel l_message = new JLabel("Message");
    public static JTextField tf_message = new JTextField(20);
    public static JLabel l_conversation = new JLabel();
    public static JTextArea ta_conversation = new JTextArea();
    public static JScrollPane sp_conversation = new JScrollPane();
    public static JLabel l_online = new JLabel();
    public static JList jl_online = new JList();
    public static JScrollPane sp_online = new JScrollPane();
    public static JLabel l_loggedInAs = new JLabel();
    public static JLabel l_loggedinasBox = new JLabel();

    ////login window
    public static JFrame LoginWindow = new JFrame();
    public static JTextField tf_usernamebox = new JTextField(20);
    public static JButton b_enter = new JButton("Enter");
    public static JLabel l_enterusername = new JLabel("Enter username");
    public static JPanel p_login = new JPanel();
    
    
    public static void main(String arg[])
    {
        BuildMainWindow();
        Initialize();
    }
    
    public static void Connect() throws IOException
    {
        try
        {
            final int port = 444;
            final String host = "Galactica";
            Socket sock = new Socket(host, port);
            System.out.println("you connected to : " + host);
            //ChatClient = new A_Chat_Client(sock);
            PrintWriter out = new PrintWriter(sock.getOutputStream());
            out.println(UserName);
            out.flush();
            //Thread X = new Thread(ChatClient);
            //X.start();
        }
        catch(Exception X)
        {
            System.out.println(X);
            JOptionPane.showMessageDialog(null, "server not responding");
            System.exit(0);
        }
    }
    
    private static void Initialize() {
        b_send.setEnabled(false);
        b_disconnect.setEnabled(false);
        b_connect.setEnabled(true);
    }

    private static void BuildMainWindow() {
        LoginWindow.setTitle("What's  your name");
        LoginWindow.setSize(400,100);
        LoginWindow.setLocation(250,200);
        LoginWindow.setResizable(false);
        p_login = new JPanel();
        p_login.add(l_enterusername);
        p_login.add(tf_usernamebox);
        p_login.add(b_enter);
        LoginWindow.add(p_login);
        Login_Action();
        LoginWindow.setVisible(true);
    }

    private static void Login_Action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
