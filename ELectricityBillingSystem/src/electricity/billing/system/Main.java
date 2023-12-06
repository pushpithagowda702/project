package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Main() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1900, 1080, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        add(imageLabel);

        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon customerIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/newcustomer.png"));
        Image customerImage = customerIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customerImage));
        menu.add(newcustomer);

        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon customerDetailsIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/customerDetails.png"));
        Image customerDetailsImage = customerDetailsIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(customerDetailsImage));
        menu.add(customerDetails);

        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon calculateBillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/calculatorbills.png"));
        Image calculateBillImage = calculateBillIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(calculateBillImage));
        menu.add(calculateBill);

        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon depositDetailsIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/depositdetails.png"));
        Image depositDetailsImage = depositDetailsIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(depositDetailsImage));
        menu.add(depositDetails);

        JMenu info = new JMenu("Info");
        info.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JMenuItem upinfo = new JMenuItem("Update Info");
        upinfo.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon upinfoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/refresh.png"));
        Image upinfoImage = upinfoIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        upinfo.setIcon(new ImageIcon(upinfoImage));
        info.add(upinfo);

        JMenuItem viewinfo = new JMenuItem("View Info");
        viewinfo.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon viewinfoIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/information.png"));
        Image viewinfoImage = viewinfoIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoImage));
        info.add(viewinfo);

        JMenu user = new JMenu("User");
        user.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon  paybillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/pay.png"));
        Image paybillImage =  paybillIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillImage));
        user.add(paybill);

        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon billdetailsIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/details.png"));
        Image billdetailsImage =  billdetailsIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsImage));
        user.add(billdetails);

        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JMenuItem genBill = new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon genBillIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/bill.png"));
        Image genBillImage =  genBillIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBillImage));
        bill.add(genBill);

        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/notepad.png"));
        Image notepadImage =  notepadIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon calculatorIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/calculator.png"));
        Image calculatorImage =  calculatorIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImage));
        utility.add(calculator);

        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        exit.setFont(new Font("monospaced", Font.PLAIN, 14));
        ImageIcon exitIcon = new ImageIcon(ClassLoader.getSystemResource("icon/icon/exit.png"));
        Image exitImage =  exitIcon.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(exitImage));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(menu);
        menuBar.add(info);
        menuBar.add(user);
        menuBar.add(bill);
        menuBar.add(utility);
        menuBar.add(exit);


        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
