package UI;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainMenu extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// this class is used for testing
		Pane pane = new Pane();
		Circle circle = new Circle(30);
		Circle circle2 = new Circle(30);
		pane.setOnMouseClicked(e->{
			System.out.println("screen"+e.getScreenX()+" "+e.getScreenY());
			System.out.println("scene"+e.getSceneX()+" + "+e.getSceneY());
			System.out.println("x"+e.getX()+" + "+e.getY());
		});
		circle.setOnMouseClicked(e->{

			System.out.println();
		});
		circle.setOnMouseDragged(e->{
			System.out.println("bscreen"+e.getScreenX()+" "+e.getScreenY());
			System.out.println("bscene"+e.getSceneX()+" + "+e.getSceneY());
			System.out.println("bx"+e.getX()+" + "+e.getY());
		});
		circle.setLayoutX(30);
		circle.setLayoutY(30);
		circle2.setLayoutX(0);
		circle2.setLayoutY(0);
		pane.getChildren().addAll(circle,circle2);
		Scene scene = new Scene(pane,800,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String []args){
		launch(args);
	}
}
