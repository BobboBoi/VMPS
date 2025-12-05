package nl.saxion.game.vmps.screens;

import com.badlogic.gdx.Game;
import nl.saxion.game.vmps.Player;
import nl.saxion.game.vmps.classes.EnemyManager;
import nl.saxion.game.vmps.classes.Level;
import nl.saxion.gameapp.GameApp;

public class TestLevel extends Level {
    public TestLevel() {
        super(1280, 720);
    }

    @Override
    public void show() {
        this.player = new Player(this,640,360);
        this.enemies = new EnemyManager(this);

        if (!GameApp.hasFont("ui"))
            GameApp.addFont("ui", "fonts/basic.ttf", 30);

        if (!GameApp.hasMusic("castlepainia"))
            GameApp.addMusic("castlepainia","audio/music/CastlepainiaWIP.ogg");

        GameApp.playMusic("castlepainia",true, 0.7f);
    }

    @Override
    public void ready() {

    }

    @Override
    public void render(float delta) {
        enemies.spawn();
        super.render(delta);

        // Placeholder UI
        GameApp.startSpriteRendering();
        GameApp.drawText("ui", "Lvl: "+player.lvl, 0f, getWorldHeight() - 30,"white");
        GameApp.drawText("ui", "Hp: "+player.hp, 0f, getWorldHeight() - 70,"white");
        GameApp.drawText("ui", "Xp: "+player.xp+"/"+player.nextLvl, 0f, getWorldHeight() - 110,"white");
        GameApp.endSpriteRendering();
    }

    @Override
    public void hide() {
        if (GameApp.hasFont("basic"))
            GameApp.disposeFont("basic");

        if (GameApp.hasMusic("castlepainia")) {
            GameApp.stopMusic("castlepainia");
            GameApp.disposeMusic("castlepainia");
        }
    }
}
