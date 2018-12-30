package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Bucket {
    private static Image image;
    static ImageView imageView;
    private static double imageWidth;
    private static double imageHeight;
    Bucket(){
        image = new Image("sample/images/bucket3.png");
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.relocate(0, Main.HEIGHT-image.getHeight());
        imageView.setX((Main.WIDTH-image.getWidth())/2);
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
        System.out.println("wymiary: " + imageHeight + " " + imageWidth);
    }

    void moveRight(){
        imageView.setX(getX()+3);
    }

    void moveLeft(){
        imageView.setX(getX()-3);
    }

    static double getX(){
        return imageView.getX();
    }

    static double imageWidth(){
        return imageWidth;
    }

    static double imageHeight(){
        return imageHeight;
    }

}
