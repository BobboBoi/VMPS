package nl.saxion.game.vmps.classes;

import nl.saxion.game.vmps.Player;

import java.util.ArrayList;

public abstract class Weapon {
    public Player player;
    public int lvl = 1;
    public int maxLvl = 8;

    public float baseSpeed = 1f;

    public ArrayList<PlayerProjectile> projectiles = new ArrayList<>();

    public Weapon(Player player) {
        this.player = player;
    }

    public abstract void render(float delta);
}
