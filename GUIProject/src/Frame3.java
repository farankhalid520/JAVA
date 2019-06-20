import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Scanner;

public class Frame3 implements ActionListener {
	JFrame f;
	JLabel l1,l2;
	JTextField jt1,jt2;
	JButton b1,b2;
	Scanner inp = new Scanner(System.in);
	
	public Frame3()
	{
		    f = new JFrame();
			
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle(" CREATE LOGIN ");
			f.setSize(600,400);
			f.setLayout(null);
			f.setLocation(400, 200);
			
			l1 =new JLabel("Username : ");
	    	l1.setSize(l1.getPreferredSize());
	    	l1.setLocation(40,50);
	    	l1.setForeground(Color.BLACK);
	    	f.add(l1);
	    	
	    	jt1=new JTextField();
	    	jt1.setColumns(10);
	    	jt1.setSize(jt1.getPreferredSize());
	    	jt1.setLocation(150,50);
	    	f.add(jt1);
	    	
	    	l2 = new JLabel("Password : ");
			l2.setSize(l2.getPreferredSize());
			l2.setLocation(40,100);
			l2.setForeground(Color.BLACK);
			f.add(l2);
			
			jt2=new JTextField();
	    	jt2.setColumns(10);
	    	jt2.setSize(jt2.getPreferredSize());
	    	jt2.setLocation(150,100);
	    	f.add(jt2);
	    	
	    	b1 = new JButton("CREATE");
	        b1.setSize(b1.getPreferredSize());
			b1.setLocation(150,170);
			b1.addActionListener(this);
			f.add(b1);
			
			b2 = new JButton("RETURN");
	        b2.setSize(b2.getPreferredSize());
			b2.setLocation(230,170);
			b2.addActionListener(this);
			f.add(b2);
	    	
	    	f.setVisible(true);
	    	
	}
	
	public static void main(String[]args)
	{
		new Frame3();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			final String FILENAME = "C:\\Users\\Faral\\Desktop\\GUIProject.txt";
			String username = jt1.getText();
			String password = jt2.getText();
			FileWriter fw = null;
			BufferedWriter out = null;
			
			try
			{
				File file = new File(FILENAME);
				fw = new FileWriter(file.getAbsoluteFile(), false);// deletes previous data in file//
				out = new BufferedWriter(fw);
				out.write(username+"-"+password);
				out.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
		else if(e.getSource() == b2)
		{
			f.dispose();
			new Frame2();
		}
		else
			JOptionPane.showMessageDialog(f, "Incorrect");
			
		
	}

}
