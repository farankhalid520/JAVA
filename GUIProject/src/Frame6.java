import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frame6 implements ActionListener{
	JFrame f;
	JLabel l1;
	JTextField jt1;
	JButton b1,b2,b3;
	
	public Frame6()
	{
        f = new JFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("STUDENT FORM");
		f.setSize(400,200);
		f.setLayout(null);
		f.setLocation(400, 200);
		
		l1 =new JLabel("ENTER ID : ");
        f.add(l1);
    	l1.setSize(l1.getPreferredSize());
    	l1.setLocation(40,50);
    	l1.setForeground(Color.BLACK);
    	

    	jt1=new JTextField();
    	jt1.setColumns(10);
    	f.add(jt1);
    	jt1.setSize(jt1.getPreferredSize());
    	jt1.setLocation(150,50);
    	
    	b1 = new JButton("SEARCH");
        b1.setSize(b1.getPreferredSize());
		b1.setLocation(100,100);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton("RETURN");
        b2.setSize(b2.getPreferredSize());
		b2.setLocation(265,100);
		b2.addActionListener(this);
		f.add(b2);
		
		b3 = new JButton("DELETE");
        b3.setSize(b3.getPreferredSize());
		b3.setLocation(185,100);
		b3.addActionListener(this);
		f.add(b3);
		
		f.setVisible(true);
	}
	
	public static void main(String[]args)
	{
		new Frame6();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			String t1 = jt1.getText();
			JOptionPane.showMessageDialog(f, "ID: " + Frame5.list1.get(0) + "\nName : "+ Frame5.list1.get(1) + "\nDEPARTMENT : " +Frame5.list1.get(2) + "\nBATCH : " + Frame5.list1.get(3));
			
		}
		else if(e.getSource() == b2)
		{
			f.dispose();
			new Frame4();
		}
		else if(e.getSource() == b3)
		{
			String t1 = jt1.getText();
			Frame5.list1.clear();
		}
		else
			JOptionPane.showMessageDialog(f, "Incorrect");
		
	}

}
