package nl.saxion.game.vmps.weapons.projectiles;

import nl.saxion.game.vmps.Player;
import nl.saxion.game.vmps.classes.*;
import nl.saxion.gameapp.GameApp;

public class BladeProjectile extends PlayerProjectile {
    public float lifetime = 1f;
    private float timer = 0f;
    private float spriteOffset = 76f;

    public BladeProjectile(Player player, Weapon weapon, float x, float y) {
        super(player, weapon, player.getX(), player.getY(), 76f, 20f);

        dmg = 5f;
        lifetime *= getDuration(); // Set lifetime at start

        spriteOffset *= getSize();
        width *= getSize();
        height *= getSize();

        addHitbox(0f, -0.5f, 1f, 1f);

        // Set rotation after defining hitbox
        this.setRotation(player.facing);
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
                System.out.println("Hit: "+obj);

                // Move back one index to compensate for moved indexes
                if (obj.isFreeing())
                    i -= 1;
            }
        }

        float drawX = x + ((float) Math.cos(Math.toRadians(this.rotation)) * spriteOffset / 2) - spriteOffset / 2;
        float drawY = y + ((float) Math.sin(Math.toRadians(this.rotation)) * spriteOffset / 2) - spriteOffset / 2;
        drawY += height / 2 + player.getHeight() / 2 + 2;

        GameApp.drawTexture("blade", drawX, drawY, width, height, rotation, false, false);
    }
}
