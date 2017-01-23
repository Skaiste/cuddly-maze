import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Maze extends JPanel implements MouseMotionListener {

	// maze state
	private boolean gameStarted = false;
	private int counter = 0;
	
	private JFrame frame;
	private int width, height;
	
	// components
	private ArrayList<Component> components;
	private boolean wasOnComponentPreviously = false;

	public static void main(String[] args) {
		Maze maze = new Maze(500, 500);
		
		maze.addComponent(new Start(new Point(435, 1)));
		
		maze.addComponent(new Rectangle(new Point(0, 0), 433, 33));
		maze.addComponent(new Rectangle(new Point(0, 33), 33, 467));
		maze.addComponent(new Rectangle(new Point(466, 0), 34, 500));
		maze.addComponent(new Rectangle(new Point(0, 466), 500, 34));
		
		maze.addComponent(new Rectangle(new Point(400, 33), 33, 133));
		maze.addComponent(new Rectangle(new Point(233, 33), 67, 33));
		maze.addComponent(new Rectangle(new Point(166, 33), 34, 167));
		maze.addComponent(new Rectangle(new Point(66, 66), 67, 34));
		maze.addComponent(new Rectangle(new Point(333, 66), 33, 167));
		maze.addComponent(new Rectangle(new Point(100, 100), 33, 66));
		maze.addComponent(new Rectangle(new Point(233, 100), 67, 66));
		maze.addComponent(new Rectangle(new Point(300, 100), 33, 33));
		maze.addComponent(new Rectangle(new Point(66, 133), 34, 133));
		maze.addComponent(new Rectangle(new Point(133, 200), 133, 33));
		maze.addComponent(new Rectangle(new Point(266, 200), 34, 66));
		maze.addComponent(new Rectangle(new Point(333, 200), 133, 33));
		maze.addComponent(new Rectangle(new Point(66, 266), 167, 34));
		maze.addComponent(new Rectangle(new Point(200, 300), 133, 33));
		maze.addComponent(new Rectangle(new Point(333, 266), 100, 34));
		maze.addComponent(new Rectangle(new Point(333, 300), 33, 133));
		maze.addComponent(new Rectangle(new Point(33, 333), 133, 33));
		maze.addComponent(new Rectangle(new Point(200, 333), 33, 100));
		maze.addComponent(new Rectangle(new Point(400, 333), 66, 34));
		maze.addComponent(new Rectangle(new Point(66, 400), 134, 33));
		maze.addComponent(new Rectangle(new Point(266, 366), 34, 100));
		maze.addComponent(new Rectangle(new Point(366, 400), 134, 33));
		
		maze.addComponent(new Finish(new Point(435, 435)));
	}
	
	private void createComponents() {
		this.addMouseMotionListener(this);
		components = new ArrayList<Component>();
		
	}
	public void addComponent(Component component) {
		components.add(component);
	}

	public Maze(int width, int height) {
		this.width = width;
		this.height = height;
		
		frame = new JFrame("JFrame Source Demo");
		// This is an empty content area in the frame
		JLabel jlbempty = new JLabel("");
		jlbempty.setPreferredSize(new Dimension(width, height));
		frame.getContentPane().add(jlbempty, BorderLayout.CENTER);
		frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		createComponents();
		
		frame.add(this);
		this.setBounds(0, 0, width, height);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // paint white background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        
        // paint all components
        for(Component c : components) {
        	c.draw(g);
        }
    }
	
	public void changeChapeColor(Color c) {
		Shape.color = c;
	}

	@Override
	public void mouseDragged(MouseEvent e) { }

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println(e.getPoint());
		
		// checking if mouse went over a component
		boolean isOnComponent = false;
		for (Component c : components) {
			if (c.isMouseOver(e.getPoint())){
				if (!wasOnComponentPreviously) {
					// if mouse went over the start object
					if (c instanceof Start && !gameStarted){
						System.out.println("Start");
						// set game status as started
						gameStarted = true;
						// start timer
						counter = 0;
					}
					// if mouse went over the finish object
					else if (c instanceof Finish && gameStarted){
						// set game status as finished
						gameStarted = false;
						System.out.println("Finish");
						// prompt a success message?
						JOptionPane.showMessageDialog(frame, "You won!");
					}
					// if mouse went over a shape
					else if (c instanceof Shape && gameStarted) {
						System.out.println("You lost!");
						// add to fail counter?
						counter++;
						// prompt a failure message?
						JOptionPane.showMessageDialog(frame, "Try again");
						gameStarted = false;
					}
				}
				isOnComponent = true;
			}
		}
		wasOnComponentPreviously = isOnComponent;
	}
}
