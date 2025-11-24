package nl.saxion.game.vmps;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import nl.saxion.game.vmps.classes.InputAction;
import nl.saxion.game.vmps.classes.Level;
import nl.saxion.game.vmps.classes.Object2D;
import nl.saxion.gameapp.GameApp;

public class Player extends Object2D {
    static final float size = 32;
    public float speed = 200f;
    public float hp = 100f;
    public int xp = 0;
    public int lvl = 1;

    public Player(Level level, float x, float y) {
        super(level, x, y, size, size);
    }

    @Override
    public void init() {
        if (!GameApp.hasTexture("brick"))
            GameApp.addTexture("brick","textures/bricktherat.png");

        addCircleHitbox(0,0,0.5f);
    }

    @Override
    public void deinit() {
        if (GameApp.hasTexture("brick"))
            GameApp.disposeTexture("brick");
    }

    @Override
    public void render(float delta) {
        input(delta);
        draw(delta);
    }

    public void draw(float delta) {
        GameApp.drawTexture("brick",scene.center.x - size / 2, scene.center.y - size / 2, width, height);
    }

    public void input(float delta) {
        Level level = (Level) scene;
        Vector2 input = new Vector2(InputAction.getInputAxis(Input.Keys.A, Input.Keys.D), InputAction.getInputAxis(Input.Keys.S, Input.Keys.W));
        Vector2 normalizedInput = input.nor();

        // moveBy(normalizedInput.x * speed * delta, normalizedInput.y * speed * delta);
        level.cameraX += normalizedInput.x * speed * delta;
        level.cameraY += normalizedInput.y * speed * delta;
    }

    public void hit(float dmg) {
        hp -= dmg;
    }
}
