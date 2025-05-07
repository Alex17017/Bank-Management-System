package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
  
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("V-Scammer Bank");
        bank.setFont(new Font("System", Font.BOLD, 18));
        bank.setBounds(130,40,160,30);
        add(bank);  
        
        JLabel card = new JLabel();
        card.setFont(new Font("System", Font.BOLD, 15));
        card.setBounds(40,100,300,30);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setFont(new Font("System", Font.BOLD, 15));
        balance.setBounds(40,460,400,30);
        add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4) + "xxxxxxxx" + rs.getString("cardnumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
           if(rs.getString("type").equals("Deposit")){
                       bal += Integer.parseInt(rs.getString("amount"));
                   }else{
                       bal -= Integer.parseInt(rs.getString("amount")); 
                   }
            }
            balance.setText("Your current account balance is Rs"+ bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
         mini.setBounds(40,180,400,300);
        
         
        setSize(400,600);
        setLocation(300,0);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#669ece"));
        setVisible(true);
        
        
    }

   
    
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
