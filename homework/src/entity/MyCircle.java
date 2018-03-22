package entity;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyCircle extends MyShape {
	private Circle circle;
	private double radius;
	public MyCircle(){
		this(500,500,50);
	}
	public MyCircle(double x,double y,double radius){
			super(x,y,radius,radius);
			this.x=x;
			this.y=y;
			this.radius=radius;
			this.circle=new Circle(x,y,radius);
			this.circle.setFill(Color.WHITE);
			this.circle.setStroke(Color.BLACK);
			super.setMyShape(this.circle);
	}
	public void Move(double x,double y){
		super.Move(x,y);
		circle.setCenterX(this.x);
		circle.setCenterY(this.y);
	}
}
