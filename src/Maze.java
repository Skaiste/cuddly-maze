import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Maze extends JPanel implements MouseMotionListener {

	private ArrayList<Component> components;
	private boolean wasOnComponentPreviously = false;

	public static void main(String[] args) { 
		JFrame frame = new JFrame("JFrame Source Demo");
		// This is an empty content area in the frame
		JLabel jlbempty = new JLabel("");
		jlbempty.setPreferredSize(new Dimension(500, 500));
		frame.getContentPane().add(jlbempty, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
		Maze maze = new Maze();
		frame.add(maze);
		
		maze.addComponent(new Rectangle(new Point(), 200, 300));
	}
	
	private void createComponents() {
		this.addMouseMotionListener(this);
		components = new ArrayList<Component>();
		
	}
	public void addComponent(Component component) {
		components.add(component);
	}

	public Maze() throws HeadlessException { createComponents(); }
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // paint white background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
        
        // paint all components
        g.setColor(Color.BLACK);
        for(Component c : components) {
        	c.draw(g);
        }
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
					if (c instanceof Start){
						// start timer
					}
					// if mouse went over the finish object
					else if (c instanceof Finish){
						// prompt a success message?
					}
					// if mouse went over a shape
					else if (c instanceof Shape) {
						System.out.println("you lost!");
						// add to fail counter?
						// prompt a failure message?
					}
				}
				isOnComponent = true;
			}
		}
		wasOnComponentPreviously = isOnComponent;
	}


}
