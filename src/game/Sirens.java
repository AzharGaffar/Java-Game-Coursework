package game;

import city.cs.engine.*;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class Sirens extends StaticBody {

    private static final Shape sirens = new PolygonShape(
            0.061f,0.968f, 0.777f,0.62f, 0.877f,-0.344f, 0.369f,-0.984f, -0.407f,-0.98f, -0.931f,-0.328f, -0.919f,0.288f, -0.231f,0.944f); //hitbox of sirens
    private static final BodyImage image = new BodyImage("data/Siren.gif", 2f); //image of sirens

    public Sirens(World world) { //When put in the world, add the sirens image.
        super(world, sirens);
        addImage(image);

    }
}