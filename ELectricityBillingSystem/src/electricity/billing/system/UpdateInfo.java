package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInfo extends JFrame implements ActionListener {

    String meter;
    JLabel nameText;
    JTextField addressText, cityText, emailText, phoneText, stateText;
    JButton updateButton,cancelButton;
    UpdateInfo(String meter) {
        this.meter = meter;

        JLabel heading = new JLabel("Update Information");
        heading.setBounds(50,10,400,40);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(30,70,100,20);
        add(name);

        nameText = new JLabel("");
        nameText.setBounds(150,70,200,20);
        add(nameText);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,110,100,20);
        add(meterNo);

        JLabel meterText = new JLabel("");
        meterText.setBounds(150,110,200,20);
        add(meterText);

        JLabel address = new JLabel("Address");
        address.setBounds(30,150,100,20);
        add(address);

        addressText = new JTextField("");
        addressText.setBounds(150,150,200,20);
        add(addressText);

        JLabel city = new JLabel("City");
        city.setBounds(30,190,100,20);
        add(city);

        cityText = new JTextField("");
        cityText.setBounds(150,190,200,20);
        add(cityText);

        JLabel state = new JLabel("State");
        state.setBounds(30,230,100,20);
        add(state);

        stateText = new JTextField("");
        stateText.setBounds(150,230,200,20);
        add(stateText);

        JLabel email = new JLabel("Email");
        email.setBounds(30,270,100,20);
        add(email);

        emailText = new JTextField("");
        emailText.setBounds(150,270,200,20);
        add(emailText);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,310,100,20);
        add(phone);

        phoneText = new JTextField("");
        phoneText.setBounds(150,310,200,20);
        add(phoneText);

        try {
            DataBase db = new DataBase();
            ResultSet resultSet = db.statement.executeQuery("select * from newcustomer where meterno='"+meterNo+"'");
            if(resultSet.next()) {
                nameText.setText(resultSet.getString("name"));
                meterText.setText(resultSet.getString("meterno"));
                addressText.setText(resultSet.getString("address"));
                cityText.setText(resultSet.getString("city"));
                stateText.setText(resultSet.getString("state"));
                emailText.setText(resultSet.getString("email"));
                phoneText.setText(resultSet.getString("phone"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        updateButton = new JButton("Update");
        updateButton.setBackground(new Color(33,106,145));
        updateButton.setForeground(Color.WHITE);
        updateButton.setBounds(50,360,120,25);
        updateButton.addActionListener(this);
        add(updateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(33,106,145));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(200,360,120,25);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/update.png"));
        Image imageTwo = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageOne = new ImageIcon(imageTwo);
        JLabel imageLabel = new JLabel(imageOne);
        imageLabel.setBounds(360,0,400,410);
        add(imageLabel);

        setBounds(400,150,777,450);
        getContentPane().setBackground(new Color(229,255,227));
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==updateButton) {
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();

            try {
                DataBase db = new DataBase();
                db.statement.executeUpdate("update newcustomer set address = '"+saddress+"', city='"+scity+"', state='"+sstate+"', email='"+semail+"', phone='"+sphone+"'");
                JOptionPane.showMessageDialog(null, "Updated successfully");
                setVisible(false);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateInfo("");
    }
}
