package runner;
import graphics.*;



import javafx.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logics.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;



public class Canvas extends Application {

	
	private Model model = new Model();
	
	public void start(Stage primaryStage) throws Exception {
		
		try {
	
		primaryStage.setTitle("My lovely paint (HD) :)");
		primaryStage.setWidth(1000);
		primaryStage.setHeight(1000);
		
		HBox mainLayout = new HBox();
		HorizontalPanel menu = new HorizontalPanel(model);
		Scene scene = new Scene(mainLayout); 
		DrawArea drawarea = new DrawArea(model);
		
		
		mainLayout.getChildren().add(menu);
		mainLayout.getChildren().add(drawarea);
		drawarea.drawPainter(model);
		
		
		primaryStage.setScene(scene);
    	primaryStage.show();
	
		} catch (Exception e) {
    		e.printStackTrace(); 
    		System.out.println("Underlying" + e.getCause());
	
		}
	}
	
		
	public static void main(String[] args) {
		launch(args);
		
		

	}



	public Model getModel() {
		return model;
	}



	public void setModel(Model model) {
		this.model = model;
	}
	
	

}
