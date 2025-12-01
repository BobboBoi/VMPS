package nl.saxion.game.vmps.weapons.projectiles;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import nl.saxion.game.vmps.Player;
import nl.saxion.game.vmps.classes.*;
import nl.saxion.gameapp.GameApp;

public class BladeProjectile extends PlayerProjectile {
    public float lifetime = 1f;
    private float timer = 0f;

    public BladeProjectile(Player player, Weapon weapon, float x, float y) {
        super(player, weapon, x, y, 76f, 20f);

        dmg = 5f;
        lifetime *= getDuration(); // Set lifetime at start

        // Set rotation
        addHitbox(0, 0f, getSize(), getSize());

        Vector2 input = new Vector2(InputAction.getInputAxis(Input.Keys.A, Input.Keys.D), InputAction.getInputAxis(Input.Keys.S, Input.Keys.W));
        Vector2 normalizedInput = input.nor();

        this.rotation = (float) Math.toDegrees(Math.atan2(normalizedInput.y, normalizedInput.x));
    }

    @Override
    public void init() {

    }

    @Override
    public void deinit() {

    }

    @Override
    public void render(float delta) {
        timer += delta;
        if (timer >= lifetime)
            kill();

        // Calculate collisions
        for (int i = 0; i < player.scene.objects.size(); i++) {
            Object2D obj = player.scene.objects.get(i);
            if (ignore.contains(obj))
                continue;

            if (obj instanceof Enemy && collidesWith(obj)) {
                ((Enemy) obj).hit(getDmg());
                ignore.add(obj);

                // Move back one index to compensate for moved indexes
                if (obj.isFreeing())
                    i -= 1;
            }
        }

//        GameApp.startShapeRenderingFilled();
//        drawHitboxes("red-500");
//        GameApp.endShapeRendering();

        GameApp.drawTexture("blade", x, y, width, height, rotation, false, false);
    }
}
