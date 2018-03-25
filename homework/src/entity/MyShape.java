package entity;

import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public abstract class  MyShape{
	protected double x;
	protected double y;
	protected double leftX;
	protected double leftY;
	protected double width;
	protected double height;
	private Status status;
	private boolean isDrag=false;
	private boolean isZoom=false;
	private boolean isSelected=false;
	private Shape shape;
	private Editer editer;
	private double sceneX;
	private double sceneY;
	private Group pane;
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
		pane=new Group();
		pane.setCursor(Cursor.CLOSED_HAND);
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
	public double getLeftX() {
		return leftX;
	}
	public void setLeftX(double leftX) {
		this.leftX = leftX;
	}
	public double getLeftY() {
		return leftY;
	}
	public void setLeftY(double leftY) {
		this.leftY = leftY;
	}
	//-----------constructor------------------------
	public MyShape(double x,double y,double width,double height){
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}

	public MyShape getPane(Pane pane){
		editer.addEditer(pane);
	    pane.getChildren().add(shape);
        return this;
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
			resizeCursorListener();
			resizeListener();
			moveHandListener();
	}
	public void setOnDrag(){
		shape.setOnMouseDragged(e->{
				Move(e.getSceneX(),e.getSceneY());
				//System.out.println("testX:"+e.getX()+"thisY"+e.getY());
				//System.out.println("this,x"+getX()+"this,.y"+getY());
				getEditer().show(this.x,this.y);
				editer.disapperCircle();
				isSelected=false;
		});
	}

	public void setOnRealse(){
		shape.setOnMouseClicked(e->{
			status.setRelease();
			if(isSelected==false){
				isSelected=true;
				editer.show(x,y);
			}else{
				isSelected=false;
				editer.disapper();
			}
		});
	}

	public void Move(double x,double y){
			this.x=x-this.getShape().getParent().getLayoutX();
			this.y=y-this.getShape().getParent().getLayoutY();
			leftX=this.x-width;
			leftY=this.y-height;
	}

	///Cursor listener
	/*
	* 	for shape cursor will be changed to moveHand
	*   for mouse on editer(which is nine small circle) will be changed to RESIZEhand
	*
	* */
	private void  resizeCursorListener() {
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
	protected abstract void resizeShape(double dx,double dy);
	private void resizeListener(){
		Circle []circles=editer.getCircles();
		for(int i =0;i<circles.length;i++){
			circles[i].setOnMouseDragged(e->{
				double ox=((Circle)(e.getSource())).getCenterX();
				double oy=((Circle)(e.getSource())).getCenterY();
				double dx=(e.getX()-ox);
				double dy=(e.getY()-oy);
				resizeShape(dx,dy);
				editer.show(x,y);
			});
		}
	}
}
