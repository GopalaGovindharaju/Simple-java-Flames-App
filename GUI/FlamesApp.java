import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;

class Gui implements ActionListener
{
	JFrame j;
	JButton b;
	JTextField t1, t2;
	JLabel l1, l2, l3;
	Image img, img1, im, im1, imgs, imgs1;
	ImageIcon i1, i2, i3;
	Gui()
	{
		j=new JFrame("Flames Calculator");
		t1=new JTextField();
		t2=new JTextField();
		i1=new ImageIcon("h1.png");
		i2=new ImageIcon("boy.png");
		i3=new ImageIcon("girl.jpg");
		l1=new JLabel("nell");
		img=i1.getImage();
		img1=img.getScaledInstance(80,30,java.awt.Image.SCALE_SMOOTH);
		i1=new ImageIcon(img1);
		im=i2.getImage();
		im1=im.getScaledInstance(200,190,java.awt.Image.SCALE_SMOOTH);
		i2=new ImageIcon(im1);
		imgs=i3.getImage();
		imgs1=imgs.getScaledInstance(200,190,java.awt.Image.SCALE_SMOOTH);
		i3=new ImageIcon(imgs1);
		l2=new JLabel(i2);
		l3=new JLabel(i3);
		b=new JButton(i1);
		b.setBounds(200,230,80,30);
		t1.setBounds(20,200,200,25);
		t2.setBounds(250,200,200,25);
		l1.setBounds(200,270,80,30);
		l2.setBounds(10,10,200,190);
		l3.setBounds(250,10,200,190);
		j.add(t1);
		j.add(t2);
		j.add(b);
		j.add(l1);
		j.add(l2);
		j.add(l3);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		b.addActionListener(this);
		
		
		j.setSize(500,350);
		//j.getContentPane().setBackground(Color.BLUE);
		j.setLayout(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String name1 = t1.getText();
        String name2 = t2.getText();
		if(e.getSource()==b)
		{
			name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();
 
        StringBuilder sb1 = new StringBuilder(name1);// converting to string builder
        StringBuilder sb2 = new StringBuilder(name2);
       
        int m=sb1.length();
        int n=sb2.length();
        for(int i=0; i<m;i++)
        {
            for(int j=0; j<n;j++)
            {
                if(sb1.charAt(i) == sb2.charAt(j))
                {
                    sb1.replace(i, i+1, "0"); // replacing matching characters into "0"
                    sb2.replace(j,j+1,"0");
                }
            }
        }


        int x1=0;
        int y1=0;
        String s1="";
        String s2="";
        s1 = sb1.toString();
        s2 = sb2.toString();
            for(int i=0;i<s1.length();i++){ //length of string to remove 0 and find the length
                if(s1.charAt(i)!='0'){
                    //System.out.print(" "+s1.charAt(i));
                    x1 +=1;
                    
                 }
            }
            //System.out.println();
            //System.out.println("First String: "+x1);
    
            for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)!='0'){
                //System.out.print(" "+s2.charAt(i));
                y1 +=1;
                
                }
            } 
            //System.out.println();
            //System.out.println("Second String: "+y1);
       
        
        int x = x1+y1; // total length of remaining characters in both the strings
        //System.out.println("Length is: "+x);

  
     
        String flames = "flames";
        StringBuilder sb3 = new StringBuilder(flames);
        
        char flameResult = 0;
        
        while(sb3.length()!=1)
        {
            int y = x%sb3.length(); 
            String temp;
            
            if(y!=0)
            {
                temp = sb3.substring(y)+sb3.substring(0, y-1); // taking substring (counting purpose)
                
            }
            else
            {
                temp = sb3.substring(0, sb3.length()-1); // taking substring (counting purpose)
                
            }
            sb3 = new StringBuilder(temp);
            flameResult = sb3.charAt(0);
            
        }
        //System.out.println(flameResult);


        switch(flameResult)
        {
            case 'f':
               l1.setText("Friends");
                break;
            case 'l':
                l1.setText("Love");
                break;
            case 'a':
                l1.setText("Affection");
                break;
            case 'm':
                l1.setText("Marriage");
                break;
            case 'e':
                l1.setText("Enemies");
                break;
            case 's':
                l1.setText("Sibling");
                break;
                
        }
		}
	}
	
}

public class FlamesApp
{
	public static void main(String args[])
	{
		Gui g=new Gui();
	}
}