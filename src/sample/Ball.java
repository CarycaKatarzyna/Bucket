package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball extends Circle{
    private int size;
    private int id;
    private int position;
    private int speed;
    Game game;

    Ball(int size, Color color, int startPosition, int id, Game game){
        super(size, color);
        this.id = id;
        this.size = size;
        this.relocate(startPosition, 0);
        position = startPosition;
        this.game = game;
    }
    void move(int speed){
        try {
            this.speed = speed;
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(speed),
                            x -> game.score.checkIt(position, Bucket.getX(), 0, id),
                            new KeyValue(this.layoutYProperty(), Main.HEIGHT - Bucket.imageHeight())));
            timeline.play();
        }catch (NullPointerException e){

        }

    }

    void continueMove(){
        try {
            double newSpeed = (speed * (Bucket.imageHeight() + 2 * size)) / (Main.HEIGHT - Bucket.imageHeight());
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(newSpeed),
                            x -> game.remove(id, 1),
                            new KeyValue(this.layoutYProperty(), Main.HEIGHT + 2 * size)));
            timeline.play();
        }catch (NullPointerException e){

        }
    }

}
