package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.gameapp.GameApp;

public abstract class Enemy extends Object2D {
    protected EnemyManager enemyManager;
    public float size = 32f;
    public float speed = 50f;
    public float hp = 10f;
    public float dmg = 3f;

    public float modifier = 1f;

    public float globalX = 0f;
    public float globalY = 0f;

    public Enemy(EnemyManager enemyManager, Level level, float x, float y) {
        super(level, 0, 0, 0, 0);
        this.enemyManager = enemyManager;

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

        // Calculate global position and movement direction
        Vector2 p = new Vector2(globalX, globalY);
        Vector2 c = new Vector2(level.cameraX, level.cameraY);
        Vector2 d = p.sub(c).nor();

        globalX -= d.x * delta * speed;
        globalY -= d.y * delta * speed;

        // Bring x and y to the correct position for drawing to the screen
        x = globalX - level.cameraX + level.center.x - (size / 2);
        y = globalY - level.cameraY + level.center.y - (size / 2);

        // Deal damage
        if (this.collidesWith(level.player))
            level.player.hit(dmg * delta);

        // Enemy on Enemy Collision
        for (Enemy obj : level.enemies.enemies) {
            if (this.collidesWith(obj)) {
                float distance = (obj.getWidth() - obj.distanceTo(this)) / 2;
                Vector2 dir = obj.directionTo(this);

                // Move this instance
                globalX += distance * dir.x;
                globalY += distance * dir.y;
            }
        }
    }

    public void hit(float dmg) {
        hp -= dmg;

        // Die when hp hits below 0
        if (hp <= 0)
            kill();
    }

    @Override
    public void kill() {
        super.kill();
        enemyManager.enemies.remove(this);
    }
}
