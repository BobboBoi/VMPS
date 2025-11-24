package nl.saxion.game.vmps.classes;

import nl.saxion.gameapp.GameApp;

public class InputAction {
    static public float getInputAxis(int key1, int key2) {
        return (GameApp.isKeyPressed(key1) ? 0 : 1) + (GameApp.isKeyPressed(key2) ? 0 : -1);
    }
}
