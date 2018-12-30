package sample;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score {
    private int score = 0;
    int lifes = 5;
    private Text text;
    Game game;

    Score(Game game){
        this.game = game;
    }

    boolean checkIt(double ballX, double bucketX, int type, int idx){ // type { 0 - ball, 1 - bomb, 2 - life}
        System.out.println(ballX + " " + bucketX + " ");
        if(ballX >= bucketX && ballX <= bucketX + Bucket.imageWidth()){
            if(type == 0) {
                score++;
                updateScore();
                System.out.println("+1");
            }
            else if(type == 1){
                game.endGame(score);
            }
            else if(lifes < 5){
                lifes++;
                game.addLife();
                System.out.println("<3");
            }
            game.remove(idx, 0);
            return true;
        }
        Node fallingObject = game.ballFactory.getObj(idx);
        try {
            if (type == 0) {
                ((Ball) fallingObject).continueMove();
            } else {
                ((FallingObject) fallingObject).continueMove();
            }
        }catch (NullPointerException e){

        }
        return false;
    }

    int returnScore(){
        return score;
    }

    Text printScore(){
        text = new Text();
        text.setFont(new Font("Impact",15));
        text.setFill(Color.WHITE);
        text.relocate(5, 23);
        text.setText("Score: " + score);
        return text;
    }

    private void updateScore(){
        text.setText("Score: " + score);
    }

    void restart(){
        lifes = 5;
        score = 0;
        updateScore();
    }
}
