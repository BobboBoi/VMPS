package nl.saxion.game.vmps;

import nl.saxion.game.vmps.classes.Enemy;
import nl.saxion.game.vmps.classes.Level;
import nl.saxion.gameapp.GameApp;

public class Kerbe extends Enemy {
    public Kerbe(Level level, float x, float y) {
        super(level, x, y);
    }

    @Override
    public void init() {
        if (!GameApp.hasTexture("kerbe"))
            GameApp.addTexture("kerbe","textures/kerbe.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        GameApp.drawTexture("kerbe", x, y, width, height);
    }


}
