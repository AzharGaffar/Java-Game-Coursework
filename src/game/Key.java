package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Key extends DynamicBody {
    public static SoundClip keySound;

    static {
        try {
            keySound = new SoundClip("data/keySound.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    private static final Shape key = new PolygonShape(
            -0.53f, 1.14f, 0.55f, 1.13f, 0.27f, -1.44f, -0.23f, -1.45f, -0.57f, 1.0f);
    private static final BodyImage image = new BodyImage("data/key.gif", 5f);

    public Key(World world) {
        super(world, key);
        addImage(image);
    }

    public void keyPickup(){
        keySound.play();
    }
}

