package breakout;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;


/**
 * Simple bouncer based on an image that moves and bounces.
 *
 * @author Robert C. Duvall
 */
public class Bouncer {
    public static final double BOUNCER_MIN_SPEED = -100;
    public static final double BOUNCER_MAX_SPEED = 100;
    public static final double BOUNCER_Y_SPEED = 100;
    public static final double BOUNCER_SIZE = 0.01 * Math.min(Breakout.WIDTH, Breakout.HEIGHT);

    private ImageView myView;
    private Point2D myVelocity;
    private Random dice;


    /**
     * Create a bouncer from a given image with random attributes.
     */
    public Bouncer (Image image, double screenWidth, double screenHeight) {
        dice = new Random();
        myView = new ImageView(image);
        // make sure it stays a circle
        myView.setFitWidth(BOUNCER_SIZE);
        myView.setFitHeight(BOUNCER_SIZE);
        // make sure it stays within the bounds
        myView.setX(screenWidth / 2 - BOUNCER_SIZE / 2);
        myView.setY(screenHeight - BOUNCER_SIZE - Paddle.PADDLE_HEIGHT);
        // turn speed into velocity that can be updated on bounces
        setVelocity(getRandomInRange(BOUNCER_MIN_SPEED, BOUNCER_MAX_SPEED), -1 * BOUNCER_Y_SPEED);
    }

    /**
     * Set velocity for the Bouncer object.
     */
    public void setVelocity (double x, double y) {
        myVelocity = new Point2D(x, y);
    }

    /**
     * Get velocity for the Bouncer object.
     */
    public Point2D getVelocity () {
        return myVelocity;
    }

    /**
     * Move by taking one step based on its velocity.
     *
     * Note, elapsedTime is used to ensure consistent speed across different machines.
     */
    public void move (double elapsedTime) {

    }


    /**
     * Returns internal view of bouncer to interact with other JavaFX methods.
     */
    public ImageView getView () {
        return myView;
    }

    // Returns an "interesting", non-zero random value in the range (min, max)
    private double getRandomInRange (double min, double max) {
        return min + dice.nextDouble() * (max - min);
    }
}
