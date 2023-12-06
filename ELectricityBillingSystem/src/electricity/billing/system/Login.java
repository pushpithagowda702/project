package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField userText, passwordText;
    Choice loginChoice;

    JButton loginButton, signupButton, cancelButton;
    Login() {
        super("Login");
        getContentPane().setBackground(Color.white);

        JLabel username = new JLabel("UserName");
        username.setBounds(300, 60, 100, 20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400, 60, 150, 20);
        add(userText);

        JLabel password = new JLabel("password");
        password.setBounds(300, 100, 100, 20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400, 100, 150, 20);
        add(passwordText);

        JLabel login = new JLabel("Login As");
        login.setBounds(300, 140, 100, 20);
        add(login);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 140, 150, 20);
        add(loginChoice);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBounds(330, 180, 100, 20);
        add(loginButton);

        signupButton = new JButton("Sign Up");
        signupButton.addActionListener(this);
        signupButton.setBounds(460, 180, 100, 20);
        add(signupButton);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        cancelButton.setBounds(400, 220, 100, 20);
        add(cancelButton);

        ImageIcon profile = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTwo = profile.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon profileOne = new ImageIcon(profileTwo);
        JLabel profileLabel = new JLabel(profileOne);
        profileLabel.setBounds(5,5,250,250);
        add(profileLabel);



        setSize(640, 300);
        setLocation(500,300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==loginButton) {
            String susername = userText.getText();
            String spassword = passwordText.getText();
            String suser = loginChoice.getSelectedItem();

            try {
                DataBase db = new DataBase();
                String query = "select * from signup where username = '"+susername+"' and password = '"+spassword+"' and userType = '"+suser+"'";

                ResultSet resultSet = db.statement.executeQuery(query);
                if(resultSet.next()) {
                    setVisible(false);
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        } else if(actionEvent.getSource() == signupButton) {
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
