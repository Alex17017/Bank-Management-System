package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 500, 700);
        add(image);
        
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.orange);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(175, 260, 500, 35);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.orange);
        pintext.setFont(new Font("System", Font.BOLD, 14));
        pintext.setBounds(120,355,110,25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 15));
        pin.setBounds(275,350,100,30);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.orange);
        repintext.setFont(new Font("System", Font.BOLD, 14));
        repintext.setBounds(120,395,160,25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 15));
        repin.setBounds(275,395,100,30);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(270,445,90,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(140,445,90,25);
        back.addActionListener(this);
        image.add(back);
            
        setSize(500,700);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change){ 
            try{
                 String npin = pin.getText();
                 String rpin = repin.getText();
            
                 if (!npin.equals(rpin)){
                 JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                 return;
                }
                
                if (npin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Enter New PIN ");
                 return;
                } 
                
                if(rpin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN ");
                 return;
                }
                 
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
                
        } catch (Exception e){
            System.out.println(e);
        }
        
    }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}