package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);
    JTextField name, fname, email, address, city, pin, state;
    JDateChooser dateChooser;

    JRadioButton r1, r2, r3, m, um;

    JButton next, save;

    Signup() {
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel(" Application Form No. " + first);
        label1.setBounds(130, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(330, 70, 600, 30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(290, 90, 600, 30);
        add(label3);

        JLabel labelName = new JLabel("Name: ");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 190, 100, 30);
        add(labelName);

        name= new JTextField();
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(300, 190, 400, 30);
        add(name);

        JLabel labelFName = new JLabel("Father's Name: ");
        labelFName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelFName.setBounds(100, 240, 200, 30);
        add(labelFName);

        fname = new JTextField();
        fname.setFont(new Font("Raleway", Font.BOLD, 16));
        fname.setBounds(300, 240, 400, 30);
        add(fname);

        JLabel labelDOB = new JLabel("DOB: ");
        labelDOB.setFont(new Font("Raleway", Font.BOLD, 20));
        labelDOB.setBounds(100, 290, 200, 30);
        add(labelDOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 290, 400, 30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender: ");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100, 340, 200, 30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBounds(300, 340, 100, 30);
        r1.setBackground(new Color(187, 216, 234));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBounds(450, 340, 100, 30);
        r2.setBackground(new Color(187, 216, 234));
        add(r2);

        r3 = new JRadioButton("Others");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBounds(600, 340, 100, 30);
        r3.setBackground(new Color(187, 216, 234));
        add(r3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);
        buttonGroup1.add(r3);

        JLabel labelEmail = new JLabel("Email: ");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 390, 200, 30);
        add(labelEmail);

        email = new JTextField();
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(300, 390, 400, 30);
        add(email);

        JLabel labelms = new JLabel("Marital Status: ");
        labelms.setFont(new Font("Raleway", Font.BOLD, 20));
        labelms.setBounds(100, 440, 200, 30);
        add(labelms);

        m = new JRadioButton("Married");
        m.setFont(new Font("Raleway", Font.BOLD, 14));
        m.setBounds(300, 440, 100, 30);
        m.setBackground(new Color(187, 216, 234));
        add(m);

        um = new JRadioButton("Unmarried");
        um.setFont(new Font("Raleway", Font.BOLD, 14));
        um.setBounds(450, 440, 200, 30);
        um.setBackground(new Color(187, 216, 234));
        add(um);


        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(m);
        buttonGroup2.add(um);

        JLabel labeladd = new JLabel("Address: ");
        labeladd.setFont(new Font("Raleway", Font.BOLD, 20));
        labeladd.setBounds(100, 490, 200, 30);
        add(labeladd);

        address = new JTextField();
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        address.setBounds(300, 490, 400, 30);
        add(address);

        JLabel labelcity = new JLabel("City: ");
        labelcity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelcity.setBounds(100, 540, 200, 30);
        add(labelcity);

        city = new JTextField();
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        city.setBounds(300, 540, 400, 30);
        add(city);

        JLabel labelpin = new JLabel("Pin Code: ");
        labelpin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelpin.setBounds(100, 590, 200, 30);
        add(labelpin);

        pin = new JTextField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(300, 590, 400, 30);
        add(pin);

        JLabel labelstate = new JLabel("State: ");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(100, 640, 200, 30);
        add(labelstate);

        state= new JTextField();
        state.setFont(new Font("Raleway", Font.BOLD, 16));
        state.setBounds(300, 640, 400, 30);
        add(state);

//        save = new JButton("Save");
//        save.setFont(new Font("Raleway", Font.BOLD, 14));
//        save.setForeground(Color.WHITE);
//        save.setBackground(Color.BLACK);
//        save.setBounds(520, 710, 80, 30);
//        save.addActionListener(this);
//        add(save);


        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setBounds(620, 710, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(187, 216, 234));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String formNo = first;
        String uName = name.getText();
        String fName = fname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()) {
            gender = "Male";
        } else if(r2.isSelected()) {
            gender = "Female";
        } else if(r3.isSelected()) {
            gender = "Others";
        }
        String eMail = email.getText();
        String marital = null;
        if(m.isSelected()) {
            marital = "Married";
        } else if(um.isSelected()) {
            marital = "Unmarried";
        }
        String addr = address.getText();
        String cityAddr = city.getText();
        String pinCode = pin.getText();
        String stateAddr = state.getText();

        try {
            if(name.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                Con con1 = new Con();
                String q = "insert into signup values('"+formNo+"', '"+uName+"', '"+fName+"', '"+dob+"', '"+gender+"', '"+eMail+"', '"+marital+"', '"+addr+"', '"+cityAddr+"', '"+pinCode+"', '"+stateAddr+"')";
                con1.statement.executeUpdate(q);
                new Signup2(first);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup();

    }


}
