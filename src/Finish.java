import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Finish extends Component {

	public Finish(Point p) {
		super(p);
		width = 30;
		height = 30;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(coordinates.x, coordinates.y, width, height);
	}

}
