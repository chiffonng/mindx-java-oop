package Player;

import game.*;

import tklibs.Mathx;

import java.awt.*;

public class Player extends GameObject {
    private final double GRAVITY = 0.5;
    private int HP;
    private boolean immune;

    public Player() {
        renderer = new Renderer("assets/images/players/straight");
        position.set(192, 400);
        hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH - 12, Settings.PLAYER_HEIGHT);
        HP = 3;
        immune = false;
    }
//    public void takeDamage(int damage) {
//        HP -= damage;
//        if (immune) {
//            return;
//        }
//        if(HP <= 0) {
//            HP = 0;
//            this.deactive();
//        } else {
//            immune = true;
//        }
//    }
    int frameCount = 0;
    @Override
    public void run() {
        this.gravityPull();
        this.move();
//        this.limitPosition();
        this.fire();
//        this.checkImmune();
    }

    @Override
    public void render(Graphics g) {
//        if(immune) {
//            if(immuneCount % 8 == 0) {
//                super.render(g);
//            }
//        } else {
//        super.render(g);}
    }

//    int immuneCount = 0;
////    private void checkImmune() {
////        if(immune) {
////            immuneCount++;
////            if(immuneCount > 120) {
////                immune = false;
////                immuneCount = 0;
////            }
////        }
////    }
//    private void limitPosition() {
//        double haltWidthPlayer = Settings.PLAYER_WIDTH * anchor.x;
//        double halfHeightPlayer = Settings.PLAYER_HEIGHT * anchor.y;
//        position.x = Mathx.clamp(position.x, haltWidthPlayer, Settings.BACKGROUND_WIDTH - haltWidthPlayer);
//        position.y = Mathx.clamp(position.y, halfHeightPlayer, Settings.GAME_HEIGHT - halfHeightPlayer);
//    }
    private void move() {
        if(KeyEventPress.isLeftPress) {
            position.add(-2,0);
        }
        if(KeyEventPress.isRightPress) {
            position.add(2,0);
        }
        if(KeyEventPress.isUpPress) {
            position.add(0,-2);
        }
        if(KeyEventPress.isDownPress) {
            position.add(0,2);
        }
    }
    private void fire() {
        frameCount++;
        if(KeyEventPress.isFirePress && frameCount >= 20) {
            int numberBullet = 5;
            double startX = position.x - 10;
            double endX = position.x + 10;
            double stepX = (endX - startX)/(numberBullet - 1);
            double startAngle = -120;
            double endAngle = -60;
            double stepAngle = (endAngle - startAngle)/(numberBullet - 1);

            for (int i = 0; i < numberBullet; i++) {
                PlayerBullet bullet = new PlayerBullet();
                bullet.position.set(startX + (stepX * i), position.y);
                bullet.velocity.setAngle(Math.toRadians(startAngle + stepAngle * i));
            }
            frameCount = 0;
        }
    }
}

