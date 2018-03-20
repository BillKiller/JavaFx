package UI;

import entity.MyCircle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
public class ToolBarUI extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();

		root.setTop(getTopBoard());
		root.setLeft(getLeftBoard());
		root.setCenter(getMainBoard());
		Scene  scene= new Scene(root,800,800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public MenuBar getTopBoard() {
		/*file Menu
		 * contain new,open,oepnRecent,sava,export,close...function
		 */
		Menu fileMenu = new Menu("File");
		MenuItem menuItem = new MenuItem("New");
		MenuItem openItem = new MenuItem("Open");
		Menu openRecenty = new Menu("Open Recent");
		MenuItem saveItem = new MenuItem("Save");
		MenuItem savaAsItem = new MenuItem("Save As");
		MenuItem exportItem = new MenuItem("Export");
		MenuItem closeItem = new MenuItem("Close");
		fileMenu.getItems().addAll( menuItem,openItem,openRecenty,saveItem,savaAsItem, exportItem ,closeItem);

		/*
		 * edit Menu
		 * contain undo,redo,cut,copy,paste,detele,select all funtcions
		 */
		Menu editMenu = new Menu("Edit");
		MenuItem undoItem = new MenuItem("Undo");
		MenuItem redoItem = new MenuItem("Redo");
		MenuItem cutItem = new MenuItem("Cut");
		MenuItem copyItem = new MenuItem("Copy");
		MenuItem pasteItem = new MenuItem("Paste");
		MenuItem deletItem = new MenuItem("Detele");
		MenuItem selectItem = new MenuItem("Select All");
		Menu insertMenu = new Menu("Insert");
		editMenu.getItems().addAll(undoItem,redoItem,cutItem,copyItem,pasteItem,deletItem,selectItem);

		/*
		 * help Menu
		 * contain quickStart,support,feedback,help,about
		 */

		Menu helpMenu= new Menu("Help");
		MenuItem quickStartItem=new MenuItem("QuickStart");
		MenuItem supportItem=new MenuItem("Support");
		MenuItem feedbackItem = new MenuItem("FeedBack");
		MenuItem helpItem = new MenuItem("Help");
		MenuItem aboutItem = new MenuItem("About");
		helpMenu.getItems().addAll(quickStartItem,supportItem,feedbackItem,helpItem,aboutItem);

		MenuBar  menuBar = new MenuBar();

		menuBar.getMenus().addAll(fileMenu,editMenu,helpMenu);
		/*
		 * set borderPane and Scene
		 */
		return menuBar;
	}

	public Pane getLeftBoard() {
		Pane pane = new Pane();
		Button btn1= new Button("Circle");
		pane.getChildren().add(btn1);
		return pane;
	}
	public Pane  getMainBoard() {
		Pane mainBoard = new Pane();
		MyCircle myCircle=new MyCircle(500,500,50);
		mainBoard.getChildren().add(myCircle.getShape());
		mainBoard.getChildren().addAll(myCircle.getEditer().getCircles());

		//		mainBoard.getChildren().add(circle);
		return mainBoard ;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
