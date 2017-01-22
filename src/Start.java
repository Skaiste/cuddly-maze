import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Start extends Component {

	public Start(Point p) {
		super(p);
		width = 10;
		height = 10;
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(coordinates.x, coordinates.y, width, height);
	}
	
}
