
package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static game.Heart.heartSound;

public class TimothyDalton extends Walker {

    public int lifeCount = 3;//lifeCount of the player
    public boolean hasKey = false;//if the player has the key
    public boolean hasDestroyPower = false;//if the player has the gunCoin.

    public static SoundClip deathSound;

    static {
        try {
            deathSound = new SoundClip("data/PlayerDeath.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    private static final Shape timothyDalton = new PolygonShape(
            -0.18f, 1.94f, 0.9f, -0.25f, 0.15f, -1.73f, -0.86f, -1.74f, -0.95f, 0.77f, -0.26f, 1.88f);//hitbox
    private static final BodyImage image = new BodyImage("data/Stationary-Timothy.png", 4.00f);//image

    public TimothyDalton(World world) {
        super(world, timothyDalton);//give him an image when putting him in the world
        addImage(image);
    }

    /**
     * gets the lifeCount
     * @return lifeCount
     */
    public int getLifeCount() {
        return lifeCount;
    }

    /**
     * Sets the lifeCount.
     * @param lifeCount
     */
    public void setLifeCount(int lifeCount) { this.lifeCount = lifeCount; }

    /**
     * Decrease the players lifeCount
     */
    public void decrementLifeCount() {
        lifeCount--;
        deathSound.play();
        System.out.println("You died, your life count is currently " + lifeCount);
    }

    /**
     * Increment the players lifeCount
     */
    public void incrementLifeCount() {
        lifeCount++;
        heartSound.play();
        System.out.println("You got a life, your life count is currently " + lifeCount);
    }
    }

