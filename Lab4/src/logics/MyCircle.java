package logics;



import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MyCircle extends Shapes {

	public MyCircle(Double x, Double y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	
	public MyCircle() {
		
	}
	
	public void setID() {
		
	}
	
	public void drawPainter(GraphicsContext context) {
		context.setFill(getColor());
		context.fillOval(getX()-30,getY()-30,60,60);
		

	}

	@Override
	public void setOnMouseClicked(EventHandler<MouseEvent> eventHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shapes clone() {
		// TODO Auto-generated method stub
		return new MyCircle();
	}

	@Override
	public void drawPainter(double x, double y, GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	
}

