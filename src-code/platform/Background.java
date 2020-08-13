package game;

public class Background extends GameObject {
    public Background() {
        renderer = new Renderer("assets/images/background/0.png");
        position.set(0, Settings.GAME_HEIGHT - Settings.BACKGROUND_HEIGHT);
        velocity.set(0, 1);
        anchor.set(0, 0);
    }

    @Override
    public void run() {
        super.run();
        if (position.y >= 0) {
            position.y = 0;
        }
    }
}

