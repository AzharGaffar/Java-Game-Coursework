package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;


public class MyView extends UserView {

    TimothyDalton timothyDalton;
    private ImageIcon oneHeart = new ImageIcon("data/Heart.png");
    private ImageIcon twoHeart = new ImageIcon("data/2Hearts.png");
    private ImageIcon threeHeart = new ImageIcon("data/3Hearts.png");
    private ImageIcon fourHeart = new ImageIcon("data/4Hearts.png");
    private ImageIcon key = new ImageIcon("data/key.png");


    public MyView(GameLevel world, TimothyDalton timothyDalton, int width, int height) {
        super(world, width, height);
        this.timothyDalton = timothyDalton;
    }

    /**
     * Paints the background of the current level
     * @param g Graphics2D
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(((GameLevel) getWorld()).getBgImage(), 0, 0, this);
    }

    /**
     * Paints the current game player stats
     * @param g Graphics2D
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        int CurrentHealth = ((GameLevel) super.getWorld()).getTimothyDalton().getLifeCount();
        boolean key = (((GameLevel) super.getWorld()).getTimothyDalton().hasKey);
        if (CurrentHealth == 3) {
            g.drawImage(threeHeart.getImage(), 20, 20, (int) (threeHeart.getIconWidth() * 0.075), (int) (threeHeart.getIconHeight() * 0.075f), this);
        } else if (CurrentHealth == 4) {
            g.drawImage(fourHeart.getImage(), 20, 20, (int) (fourHeart.getIconWidth() * 0.075f), (int) (fourHeart.getIconHeight() * 0.075f), this);
        } else if (CurrentHealth == 2) {
            g.drawImage(twoHeart.getImage(), 20, 20, (int) (twoHeart.getIconWidth() * 0.075f), (int) (twoHeart.getIconHeight() * 0.075f), this);
        } else if (CurrentHealth == 1) {
            g.drawImage(oneHeart.getImage(), 20, 20, (int) (oneHeart.getIconWidth() * 0.075f), (int) (oneHeart.getIconHeight() * 0.075f), this);
        }
        if (key) {
            g.drawImage(this.key.getImage(), 140, -20, (int) (this.key.getIconWidth() * 0.5), (int) (this.key.getIconHeight() * 0.5), this);
        }
    }

}