package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.game.vmps.Player;

public abstract class Collectible extends Object2D {
    public boolean attracted = false;
    public float attractionSpeed = 200f;
    public float globalX = 0f, globalY = 0f;

    public Collectible(Level level, float globalX, float globalY, float size) {
        super(level, globalX - level.cameraX + level.center.x - (size / 2), globalY - level.cameraY + level.center.y - (size / 2), size, size);

        this.globalX = globalX;
        this.globalY = globalY;

        addCircleHitbox(0f,0f,0.5f);
    }

    @Override
    public void render(float delta) {
        // Collect on contact
        if (((Level) scene).player.collidesWith(this)) {
            collected(((Level) scene).player);
            kill();
        }

        // Move to player when in collection range
        if (!attracted) {
            attracted = this.distanceTo(((Level) scene).player) <= ((Level) scene).player.collectionRange;
        }
        else {
            Vector2 dir = this.directionTo(((Level) scene).player);
            globalX = globalX + dir.x * delta * attractionSpeed;
            globalY = globalY + dir.y * delta * attractionSpeed;
        }

        // Bring x and y to the correct position for drawing to the screen
        x = globalX - scene.cameraX + scene.center.x - (width / 2);
        y = globalY - scene.cameraY + scene.center.y - (width / 2);
    }

    public abstract void collected(Player player);
}
