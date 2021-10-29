import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    double x;
    double y;
    private ImageView sprite;

    public StaticThing(double xpos, double ypos, String fileName, int x, int y, int length, int width){
        this.x=xpos;
        this.y=ypos;
        Image spritesheet= new Image(fileName);
        sprite =new ImageView(spritesheet);
        sprite.setViewport(new Rectangle2D(x,y,length,width));
    }

/////Getters
    public double getX(){return x;}
    double getY(){return y;}
    ImageView getSprite(){return sprite;}

/////Setters
    public void setX(double x){this.x=x;}
    public void setY(double y){this.y=y;}

}
