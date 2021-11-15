import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Foe extends AnimatedThing{

    public Foe(double x,double y,String file){
        super(x,y,file);
        this.getSprite().setViewport(new Rectangle2D(10,5,50,110));
        this.getSprite().setX(250);
        this.getSprite().setY(250);
    }
}
