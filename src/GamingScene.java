import javafx.animation.AnimationTimer;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.util.ArrayList;


public class GamingScene extends Scene {
    private Group root;
    public Hero hero = new Hero(20, 245, "heros.png");
    private Camera camera = new Camera(0, 0, hero);
    StaticThing backgroundL = new StaticThing(0, 0, "desert.png", 0, 0, 800, 400);
    StaticThing backgroundR = new StaticThing(0, 0, "desert.png", 0, 0, 800, 400);
    StaticThing life1 = new StaticThing(20, 0, "heart.png", 0, 0, 59, 51);
    StaticThing life3 = new StaticThing(20, 0, "heart.png", 0, 0, 59, 51);
    StaticThing life2 = new StaticThing(20, 0, "heart.png", 0, 0, 59, 51);
    private ArrayList<Foe> foelist = new ArrayList<>();

    AnimationTimer timer = new AnimationTimer() {
        public void handle(long time) {
            hero.update(time);
            camera.update(time);
            render();
            update(time);
        }
    };


    public void render() {
        double offset = camera.getX() % 800;
        hero.getSprite().setX(hero.getX() - camera.getX());
        backgroundL.getSprite().setViewport(new Rectangle2D(offset, 0, 1000 - offset, 0));
        backgroundR.getSprite().setX(0 - offset);
        backgroundL.getSprite().setX(800 - offset);
    }

    public void update(long l) {
        for (Foe f : this.foelist) {
            //System.out.println(hero.getHitBox() + " " + f.getHitBox());
            f.getSprite().setX(f.getXpos() -camera.getX());
            f.setX(f.getXpos() - camera.getX());
            if(!hero.Isinvincible()){
                if (f.getHitBox().intersects(hero.getHitBox())) {
                    hero.numberOfLives -= 1;
                    hero.invincibility=25;
                    System.out.println(hero.numberOfLives);
                    switch (hero.numberOfLives) {
                        case 2 -> root.getChildren().remove(life3.getSprite());
                        case 1 -> root.getChildren().remove(life2.getSprite());
                        case 0 -> root.getChildren().remove(life1.getSprite());
                    }
                }
                    System.out.println("lives = " + hero.numberOfLives);
                }

            }
        }



    public ArrayList<Foe> getFoelist() {
        return this.foelist;
    }

    public GamingScene(Group g) {
        super(g, 800, 400);
        root = g;
        this.camera = camera;
        timer.start();
        g.getChildren().add(backgroundL.getSprite());
        g.getChildren().add(backgroundR.getSprite());
        g.getChildren().add(hero.getSprite());
        g.getChildren().add(life1.getSprite());
        g.getChildren().add(life2.getSprite());
        g.getChildren().add(life3.getSprite());
        for (int i = 1; i < 251; i++) {
            this.foelist.add(new Foe(0, 0, "Villain.png", 500 * i));
        }
        for (Foe f : foelist) {
            f.getSprite().setViewport(new Rectangle2D(10, 5, 50, 110));
            g.getChildren().add(f.getSprite());
            f.setX(f.getX()-camera.getX());
            f.setY(250);
            f.getSprite().setY(250);
            }
            hero.getSprite().setX(hero.getX() - camera.getX());
            hero.setX(hero.getX() - camera.getX());
            hero.getSprite().setY(hero.getY() - camera.getY());
            life1.getSprite().setY(5);
            life1.getSprite().setX(10);
            life2.getSprite().setX(75);
            life2.getSprite().setY(5);
            life3.getSprite().setX(140);
            life3.getSprite().setY(5);
            backgroundL.getSprite().setX(backgroundL.getX() - camera.getX());
            backgroundR.getSprite().setX(backgroundR.getX() + 790 - camera.getX());
            this.setOnKeyPressed((event) -> {
                if (event.getText().equals(" ")) {
                    hero.jump();
                }
            });

        }
    }
