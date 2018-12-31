package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Settings{
    Scene scene;
    private VBox root;
    private Button back;

    Settings(VBox root, double width, double height){
        scene = new Scene(root, width, height);
        this.root = root;
        root.setSpacing(15);
        update();
    }
    Scene printSettings(){
        final Text color = new Text("BACKGROUND COLOR:");
        color.setFill(Color.WHITE);
        color.setFont(new Font("Impact", 15));
        root.getChildren().add(color);
        color.setTranslateX((Main.WIDTH - color.getLayoutBounds().getWidth())/2);

        HBox hBox = new HBox();
        hBox.setSpacing(15);

        Button black = new Button("BLACK");
        black.setOnAction(event -> Main.setColor(Color.BLACK, this));
        black.setFont(new Font("Impact", 15));
        black.setTextFill(Color.WHITE);
        black.setPrefWidth(70);
        black.setPrefHeight(20);
        black.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.getChildren().add(black);

        Button blue = new Button("BLUE");
        blue.setOnAction(event -> Main.setColor(Color.DARKBLUE, this));
        blue.setFont(new Font("Impact", 15));
        blue.setTextFill(Color.WHITE);
        blue.setPrefWidth(70);
        blue.setPrefHeight(20);
        blue.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.getChildren().add(blue);

        Button green = new Button("GREEN");
        green.setOnAction(event -> Main.setColor(Color.DARKGREEN, this));
        green.setFont(new Font("Impact", 15));
        green.setTextFill(Color.WHITE);
        green.setPrefWidth(70);
        green.setPrefHeight(20);
        green.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.getChildren().add(green);

        hBox.setPrefWidth(70*3 + hBox.getSpacing()*2);
        root.getChildren().add(hBox);
        hBox.setTranslateX((Main.WIDTH - hBox.getPrefWidth())/2);

        final Text hard = new Text("DIFFICULTY:");
        hard.setFill(Color.WHITE);
        hard.setFont(new Font("Impact", 15));
        root.getChildren().add(hard);
        hard.setTranslateX((Main.WIDTH - hard.getLayoutBounds().getWidth())/2);

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(2);
        slider.setValue(1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(2);
        slider.setMinorTickCount(0);
        slider.setBlockIncrement(1);
        slider.setMaxWidth(Main.WIDTH/2);
        root.getChildren().add(slider);
        slider.setTranslateX((Main.WIDTH-slider.getMaxWidth())/2);

        back = new Button("BACK");
        back.setOnAction(event -> Main.menuFromSettings(slider.getValue()));
        back.setFont(new Font("Impact", 15));
        back.setTextFill(Color.WHITE);
        back.setPrefWidth(100);
        back.setPrefHeight(17);
        back.setBackground(new Background(new BackgroundFill(Main.BUTTONCOLOR, CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().add(back);
        back.setTranslateX((Main.WIDTH-back.getPrefWidth())/2);

        return scene;
    }

    void update(){
        if(back != null)
            back.setBackground(new Background(new BackgroundFill(Main.BUTTONCOLOR, CornerRadii.EMPTY, Insets.EMPTY)));
        BackgroundFill bf = new BackgroundFill(Main.BACKGROUNDCOLOR, CornerRadii.EMPTY, Insets.EMPTY);
        root.setBackground(new Background(bf));
    }
}
