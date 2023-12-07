package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class BillDetails extends JFrame {

    String meter;
    BillDetails(String meter) {
        this.meter = meter;

        JTable table = new JTable();

        try {
            DataBase db = new DataBase();
            String query = "select * from bill where meterno = '"+meter+"'";
            ResultSet resultSet = db.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(0,0,700,650);
        add(scroll);


        getContentPane().setBackground(Color.WHITE);
        setSize(700,650);
        setLocation(400,150);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BillDetails("");
    }
}
