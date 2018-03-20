package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenu extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new  BorderPane();
		Button btn =new Button("hello world");
		pane.setOnMouseClicked(e->{
			System.out.println("screen"+e.getScreenX()+" "+e.getScreenY());
			System.out.println("scene"+e.getSceneX()+" + "+e.getSceneY());
			System.out.println("x"+e.getX()+" + "+e.getY());
		});
		btn.setOnMouseClicked(e->{
			System.out.println("bscreen"+e.getScreenX()+" "+e.getScreenY());
			System.out.println("bscene"+e.getSceneX()+" + "+e.getSceneY());
			System.out.println("bx"+e.getX()+" + "+e.getY());
		});
		pane.setCenter(btn);
		Scene scene = new Scene(pane,800,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String []args){
		launch(args);
	}
}
