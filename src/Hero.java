import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Hero extends AnimatedThing{
    private double vx=30,vy,ax=0,ay=0,lastTime,k=1.3,f=1.2,m,g=0.8;

    public  Hero(double x, double y, Integer attitude, String fileName) {
        super(x,y, attitude, fileName);
    }

    public void jump(){
        this.ay=-20000;
        this.vy=-50;
        //this.getSprite().setViewport(new Rectangle2D(22));
    }


    public void update(long time){
        double deltatime=(time-lastTime)/100000000.0;

        //System.out.println(deltatime);
        if(deltatime>0.016){
            if(deltatime < 6) {
                int index= (int) ((time/100000000)%6);
                if (index==0){this.getSprite().setViewport(new Rectangle2D(22, 14, 53, 84));}
                if (index==1){this.getSprite().setViewport(new Rectangle2D(96, 4, 64, 94));}
                if (index==2){this.getSprite().setViewport(new Rectangle2D(175, 16, 75, 82));}
                if (index==3){this.getSprite().setViewport(new Rectangle2D(275, 14, 53, 84));}
                if (index==4){this.getSprite().setViewport(new Rectangle2D(350, 5, 61, 93));}
                if (index==5){this.getSprite().setViewport(new Rectangle2D(428, 18, 72, 80));}
                //System.out.println(x + ", " + vx + ", " + ax);
                vy = vy + ay * deltatime;
                this.setX(getX() + vx * deltatime);
                this.setY(getY() - vy * deltatime);
//                if (this.getY()<250){
//                    vy=vy-g*time;
//                    setY(getY()+vy*deltatime);
//                }
            }
            lastTime=time;
        }

        //ax=k*(center.getX())

    }
    //private Integer getAttitude(){return this.getAttitude()}
}
