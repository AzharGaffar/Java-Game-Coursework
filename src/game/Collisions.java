package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;


public class Collisions implements CollisionListener {

    private TimothyDalton timothyDalton;
    private Game game;

    public Collisions(TimothyDalton timothyDalton, Game game) { //Linking
        this.game = game;
        this.timothyDalton = timothyDalton;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof TimothyDalton) { //If timothy collides with...
            if (timothyDalton.getLifeCount() == 1 && (e.getReportingBody()instanceof Enemy1 || e.getReportingBody() instanceof Enemy2)) { //... any enemy and you've lost all your life then game over.
                System.out.println("Game Over");
                System.exit(0);
            } else if (e.getReportingBody() instanceof Enemy1 && !timothyDalton.hasDestroyPower) { //...enemy1 then lose life and respawn
                timothyDalton.decrementLifeCount();
                timothyDalton.setPosition(new Vec2(-20, -7));
            } else if (e.getReportingBody() instanceof Enemy2 && !timothyDalton.hasDestroyPower) { //...enemy2 then lose life and respawn
                timothyDalton.decrementLifeCount();
                timothyDalton.setPosition(new Vec2(-20, -11));
            } else if (e.getReportingBody() instanceof Enemy2 && timothyDalton.hasDestroyPower) { //...enemy2 and have gunCoin, kill the enemy.
                e.getReportingBody().destroy();
                ((Enemy2) e.getReportingBody()).enemyDeathSound();
            } else if (e.getReportingBody() instanceof GunCoin) { //...gunCoin, give him the power to kill enemies, and destroy coin.
                timothyDalton.hasDestroyPower = true;
                e.getReportingBody().destroy();
                ((GunCoin)e.getReportingBody()).gunPickupSound();
            } else if (e.getReportingBody() instanceof Key) { //...key, give him power to open doors
                e.getReportingBody().destroy();
                timothyDalton.hasKey = true;
                ((Key) e.getReportingBody()).keyPickup();
            } else if (e.getReportingBody() instanceof Door && timothyDalton.hasKey) { //...door and has the power to open doors, go next level
                System.out.println("Congratulations! You have completed the Level");
                ((Door) e.getReportingBody()).doorOpen();
                game.currMaxHealth = game.getWorld().getTimothyDalton().getLifeCount(); //Get health at the end of the level so it can be set next level.
                game.goNextLevel();
            } else if (e.getReportingBody() instanceof Door && timothyDalton.hasKey == false) { //... door and doesn't have key, don't open door
                System.out.println("You cannot pass this door without a key!");
                ((Door) e.getReportingBody()).noKey();
            } else if (e.getReportingBody() instanceof Heart) { //... heart, give him extra life
                e.getReportingBody().destroy();
                timothyDalton.incrementLifeCount();
            } else if (e.getReportingBody() instanceof Button1) { //... button, destroy the platform in Level 2 blocking him.
                if(game.getWorld()instanceof Level2) {
                    ((Level2) game.getWorld()).getDestroyablePlatform().destroy();
                }
            } else if (e.getReportingBody() instanceof Button2) { //... button destroy platform under money bag
                if(game.getWorld()instanceof Level3) {
                    ((Level3) game.getWorld()).getbagPlatform().destroy();
                }
            } else if (e.getReportingBody() instanceof Button3) { //... button destroy platform under money bag
                if(game.getWorld()instanceof Level3) {
                    ((Level3) game.getWorld()).getkeyPlatform().destroy();
                }
            } else if (e.getReportingBody() instanceof MoneyBag) { //... moneybag, end the game
                System.out.println("He got away!! Game Over...");
                System.exit(0);
                }
        } else if (e.getOtherBody() instanceof Enemy1) { //If enemy collides with...
            if (e.getReportingBody().getName() == "rightWall") {//... right wall then start walking to the left
                ((Enemy1) e.getOtherBody()).startWalking(-6);
                e.getOtherBody().removeAllImages();
                e.getOtherBody().addImage(new BodyImage("data/Enemy-Walk-Left.gif", 6.00f));
            } else if (e.getReportingBody().getName() == "leftWall") {//... left wall then start walking to the right.
                ((Enemy1) e.getOtherBody()).startWalking(6);
                e.getOtherBody().removeAllImages();
                e.getOtherBody().addImage(new BodyImage("data/Enemy-Walk.gif", 6.00f));
            }
        }
    }

}