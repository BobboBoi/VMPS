package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.game.vmps.Kerbe;
import nl.saxion.gameapp.GameApp;

import java.util.ArrayList;

public class EnemyManager {
    public Level level;
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public float safeZone = 300f;
    public int maxEnemyCount = 30;

    public EnemyManager(Level level) {
        this.level = level;
    }

    public void spawn() {
        // Despawn distant enemies
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            if (e.getX() > level.getWorldWidth() || e.getX() < 0 ||
                e.getY() > level.getWorldHeight() || e.getY() < 0)
                e.kill();
        }

        while(enemies.size() < maxEnemyCount) {
            Vector2 pos = Vector2.Zero;
            while(pos.len() < safeZone)
                pos = new Vector2(GameApp.random(-level.center.x, level.center.x), GameApp.random(-level.center.y, level.center.y));

            enemies.add(new Kerbe(this, level, pos.x + level.cameraX, pos.y + level.cameraY));
        }
    }

}
