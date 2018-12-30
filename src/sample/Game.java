package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.ArrayList;

public class Game {
    private int lifes;
    Score score;
    BallFactory ballFactory;
    private Pane pane;
    Scene scene;
    private AnimationTimer animationTimer;
    private Timeline timeline;
    private Bucket bucket = new Bucket();
    private ArrayList<ExtraLife> Lifes = new ArrayList<>();

    Game(){
        lifes = 5;
        Lifes.clear();
        pane = new Pane();
        scene = new Scene(pane, Main.WIDTH, Main.HEIGHT);
        BackgroundFill bf = new BackgroundFill(Main.BACKGROUNDCOLOR, CornerRadii.EMPTY, Insets.EMPTY);
        pane.setBackground(new Background(bf));
        addObjects();
        score.restart();
        ballFactory.restart();
    }

    void endGame(int score){
        animationTimer.stop();
        timeline.stop();
        Main.endGame(score);
    }

    Scene returnScene(){
        return scene;
    }

    void addLife(){
        pane.getChildren().add(Lifes.get(lifes));
        lifes++;
    }


    void remove(int id, int type){ // 0 - ball/bomb/extra life, 1 - life
        if(type != 1)
            pane.getChildren().remove(ballFactory.getObj(id));
        else {
            if(lifes == 0){
                return;
            }
            lifes--;
            score.lifes--;
            if(lifes == 0)
                endGame(score.returnScore());
            try {
                pane.getChildren().remove(Lifes.get(lifes));
                pane.getChildren().remove(ballFactory.getObj(id));
            }catch (IndexOutOfBoundsException e){

            }
        }

    }

    private void setAnimationTimer(){
        ArrayList<KeyCode> move = new ArrayList<KeyCode>();

        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent keyEvent) {
                        KeyCode code = keyEvent.getCode();
                        if (!move.contains(code))
                            move.add(code);
                    }
                });

        scene.setOnKeyReleased(
                new EventHandler<KeyEvent>(){
                    public void handle(KeyEvent keyEvent){
                        KeyCode code = keyEvent.getCode();
                        move.remove(code);
                    }
                });

        animationTimer = new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (move.contains(KeyCode.LEFT))
                    bucket.moveLeft();

                if (move.contains(KeyCode.RIGHT))
                    bucket.moveRight();
            }
        };
        animationTimer.start();
    }

    private void setTimeLine(){
        System.out.println("factory: " + (3-Main.hard));
        timeline = new Timeline(new KeyFrame(
                Duration.seconds((3-Main.hard)),
                x -> pane.getChildren().add(ballFactory.produce())));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void addObjects(){
        Bucket bucket =  new Bucket();
        ballFactory = new BallFactory(this);
        pane.getChildren().add(Bucket.imageView);
        for(int i=1; i<6; i++){
            ExtraLife life = new ExtraLife((i-1)*20 + 5, -i, null);
            Lifes.add(life);
            pane.getChildren().add(life);
        }
        score = new Score(this);
        pane.getChildren().add(score.printScore());
        setTimeLine();
        setAnimationTimer();
    }


}
