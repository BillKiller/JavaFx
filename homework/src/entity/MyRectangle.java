package entity;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends  MyShape {
    private Rectangle rectangle;
    public MyRectangle(){
        this(500,500,50,50);
    }
    public MyRectangle(double x,double y,double width,double height){
        super(x,y,width,height);
        this.rectangle=new Rectangle(x,y,width,height);
        this.rectangle.setFill(Color.RED);
        this.rectangle.setStroke(Color.BLACK);
        super.setMyShape(this.rectangle);
    }
    public void Move(double x,double y){
        super.Move(x,y);
        rectangle.setX(this.x-width/2);
        rectangle.setY(this.y-height/2);
    }
}
