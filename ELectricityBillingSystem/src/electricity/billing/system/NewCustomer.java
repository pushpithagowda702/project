package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {


    JTextField nameText, addressText, cityText, stateText, emailText,phoneText;
    JLabel customerName, heading, meterNum, meterText, address, city, state, email, phone;

    JButton cancelButton, nextButton;
    NewCustomer() {

        super("New Customer");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        heading = new JLabel("New Customer");
        heading.setBounds(180,20,200,20);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(heading);

        customerName = new JLabel("Customer Name");
        customerName.setBounds(50,80,150,20);
        panel.add(customerName);

        nameText = new JTextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        meterNum = new JLabel("Meter No");
        meterNum.setBounds(50,120,150,20);
        panel.add(meterNum);

        meterText = new JLabel("");
        meterText.setBounds(180,120,150,20);
        panel.add(meterText);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meterText.setText("" + Math.abs(number));

        address = new JLabel("Address");
        address.setBounds(50,160,150,20);
        panel.add(address);

        addressText = new JTextField();
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        city = new JLabel("City");
        city.setBounds(50,200,150,20);
        panel.add(city);

        cityText = new JTextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        state = new JLabel("State");
        state.setBounds(50,240,150,20);
        panel.add(state);

        stateText = new JTextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        email = new JLabel("Email");
        email.setBounds(50,280,150,20);
        panel.add( email);

        emailText = new JTextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);

        phone = new JLabel("Phone");
        phone.setBounds(50,320,150,20);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(180,320,150,20);
        panel.add(phoneText);

        nextButton = new JButton("Next");
        nextButton.setBounds(120, 390, 100, 25);
        nextButton.setBackground(new Color(39, 207, 56));
        nextButton.setForeground(Color.white);
        nextButton.addActionListener(this);
        panel.add(nextButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 390, 100, 25);
        cancelButton.setBackground(Color.red);
        cancelButton.setForeground(Color.white);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        add(imageLabel, "West");


        setSize(700, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton) {
            String sname = nameText.getText();
            String smeter = meterText.getText();
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();


            String query = "insert into newcustomer values('"+sname+"', '"+smeter+"', '"+saddress+"', '"+scity+"', '"+sstate+"', '"+semail+"', '"+sphone+"')";
            String query_signup = "insert into signup values('"+smeter+"', '', '"+sname+"', '', '')";
            try {
                DataBase db = new DataBase();
                db.statement.executeUpdate(query);
                db.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null, "Customer details added successfully");
                setVisible(false);
                new MeterInfo(smeter);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
