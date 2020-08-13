package Enemy;

import game.GameObject;
import game.Renderer;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion() {
        renderer = new Renderer("assets/images/players/explosions", 6, true);
    }
}
