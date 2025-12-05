package nl.saxion.game.vmps;

import nl.saxion.game.vmps.classes.Enemy;
import nl.saxion.game.vmps.classes.EnemyManager;
import nl.saxion.game.vmps.classes.Level;
import nl.saxion.gameapp.GameApp;

public class Kerbe extends Enemy {
    public Kerbe(EnemyManager enemyManager, Level level, float x, float y) {
        super(enemyManager, level, x, y);
    }

    @Override
    public void init() {
        if (!GameApp.hasTexture("kerbe"))
            GameApp.addTexture("kerbe","textures/kerbe.png");
    }

    @Override
    public void deinit() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (!isVisible()) return;
        GameApp.drawTexture("kerbe", x, y, width, height);
    }
}
