/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crystalbreaker;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Genaro Martínez A01566055
 */
public class Bullet extends Item {

    private int width;
    private int height;
    private int direction;
    private boolean shoot;
    private int speedY;
    private int speedX;
    private Player player;
    private Game game;
    private boolean dead;
    private boolean hit;

    /**
     *
     * @param startX
     * @param startY
     * @param x
     * @param y
     * @param game
     * @param player
     */
    public Bullet(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        speedY = -5;
        speedX = 5;
        shoot = false;
        direction = (int) (Math.random() * 10 + 2);
    }

    public boolean isShoot() {
        return shoot;
    }

    public void bulletDirection(int numRand) {

        if (getX() + 50 >= game.getWidth()) {
            speedX = speedX * - 1;
            setX(getX() - 20);
        }
        if (getX() <= -20) {
            speedX = speedX * - 1;
            setX(getX() + 10);
        }
        if (getY() == game.getHeight()) {
            //dead
            setDead(true);
            setShoot(false);
        }
        if (getY() <= -20) {
            speedY = speedY * - 1;
        }
         /*else {
            setX(getX() - speedX);
            setY(getY() + speedY);
        }*/
    
        setX((numRand%2==0) ? getX()+speedX : getX() - speedX);
        setY(getY() - speedY);
        System.out.println("x " + speedX);
        System.out.println("y " + speedY);
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeedY() {
        return speedY;
    }

    public boolean canShoot() {
        return shoot;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setShoot(boolean aux) {
        shoot = aux;
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
     * getWidth method
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * setHeight method
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }

    /**
     * getPLayer method
     *
     * @param player
     */
    public Player getPlayer() {
        return player;
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
     * Renders the player
     *
     * @param g
     */
    @Override
    public void tick() {
        // vertical left up
        if (shoot == false) {
            if (game.getKeyManager().left) {
                setX(getX() - 10);
            }
            // vertical left down
            if (game.getKeyManager().right) {
                setX(getX() + 10);
            }
            if (getX() + 120 >= game.getWidth()) {
                setX(game.getWidth() - 120);
            } else if (getX() <= 55) {
                setX(55);
            }
            if (game.getKeyManager().space) {
                shoot = true;
            }
        } else {
            bulletDirection(direction);

            /*if (getX() + 32 >= game.getWidth()) {
                speedX = speedX * - 1;
            }
            if (getX() <= 0) {
                speedX = speedX * -1;
            }
            if (getY() == game.getHeight()) {
                //dead
                setDead(true);
                setShoot(false);
            }
            if (getY() <= -20) {
                speedY = speedY * -1;
            }
            setX(getX() + speedX);
            setY(getY() + speedY);*/

        }
    }

    /**
     *Rectangle mehtod
     * @return
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * @param obj
     * @return
     */
    public boolean intersectaBarra(Object obj) {
        return obj instanceof Bar && getPerimetro().intersects(((Bar) obj).getPerimetro());
    }

    public boolean intersectaJugador(Object obj) {
        return obj instanceof Player && getPerimetro().intersects(((Player) obj).getPerimetro());
    }

    public void render(Graphics g) {
        if(isHit()) {
            int count = 1000;
            while(count >=0){
                g.drawImage(Assets.bullet_destroyed, getX(), getY(), getWidth(), getHeight(), null);
                count -= 1;
                System.out.println(count);
                setHit(false);
            }
        } else {
            g.drawImage(Assets.bullet, getX(), getY(), getWidth(), getHeight(), null);
        }
    }

    /**
     * Change direction method
     * works
     */
    void changeDirection() {
        int randNum = (int) (Math.random() * 10 + 1);
        if (randNum % 2 == 0) {
            speedX = speedX * - 1;
            speedY = speedY * - 1;
            
        } else {
            speedX = speedX * 1;
            speedY = speedY * - 1;
            
        }
    }

    /**
     * Change direction when hitted by player
     */
    void changeBulletByPlayerDirection() {
        int randNum = (int) (Math.random() * 10 + 1);
        if (randNum % 2 == 0) {
            speedX = speedX * - 1;
            speedY = speedY * - 1;
            setX(getX() - 5);
            setY(getY() - 5);
        } 
        else {
            speedX *= 1;
            speedY *= - 1;
            setX(getX() + 5);
            setY(getY() - 5);
        }
    }
}
