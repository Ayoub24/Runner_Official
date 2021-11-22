import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double xpos;
    protected double ypos;
    private Integer attitude;
    private ImageView sprite;
    protected int length;
    protected int width;


    public AnimatedThing(double x, double y, String fileName){
        this.xpos=x;
        this.ypos=y;
        Image spriteSheet = new Image(fileName);
        sprite= new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(0,0,53,84));
    }

/////Getter
    public ImageView getSprite(){return this.sprite;}

    public double getX(){return this.xpos;}

    public double getY(){return this.ypos;}

    public String getAttitude() {
        if (this.attitude == 1) {
            return "running";
        } else if (this.attitude == 2) {
            return "jumping Down";

        } else if (this.attitude == 3) {
            return "jumping Up";
        } else if (this.attitude == 4) {
            return "jumpshoot";
        }
        return null;
    }


    /////Setters
    public void setX(double x){this.xpos=x;}
    public void setY(double y){this.ypos=y;}
    public void setAttitude(Integer a){this.attitude=a;}

    public Rectangle2D getHitBox(){return new Rectangle2D(xpos,ypos,this.getSprite().getViewport().getWidth(),this.getSprite().getViewport().getHeight());}


}
