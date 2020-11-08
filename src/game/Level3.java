package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

import java.awt.*;

public class Level3 extends GameLevel {

    public static SoundClip background3Music;
    public static SoundClip voiceOver3;
    static {
        try {
            background3Music = new SoundClip("data/Background-3-Music.wav");
            voiceOver3 = new SoundClip("data/LevelThreeAudio.wav");
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    private Body bagPlatform;
    private Body keyPlatform;

    /**
     * Populate the game with all necessary bodies, platforms and files in order for the level to function
     * @param game the game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);


        Level2.background2Music.stop();
        background3Music.loop();
        voiceOver3.play();

        Shape groundShape = new BoxShape(100, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -18));

        Shape wallShape = new BoxShape(0.5f, 100);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-25f, -6));
        leftWall.setName("leftWall");
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(25f, -6));
        rightWall.setName("rightWall");
        Body TopWall = new StaticBody(this, groundShape);
        TopWall.setPosition(new Vec2(25f, 18f));

        Shape platformShape = new BoxShape(3, 0.5f);

        bagPlatform = new StaticBody(this, platformShape);
        bagPlatform.setPosition(new Vec2(-10, 5));
        bagPlatform.setName("bagPlatform");

        keyPlatform = new StaticBody(this, platformShape);
        keyPlatform.setPosition(new Vec2(12, 5));
        keyPlatform.setName("keyPlatform");

        MoneyBag moneyBag = new MoneyBag(this);
        moneyBag.setPosition(new Vec2(-10, 6));
        moneyBag.addCollisionListener(new Collisions(timothyDalton, game));

        Button2 button1 = new Button2(this);
        button1.setPosition(new Vec2(-10, -17));
        button1.addCollisionListener(new Collisions(timothyDalton, game));

        Button3 button2 = new Button3(this);
        button2.setPosition(new Vec2(12, -17));
        button2.addCollisionListener(new Collisions(timothyDalton, game));


    }

    /**
     * returns the bagPlatform to be destroyed
     * @return bagPlatform
     */
    public Body getbagPlatform() {
        return bagPlatform;
    }

    /**
     * return keyPlatform to be destroyed
     * @return keyPlatform
     */
    public Body getkeyPlatform() {
        return keyPlatform;
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(0, -7); //The initial postion of the player
    }

    @Override
    public int setUpLevelNo() {
        return 3; //This is level 3
    }

    @Override
    public Image setUpImage() {
        return new ImageIcon("data/Background3.png").getImage(); //The level 3 background.
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(23, -16); //This is the position of the door in this level.
    }

    @Override
    public Vec2 keyPosition() {
        return new Vec2(12, 6); //This is the position of the key in this level.
    }
}
