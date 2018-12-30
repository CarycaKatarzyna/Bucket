package sample;

import javafx.scene.image.Image;

class Bomb extends FallingObject{
    Bomb(int startPosition, int id, Game game) {
        super(startPosition, id, game);
        this.setImage(new Image("sample/images/bomb2.png"));
        height = this.getFitHeight();
        type = 1;
    }
}