package nl.saxion.game.vmps;

import nl.saxion.game.vmps.classes.Collectible;
import nl.saxion.game.vmps.classes.Level;

public class Gem extends Collectible {
    int value = 1;

    public Gem(Level level, float x, float y, float size) {
        super(level, x, y, size);
    }

    @Override
    public void collected(Player player) {
        player.setXp(player.xp + value);
    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (!isVisible()) return;
        drawHitboxes("red-500");
    }

    @Override
    public void deinit() {

    }
}
