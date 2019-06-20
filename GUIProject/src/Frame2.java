import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frame2 implements ActionListener {
	JFrame f;
	JLabel l1,l2;
	JTextField jt1,jt2;
	JButton b1,b2;
	
	public Frame2()
	{
		    f = new JFrame();
			
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("LOGIN ");
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
	    	
	    	b1 = new JButton("LOGIN");
	        b1.setSize(b1.getPreferredSize());
			b1.setLocation(150,150);
			b1.addActionListener(this);
			f.add(b1);
			
			b2 = new JButton("RETURN");
	        b2.setSize(b2.getPreferredSize());
			b2.setLocation(230,150);
			b2.addActionListener(this);
			f.add(b2);
	    	
	    	f.setVisible(true);
	    	
	}
	
	public static void main(String[]args)
	{
		new Frame2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			String s = "";
			String t1 = jt1.getText();
			String t2 = jt2.getText();
			String t3 = t1 +"-"+t2;
			if(!jt1.getText().isEmpty() && !jt2.getText().isEmpty())
			{
				try
				{
					final String FILENAME = "C:\\Users\\Faral\\Desktop\\GUIProject.txt";
					File file = new File(FILENAME);
					FileReader fr = new FileReader(FILENAME);
					BufferedReader br = new BufferedReader(fr);
					while((s = br.readLine()) != null)
					{
						if(s.equals(t3))
						{
							new Frame4();
						}
						else
							JOptionPane.showMessageDialog(f, "Incorrect Password");
					}
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
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
