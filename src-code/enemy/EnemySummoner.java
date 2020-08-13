package Enemy;

import game.GameObject;

public class EnemySummoner extends GameObject {
    public int frameCount = 0;
    public int delaySummon = 120;

    public EnemySummoner(){

    }

    @Override
    public void run() {
        super.run();
        frameCount++;
        if(frameCount>=delaySummon) {
            new Enemy();
            frameCount=0;
        }
    }
}
