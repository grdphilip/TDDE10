package logics;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MyEraser extends Shapes {

	public MyEraser(Double x, Double y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	
	public MyEraser() {
		
	}
	

	public void drawPainter(GraphicsContext context) {
		context.setFill(Color.WHITE);
		context.fillRect(0,0,800,800);

		
	}
	
	
	@Override
	public Shapes clone() {
		// TODO Auto-generated method stub
		return new MyEraser();
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
