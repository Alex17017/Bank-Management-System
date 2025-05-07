package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balance, exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,500,700);
        add(image);
        
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(135, 270, 500, 35);
        text.setForeground(Color.orange);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(120,355,110,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(250,355,130,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(120,395,110,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        
        
        ministatement = new JButton("Ministatement");
        ministatement.setBounds(250,395,130,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(120,435,110,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(250,435,130,25);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(210,465,60,15);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(500,700);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
    } 
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if (ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource() == balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource() == ministatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
   
    public static void main(String args[]) {
       new Transactions("");
        
    }
}
