package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.gameapp.gameobject.GameObject;

public abstract class Object2D extends GameObject {
    /** The Scene that this object is in. **/
    protected Scene scene = null;

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
}

