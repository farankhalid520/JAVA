import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame4 implements ActionListener  {
	JFrame f;
	JButton b1,b2,b3,b4;
	
	public Frame4()
	{
		f = new JFrame();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("ADD/DELETE/SEARCH");
		f.setSize(400,400);
		f.setLayout(null);
		f.setLocation(400, 200);
		
		b1 = new JButton("ADD");
        b1.setSize(b1.getPreferredSize());
		b1.setLocation(150,170);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton("DELETE");
        b2.setSize(b2.getPreferredSize());
		b2.setLocation(150,200);
		b2.addActionListener(this);
		f.add(b2);
		
		b3 = new JButton("SEARCH");
        b3.setSize(b3.getPreferredSize());
		b3.setLocation(150,230);
		b3.addActionListener(this);
		f.add(b3);
		
		b4 = new JButton("RETURN");
        b4.setSize(b4.getPreferredSize());
		b4.setLocation(150,260);
		b4.addActionListener(this);
		f.add(b4);
		
		f.setVisible(true);
	}
	
	public static void main(String[]args)
	{
		new Frame4();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			new Frame5();
		}
		else if(e.getSource() == b2)
		{
			new Frame6();
		
		}
		else if(e.getSource() == b3)
		{
			new Frame6();
		}
		else if(e.getSource() == b4)
		{
			f.dispose();
			new Frame2();
		}
		else
			JOptionPane.showMessageDialog(f, "Incorrect");
		
	}

}
