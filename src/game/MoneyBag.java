package game;

import city.cs.engine.*;

public class MoneyBag extends DynamicBody {

    private static final Shape moneyBag = new PolygonShape(
            -0.78f,-1.1f, 0.95f,-1.06f, 0.41f,1.3f, -0.59f,0.97f, -0.85f,-1.09f); //moneyBag hitbox
    private static final BodyImage image = new BodyImage("data/moneyBag.png", 3f); //Giving an image

    public MoneyBag(World world) { //Drawing on the image
        super(world, moneyBag);
        addImage(image);
    }
}
