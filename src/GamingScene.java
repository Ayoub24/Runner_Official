import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.util.ArrayList;


public class GamingScene extends Scene {
    private Hero hero=new Hero(20,245,"heros.png");
    private Camera camera=new Camera(0,0,hero);
    StaticThing backgroundL= new StaticThing(0,0,"desert.png",0,0,800,400);
    StaticThing backgroundR= new StaticThing(0,0,"desert.png",0,0,800,400);
    StaticThing life1= new StaticThing(20,0,"heart.png",0,0,59,51);
    StaticThing life3= new StaticThing(20,0,"heart.png",0,0,59,51);
    StaticThing life2= new StaticThing(20,0,"heart.png",0,0,59,51);
    int numberOfLives;
    ArrayList<Foe> foes = new ArrayList<Foe>();

    AnimationTimer timer = new AnimationTimer(){
        public void handle(long time){
            hero.update(time);
            camera.update(time);
            render();
        }
    };



    public void render(){
        double offset= camera.getX()%800;
        hero.getSprite().setX(hero.getX()-camera.getX());
        backgroundL.getSprite().setViewport(new Rectangle2D(offset,0,1000-offset,0));
        backgroundR.getSprite().setX(0-offset);
        backgroundL.getSprite().setX(800-offset);
        foes.get(foes.size()-1).getSprite().setX(250);
    }


    public GamingScene(Group g) {
        super(g, 800, 400);
        this.numberOfLives=3;
        this.camera=camera;
        timer.start();
        this.foes.add(new Foe(250,0, "Villain.png"));
        g.getChildren().add(backgroundL.getSprite());
        g.getChildren().add(backgroundR.getSprite());
        g.getChildren().add(hero.getSprite());
        g.getChildren().add(life1.getSprite());
        g.getChildren().add(foes.get(foes.size()-1).getSprite());
        if(this.numberOfLives>=2){
            g.getChildren().add(life2.getSprite());
            life2.getSprite().setX(75);
            life2.getSprite().setY(5);
        }
        if(this.numberOfLives==3){
            g.getChildren().add(life3.getSprite());
            life3.getSprite().setX(140);
            life3.getSprite().setY(5);
        }
        hero.getSprite().setX(hero.getX()-camera.getX());
        hero.getSprite().setY(hero.getY()-camera.getY());
        foes.get(foes.size()-1).getSprite().setX(250);
        life1.getSprite().setY(5);
        life1.getSprite().setX(10);
        backgroundL.getSprite().setX(backgroundL.getX()-camera.getX());
        backgroundR.getSprite().setX(backgroundR.getX()+790-camera.getX());
        this.setOnKeyPressed( (event)->{
            if (event.getText().equals(" ")) {
                hero.jump();
            }
        });

    }
}