package graphics;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import logics.Model;
import logics.Shapes;
import logics.MyCircle;
import logics.MyRectangle;


public class DrawArea extends Canvas {

	
	private Model model;
	
	
	public DrawArea(Model model) {
		this.setStyle("-fx-background-color: #000000;");
		this.setWidth(800);
		this.setHeight(800);
		this.model = model;

	}


	public void drawPainter(Model model) {
		
		GraphicsContext context = this.getGraphicsContext2D();
		context.setFill(Color.WHITE);
		context.fillRect(0,0,800,800);
		
			 setOnMouseClicked(event -> {
				 //model.draw(event.getX(),event.getY(),context)
				 model.add(event.getX(), event.getY());
				 model.draw(event.getX(), event.getY(), context);
 
			 });
			
			 		
		}

}
