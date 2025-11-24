package nl.saxion.game.vmps;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import nl.saxion.game.vmps.classes.InputAction;
import nl.saxion.game.vmps.classes.Level;
import nl.saxion.game.vmps.classes.Object2D;
import nl.saxion.gameapp.GameApp;

public class Player extends Object2D {
    static final float size = 32;

    public double speed = 200.;

    public Player(Level level, float x, float y) {
        super(level, x, y, size, size);
    }

    @Override
    public void init() {
        if (!GameApp.hasTexture("brick"))
            GameApp.addTexture("brick","textures/bricktherat.png");
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
        Vector2 input = new Vector2(InputAction.getInputAxis(Input.Keys.A, Input.Keys.D), InputAction.getInputAxis(Input.Keys.S, Input.Keys.W));
        Vector2 normalizedInput = input.nor();

//        System.out.println(input.x + " " + input.y);

        this.x += (float) (normalizedInput.x * speed * delta);
        this.y += (float) (normalizedInput.y * speed * delta);
    }
}
