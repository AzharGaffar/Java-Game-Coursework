package game;

import city.cs.engine.*;

public class Button1 extends StaticBody {

    private static final Shape button1 = new PolygonShape(
            -0.384f,0.668f, -0.44f,-0.668f, 0.62f,-0.648f, 0.7f,0.572f, -0.332f,0.688f); //Setting up the hitbox of the button
    private static final BodyImage image = new BodyImage("data/Button.png", 2f); //Giving an image

    public Button1(World world) {
        super(world, button1); //When button is put into the world, give an image to it.
        addImage(image);
    }
}
