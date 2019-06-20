import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame1 implements ActionListener {
	JFrame f;
	JButton b1,b2;
	
	public Frame1()
	{
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("FRAME 1");
		f.setLayout(null);
		f.setSize(400,400);
		f.setLocation(400, 200);
		
		b1 = new JButton("LOGIN");
        b1.setSize(b1.getPreferredSize());
		b1.setLocation(150,100);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 = new JButton("CREATE LOGIN");
        b2.setSize(b2.getPreferredSize());
		b2.setLocation(125,150);
		b2.addActionListener(this);
		f.add(b2);
		
		f.setVisible(true);
	}
	
	public static void main(String[]args)
	{
		new Frame1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			f.setVisible(false);
			new Frame2();
		}
		else if(e.getSource() == b2)
		{
			f.setVisible(false);
			new Frame3();
		}
		else
			JOptionPane.showMessageDialog(f, "Incorrect");
		}

}
