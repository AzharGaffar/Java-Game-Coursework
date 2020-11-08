package game;

import city.cs.engine.*;


import city.cs.engine.StaticBody;
import city.cs.engine.World;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Door extends StaticBody {
    public static SoundClip doorSound;
    public static SoundClip openDoor;

    static {
        try {
            doorSound = new SoundClip("data/noKey.wav");
            openDoor = new SoundClip("data/DoorCreak.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final Shape door = new PolygonShape(
            -2.08f, 1.91f, 0.13f, 1.94f, 0.13f, -1.36f, -2.11f, -1.36f, -2.14f, 1.68f); //hitbox of door
    private static final BodyImage image = new BodyImage("data/door.png", 9f); //adding image to door

    public Door(World world) { //When you put door into world give an image to it.
        super(world, door);
        addImage(image);
    }

    public void noKey() {
        doorSound.play();
    }//sound if player collides with door with no key

    public void doorOpen() {
        openDoor.play();
    }//sound if player collides with door with key
}
