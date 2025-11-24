package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.game.vmps.Kerbe;
import nl.saxion.gameapp.GameApp;

import java.util.ArrayList;

public class EnemyManager {
    public Level level;
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public float safeZone = 100;
    public int maxEnemyCount = 20;

    public EnemyManager(Level level) {
        this.level = level;
    }

    public void spawn() {
        while(enemies.size() < maxEnemyCount) {
            Vector2 pos = Vector2.Zero;
            while(pos.len() < safeZone)
                pos = new Vector2(GameApp.random(-level.center.x, level.center.x), GameApp.random(-level.center.y, level.center.y));

            pos = pos.add(level.center);
            enemies.add(new Kerbe(level, pos.x , pos.y));
        }
    }

}
