package nl.saxion.game.vmps.screens;

import nl.saxion.game.vmps.Player;
import nl.saxion.game.vmps.classes.Level;

public class TestScreen extends Level {
    Player player = null;

    public TestScreen() {
        super(1280, 720);
    }

    @Override
    public void show() {
        player = new Player(this,640,360);
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
