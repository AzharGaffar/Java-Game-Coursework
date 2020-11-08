package game;

import city.cs.engine.*;

public class Enemy1 extends Walker {
    public int enemyWalk = 6;//intial walking speed for enemy1
    private static final Shape enemy1 = new PolygonShape(
            -0.35f, 2.2f, -0.86f, 1.75f, -1.05f, -2.39f, 1.06f, -2.39f, 0.85f, 1.2f, 0.07f, 2.21f);//hitbox for enemy
    private static final BodyImage image = new BodyImage("data/Enemy-Walk.gif", 6.00f); //give enemy walking image


    public Enemy1(World world) { //when put in the world, start walking
        super(world, enemy1);
        addImage(image);
        startWalking(enemyWalk);
    }
}

