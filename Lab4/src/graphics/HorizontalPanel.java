package graphics;


import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logics.Model;
import logics.MyEraser;
import logics.MyTriangle;
import logics.MyCircle;
import logics.MyColor;
import logics.MyRectangle;

public class HorizontalPanel extends HBox {

	
	
	public HorizontalPanel(Model model) {
		
		this.setHeight(400);
		this.setWidth(1000);
		this.setStyle("-fx-background-color: #d4d6d5;");
		//setStyle(Color.AQUA);
		
		   // Vi initerar knapparna. Mer under Knappar / Buttons om hur de fungerar.

		VBox vbox = new VBox();
		Button circleButton = new Button("Circle");
		Button rectangleButton = new Button("Rectangle");
		Button eraseButton = new Button("Eraser");
		Button triangleButton = new Button("Triangle");
		Button blackButton = new Button("Selected");
		Button redButton = new Button("Selected");
		Button greenButton = new Button("Selected");
		Button yellowButton = new Button("Selected");
		Button blueButton = new Button("Selected");
		Button whiteButton = new Button("Selected");
		Button orangeButton = new Button("Selected");
		Button goldButton = new Button("Selected");
		Button colorButton = new Button("Current");

		
		vbox.getChildren().add(colorButton);
		vbox.getChildren().add(triangleButton);
		vbox.getChildren().add(rectangleButton);
		vbox.getChildren().add(circleButton);
		vbox.getChildren().add(blackButton);
		vbox.getChildren().add(redButton);
		vbox.getChildren().add(greenButton);
		vbox.getChildren().add(yellowButton);
		vbox.getChildren().add(blueButton);
		vbox.getChildren().add(whiteButton);
		vbox.getChildren().add(orangeButton);
		vbox.getChildren().add(goldButton);
		vbox.getChildren().add(eraseButton);

		
		colorButton.setMaxSize(80, 50);
		colorButton.setMinSize(80, 50);
		rectangleButton.setMaxSize(80, 50);
		circleButton.setMaxSize(80, 50);
		rectangleButton.setMinSize(80, 50);
		circleButton.setMinSize(80, 50);
		eraseButton.setMaxSize(80, 50);
		eraseButton.setMinSize(80, 50);
		triangleButton.setMaxSize(80, 50);
		triangleButton.setMinSize(80, 50);
		redButton.setMaxSize(80, 50);
		redButton.setMinSize(80, 50);
		blackButton.setMaxSize(80, 50);
		blackButton.setMinSize(80, 50);
		greenButton.setMinSize(80, 50);
		greenButton.setMaxSize(80, 50);
		yellowButton.setMinSize(80, 50);
		yellowButton.setMaxSize(80, 50);
		blueButton.setMinSize(80, 50);
		blueButton.setMaxSize(80, 50);
		whiteButton.setMinSize(80, 50);
		whiteButton.setMaxSize(80, 50);
		orangeButton.setMinSize(80, 50);
		orangeButton.setMaxSize(80, 50);
		goldButton.setMinSize(80, 50);
		goldButton.setMaxSize(80, 50);
		
		blueButton.setStyle("-fx-background-color: #0000FF;");
		yellowButton.setStyle("-fx-background-color: #FFFF00;");
		redButton.setStyle("-fx-background-color: #FF0000;");
		blackButton.setStyle("-fx-background-color: #000000;");
		greenButton.setStyle("-fx-background-color: #008000;");
		whiteButton.setStyle("-fx-background-color: #FFFFFF;");
		orangeButton.setStyle("-fx-background-color: #FFA500;");
		goldButton.setStyle("-fx-background-color: #FFD700;");
		
     
	
	 circleButton.setOnAction(actionEvent ->  {
    	 model.setCurrentShape(new MyCircle());
    	 
    	});
     
     rectangleButton.setOnAction(actionEvent ->  {
    	 model.setCurrentShape(new MyRectangle());
   	 
    	});
     
     eraseButton.setOnAction(actionEvent ->  {
    	 System.out.println("Click screen to start over");
    	 model.setCurrentShape(new MyEraser());
   	 
    	});
     

     triangleButton.setOnAction(actionEvent ->  {
    	 model.setCurrentShape(new MyTriangle());
   	 
    	});
     
     blackButton.setOnAction(actionEvent ->  {
    	model.setCurrentColor(Color.BLACK);
    	
    	
    	});
     
     blueButton.setOnAction(actionEvent ->  {
    	model.setCurrentColor(Color.BLUE);
    	colorButton.setStyle("-fx-background-color: blue;");
    	});
     
     greenButton.setOnAction(actionEvent ->  {
    	 model.setCurrentColor(Color.GREENYELLOW);
    	 colorButton.setStyle("-fx-background-color: green;");
   	 
    	});
     
     yellowButton.setOnAction(actionEvent ->  {
    	 model.setCurrentColor(Color.YELLOW);
   	 
    	});
     
     redButton.setOnAction(actionEvent ->  {
    	 model.setCurrentColor(Color.RED);
   	 
    	});
     
     colorButton.setTextFill(Color.ANTIQUEWHITE);
     
   
     getChildren().addAll(vbox);
     
	}



}
