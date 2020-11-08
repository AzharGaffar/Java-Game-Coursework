package game;

import city.cs.engine.*;

public class Button2 extends StaticBody {

    private static final Shape button2 = new PolygonShape(
            -0.62f,-0.48f, 0.788f,-0.504f, 0.56f,0.548f, -0.38f,0.58f, -0.692f,-0.464f); //Setting up hitbox of the button
    private static final BodyImage image = new BodyImage("data/button2.png", 2f); //Giving it an image

    public Button2(World world) {
        super(world, button2); //When button is put into the world, give an image to it.
        addImage(image);
    }
}
