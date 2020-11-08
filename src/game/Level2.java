package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level2 extends GameLevel {
    public static SoundClip background2Music;
    public static SoundClip voiceOver2;
    static {
        try {
            background2Music = new SoundClip("data/Background-2-Music.wav");
            voiceOver2 = new SoundClip("data/LevelTwoAudio.wav");
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private Body destroyablePlatform;

    /**
     * Populate the game with all necessary bodies, platforms and files in order for the level to function
     * @param game the game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        Level1.background1Music.stop();
        background2Music.loop();
        voiceOver2.play();

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
        Shape platformShape2= new BoxShape(5,0.5f);
        Shape platformShape3= new BoxShape(12,0.5f);
        Shape platformShape4= new BoxShape(16,0.5f);
        Shape platformShape5= new BoxShape(0.5f,2);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(20, -10));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(13, -5));
        Body platform3 = new StaticBody(this, platformShape2);
        platform3.setPosition(new Vec2(4, 0));
        Body platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(-15, -5));
        Body platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(20, 3));
        Body platform6 = new StaticBody(this, platformShape3);
        platform6.setPosition(new Vec2(8, 11));
        Body platform7 = new StaticBody(this, platformShape4);
        platform7.setPosition(new Vec2(12, 16.5f));
        Body platform8 = new StaticBody(this,platformShape);
        platform8.setPosition(new Vec2(-10f,10));
        Body platform9 = new StaticBody(this,platformShape2);
        platform9.setPosition(new Vec2(-19.5f,12));
        Body platform10 = new StaticBody(this,platformShape);
        platform10.setPosition(new Vec2(0,-9));

        Enemy2 enemy2 = new Enemy2(this);
        enemy2.setPosition(new Vec2(-20, 14));
        enemy2.addCollisionListener(new Collisions(timothyDalton, game));

        destroyablePlatform = new StaticBody(this,platformShape5);
        destroyablePlatform.setPosition(new Vec2(-3,13.75f));
        destroyablePlatform.setName("destroyablePlatform");

        Heart heart= new Heart(this);
        heart.setPosition(new Vec2(-15,-4));
        heart.addCollisionListener(new Collisions(timothyDalton,game));

        GunCoin coin = new GunCoin(this);
        coin.setPosition(new Vec2(0, -8));
        coin.addCollisionListener(new Collisions(timothyDalton,game));

        Button1 button= new Button1(this);
        button.setPosition(new Vec2(-24,0));
        button.addCollisionListener(new Collisions(timothyDalton,game));
    }

    /**
     * Returns the platform to be destroyed
     * @return destroyablePlatform
     */
    public Body getDestroyablePlatform() {
        return destroyablePlatform;
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(20, -11); //The starting position of the player in this level.
    }

    @Override
    public Image setUpImage() {
        return new ImageIcon("data/Background2.png").getImage(); //The background of the level.
    }

    @Override
    public int setUpLevelNo() {
        return 2; //The current level number is 2.
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-22f, 13.75f); //The position of the door in this level.
    }

    @Override
    public Vec2 keyPosition() {
        return new Vec2(-23, -15); //The position of the key in this level.
    }
}
