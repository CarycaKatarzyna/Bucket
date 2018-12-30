package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    static public int WIDTH = 300;
    static public int HEIGHT = 275;
    static public Color BACKGROUNDCOLOR = Color.BLACK;
    static public Color BUTTONCOLOR = Color.GREY;
    static Random generator = new Random();
    private static Stage primaryStage;
    static int hard = 1;


    static void menu(){
        primaryStage.setScene(new Menu(new Pane(), WIDTH, HEIGHT).printMenu());
    }

    static void endGame(int score){
        EndGame endGame = new EndGame(new Pane(), WIDTH, HEIGHT);
        primaryStage.setScene(endGame.printEnd(score));
    }

    static void game(){
        Game game = new Game();
        primaryStage.setScene(game.returnScene());
    }

    static void settings(){
        Settings settings = new Settings(new VBox(), Main.WIDTH, Main.HEIGHT);
        primaryStage.setScene(settings.printSettings());
    }

    static void menuFromSettings(double hard){
        Main.hard = (int)hard;
        System.out.println("hard "+ Main.hard);
        Menu menu = new Menu(new Pane(), Main.WIDTH, Main.HEIGHT);
        primaryStage.setScene(menu.printMenu());
    }

    static void help() {
        Help help = new Help(new Pane(), Main.WIDTH, Main.HEIGHT);
        primaryStage.setScene(help.printMenu());
    }
    static void setColor(Color color, Settings settings){
        if(color == Color.BLACK){
            BACKGROUNDCOLOR = Color.BLACK;
            BUTTONCOLOR = Color.GREY;
        }
        else if(color == Color.DARKBLUE){
            BACKGROUNDCOLOR = Color.DARKBLUE;
            BUTTONCOLOR = Color.BLUE;
        }
        else{
            BACKGROUNDCOLOR = Color.DARKGREEN;
            BUTTONCOLOR = Color.GREEN;
        }
        settings.update();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bucket");
        menu();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
