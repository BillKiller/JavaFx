package entity;

import javafx.scene.Cursor;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class MyShape{
	private double x;
	private double y;
	private double width;
	private double height;
	private Status status;
	private boolean isDrag;
	private boolean isZoom;
	private Shape shape;
	private Editer editer;
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
		addListener();
		startEditerListener();
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


//-----------constructor------------------------
	public MyShape(double x,double y,double height,double width){
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
// ---listener--
	public void addListener(){
			setOnDrag();
			setOnRealse();
	}
	public void setOnDrag(){
		shape.setOnMouseDragged(e->{
				status.setDrag();
				status.move(e.getX(),e.getY());
				System.out.println("test");
				Move(e.getX(),e.getY());
				editer.disapper();
		});
	}

	public void setOnRealse(){
		shape.setOnMouseClicked(e->{
			status.setRelease();
			e.
			System.out.println("asd");
			this.editer.show(x,y);
		});
	}

	public void Move(double x,double y){
			this.x=x;
			this.y=y;
	}

	///--------listener
	private void  startEditerListener() {
		Circle []circles=editer.getCircles();
		Cursor []hand={Cursor.NW_RESIZE,Cursor.W_RESIZE,Cursor.NE_RESIZE,Cursor.N_RESIZE,Cursor.MOVE,Cursor.S_RESIZE,Cursor.SW_RESIZE,Cursor.E_RESIZE,Cursor.SE_RESIZE};
		for(int i =0;i<circles.length;i++){
			circles[i].setCursor(hand[i]);
		}
	}


}
