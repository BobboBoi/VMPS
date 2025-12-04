package nl.saxion.game.vmps.weapons;

import com.badlogic.gdx.graphics.Texture;
import nl.saxion.game.vmps.Player;
import nl.saxion.game.vmps.classes.Weapon;
import nl.saxion.game.vmps.weapons.projectiles.BladeProjectile;
import nl.saxion.gameapp.GameApp;

public class BobboBlade extends Weapon {
    float cooldown = 2f;
    float time = 0f;

    public BobboBlade(Player player) {
        super(player);
        if (!GameApp.hasTexture("blade"))
            GameApp.addTexture("blade", "textures/sword.png", Texture.TextureFilter.Nearest);
    }

    @Override
    public void render(float delta) {
        time += delta;

        if (time > cooldown) {
            time -= cooldown;
            BladeProjectile p = new BladeProjectile(player, this, 0, 0);
        }
    }

    public float getCooldown() {
        return cooldown * baseSpeed * player.weaponSpeed;
    }
}
