import java.awt.Graphics;
import java.awt.Point;

public class Component {
	protected Point coordinates;
	protected int width, height;
	
	public Component(Point p) {
		coordinates = p;
	}
	
	public boolean isMouseOver(Point p){
		boolean isOver = false;
		
		if ((p.x > coordinates.x) && (p.x < coordinates.x + width) &&
			(p.y > coordinates.y) && (p.y < coordinates.y + height))
			isOver = true;
		
		return isOver;
	}
	
	public void draw(Graphics g) {}

}
