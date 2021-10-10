package logics;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MyRectangle extends Shapes {

	public MyRectangle(Double x, Double y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	
	public MyRectangle() {
		
	}
	

	public void drawPainter(GraphicsContext context) {
		context.setFill(getColor());
		context.fillRect(getX()-30,getY()-30,60,60);

		
	}
	
	
	@Override
	public Shapes clone() {
		// TODO Auto-generated method stub
		return new MyRectangle();
	}
	


	@Override
	public void drawPainter(double x, double y, GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOnMouseClicked(EventHandler<MouseEvent> eventHandler) {
		// TODO Auto-generated method stub
		
	}


	
}
