package nl.saxion.game.vmps.screens;

import nl.saxion.game.vmps.Kerbe;
import nl.saxion.game.vmps.Player;
import nl.saxion.game.vmps.classes.Enemy;
import nl.saxion.game.vmps.classes.Level;

public class TestScreen extends Level {
    public Enemy enemy = null;

    public TestScreen() {
        super(1280, 720);
    }

    @Override
    public void show() {
        this.player = new Player(this,640,360);
        enemy = new Kerbe(this, center.x, center.y);
    }

    @Override
    public void ready() {
        System.out.println("Ready");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void hide() { }
}
