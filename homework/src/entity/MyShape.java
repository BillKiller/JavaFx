package entity;

import javafx.scene.Cursor;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class MyShape{
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	private Status status;
	private boolean isDrag;
	private boolean isZoom;
	private Shape shape;
	private Editer editer;
	private double sceneX;
	private double sceneY;
	private Pane pane;
//--getter and setter
	public Shape getShape(){
		return this.shape;
	}
	public Status getStatus(){
		return status;
	}
	public void  setMyShape(Shape shape){
		this.shape=shape;
		this.status=new Status();
		this.editer=new Editer(x,y,height,width);
		pane=new Pane();
		pane.getChildren().add(editer.getPane());
		pane.getChildren().add(shape);
		addListener();

	}
	public Editer getEditer() {
		return editer;
	}
	public void setEditer(Editer editer) {
		this.editer = editer;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Pane getPane(){return  pane; }


//-----------constructor------------------------
	public MyShape(double x,double y,double height,double width){
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
/* ---listener
		--editer listener
		--cursor listener
		--resize listener
		--move   listener

*/
public void addListener(){
			setOnDrag();
			setOnRealse();
			resizeEditerListener();
			moveHandListener();
	}
	public void setOnDrag(){
		shape.setOnMouseDragged(e->{
				Move(e.getSceneX(),e.getSceneY());
				System.out.println("testX:"+e.getX()+"thisY"+e.getY());
				System.out.println("this,x"+getX()+"this,.y"+getY());
				getEditer().show(this.x,this.y);
		});
	}

	public void setOnRealse(){
		shape.setOnMouseClicked(e->{
			status.setRelease();
			this.editer.show(x,y);
		});
	}

	public void Move(double x,double y){
			this.x=x-this.getShape().getParent().getParent().getLayoutX();
			this.y=y-this.getShape().getParent().getParent().getLayoutY();

	}

	///Cursor listener
	/*
	* 	for shape cursor will be changed to moveHand
	*   for mouse on editer(which is nine small circle) will be changed to RESIZEhand
	*
	* */
	private void  resizeEditerListener() {
		Circle []circles=editer.getCircles();
		Cursor []hand={Cursor.NW_RESIZE,Cursor.W_RESIZE,Cursor.SW_RESIZE,Cursor.N_RESIZE,Cursor.MOVE,Cursor.S_RESIZE,Cursor.NE_RESIZE,Cursor.E_RESIZE,Cursor.SE_RESIZE};
		for(int i =0;i<circles.length;i++){
			circles[i].setCursor(hand[i]);
		}
	}
	private void moveHandListener(){
		getShape().setCursor(Cursor.MOVE);
	}
	//Resize listener
	private void resize(){

	}
}
