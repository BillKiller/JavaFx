package entity;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Editer {
	private Circle []circles;
	private double x;
	private double y;
	private double width;
	private double height;

	public Circle[] getCircles(){
		return this.circles;
	}
	public Editer(double x,double y,double height,double width){
			this.x=x;
			this.y=y;
			this.height=height+10;
			this.width=width+10;
			circles =new Circle[9];
			for(int i =0;i<9;i++){
				circles[i] = new Circle(x,y,10);
				circles[i].setFill(Color.BLUE);
			}
	}
	public void  show(double x,double y){
		for(int i =0;i<3;i++){
			for(int j =0;j<3;j++){
				circles[3*i+j].setCenterX(x+width*(i-1));
				circles[3*i+j].setCenterY(y+height*(j-1));
				circles[3*i+j].setRadius(5);
			}
		}
	}
	public void  disapper(){
		for(int i =0;i<3;i++){
			for(int j =0;j<3;j++){
				circles[3*i+j].setRadius(0);
			}
		}
	}
}
