import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;


public class GamingScene extends Scene {
    private Hero hero=new Hero(20,245,1,"heros.png");
    private Camera camera=new Camera(0,0,hero);
    StaticThing backgroundL= new StaticThing(0,0,"desert.png",0,0,800,400);
    StaticThing backgroundR= new StaticThing(0,0,"desert.png",0,0,800,400);
    int numberOfLives;

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
    }

    public GamingScene(Group g) {
        super(g, 800, 400);
        this.numberOfLives=3;
        this.camera=camera;
        timer.start();
        g.getChildren().add(backgroundL.getSprite());
        g.getChildren().add(backgroundR.getSprite());
        g.getChildren().add(hero.getSprite());
        hero.getSprite().setX(hero.getX()-camera.getX());
        hero.getSprite().setY(hero.getY()-camera.getY());
        backgroundL.getSprite().setX(backgroundL.getX()-camera.getX());
        backgroundR.getSprite().setX(backgroundR.getX()+790-camera.getX());
        this.setOnKeyPressed( (event)->{
            if (event.getText().equals(" ")) {
                System.out.println("Jump");
                hero.jump();
            }
        });

    }

   /*public void update(long time){
        System.out.println(backgroundL.getX()-camera.getX());
        backgroundL.getSprite().setX(backgroundL.getX()-camera.getX());
        backgroundR.getSprite().setX(backgroundR.getX()+790-camera.getX());
        hero.getSprite().setX(hero.getX()-camera.getX());
        hero.getSprite().setY(hero.getY());

    }*/


}
