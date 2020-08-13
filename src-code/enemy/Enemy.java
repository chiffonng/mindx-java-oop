package Enemy;

import Player.Player;
import game.BoxCollider;
import game.GameObject;
import game.Renderer;
import game.Settings;

import java.util.Set;

public class Enemy extends GameObject {
    int damage;
    public Enemy() {
        renderer = new Renderer("assets/images/enemies/level0/black", 3);
        position.set(-50, -50);
        hitBox = new BoxCollider(this, Settings.ENEMY_WIDTH - 8, Settings.ENEMY_HEIGHT - 8);
        velocity.set(0, 3);
        velocity.setAngle(Math.toRadians(20));
        damage = 1;
    }

    @Override
    public void run() {
        super.run();
        checkPlayer();
        if (onGoingRight() && OutOfRightBorder()) {
            changeDirection();
        }
        if (onGoingLeft() && OutOfLeftBorder()) {
            changeDirection();
        }
    }

    private void changeDirection() {
        velocity.x *= -1;
    }

    private boolean onGoingLeft() {
        return velocity.x < 0;
    }

    private boolean onGoingRight() {
        return velocity.x > 0;
    }

    private boolean OutOfLeftBorder() {
        return position.x <= Settings.ENEMY_WIDTH * anchor.x;
    }

    private boolean OutOfRightBorder() {
        return position.x >= Settings.BACKGROUND_WIDTH - Settings.ENEMY_WIDTH * anchor.x;
    }

    @Override
    public void deactive() {
        super.deactive();
        EnemyExplosion explosion = new EnemyExplosion();
        explosion.position.set(position);
    }

    public void checkPlayer() {
        Player player = GameObject.findIntersection(Player.class, this);
        if (player != null) {
            this.deactive();
//            player.takeDamage(damage);
        }
    }
}
