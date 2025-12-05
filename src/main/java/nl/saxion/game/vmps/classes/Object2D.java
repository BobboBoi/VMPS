package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.game.vmps.classes.collision.FixedPolygonHitbox;
import nl.saxion.gameapp.GameApp;
import nl.saxion.gameapp.gameobject.RotatableGameObject;
import nl.saxion.gameapp.gameobject.hitbox.PolygonHitbox;

public abstract class Object2D extends RotatableGameObject {
    /** The Scene that this object is in. **/
    public Scene scene = null;
    /** If true object is in process of being freed **/
    private boolean freeing = false;

    public Object2D(Scene scene) {
        super(0,0,32,32);
        this.scene = scene;
        init();

        this.scene.objects.add(this);
    }
    public Object2D(Scene scene, Vector2 position){
        super(position.x, position.y,32,32);
        this.scene = scene;
        init();

        this.scene.objects.add(this);
    }
    public Object2D(Scene scene, float x, float y) {
        super(x,y,32,32);
        this.scene = scene;
        init();

        this.scene.objects.add(this);
    }
    public Object2D(Scene scene, float x, float y, float width, float height) {
        super(x,y,width,height);
        this.scene = scene;
        init();

        this.scene.objects.add(this);
    }

    public abstract void init();
    public abstract void deinit();
    public abstract void render(float delta);

    @Override
    public void setRotation(float rotation) {
        for (int i = 0; i < hitboxes.size(); i++) {
            if(hitboxes.get(i) instanceof PolygonHitbox)
                ((PolygonHitbox) hitboxes.get(i)).setRotation(rotation);
        }

        this.rotation = rotation;
    }

    @Override
    public void addHitbox(float relOffsetX, float relOffsetY, float relWidth, float relHeight) {
        float[] vertices = new float[]{
                relOffsetX, relOffsetY,
                relOffsetX + relWidth, relOffsetY,
                relOffsetX + relWidth, relOffsetY + relHeight,
                relOffsetX, relOffsetY + relHeight
        };

        // Use FixedPolygonHitbox patch for PolygonHitbox as it fixes the fact that the origin of the hit box is never modified
        // Common Saxion L
        hitboxes.add(new FixedPolygonHitbox(this, vertices));
    }


    /**
     * Remove object from the scene objects list
     * !UNTESTED!
     **/
    public void kill(){
        freeing = true;

        deinit();
        scene.objects.remove(this);
    }

    /**
     * Check if object is in process of being freed
     * @return freeing
     */
    public boolean isFreeing(){
        return freeing;
    }

    public boolean isVisible(){
        return isVisible(this.x, this.y, this.width, this.height);
    }
    public boolean isVisible(float x, float y){
        return isVisible(x, y, this.width, this.height);
    }
    public boolean isVisible(float x, float y, float width, float height){
        return x - width / 2 < GameApp.getWorldWidth() || x + width / 2 > 0 || y - height / 2 < GameApp.getWorldHeight() || y + width / 2 > 0;
    }
}

