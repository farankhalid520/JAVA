import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frame5 implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4;
	JTextField jt1,jt2,jt3,jt4;
	JButton b1,b2;
	public static ArrayList<String> list1 = new ArrayList<String>();
	
	public Frame5()
	{
        f = new JFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("STUDENT FORM");
		f.setSize(400,400);
		f.setLayout(null);
		f.setLocation(400, 200);
		
		l1 =new JLabel("ID : ");
        f.add(l1);
    	l1.setSize(l1.getPreferredSize());
    	l1.setLocation(40,50);
    	l1.setForeground(Color.BLACK);
    	

    	jt1=new JTextField();
    	jt1.setColumns(10);
    	f.add(jt1);
    	jt1.setSize(jt1.getPreferredSize());
    	jt1.setLocation(150,50);
    	
    	l2 = new JLabel("Name : ");
		f.add(l2);
		l2.setSize(l2.getPreferredSize());
		l2.setLocation(40,100);
		l2.setForeground(Color.BLACK);
		
		jt2=new JTextField();
    	jt2.setColumns(10);
    	f.add(jt2);
    	jt2.setSize(jt2.getPreferredSize());
    	jt2.setLocation(150,100);
    	
    	l3 =new JLabel("DEPARTMENT : ");
        f.add(l3);
    	l3.setSize(l3.getPreferredSize());
    	l3.setLocation(40,150);
    	l3.setForeground(Color.BLACK);
    	

    	jt3=new JTextField();
    	jt3.setColumns(10);
    	f.add(jt3);
    	jt3.setSize(jt3.getPreferredSize());
    	jt3.setLocation(150,150);
    	
    	l4 = new JLabel("BATCH : ");
		f.add(l4);
		l4.setSize(l4.getPreferredSize());
		l4.setLocation(40,200);
		l4.setForeground(Color.BLACK);
		
		jt4=new JTextField();
    	jt4.setColumns(10);
    	f.add(jt4);
    	jt4.setSize(jt4.getPreferredSize());
    	jt4.setLocation(150,200);
    	
    	b1 = new JButton("ADD");
        b1.setSize(b1.getPreferredSize());
		b1.setLocation(130,230);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton("RETURN");
        b2.setSize(b2.getPreferredSize());
		b2.setLocation(130,280);
		b2.addActionListener(this);
		f.add(b2);
    	
    	f.setVisible(true);
	}
	
	public static void main(String[]args)
	{
		new Frame5();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			String t1 = jt1.getText();
			String t2 = jt2.getText();
			String t3 = jt3.getText();
			String t4 = jt4.getText();
			
			list1.add(t1);
			list1.add(t2);
			list1.add(t3);
			list1.add(t4);
		}
		else if(e.getSource() == b2)
		{
			f.dispose();
			new Frame4();
		}
		else
			JOptionPane.showMessageDialog(f, "Incorrect");
		
	}

}
