import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double xpos;
    private double ypos;
    private Integer attitude;
    private ImageView sprite;
    private int index;
    private int duration;
    private int maxIndex;
    private int length;
    private int width;
    private int offset;


    protected final Integer running=1;
    protected final Integer jumpingUp=2;
    protected final Integer jumpingDw=3;
    protected final Integer jumpShoot=4;


    public AnimatedThing(double x, double y, String fileName){
        this.xpos=x;
        this.ypos=y;
        Image spriteSheet = new Image(fileName);
        sprite= new ImageView(spriteSheet);
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



}
