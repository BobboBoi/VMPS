package nl.saxion.game.vmps.classes;

import nl.saxion.game.vmps.Player;

public abstract class PlayerProjectile extends Projectile {
    public Player player = null;
    public Weapon weapon = null;

    public PlayerProjectile(Player player, Weapon weapon, float x,  float y, float width, float height) {
        super(player.scene, player.getX(), player.getY(), width, height);
        this.player = player;
        this.weapon = weapon;

        player.projectiles.add(this);
        weapon.projectiles.add(this);
    }

    public abstract void init();
    public abstract void deinit();
    public abstract void render(float delta);

    @Override
    public void kill(){
        super.kill();
        this.player.projectiles.remove(this);
        this.weapon.projectiles.remove(this);
    }

    public float getSize() {
        return player.projectileSize * size;
    }

    public float getSpeed() {
        return player.projectileSpeed * speed;
    }

    public float getDuration() {
        return player.projectileDuration * duration;
    }

    public float getDmg() {
        return player.dmg * dmg;
    }
}
