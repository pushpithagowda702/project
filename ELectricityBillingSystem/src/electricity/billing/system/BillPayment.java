package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillPayment extends JFrame implements ActionListener {

    JButton backButton;

    String meter;
    BillPayment(String meter) {
        this.meter = meter;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com/");
            j.setBounds(400,150,800,600);
        } catch (Exception e) {
            e.printStackTrace();
            j.setContentType("text/html");
            j.setText("<html>Error!</html>");
        }

        JScrollPane scroll = new JScrollPane(j);
        add(scroll);

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(640,20,80,30);
        backButton.addActionListener(this);
        j.add(backButton);


        setBounds(400,150,800,600);
        setVisible(true);
    }


    public static void main(String[] args) {
        new BillPayment("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        new PayBill(meter);
    }
}
