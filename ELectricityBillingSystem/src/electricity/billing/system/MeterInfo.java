package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {


    String meterNumber;
    Choice meterLoc, meterTypeChoice, phaseCodeChoice, billTypeChoice;
    JButton submit;
    MeterInfo(String s) {
        this.meterNumber = s;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,250,20);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(heading);

        JLabel meterNum = new JLabel("Meter Number");
        meterNum.setBounds(50,80,150,20);
        panel.add(meterNum);

        JLabel meterText = new JLabel(meterNumber);
        meterText.setBounds(180, 80, 150,20);
        panel.add(meterText);

        JLabel loc = new JLabel("Location");
        loc.setBounds(50,120,100,20);
        panel.add(loc);

        meterLoc = new Choice();
        meterLoc.setBounds(180,120,150,20);
        meterLoc.setBackground(Color.white);
        meterLoc.add("Outside");
        meterLoc.add("Inside");
        panel.add(meterLoc);

        JLabel meterType = new JLabel("Meter Type");
        meterType.setBounds(50,160,100,20);
        panel.add(meterType);

        meterTypeChoice = new Choice();
        meterTypeChoice.setBounds(180,160,150,20);
        meterTypeChoice.setBackground(Color.white);
        meterTypeChoice.add("Electric Meter");
        meterTypeChoice.add("Solar Meter");
        meterTypeChoice.add("Smart Meter");
        panel.add(meterTypeChoice);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeChoice = new Choice();
        phaseCodeChoice.setBounds(180,200,150,20);
        phaseCodeChoice.setBackground(Color.white);
        phaseCodeChoice.add("011");
        phaseCodeChoice.add("022");
        phaseCodeChoice.add("033");
        phaseCodeChoice.add("044");
        phaseCodeChoice.add("055");
        phaseCodeChoice.add("066");
        phaseCodeChoice.add("077");
        phaseCodeChoice.add("088");
        phaseCodeChoice.add("099");
        panel.add(phaseCodeChoice);

        JLabel billType = new JLabel("Bill Type");
        billType.setBounds(50,240,100,20);
        panel.add(billType);

        billTypeChoice = new Choice();
        billTypeChoice.setBounds(180,240,150,20);
        billTypeChoice.setBackground(Color.white);
        billTypeChoice.add("Normal");
        billTypeChoice.add("Industrial");
        panel.add(billTypeChoice);

        JLabel day = new JLabel("30 Days Billing Time");
        day.setBounds(50,280,150,20);
        panel.add(day);

        JLabel note = new JLabel("Note...");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1 = new JLabel("Bill calculated for 30 days");
        note1.setBounds(50,340,300,20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBackground(new Color(39, 207, 56));
        submit.setForeground(Color.white);
        submit.setBounds(220,390,100,25);
        submit.addActionListener(this);
        panel.add(submit);

        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon/details.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imageLabel = new JLabel(i3);
        add(imageLabel, "East");

        setSize(700, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {
            String smeternum = meterNumber;
            String smeterLoc = meterLoc.getSelectedItem();
            String smeterType = meterTypeChoice.getSelectedItem();
            String sphaseCode = phaseCodeChoice.getSelectedItem();
            String sbillType = billTypeChoice.getSelectedItem();
            String sday = "30";

            String query = "insert into meterinfo values('" + smeternum + "', '" + smeterLoc + "', '" + smeterType + "', '" + sphaseCode + "', '" + sbillType + "', '" + sday + "')";

            try {
                DataBase db = new DataBase();
                db.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Meter information submitted successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }  else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MeterInfo("");
    }
}
