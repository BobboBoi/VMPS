package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.gameapp.GameApp;
import nl.saxion.gameapp.screens.ScalableGameScreen;
import java.util.ArrayList;

/** Wrapper class for ScalableGameScreen that allows the use of Object2D **/
public abstract class Scene extends ScalableGameScreen {
    protected boolean ready = false;

    protected double time = 0.;
    public final Vector2 size;
    public final Vector2 center;

    public ArrayList<Object2D> objects = new ArrayList<Object2D>();

    public Scene(int worldWidth, int worldHeight) {
        super(worldWidth, worldHeight);

        this.size = new Vector2(worldWidth, worldHeight);
        this.center = new Vector2((float) worldWidth / 2, (float) worldHeight / 2);
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
        GameApp.startShapeRenderingFilled();
        GameApp.startSpriteRendering();

        for (int i = 0; i < objects.size(); i++)
            objects.get(i).render(delta);

        GameApp.endSpriteRendering();
        GameApp.endShapeRendering();
    }

    @Override
    public void hide() {
        for (Object2D o : objects)
            o.deinit();
    }

    public abstract void show();

    /**
     * Called on the first frame.
     */
    public abstract void ready();
}
