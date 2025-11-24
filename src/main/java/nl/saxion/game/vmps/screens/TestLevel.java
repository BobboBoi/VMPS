package nl.saxion.game.vmps.screens;

import nl.saxion.game.vmps.Player;
import nl.saxion.game.vmps.classes.EnemyManager;
import nl.saxion.game.vmps.classes.Level;

public class TestLevel extends Level {
    public TestLevel() {
        super(1280, 720);
    }

    @Override
    public void show() {
        this.player = new Player(this,640,360);
        this.enemies = new EnemyManager(this);
    }

    @Override
    public void ready() {
        System.out.println("Ready");
    }

    @Override
    public void render(float delta) {
        enemies.spawn();
        super.render(delta);
    }

    @Override
    public void hide() { }
}
