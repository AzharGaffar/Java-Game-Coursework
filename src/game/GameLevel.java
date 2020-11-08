package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevel extends World {
private int levelNo;
private Image bgImage;

    public Image getBgImage() {
        return bgImage;
    }

    public TimothyDalton timothyDalton;

    /**
     * return the player
     * @return timothyDalton
     */
    public TimothyDalton getTimothyDalton() {
        return timothyDalton;
    }

    /**
     *populate the world and put in the main bodies needed for a basic level
     * @param game the game
     */
    public void populate(Game game) {
        levelNo = setUpLevelNo();
        bgImage = setUpImage();
        timothyDalton = new TimothyDalton(this);
        timothyDalton.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new Collisions(timothyDalton, game));
        Key key = new Key(this);
        key.setPosition(keyPosition());
        key.addCollisionListener(new Collisions(timothyDalton, game));

    }

    /**
     * Initial position of player in the level
     */
    public abstract Vec2 startPosition();

    /**
     *The level number of current level
     */
    public abstract int setUpLevelNo();

    /**
     * Background of current level
     */
    public abstract Image setUpImage();

    /**
     * The position of the door in the level
     */
    public abstract Vec2 doorPosition();

    /**
     * The position of the key in the world.
     */
    public abstract Vec2 keyPosition();

}

