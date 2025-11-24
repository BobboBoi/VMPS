package nl.saxion.game.vmps.classes;

import nl.saxion.game.vmps.Player;

/** A playable level **/
public abstract class Level extends Scene {
    public Player player = null;
    public EnemyManager enemies = null;

    public float cameraX = 0;
    public float cameraY = 0;

    public Level(int worldWidth, int worldHeight) {
        super(worldWidth, worldHeight);
    }

    public abstract void show();
    public abstract void hide();
    public abstract void ready();
}
