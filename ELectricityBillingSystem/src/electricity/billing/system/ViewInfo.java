package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInfo extends JFrame implements ActionListener {

    String meternum;

    JButton cancelButton;
    ViewInfo(String meternum) {

        super("Details");
        this.meternum = meternum;
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Customer Info");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(70,80,100,20);
        add(nameLabel);

        JLabel nameLabelText = new JLabel("");
        nameLabelText.setBounds(200,80,100,20);
        add(nameLabelText);

        JLabel meterLabel = new JLabel("Meter Number");
        meterLabel.setBounds(70,140,130,20);
        add(meterLabel);

        JLabel meterLabelText = new JLabel("");
        meterLabelText.setBounds(200,140,100,20);
        add(meterLabelText);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(70,200,100,20);
        add(addressLabel);

        JLabel addressLabelText = new JLabel("");
        addressLabelText.setBounds(200,200,100,20);
        add(addressLabelText);

        JLabel cityLabel = new JLabel("City");
        cityLabel.setBounds(70,260,100,20);
        add(cityLabel);

        JLabel cityLabelText = new JLabel("");
        cityLabelText.setBounds(200,260,100,20);
        add(cityLabelText);

        JLabel stateLabel = new JLabel("State");
        stateLabel.setBounds(500,80,100,20);
        add(stateLabel);

        JLabel stateLabelText = new JLabel("");
        stateLabelText.setBounds(600,80,100,20);
        add(stateLabelText);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(500,140,100,20);
        add(emailLabel);

        JLabel emailLabelText = new JLabel("");
        emailLabelText.setBounds(600,140,150,20);
        add(emailLabelText);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(500,200,100,20);
        add(phoneLabel);

        JLabel phoneLabelText = new JLabel("");
        phoneLabelText.setBounds(600,200,150,20);
        add(phoneLabelText);

        try {
            DataBase db = new DataBase();
            ResultSet resultSet = db.statement.executeQuery("select * from newcustomer where meterno = '"+meternum+"'");
            if(resultSet.next()) {
                nameLabelText.setText(resultSet.getString("name"));
                meterLabelText.setText(resultSet.getString("meterno"));
                addressLabelText.setText(resultSet.getString("address"));
                cityLabelText.setText(resultSet.getString("city"));
                stateLabelText.setText(resultSet.getString("state"));
                emailLabelText.setText(resultSet.getString("email"));
                phoneLabelText.setText(resultSet.getString("phone"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(220,350,120,25);
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon/viewInfo.png"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        imageLabel.setBounds(100,320,600,300);
        add(imageLabel);

        setSize(850, 650);
        setLocation(350, 150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==cancelButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewInfo("");
    }
}
