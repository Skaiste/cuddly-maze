import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame implements MouseMotionListener {

	public static void main(String[] args) {
		JFrame frame = new Frame("JFrame Source Demo");
		// This is an empty content area in the frame
		JLabel jlbempty = new JLabel("");
		jlbempty.setPreferredSize(new Dimension(175, 100));
		frame.getContentPane().add(jlbempty, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createComponents() {
		this.addMouseMotionListener(this);
	}

	public Frame() throws HeadlessException { createComponents(); }

	public Frame(GraphicsConfiguration gc) {
		super(gc);
		createComponents();
	}

	public Frame(String title) throws HeadlessException {
		super(title);
		createComponents();
	}

	public Frame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		createComponents();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getPoint());
	}


}
