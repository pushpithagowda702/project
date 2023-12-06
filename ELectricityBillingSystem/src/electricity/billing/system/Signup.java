package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {

    JTextField employeeText, nameText, meterText, userText, passwordText;
    JButton createButton, cancelButton;

    Choice loginAsChoice;

    Signup() {
        super("Signup");
        getContentPane().setBackground(new Color(147, 238, 214, 245));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30, 50, 140, 20);
        add(createAs);

        loginAsChoice = new Choice();
        loginAsChoice.setBackground(Color.white);
        loginAsChoice.add("Admin");
        loginAsChoice.add("Customer");
        loginAsChoice.setBounds(170, 50, 120, 20);
        add(loginAsChoice);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30, 100, 125, 20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new JTextField();
        meterText.setBounds(170, 100, 120, 20);
        meterText.setVisible(false);
        add(meterText);

        JLabel employee = new JLabel("Employee ID");
        employee.setBounds(30, 100, 125, 20);
        employee.setVisible(true);
        add(employee);

        employeeText = new JTextField();
        employeeText.setBounds(170, 100, 120, 20);
        employeeText.setVisible(true);
        add(employeeText);

        JLabel userName = new JLabel("UserName");
        userName.setBounds(30, 140, 125, 20);
        add(userName);

        userText = new JTextField();
        userText.setBounds(170, 140, 120, 20);
        add(userText);

        JLabel name = new JLabel("Name");
        name.setBounds(30, 180, 125, 20);
        add(name);

        nameText = new JTextField();
        nameText.setBounds(170, 180, 120, 20);
        add(nameText);

        JLabel password = new JLabel("password");
        password.setBounds(30, 220, 125, 20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(170, 220, 120, 20);
        add(passwordText);

        loginAsChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAsChoice.getSelectedItem();
                if (user.equals("Admin")) {
                    employee.setVisible(true);
                    employeeText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                } else {
                    employee.setVisible(false);
                    employeeText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                }
            }
        });

        createButton = new JButton("Create");
        createButton.setBackground(new Color(39, 207, 56));
        createButton.setForeground(Color.white);
        createButton.addActionListener(this);
        createButton.setBounds(50, 270, 100, 30);
        add(createButton);


        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.red);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(this);
        cancelButton.setBounds(200, 270, 100, 30);
        add(cancelButton);

        ImageIcon signUpIcon = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image icon = signUpIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(icon);
        JLabel iconLabel = new JLabel(icon1);
        iconLabel.setBounds(330, 40, 250, 250);
        add(iconLabel);


        setSize(600, 380);
        setLocation(500, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==createButton) {
            String sloginAs = loginAsChoice.getSelectedItem();
            String suserName = userText.getText();
            String sname = nameText.getText();
            String spassword = passwordText.getText();
            String smeter = meterText.getText();
            try {
                DataBase db = new DataBase();
                String query = null;
                query = "insert into signup value('"+smeter+"', '"+suserName+"', '"+sname+"', '"+spassword+"', '"+sloginAs+"')";
                db.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account created successfully");
                setVisible(false);
                new Login();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
