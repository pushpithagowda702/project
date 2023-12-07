package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class CalculateBill extends JFrame implements ActionListener {

    JLabel nameText, addressText;

    JButton submitButton, cancelButton;

    JTextField unitText;
    Choice meterNumChoice, monthChoice;
    CalculateBill() {
        super("Bill");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214, 195,247));
        add(panel);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(heading);

        JLabel meterNum = new JLabel("Meter No");
        meterNum.setBounds(50,80,100,20);
        panel.add(meterNum);

        meterNumChoice = new Choice();
        try {
            DataBase db = new DataBase();
            ResultSet resultSet = db.statement.executeQuery("Select * from newcustomer");
            while(resultSet.next()) {
                meterNumChoice.add(resultSet.getString("meterno"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        meterNumChoice.setBounds(180,80,100,20);
        panel.add(meterNumChoice);

        JLabel name = new JLabel("Name");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(180,120,150,20);
        panel.add(nameText);

        JLabel address = new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);


        addressText = new JLabel("");
        addressText.setBounds(180,160,100,20);
        panel.add(addressText);



        meterNumChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                try {

                    DataBase db = new DataBase();
                    ResultSet resultSet = db.statement.executeQuery("select * from newcustomer where meterno = '"+meterNumChoice.getSelectedItem()+"'");
                    while(resultSet.next()) {
                        nameText.setText(resultSet.getString("name"));
                        addressText.setText(resultSet.getString("address"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JLabel unitConsumed = new JLabel("Unit Consumed");
        unitConsumed.setBounds(50,200,130,20);
        panel.add(unitConsumed);

        unitText = new JTextField();
        unitText.setBounds(180,200,100,20);
        panel.add(unitText);

        JLabel month = new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);


        monthChoice = new Choice();
        monthChoice.add("January");
        monthChoice.add("Febrauary");
        monthChoice.add("March");
        monthChoice.add("April");
        monthChoice.add("May");
        monthChoice.add("June");
        monthChoice.add("July");
        monthChoice.add("August");
        monthChoice.add("September");
        monthChoice.add("October");
        monthChoice.add("November");
        monthChoice.add("December");
        monthChoice.setBounds(180,240,100,20);
        panel.add(monthChoice);

        submitButton = new JButton("Submit");
        submitButton.setBounds(80, 300,100,50);
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(220, 300,100,50);
        cancelButton.setBackground(Color.BLUE);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        setLayout(new BorderLayout());
        add(panel, "Center");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon/budget.png"));
        Image i2 = i1.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        add(imageLabel, "East");
        setSize(650,450);
        setLocation(400,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==submitButton) {
            String smeterno = meterNumChoice.getSelectedItem();
            String sunit = unitText.getText();
            String smonth = monthChoice.getSelectedItem();

            int totalBill = 0;
            int units = Integer.parseInt(sunit);
            String queryTax = "select * from tax";
            try{
                DataBase db = new DataBase();
                ResultSet resultSet = db.statement.executeQuery(queryTax);
                while(resultSet.next()) {
                    totalBill += units * Integer.parseInt(resultSet.getString("costperunit"));
                    totalBill += Integer.parseInt(resultSet.getString("rent"));
                    totalBill += Integer.parseInt(resultSet.getString("servicecharge"));
                    totalBill += Integer.parseInt(resultSet.getString("swachbharathtax"));
                    totalBill += Integer.parseInt(resultSet.getString("fixedtax"));

                }
            } catch (Exception e){
                e.printStackTrace();
            }

            String query = "insert into bill values('"+smeterno+"', '"+smonth+"', '"+sunit+"', '"+totalBill+"', 'Not Paid')";

            try {
                DataBase db = new DataBase();
                db.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer bill updated successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CalculateBill();
    }
}
