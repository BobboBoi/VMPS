package nl.saxion.game.vmps;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import nl.saxion.game.vmps.classes.*;
import nl.saxion.game.vmps.weapons.BobboBlade;
import nl.saxion.gameapp.GameApp;

import java.util.ArrayList;

public class Player extends Object2D {
    static final float size = 32;
    public float speed = 200f;
    public float hp = 100f;
    public int xp = 0;
    public int lvl = 1;
    public int nextLvl = 10;

    public float dmg = 1f;
    public float weaponSpeed = 1f;
    public float projectileSpeed = 1f;
    public float projectileSize = 1.5f;
    public float projectileDuration = 1f;
    public float collectionRange = 50f;

    public float facing = 0f;

    public ArrayList<Weapon> weapons;
    public ArrayList<PlayerProjectile> projectiles;

    public Player(Level level, float x, float y) {
        super(level, x, y, size, size);
    }

    @Override
    public void init() {
        if (!GameApp.hasTexture("brick"))
            GameApp.addTexture("brick", "textures/bricktherat.png", Texture.TextureFilter.Nearest);

        weapons = new ArrayList<>();
        projectiles = new ArrayList<>();

        weapons.add(new BobboBlade(this)); // starter weapon
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

        for (Weapon weapon : weapons)
            weapon.render(delta);
    }

    public void draw(float delta) {
        GameApp.drawTexture("brick",scene.center.x - size / 2, scene.center.y - size / 2, width, height);
    }

    public void input(float delta) {
        Level level = (Level) scene;
        Vector2 input = new Vector2(InputAction.getInputAxis(Input.Keys.A, Input.Keys.D), InputAction.getInputAxis(Input.Keys.S, Input.Keys.W));
        Vector2 normalizedInput = input.nor();

        // Set facing direction used by some weapons
        if (normalizedInput.x != 0f || normalizedInput.y != 0f)
            facing = (float) Math.toDegrees(Math.atan2(normalizedInput.y, normalizedInput.x));

        // moveBy(normalizedInput.x * speed * delta, normalizedInput.y * speed * delta);
        level.cameraX += normalizedInput.x * speed * delta;
        level.cameraY += normalizedInput.y * speed * delta;
    }

    public void levelUp() {
        if(this.xp < nextLvl) return;

        this.lvl++;
        this.xp -= this.nextLvl;
        //noinspection PointlessArithmeticExpression NO INTELLIJ THIS IS NOT WORTH A WARNING STFU
        this.nextLvl = this.nextLvl * (this.lvl + 1 / 4);

        // TODO item upgrade menu
    }

    public void setXp(int xp) {
        this.xp = xp;
        while(this.xp >= nextLvl)
            levelUp();
    }

    public void hit(float dmg) {
        hp -= dmg;
    }
}
