package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Menu {
    Scene scene;
    private Pane root;

    Menu(Pane root, double width, double height){
        scene = new Scene(root, width, height);
        BackgroundFill bf = new BackgroundFill(Main.BACKGROUNDCOLOR, CornerRadii.EMPTY, Insets.EMPTY);
        root.setBackground(new Background(bf));
        this.root = root;
    }
    Scene printMenu(){
        ImageView imageView = new ImageView(new Image("sample/images/menu.png"));
        BackgroundFill bf = new BackgroundFill(Main.BUTTONCOLOR, CornerRadii.EMPTY, Insets.EMPTY);
        imageView.relocate(0,0);
        root.getChildren().add(imageView);

        Button start = new Button("START");
        start.setOnAction(event -> Main.game());
        start.setFont(new Font("Impact", 15));
        start.setTextFill(Color.WHITE);
        start.setPrefWidth(100);
        start.setPrefHeight(17);
        start.relocate((Main.WIDTH - start.getPrefWidth())/2, Main.HEIGHT/2);
        start.setBackground(new Background(bf));
        root.getChildren().add(start);

        Button settings = new Button("SETTINGS");
        settings.setOnAction(event -> Main.settings());
        settings.setFont(new Font("Impact", 15));
        settings.setTextFill(Color.WHITE);
        settings.setPrefWidth(100);
        settings.setPrefHeight(17);
        settings.relocate((Main.WIDTH - settings.getPrefWidth())/2, Main.HEIGHT/2 + start.getPrefHeight()+ 15);
        settings.setBackground(new Background(bf));
        root.getChildren().add(settings);

        Button help = new Button("HELP");
        help.setOnAction(event -> Main.help());
        help.setFont(new Font("Impact", 15));
        help.setTextFill(Color.WHITE);
        help.setPrefWidth(100);
        help.setPrefHeight(17);
        help.relocate((Main.WIDTH - help.getPrefWidth())/2, Main.HEIGHT/2 + start.getPrefHeight()+ 15 + settings.getPrefHeight() + 15);
        help.setBackground(new Background(bf));
        root.getChildren().add(help);

        return scene;
    }
}
