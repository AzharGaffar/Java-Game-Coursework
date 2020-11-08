package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Enemy2 extends DynamicBody {
    public static SoundClip enemyDeath;
    static {
        try {
            enemyDeath = new SoundClip("data/enemyDeath.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    private static final Shape enemy2 = new PolygonShape(
            -0.44f,-2.33f, 0.75f,-2.32f, 0.52f,2.3f, -1.02f,0.97f, -0.57f,-2.32f);//hitbox of enemy2
    private static final BodyImage image = new BodyImage("data/enemy2-Stationary.png", 6.00f);// image of enemy2


    public Enemy2(World world) { //when putting enemy2 in the world, give a image to him
        super(world, enemy2);
        addImage(image);
    }

    public void enemyDeathSound(){
        enemyDeath.play();
    } //Sound for when enemy2 dies
}
