package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EndGame{
    Scene scene;
    private Pane root;

    EndGame(Pane root, double width, double height){
        scene = new Scene(root, width, height);
        BackgroundFill bf = new BackgroundFill(Main.BACKGROUNDCOLOR, CornerRadii.EMPTY, Insets.EMPTY);
        root.setBackground(new Background(bf));
        this.root = root;
    }

    Scene printEnd(int score){
        final Text text = new Text();
        text.setFont(new Font("Impact", 20));
        text.setText("GAME OVER\n SCORE: " + score);
        text.setFill(Color.WHITE);
        text.relocate((Main.WIDTH - text.getLayoutBounds().getWidth())/2, 0);
        root.getChildren().add(text);

        BackgroundFill bf = new BackgroundFill(Main.BUTTONCOLOR, CornerRadii.EMPTY, Insets.EMPTY);
        Button button = new Button("BACK");
        button.setOnAction(event -> Main.menu());
        button.setFont(new Font("Impact", 15));
        button.setPrefWidth(100);
        button.relocate((Main.WIDTH-button.getPrefWidth())/2, Main.HEIGHT/2);
        button.setTextFill(Color.WHITE);
        button.setBackground(new Background(bf));
        root.getChildren().add(button);
        return scene;
    }
}
