package nl.saxion.game.vmps.classes;

import nl.saxion.gameapp.gameobject.RotatableGameObject;

import java.util.ArrayList;

public abstract class Projectile extends Object2D {
    public float duration = 1f;
    public float speed = 1f;
    public float size = 1f;
    public float dmg = 1f;

    /** ignore list for collisions **/
    public ArrayList<Object2D> ignore = new ArrayList<>();

    public Projectile(Scene scene, float x,  float y, float width, float height) {
        super(scene, x,y,width,height);
    }

    public abstract void init();
    public abstract void deinit();
    public abstract void render(float delta);

    /** Clear the ignore list **/
    public void resetIgnoreList() {
        ignore.clear();
    }
}
