package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class BallFactory {
    private int id = 0;
    private HashMap<Integer, Node> map = new HashMap<>();
    Game game;

    BallFactory(Game game){
        this.game = game;
    }


    Node produce(){
        int size = 10, speed;
        Color color;
        do {
            color = Color.color(Math.random(), Math.random(), Math.random());
        }while (color == Main.BACKGROUNDCOLOR);
        int position = Main.generator.nextInt(Main.WIDTH - 40);
        if(id < 10)
            speed = 4;
        else if(id < 20)
            speed = 3;
        else if(id < 30)
            speed = 2;
        else
            speed = 1;
        if( Main.generator.nextInt(10) == 9){
            Bomb bomb = new Bomb(position, id, game);
            bomb.move(speed);
            map.put(id++, bomb);
            return bomb;
        }
        if( Main.generator.nextInt(10) == 1){
            System.out.println("EXTRA LIFE");
            ExtraLife life = new ExtraLife(position, id, game);
            life.move(speed);
            map.put(id++, life);
            return life;
        }
        Ball ball = new Ball(size, color, position, id, game);
        ball.move(speed);
        map.put(id++, ball);
        return  ball;
    }

    Node getObj(int id){
        return map.get(id);
    }

    void restart(){
        map.clear();
        id = 0;
    }
}
