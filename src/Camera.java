import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Camera {
    private double x;
    private double y;
    private double ax=0,ay=0,vx=150,vy,k=1.3,f=1.2,lastTime;
    Hero hero;



    public Camera(int x, int y, Hero h) {
        this.x = x;
        this.y = y;
        this.hero=h;
    }



    public void update(long time){
        double deltatime=(time-lastTime)/100000000.0;
        if(deltatime>0.016){
            if(deltatime < 6) {
                x = x + vx * deltatime;
                y = y + vy * deltatime;
                vx = vx + ax * deltatime;
                vy = vy + ay * deltatime;
                ax = k * (hero.getX() - this.getX()) - f * vx;
                ay = k * (hero.getY() - this.getY()) - f * vy;
            }
            lastTime=time;
        }
    }
/////Getters
    double getX(){return x;}
    double getY(){return y;}
/////Setters
    public void setX(double x){this.x=x;}
    public void setY(double y){this.y=y;}

    @Override
    public String toString(){
        return "Camera coordinates: "+x+","+y;
    }
}
