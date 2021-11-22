import javafx.geometry.*;

public class Hero extends AnimatedThing{
    private double vx=30,vy=0,ax=0,lastTime,k=1.3,f=1.2,m;
    private long g=360,ay=0,e=0;
    public int numberOfLives;
    public double invincibility = 0;

    public Hero(double x, double y, String fileName) {super(x,y, fileName);
    this.numberOfLives=3;}

    public void jump(){
        this.e=-350;
        this.ay=e+g;
        vy=-75;
        System.out.println("jump");
    }


    public void update(long time){
        double deltatime=(time-lastTime)/100000000.0;
        if(deltatime>0.016){
            if(deltatime < 6) {
                System.out.println(invincibility);
                if(invincibility>=0){
                    invincibility-=deltatime;
                }
                else{invincibility=0;}
                int index= (int) ((time/100000000)%6);
                if (index==0){this.getSprite().setViewport(new Rectangle2D(22, 14, 53, 84));}
                if (index==1){this.getSprite().setViewport(new Rectangle2D(96, 4, 64, 94));}
                if (index==2){this.getSprite().setViewport(new Rectangle2D(175, 16, 75, 82));}
                if (index==3){this.getSprite().setViewport(new Rectangle2D(275, 14, 53, 84));}
                if (index==4){this.getSprite().setViewport(new Rectangle2D(350, 5, 61, 93));}
                if (index==5){this.getSprite().setViewport(new Rectangle2D(428, 18, 72, 80));}
                vy=vy+ay*deltatime;
                this.setX(getX() + vx * deltatime);
                this.setY(getY() + vy * deltatime);
                //System.out.println("ay = "+ay+", vy = "+vy+", y = "+this.getY());
                this.getSprite().setY(this.getY());
                if (this.getY()<250){
                    if(this.e<0){this.e+=1;}else{this.e=0;}
                    ay=e+g;
                    if(this.ay<0){this.getSprite().setViewport(new Rectangle2D(20,160,60,105));}
                    if(this.ay>=0){this.getSprite().setViewport(new Rectangle2D(95,160,60,105));}
                }
                if (this.getY()>250){
                    ay=0;
                    vy=0;
                    this.setY(250);
                }
            }
            lastTime=time;
        }

        //ax=k*(center.getX())

    }
    //private Integer getAttitude(){return this.getAttitude()}


    public boolean Isinvincible(){
        if(this.invincibility>=0){
            return true;
        }
        return false;
    }


}

