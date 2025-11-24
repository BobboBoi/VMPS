package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;

public abstract class Enemy extends Object2D {
    public float size = 32f;
    public float speed = 50f;
    public float health = 10f;
    public float dmg = 3f;

    public float modifier = 1f;

    public float globalX = 0f;
    public float globalY = 0f;

    public Enemy(Level level, float x, float y) {
        super(level, 0, 0, 0, 0);

        this.globalX = x;
        this.globalY = y;

        this.x = globalX - level.cameraX + level.center.x - (size / 2);
        this.y = globalY - level.cameraY + level.center.y - (size / 2);

        this.width = size;
        this.height = size;

        addCircleHitbox(0,0,0.5f);
    }

    public void render(float delta) {
        Level level = (Level) scene;

        Vector2 p = new Vector2(globalX, globalY);
        Vector2 c = new Vector2(level.cameraX, level.cameraY);
        Vector2 d = p.sub(c).nor();

        globalX -= d.x * delta * speed;
        globalY -= d.y * delta * speed;

        // Bring x and y to the correct position for drawing to the screen
        x = globalX - level.cameraX + level.center.x - (size / 2);
        y = globalY - level.cameraY + level.center.y - (size / 2);

        if (this.collidesWith(level.player))
            level.player.hit(dmg * delta);
    }
}
