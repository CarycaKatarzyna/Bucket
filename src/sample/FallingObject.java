package sample;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class FallingObject extends ImageView {
    private int position;
    private int id;
    double height;
    private int speed;
    int type;
    Game game;

    FallingObject(int startPosition, int id, Game game){
        super();
        this.game = game;
        this.relocate(startPosition, 0);
        position = startPosition;
        this.id = id;
    }

    void move(int speed){
        try {
            this.speed = speed;
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(speed),
                            x -> game.score.checkIt(position, Bucket.getX(), type, id),
                            new KeyValue(this.layoutYProperty(), Main.HEIGHT - Bucket.imageHeight())));
            timeline.play();
        }catch (NullPointerException e){

        }
    }

    void continueMove(){
        try {
            double newSpeed = (speed * (Bucket.imageHeight() + height)) / (Main.HEIGHT - Bucket.imageHeight());
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(newSpeed),
                            x -> game.remove(id, 0),
                            new KeyValue(this.layoutYProperty(), Main.HEIGHT + height)));
            timeline.play();
        }catch (NullPointerException e){

        }
    }

}
