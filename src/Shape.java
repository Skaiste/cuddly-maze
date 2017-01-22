import java.awt.Color;
import java.awt.Point;

public class Shape extends Component {
	
	public static Color color = Color.BLACK;

	public Shape(Point coordinates, int width, int height) {
		super(coordinates);
		this.width = width;
		this.height = height;
	}
}
