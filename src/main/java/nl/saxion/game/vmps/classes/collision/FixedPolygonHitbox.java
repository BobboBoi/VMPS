package nl.saxion.game.vmps.classes.collision;

import com.badlogic.gdx.math.Polygon;
import nl.saxion.gameapp.gameobject.GameObject;
import nl.saxion.gameapp.gameobject.hitbox.PolygonHitbox;

/** Patched class for PolygonHitbox that actually uses the origin **/
public class FixedPolygonHitbox extends PolygonHitbox {
    /**
     * Creates a new polygon hitbox relative to the parent GameObject.
     *
     * @param parent      the GameObject this hitbox belongs to
     * @param relVertices array of vertices (x1,y1,x2,y2,...) in 0–1 percentages
     */
    public FixedPolygonHitbox(GameObject parent, float[] relVertices) {
        super(parent, relVertices);
    }

    @Override
    public Polygon getAbsolutePolygon() {
        float[] absVerts = new float[getRelVertices().length];
        for (int i = 0; i < getRelVertices().length; i += 2) {
            absVerts[i] = parent.getX() + getRelVertices()[i] * parent.getWidth();
            absVerts[i + 1] = parent.getY() + getRelVertices()[i + 1] * parent.getHeight();
        }

        getPolygon().setOrigin(parent.getX(), parent.getY()); // Fix
        getPolygon().setVertices(absVerts);
        return getPolygon();
    }
}
