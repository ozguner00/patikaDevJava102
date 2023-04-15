package PratikPatikaKlonu.View;

import PratikPatikaKlonu.Helper.*;

import javax.swing.*;

public class LoginGUI extends JFrame{
    private JPanel pnlWrapper;
    private JPanel pnlTop;
    private JPanel pnlBottom;
    private JLabel lblTop;
    private JLabel lblTop2;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginGUI(){
        Helper.setLayout();
        setContentPane(pnlWrapper);
        setSize(400,300);
        setLocation(Helper.centerPoint("x", getSize().width),Helper.centerPoint("y",getSize().height));
        setVisible(true);
        setResizable(false);
        setTitle(Config.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
