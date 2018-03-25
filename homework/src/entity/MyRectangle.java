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
        this.width=this.width/2;
        this.height=this.height/2;
        leftX=x;
        leftY=y;
        this.x=this.x+this.width;
        this.y=this.y+this.height;
        this.rectangle=new Rectangle(x,y,width,height);
        this.rectangle.setFill(Color.RED);
        this.rectangle.setStroke(Color.BLACK);
        super.setMyShape(this.rectangle);
    }
    public void Move(double x,double y){
        super.Move(x,y);
        rectangle.setX(leftX);
        rectangle.setY(leftY);
    }
    public void resizeShape(double x,double y){
            if(width+x>=0 && height+y>=0) {
                this.width = width + x;
                this.height = height + y;
                System.out.println("dx" + x + "dy" + y + "width" + width + "heigth" + height);
                this.x = leftX + width;
                this.y = leftY + height;
                getEditer().setHeight(height+5);
                getEditer().setWidth(width+5);
                rectangle.setWidth(width * 2);
                rectangle.setHeight(height * 2);
            }
    }
}
