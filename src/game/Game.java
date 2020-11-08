package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * A world with some bodies.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    // display the view in a frame
    final JFrame frame = new JFrame("James Bond");

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;
    private int level;
    public int currMaxHealth = 3; //Current health

    private KeyPressed keyPressed;

    private GameUI gameUI;

    /**
     * The entry into the first level. This populates the world with all necessary things required
     */
    public Game() {
        level = 1;
        world = new Level1();
        world.populate(this);


        // make a view
        view = new MyView(world, world.getTimothyDalton(), 1000, 720);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        gameUI = new GameUI(this);
        frame.add(gameUI.getMainPanel(), BorderLayout.NORTH); //Setting button panel to top
        frame.revalidate();

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        frame.requestFocusInWindow();

        keyPressed = new KeyPressed(world.getTimothyDalton());
        frame.addKeyListener(keyPressed);


        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1000, 720);

        // start!
        world.start();
    }

    /**
     * When the user completes the level, game goes to the next level.
     */
    public void goNextLevel() {
        world.stop();
        level++;
        if (level == 1) {
            world = new Level1();
            world.populate(this); // setting up the level
            keyPressed.setPlayer(world.getTimothyDalton());
            view.setWorld(world);
            world.start();
        } else if (level == 2) {
            world = new Level2();
            world.populate(this);// setting up the level
            keyPressed.setPlayer(world.getTimothyDalton());
            view.setWorld(world);
            world.start();
        } else if (level == 3) {
            world = new Level3();
            world.populate(this);// setting up the level
            keyPressed.setPlayer(world.getTimothyDalton());
            view.setWorld(world);
            world.start();
        } else {
            System.out.println("Congratulations, You have finished the game!!"); //End of game, no more levels
            System.exit(0);
        }
        world.getTimothyDalton().setLifeCount(currMaxHealth); //set the new life from the last level.
        System.out.println("Your life count is currently " + world.getTimothyDalton().getLifeCount());
       // JFrame debugView = new DebugViewer(world, 1000, 720);

        frame.add(gameUI.getMainPanel(), BorderLayout.NORTH);
        frame.revalidate();
    }

    /**
     * Run the game
     */
    public static void main(String[] args) { //Entry into game
        System.out.println("Controls: wasd to walk and jump, shift+wasd to run and super jump");
        new Game();
    }

    /**
     * Returns the world
     * @return world
     */
    public GameLevel getWorld() {
        return world;
    }

    /**
     * returns the level.
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * sets the level
     * @param level the current level the user is on
     */
    public void setLevel(int level) {
        this.level = level;
    }
}