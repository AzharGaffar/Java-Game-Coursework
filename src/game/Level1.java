package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level1 extends GameLevel {
    private Enemy1 enemy1;
    public static SoundClip background1Music;
    public static SoundClip voiceOver1;
    static {
        try {
            background1Music = new SoundClip("data/Background-1-Music.wav");
            voiceOver1 = new SoundClip("data/LevelOneAudio.wav");
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Populate the game with all necessary bodies, platforms and files in order for the level to function
     * @param game the game
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        background1Music.loop();
        voiceOver1.play();

        Shape groundShape = new BoxShape(100, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -18));

        Shape wallShape = new BoxShape(0.5f, 100);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-25f, -6));
        leftWall.setName("leftWall");
        leftWall.addCollisionListener(new Collisions(timothyDalton, game));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(25f, -6));
        rightWall.setName("rightWall");
        rightWall.addCollisionListener(new Collisions(timothyDalton, game));
        Body TopWall = new StaticBody(this, groundShape);
        TopWall.setPosition(new Vec2(25f, 18f));


        Shape platformShape = new BoxShape(5, 0.5f);
        Shape platform2Shape = new BoxShape(2.5f, 0.5f);
        Shape platform3Shape = new BoxShape(0.5f, 8);
        Shape platform4Shape = new BoxShape(1, 0.5f);
        Shape platform5Shape = new BoxShape(6.5f, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-20, -8));
        Body platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-15, 3.5f));
        Body platform3 = new StaticBody(this, platform2Shape);
        platform3.setPosition(new Vec2(-23, 10));
        Body platform4 = new StaticBody(this, platform3Shape);
        platform4.setPosition(new Vec2(0, 10.5f));
        Body platform5 = new StaticBody(this, platform2Shape);
        platform5.setPosition(new Vec2(15, -8));
        Body platform6 = new StaticBody(this, platform4Shape);
        platform6.setPosition(new Vec2(23, -3));
        Body platform7 = new StaticBody(this, platform2Shape);
        platform7.setPosition(new Vec2(18, 2.5f));
        Body platform8 = new StaticBody(this, platform2Shape);
        platform8.setPosition(new Vec2(6, 5));
        Body platform9 = new StaticBody(this, platform5Shape);
        platform9.setPosition(new Vec2(18, 13));

        Enemy1 enemy1 = new Enemy1(this);
        enemy1.setPosition(new Vec2(0, -15));
        enemy1.addCollisionListener(new Collisions(timothyDalton, game));
        Sirens sirens1 = new Sirens(this); //police sirens, Aesthetic choice
        sirens1.setPosition(new Vec2(-2.85f, 16.5f));
        Sirens sirens2 = new Sirens(this);
        sirens2.setPosition(new Vec2(3.25f, 16.5f));
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-20, -7);//Start at this position
    }

    @Override
    public int setUpLevelNo() {
        return 1; //This is level 1
    }

    @Override
    public Image setUpImage() {
        return new ImageIcon("data/Background1.png").getImage(); //This is level ones background
    }


    @Override
    public Vec2 doorPosition() {
        return new Vec2(23, 14.75f); //This is the position of the door in this level.
    }

    @Override
    public Vec2 keyPosition() {
        return new Vec2(-23, 12); //This is the position of the key in this level
    }

}

