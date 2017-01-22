import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Shape {

	private int radius;
	
	public Circle(Point center, int radius) {
		super(center, radius*2, radius*2);
		this.radius = radius;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(coordinates.x - radius, coordinates.y - radius, width, height);
	}
	
	public boolean isMouseOver(Point p){
		boolean isOver = false;
		
		Point d = new Point(Math.abs(p.x - coordinates.x), Math.abs(p.y - coordinates.y));

		if (d.x*d.x + d.y*d.y <= radius*radius)
			isOver = true;
		
		return isOver;
	}
}
