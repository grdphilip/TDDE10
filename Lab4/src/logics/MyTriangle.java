package logics;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MyTriangle extends Shapes {

	public MyTriangle(Double x, Double y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	
	public MyTriangle() {
		
	}
	

	public void drawPainter(GraphicsContext context) {
		context.setFill(getColor());
		double[] xPoints = new double[3];
		
		xPoints[0] = (getX() + 30);
		xPoints[1] = (getX() + 60);
		xPoints[2] = getX();

		double[] yPoints = new double[3];
		yPoints[0] = getY();
		yPoints[1] = getY() + 60;
		yPoints[2] = getY() + 60;
		
		context.fillPolygon(xPoints, yPoints, 3);
		
	}
	
	


	@Override
	public void drawPainter(double x, double y, GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOnMouseClicked(EventHandler<MouseEvent> eventHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shapes clone() {
		// TODO Auto-generated method stub
		return new MyTriangle();
	}


	
}
