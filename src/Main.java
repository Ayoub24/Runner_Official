// add any usefull package line

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application{

    public void start(Stage primaryStage){
        primaryStage.setTitle("Runner");
        primaryStage.setResizable(false);
        Group root = new Group();
        //Pane pane= new Pane(root);
        GamingScene scene = new GamingScene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        if(scene.hero.numberOfLives==0){
            primaryStage.close();
            System.out.println("test");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

