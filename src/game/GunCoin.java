package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GunCoin extends DynamicBody {
    public static SoundClip gunCoinSound;
    static {
        try {
            gunCoinSound = new SoundClip("data/gunCoin.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    private static final Shape gunCoin = new PolygonShape(
            -0.8f, -0.296f, -0.348f, -0.74f, 0.368f, -0.732f, 0.788f, -0.28f, 0.792f, 0.372f, 0.34f, 0.84f, -0.344f, 0.832f, -0.78f, 0.372f);
    private static final BodyImage image = new BodyImage("data/gunCoin.png", 2f);

    public GunCoin(World world) {
        super(world, gunCoin);
        addImage(image);
    }

    public void gunPickupSound() {
        gunCoinSound.play();
    }
}

