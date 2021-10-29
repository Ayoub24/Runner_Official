// add any usefull package line

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application{

    public void start(Stage primaryStage){
        primaryStage.setTitle("Runner");
        //primaryStage.setResizable(true);
        Group root = new Group();
        //Pane pane= new Pane(root);
        GamingScene scene = new GamingScene(root);
        primaryStage.setScene(scene);
        primaryStage.show();




        /*AnimatedThing hero = new Hero(20,245,1,"heros.png");
        StaticThing desertLeft = new StaticThing(0,0,"desert.png",0,0,800,400);
        StaticThing desertRight = new StaticThing(0,0,"desert.png",0,0,800,400);
        StaticThing desertLeft2 = new StaticThing(1600,0,"desert.png",0,0,800,400);

        Button btn= new Button("Bouton");
        root.getChildren().add(desertLeft.getSprite());
        root.getChildren().add(desertRight.getSprite());

        root.getChildren().add(hero.getSprite());
        root.getChildren().add(btn);
        hero.getSprite().setX(hero.getX()-camera.getX());
        hero.getSprite().setY(hero.getY()-camera.getY());
        desertLeft.getSprite().setX(desertLeft.getX()-camera.getX());
        desertRight.getSprite().setX(desertRight.getX()+790-camera.getX());*/
    }
    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}

