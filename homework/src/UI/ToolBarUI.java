package UI;

import entity.MyCircle;
import entity.MyRectangle;
import entity.RoundRectangle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class ToolBarUI extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		root.setCenter(getMainBoard());
		root.setLeft(getLeftBoard());
        root.setTop(getTopBoard());
		Scene  scene= new Scene(root,800,600);
		Application.setUserAgentStylesheet(null);
		//s//cene.getStylesheets().add(getClass().getResource("UI/view.css").toExternalForm());
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
		Pane pane = new Pane();
		pane.getChildren().add(menuBar);
		return menuBar;
	}

	public BorderPane getLeftBoard() {
		BorderPane pane = new BorderPane();
		pane.setPrefSize(300,300);
		pane.setMaxWidth(300);;
        pane.setBackground(new Background(new BackgroundFill(Color.rgb(255,20,0),null,null)));
        pane.setCenter(getVBox());
        ScrollBar sb = new ScrollBar(); 
        sb.setLayoutX(100);
        sb.setMin(100);
        sb.setOrientation(Orientation.VERTICAL); 
        sb.setPrefHeight(180);  
        sb.setMax(360);  
  
        sb.setUnitIncrement(10.0);  
        sb.setBlockIncrement(5.0); 
		return pane;
	}

	public VBox getVBox(){
		VBox vBox = new VBox(20);
		vBox.setPadding(new Insets(20,10,10,10));
		Image imagePrepare = new Image("image/prepare.png");
		Image imageConnector =new Image("image/connector.png");
		Image imageData =new Image("image/data.png");
		Image imageDecision = new Image("image/decision.png");
		Image imageDocument =new Image("image/document.png");
		Image imageStart = new Image("image/start.png");
		Image imagePath = new Image("image/path.png");
		Image imagePredefined = new Image("image/predefined.png");
		Image imageProcess = new Image("image/process.png");
		Button btnStart =new Button();
		Button btnPrepare = new Button();
		Button btnConnector = new Button();
		Button btnData = new Button();
		Button btnDecision =new Button();
		Button btnDocument = new Button();
		Button btnPath =new Button();
		Button btnPredefined = new Button();
		Button btnProcess = new Button();
		btnStart.setGraphic(new ImageView(imageStart));
		btnPrepare.setGraphic(new ImageView(imagePrepare));
		btnConnector.setGraphic(new ImageView(imageConnector));
		btnData.setGraphic(new ImageView(imageData));
		btnDecision.setGraphic(new ImageView(imageDecision));
		btnDocument.setGraphic(new ImageView(imageDocument));
		btnPath.setGraphic(new ImageView(imagePath));
		btnPredefined.setGraphic(new ImageView(imagePredefined));
		btnProcess.setGraphic(new ImageView(imageProcess));
		vBox.getChildren().add(btnStart);
		vBox.getChildren().add(btnData);
		vBox.getChildren().add(btnProcess);
		vBox.getChildren().add(btnDecision);
		vBox.getChildren().add(btnPath);
		return vBox;
	}
	public Pane  getMainBoard() {
		Pane pane = new Pane();
		MyCircle myCircle = new MyCircle();
		MyRectangle myRectangle=new MyRectangle(500,500,100,200);
		myRectangle.getPane(pane);
		myCircle.getPane(pane);
		RoundRectangle roundRectangle=new RoundRectangle(300,300,100,100);
		roundRectangle.getPane(pane);
		pane.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0),null,null)));
		return pane;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
