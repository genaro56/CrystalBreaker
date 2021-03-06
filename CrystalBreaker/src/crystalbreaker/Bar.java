package crystalbreaker;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Player class
 *
 * @author Luis Felipe Alvarez Sanchez A01194173 4 Feb 2019
 */
public class Bar extends Item {

    private int width;
    private int height;
    private int health;
    private Game game;
    private boolean dead;

    /**
     * Player constructor
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game
     */
    public Bar(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        health = 3;
        this.game = game;
        this.dead = false;
    }

    /**
     * getHeight method
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * setDead method
     *
     * @param dead
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * isDead method
     *
     * @return dead
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * getWidth method
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * getHealth method
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * setHeight method
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * setWidth method
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * setHealth method
     *
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * tick method The overall movement of the object
     */
    @Override
    public void tick() {

    }
    //Collisions

    /**
     * getPerimetro method
     *
     * @return rectangle
     */
    public Rectangle getPerimetro() {

        return new Rectangle(getX(), getY(), getWidth(), getHeight() - 50);
    }

    /**
     * Renders the player
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.bar,getX(), getY(), getWidth(), getHeight(), null);
        switch (getHealth()) {
            case 1:
                g.drawImage(Assets.bar1, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 2:
                g.drawImage(Assets.bar2, getX(), getY(), getWidth(), getHeight(), null);
                break;
            case 3:
                g.drawImage(Assets.bar, getX(), getY(), getWidth(), getHeight(), null);
                break;
        }

    }
}
