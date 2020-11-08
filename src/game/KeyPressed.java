package game;


import city.cs.engine.BodyImage;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressed implements KeyListener {


    private static final float walkingSpeed = 4; //The initial walking speed of player.
    private static final float jumpSpeed = 9; //The jump speed of the player.
    private TimothyDalton body;

    public KeyPressed(TimothyDalton body) {
        this.body = body;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Method that allows player to move around the world at certain speeds and with different images.
     * @param e keyevent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            body.startWalking(-walkingSpeed);
            body.removeAllImages();
            body.addImage(new BodyImage("data/Running-Timothy-Alternative.gif", 4.00f));
        } else if (e.getKeyChar() == 'A') {
            body.startWalking(-walkingSpeed * 2);
            body.removeAllImages();
            body.addImage(new BodyImage("data/Running-Timothy-Alternative.gif", 4.00f));
        } else if (e.getKeyChar() == 'd') {
            body.startWalking(walkingSpeed);
            body.removeAllImages();
            body.addImage(new BodyImage("data/Running-Timothy.gif", 4.00f));
        } else if (e.getKeyChar() == 'D') {
            body.startWalking(walkingSpeed * 2);
            body.removeAllImages();
            body.addImage(new BodyImage("data/Running-Timothy.gif", 4.00f));
        } else if (e.getKeyChar() == 'w') {
            body.jump(jumpSpeed);
            body.removeAllImages();
            body.addImage(new BodyImage("data/Jumping-Timothy.png", 4.00f));
        } else if (e.getKeyChar() == 'W') {
            body.jump(jumpSpeed + 6);
            body.removeAllImages();
            body.addImage(new BodyImage("data/Jumping-Timothy.png", 4.00f));
        }
    }

    /**
     * Method that stops the player from walking around and returns player imagery to stationary.
     * @param e keyevent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(new BodyImage("data/Stationary-Timothy.png", 4.00f));
        } else if (e.getKeyChar() == 'A') {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(new BodyImage("data/Stationary-Timothy.png", 4.00f));
        } else if (e.getKeyChar() == 'd') {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(new BodyImage("data/Stationary-Timothy.png", 4.00f));
        } else if (e.getKeyChar() == 'D') {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(new BodyImage("data/Stationary-Timothy.png", 4.00f));
        } else if (e.getKeyChar() == 'w') {
            body.jump(0);
            body.removeAllImages();
            body.addImage(new BodyImage("data/Stationary-Timothy.png", 4.00f));
        } else if (e.getKeyChar() == 'W') {
            body.jump(0);
            body.removeAllImages();
            body.addImage(new BodyImage("data/Stationary-Timothy.png", 4.00f));
        }
    }

   public void setPlayer(TimothyDalton timothyDalton){
        this.body=timothyDalton;
    }
}