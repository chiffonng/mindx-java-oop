package Player;

import Enemy.Enemy;
import game.*;

public class PlayerBullet extends GameObject {
    public PlayerBullet() {
        renderer = new Renderer("assets/images/player-bullets/a");
        velocity.set(0, -5);
        hitBox = new BoxCollider(this, Settings.PLAYER_BULLET_WIDTH - 8, Settings.PLAYER_BULLET_HEIGHT - 8);
    }
    @Override
    public void run() {
        super.run();
        this.checkEnemy();
    }

    public void checkEnemy() {
        Enemy enemy = GameObject.findIntersection(Enemy.class, this);
        if (enemy != null && EnemyInbound(enemy)) {
            this.deactive();
            enemy.deactive();
        }
    }

    public boolean EnemyInbound(Enemy enemy) {
        return enemy.position.x >= enemy.anchor.x * Settings.ENEMY_WIDTH && enemy.position.y >= enemy.anchor.y * Settings.ENEMY_HEIGHT;
    }
}
