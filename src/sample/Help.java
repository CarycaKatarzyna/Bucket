package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Help {
    Scene scene;
    private Pane root;

    Help(Pane root, double width, double height){
        scene = new Scene(root, width, height);
        BackgroundFill bf = new BackgroundFill(Main.BACKGROUNDCOLOR, CornerRadii.EMPTY, Insets.EMPTY);
        root.setBackground(new Background(bf));
        this.root = root;
    }
    Scene printMenu(){
        ImageView imageView = new ImageView(new Image("sample/images/manual.png"));
        imageView.relocate(0,0);
        root.getChildren().add(imageView);

        BackgroundFill bf = new BackgroundFill(Main.BUTTONCOLOR, CornerRadii.EMPTY, Insets.EMPTY);
        Button button = new Button("BACK");
        button.setOnAction(event -> Main.menu());
        button.setFont(new Font("Impact", 15));
        button.setPrefWidth(100);
        button.relocate((Main.WIDTH-button.getPrefWidth())/2, 3*Main.HEIGHT/4);
        button.setTextFill(Color.WHITE);
        button.setBackground(new Background(bf));
        root.getChildren().add(button);

        return scene;
    }
}

