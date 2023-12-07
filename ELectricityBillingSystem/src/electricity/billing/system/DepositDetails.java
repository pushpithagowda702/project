package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DepositDetails extends JFrame implements ActionListener {

    Choice meterChoice, monthChoice;

    JButton searchButton, closeButton;

    JTable table;
    DepositDetails() {
        super("Deposit Details");
        getContentPane().setBackground(new Color(192,186,254));

        JLabel meternum = new JLabel("Meter Number");
        meternum.setBounds(20,20,150,20);
        add(meternum);

        meterChoice = new Choice();
        meterChoice.setBounds(180,20,150,20);
        meterChoice.setBackground(Color.WHITE);
        add(meterChoice);

        JLabel month = new JLabel("Month");
        month.setBounds(400,20,50,20);
        add(month);

        monthChoice = new Choice();
        monthChoice.setBounds(500,20,150,20);
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

        try {
            DataBase db = new DataBase();
            ResultSet resultSet = db.statement.executeQuery("select * from bill");
            while(resultSet.next()) {
                meterChoice.add(resultSet.getString("meterno"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        table = new JTable();

//        try {
//            DataBase db = new DataBase();
//            ResultSet resultSet = db.statement.executeQuery("select * from newcustomer");
//            table.setModel(DbUtils.resultSetToTableModel(resultSet));
//        } catch (Exception E) {
//            E.printStackTrace();
//        }
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0, 100,700,500);
        scroll.setBackground(Color.WHITE);
        add(scroll);

        searchButton = new JButton("Search");
        searchButton.setBackground(new Color(39, 207, 56));
        searchButton.setBounds(250,70,100,23);
        searchButton.addActionListener(this);
        add(searchButton);



        closeButton = new JButton("Close");
        closeButton.setBackground(Color.red);
        closeButton.setBounds(400,70,100,23);
        closeButton.addActionListener(this);
        add(closeButton);

        setSize(700, 500);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==searchButton) {
            String querySearch = "select * from bill where meterno = '"+meterChoice.getSelectedItem()+"' and month = '"+ monthChoice.getSelectedItem()+"'";
            try {
                DataBase db = new DataBase();
                ResultSet resultSet = db.statement.executeQuery(querySearch);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DepositDetails();
    }
}
