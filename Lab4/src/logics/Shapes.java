package logics;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class Shapes {
	
	private Double x;
	private Double y;
	private Color color;
	
	public Shapes(Double x, Double y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
		
	}
	
	public Shapes() {
		
	}
	
	public abstract Shapes clone();
	
	public Double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	
	}
	
	
	
	public abstract void drawPainter(double x, double y, GraphicsContext context);

	public abstract void setOnMouseClicked(EventHandler<MouseEvent> eventHandler);

	protected abstract void drawPainter(GraphicsContext context);

		
	}

	


