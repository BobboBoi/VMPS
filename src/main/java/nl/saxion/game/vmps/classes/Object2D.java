package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.gameapp.gameobject.RotatableGameObject;

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


    /**
     * Remove object from the scene objects list
     * !UNTESTED!
     **/
    public void kill(){
        freeing = true;

        deinit();
        scene.objects.remove(this);
    }

    public boolean isFreeing(){
        return freeing;
    }
}

