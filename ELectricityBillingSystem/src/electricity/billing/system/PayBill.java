package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayBill extends JFrame implements ActionListener {

    String meter;

    JButton payButton, backButton;

    Choice monthChoice;
    PayBill(String meter) {
        this.meter = meter;

        JLabel heading = new JLabel("Pay Bill");
        heading.setFont(new Font("serif", Font.BOLD, 24));
        heading.setBounds(120,5,400,30);
        add(heading);

        JLabel meterNum = new JLabel("Meter NUmber");
        meterNum.setBounds(35,80,200,20);
        add(meterNum);

        JLabel meterNumText = new JLabel("");
        meterNumText.setBounds(300,80,200,20);
        add(meterNumText);

        JLabel name = new JLabel("Name");
        name.setBounds(35,140,200,20);
        add(name);

        JLabel nameText = new JLabel("");
        nameText.setBounds(300,140,200,20);
        add(nameText);

        JLabel month = new JLabel("Month");
        month.setBounds(35,200,200,20);
        add(month);

        monthChoice = new Choice();
        monthChoice.setBounds(300,200,150,20);
        monthChoice.setBackground(Color.WHITE);
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
        add(monthChoice);

        JLabel unit = new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        add(unit);

        JLabel unitText = new JLabel("");
        unitText.setBounds(300,260,200,20);
        add(unitText);

        JLabel totalBill = new JLabel("Total Bill");
        totalBill.setBounds(35,320,200,20);
        add(totalBill);

        JLabel totalBillText = new JLabel("");
        totalBillText.setBounds(300,320,200,20);
        add(totalBillText);

        JLabel status = new JLabel("Status");
        status.setBounds(35,380,200,20);
        add(status);

        JLabel statusText = new JLabel("");
        statusText.setBounds(300,380,200,20);
        add(statusText);

        try {
            DataBase db = new DataBase();
            String query = "select * from newcustomer where meterno='"+meter+"'";
            ResultSet resultSet = db.statement.executeQuery(query);

            while(resultSet.next()) {
                meterNumText.setText(meter);
                nameText.setText(resultSet.getString("name"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        monthChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                DataBase db = new DataBase();
                try {
                    String query = "select * from newcustomer where meterno='"+meter+"' and month = '"+monthChoice.getSelectedItem()+"'";
                    ResultSet resultSet = db.statement.executeQuery(query);

                    while(resultSet.next()) {
                        unitText.setText(resultSet.getString("unit"));
                        totalBillText.setText(resultSet.getString("totalbill"));
                        statusText.setText(resultSet.getString("status"));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        payButton = new JButton("Pay");
        payButton.setBackground(Color.BLUE);
        payButton.setForeground(Color.WHITE);
        payButton.setBounds(100,470,100,25);
        payButton.addActionListener(this);
        add(payButton);

        backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.RED);
        backButton.setBounds(300,470,100,25);
        backButton.addActionListener(this);
        add(backButton);

        setSize(900,600);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PayBill("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==payButton) {
            try {
                DataBase db = new DataBase();
                db.statement.executeUpdate("update bill set status = 'Paid' where meterno='"+meter+"' and month = '"+monthChoice.getSelectedItem()+"'");
                new BillPayment(meter);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            setVisible(false);
        } else {
            setVisible(false);
        }
    }
}
