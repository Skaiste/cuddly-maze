import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

	public Rectangle(Point coordinates, int width, int height) {
		super(coordinates, width, height);
	}
	
	public void draw(Graphics g) {
		g.fillRect(coordinates.x, coordinates.y, width, height);
	}
}
