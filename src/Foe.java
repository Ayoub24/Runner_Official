import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Foe extends AnimatedThing {
    private double x, lastTime;

    public Foe(double x, double y, String file,double bim) {
        super(x, y, file);
        this.x = bim;
    }

    public void setXpos(double val) {
        this.x = val;
    }

    public double getXpos() {
        return this.x;
    }
}