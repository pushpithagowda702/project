package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class Signup2 extends JFrame implements ActionListener {

    String formNo;
    JTextField textPan, textAdhaar;

    JRadioButton s1, s2, e1, e2;

    JButton next;

    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;

    Signup2(String first) {

        super("Application Form No. ");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 5, 100, 100);
        add(image);

        this.formNo = first;

        JLabel l1 = new JLabel("Page 2:-");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(300, 60, 600, 40);
        add(l2);

        JLabel l3 = new JLabel("Religion: ");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 120, 100, 30);
        add(l3);

        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(187, 216, 234));
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(350, 120, 320, 30);
        add(comboBox);

        JLabel l4 = new JLabel("Category: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 170, 100, 30);
        add(l4);

        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(187, 216, 234));
        comboBox2.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox2.setBounds(350, 170, 320, 30);
        add(comboBox2);

        JLabel l5 = new JLabel("Income: ");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 220, 100, 30);
        add(l5);

        String income[] = {"Null", "<1,50,000", "<2,50,000", "5,00,000", "Upto 10 Lakh", "Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(187, 216, 234));
        comboBox3.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox3.setBounds(350, 220, 320, 30);
        add(comboBox3);

        JLabel l6 = new JLabel("Educational: ");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100, 270, 200, 30);
        add(l6);

        String educational[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(new Color(187, 216, 234));
        comboBox4.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox4.setBounds(350, 270, 320, 30);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation: ");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 320, 200, 30);
        add(l7);

        String occupation[] = {"Self-Employee", "Salaried", "Business", "Student", "Retired", "Others"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(new Color(187, 216, 234));
        comboBox5.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox5.setBounds(350, 320, 320, 30);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN: ");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 370, 200, 30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD, 14));
        textPan.setBounds(350, 370, 320, 30);
        add(textPan);

        JLabel l9 = new JLabel("Adhaar: ");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100, 420, 200, 30);
        add(l9);

        textAdhaar = new JTextField();
        textAdhaar.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdhaar.setBounds(350, 420, 320, 30);
        add(textAdhaar);

        JLabel l10 = new JLabel("Senior Citizem: ");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 470, 200, 30);
        add(l10);

        s1 = new JRadioButton("Yes");
        s1.setFont(new Font("Raleway", Font.BOLD, 14));
        s1.setBackground(new Color(187, 216, 234));
        s1.setBounds(350, 470, 100, 30);
        add(s1);

        s2 = new JRadioButton("No");
        s2.setFont(new Font("Raleway", Font.BOLD, 14));
        s2.setBackground(new Color(187, 216, 234));
        s2.setBounds(500, 470, 100, 30);
        add(s2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(s1);
        buttonGroup1.add(s2);

        JLabel l11 = new JLabel("Existing Account: ");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 520, 200, 30);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD, 14));
        e1.setBackground(new Color(187, 216, 234));
        e1.setBounds(350, 520, 100, 30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD, 14));
        e2.setBackground(new Color(187, 216, 234));
        e2.setBounds(500, 520, 100, 30);
        add(e2);

        JLabel l12 = new JLabel("Form No: ");
        l12.setFont(new Font("Raleway", Font.BOLD, 18));
        l12.setBounds(700, 10, 100, 30);
        add(l12);

        JLabel l13 = new JLabel(formNo);
        l13.setFont(new Font("Raleway", Font.BOLD, 18));
        l13.setBounds(760, 10, 200, 30);
        add(l13);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(700, 640, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850, 750);
        setLocation(400, 20);
        getContentPane().setBackground(new Color(187, 216, 234));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) comboBox.getSelectedItem();
        String cat = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();
        String pan = textPan.getText();
        String adhaar = textAdhaar.getText();
        String sCitizen = "";
        if(s1.isSelected()) {
            sCitizen += "Yes";
        } else if(s2.isSelected()) {
            sCitizen += "No";
        }
        String eAcc = "";
        if(e1.isSelected()) {
            eAcc += "Yes";
        } else if(e2.isSelected()) {
            eAcc += "No";
        }

        try {
            if(textPan.getText().equals("") || textAdhaar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                Con c1 = new Con();
                String q = "insert into signuptwo values('"+formNo+"', '"+rel+"', '"+cat+"', '"+inc+"', '"+edu+"', '"+occ+"', '"+pan+"', '"+adhaar+"', '"+sCitizen+"', '"+eAcc+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formNo);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Signup2("");

    }

}
