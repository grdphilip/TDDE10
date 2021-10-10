package logics;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Model {
	
	private Shapes currentShape = null;
	private Color currentColor = null;
	private ArrayList<Shapes> shapes = new ArrayList<Shapes>();
	
	public ArrayList<Shapes> getShapes() {
		return shapes;
		}

	 public void setShapes(ArrayList<Shapes> shapes) {
		this.shapes = shapes;
		}
	 
	 
	
	 public void add(double x, double y) {
		 // skapar en temporär shape
		 
		 //Shapes tempShape = currentShape.clone();
		
		 
		 
		 
		 if (getCurrentShape() instanceof MyRectangle) {
			 //currentShape = new myRectangle();
			 currentShape.setX(x);
			 currentShape.setY(y);
			
			 this.shapes.add(new MyRectangle(x,y,this.currentColor));
		 }
		 
		 if (getCurrentShape() instanceof MyCircle) {
			 currentShape.setX(x);
			 currentShape.setY(y);
			 this.shapes.add(new MyCircle(x,y,this.currentColor));
			 
		 }
		 
		 if (getCurrentShape() instanceof MyEraser) {
			 currentShape.setX(x);
			 currentShape.setY(y);
			 this.shapes.add(new MyEraser(x,y,this.currentColor));
			 
		 }
		 
		 if (getCurrentShape() instanceof MyTriangle) {
			 currentShape.setX(x);
			 currentShape.setY(y);
			 this.shapes.add(new MyTriangle(x-30,y-30,this.currentColor));
			 
		 }
		 	 
	 }
	 

	public Shapes getCurrentShape() {
		return currentShape;
	}

	public void setCurrentShape(Shapes currentShape) {
		this.currentShape = currentShape;
		
	}

	public void draw(double x, double y, GraphicsContext context) {
		
		 
		 for (Shapes currentShape: this.getShapes()) {
			 currentShape.drawPainter(context);
			 
		 }
		 
		 }
	

	
	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}
}

	

	




		 
	 

	//public void draw(double x, double y, GraphicsContext context) {
		// TODO Auto-generated method stub
		

	


