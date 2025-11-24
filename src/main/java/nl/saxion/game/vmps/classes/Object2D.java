package nl.saxion.game.vmps.classes;

import com.badlogic.gdx.math.Vector2;
import nl.saxion.gameapp.gameobject.GameObject;

public abstract class Object2D extends GameObject {
    /** The Level that this object is in. **/
    protected Level level = null;

    public Object2D(Level level) {
        super(0,0,32,32);
        this.level = level;
        init();

        this.level.objects.add(this);
    }

    public Object2D(Level level, Vector2 position){
        super(position.x, position.y,32,32);
        this.level = level;
        init();

        this.level.objects.add(this);
    }

    public Object2D(Level level, float x, float y) {
        super(x,y,32,32);
        this.level = level;
        init();

        this.level.objects.add(this);
    }

    public Object2D(Level level, float x, float y, float width, float height) {
        super(x,y,width,height);
        this.level = level;
        init();

        this.level.objects.add(this);
    }

    public abstract void init();
    public abstract void render(float delta);
    public abstract void draw(float delta);
}

