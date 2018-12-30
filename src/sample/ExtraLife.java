package sample;

import javafx.scene.image.Image;

class ExtraLife extends FallingObject{
    ExtraLife(int startPosition, int id, Game game){
        super(startPosition, id, game);
        this.setImage(new Image("sample/images/heart.png"));
        height = getFitHeight();
        type = 2;
    }
}
