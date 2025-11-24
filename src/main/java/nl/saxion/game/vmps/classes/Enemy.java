package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;

public abstract class Enemy extends Object2D {
    public float size = 32;
    public float speed = 50f;
    public int health = 10;

    public float modifier = 1f;

    public float globalX = 0;
    public float globalY = 0;

    public Enemy(Level level, float x, float y) {
        super(level, 0, 0, 0, 0);

        this.globalX = x;
        this.globalY = y;

        width = size;
        height = size;
    }

    @Override
    public void render(float delta) {
        Level level = (Level) scene;

        x = globalX - level.player.getX() + level.center.x - (size / 2);
        y = globalY - level.player.getY() + level.center.y - (size / 2);
    }
}
