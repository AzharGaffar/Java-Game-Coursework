package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Heart extends DynamicBody {
    public static SoundClip heartSound;
    static {
        try {
            heartSound = new SoundClip("data/HeartGain.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final Shape heart = new PolygonShape(
            -0.672f,-0.924f, 0.576f,-0.92f, 0.984f,-0.06f, 0.984f,0.66f, 0.448f,0.884f, -0.464f,0.88f, -0.972f,0.616f, -0.98f,-0.048f);
    private static final BodyImage image = new BodyImage("data/heart.png", 2f);

    public Heart(World world) {
        super(world, heart);
        addImage(image);
    }
}
