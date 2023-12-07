package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class GenerateBill extends JFrame implements ActionListener {

    String meter;
    JTextArea area;
    JButton billButton;
    Choice monthChoice;
    GenerateBill(String meter) {
        this.meter = meter;

        setBounds(500,30,500,700);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();

        JLabel heading = new JLabel("Generate Bill" + " "+ " " + " ");

        JLabel meterNum = new JLabel("");

        monthChoice = new Choice();
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

        area = new JTextArea(50,15);
        area.setText("\n\n\t.......Click on........ Generate Bill........\n\t");
        area.setFont(new Font("senserif", Font.ITALIC, 15));

        JScrollPane pane = new JScrollPane(area);

        billButton = new JButton("Generate Bill");
        billButton.addActionListener(this);
        add(billButton, "South");

        add(pane);
        panel.add(heading);
        panel.add(monthChoice);
        panel.add(meterNum);
        add(panel, "North");
        setVisible(true);
    }

    public static void main(String[] args) {
        new GenerateBill("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            DataBase db = new DataBase();
            String smonth = monthChoice.getSelectedItem();
            area.setText("\n Power Limited \n ELectricity Bill for Month of " + smonth + " 2023");
            ResultSet resultSet = db.statement.executeQuery("select * from newcustomer where meterno='"+meter+"'");

            if (resultSet.next()){
                area.append("\n    Customer Name                 -    "+resultSet.getString("name"));
                area.append("\n    Customer Meter Number    -    "+resultSet.getString("meterno"));
                area.append("\n    Customer Address              -    "+resultSet.getString("address"));
                area.append("\n    Customer City                    -    "+resultSet.getString("city"));
                area.append("\n    Customer State                 -    "+resultSet.getString("state"));
                area.append("\n    Customer Email                -    "+resultSet.getString("email"));
                area.append("\n    Customer Phone Number  -    "+resultSet.getString("phone"));

            }

            resultSet = db.statement.executeQuery("select * from meterinfo where meternum ='"+meter+"'");
            if (resultSet.next()){
                area.append("\n    Customer Meter Location   -    "+resultSet.getString("meterloc"));
                area.append("\n    Customer Meter Type        -    "+resultSet.getString("metertype"));
                area.append("\n    Customer Phase Code      -    "+resultSet.getString("phasecode"));
                area.append("\n    Customer Bill Type           -    "+resultSet.getString("billtype"));
                area.append("\n    Customer Days              -    "+resultSet.getString("days"));


            }
            resultSet = db.statement.executeQuery("select * from tax");
            if (resultSet.next()){
                area.append("\n    Cost Per Unit                 -    "+resultSet.getString("costperunit"));
                area.append("\n    Meter Rent                    -    "+resultSet.getString("rent"));
                area.append("\n    Service Charge              -    "+resultSet.getString("servicecharge"));
                area.append("\n    Service Tax                   -    "+resultSet.getString("servicetax"));
                area.append("\n    Swacch Bharat Acss      -    "+resultSet.getString("swachbharathtax"));
                area.append("\n    Fixed Tax                      -    "+resultSet.getString("fixedtax"));

            }
            resultSet = db.statement.executeQuery("select * from bill where meterno = '"+meter+"' and month = '"+smonth+"'");
            if (resultSet.next()) {
                area.append("\n    Current Month                 -    " + resultSet.getString("month"));
                area.append("\n    Units Consumed                -    " + resultSet.getString("unit"));
                area.append("\n    Total Charges                 -    " + resultSet.getString("totalbill"));
                area.append("\n    Total Payable                 -    "+resultSet.getString("totalbill"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
