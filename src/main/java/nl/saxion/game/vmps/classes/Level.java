package nl.saxion.game.vmps.classes;

import nl.saxion.gameapp.GameApp;
import nl.saxion.gameapp.screens.ScalableGameScreen;
import java.util.ArrayList;

public abstract class Level extends ScalableGameScreen {
    protected boolean ready = false;
    protected double time = 0.;
    public ArrayList<Object2D> objects = new ArrayList<Object2D>();

    public Level(int worldWidth, int worldHeight) {
        super(worldWidth, worldHeight);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (!ready) {
            ready();
            this.ready = true;
        }

        this.time += delta;

        // Clear previous frame
        GameApp.clearScreen();

        // Render all level objects
        GameApp.startSpriteRendering();
        for (Object2D o : objects) {
            o.render(delta);
        }
        GameApp.endSpriteRendering();
    }

    public abstract void show();
    public abstract void hide();

    /**
     * Called on the first frame.
     */
    public abstract void ready();
}
