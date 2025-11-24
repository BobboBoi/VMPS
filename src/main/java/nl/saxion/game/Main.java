package nl.saxion.game;

import nl.saxion.game.vmps.screens.MainMenuScreen;
import nl.saxion.game.vmps.screens.TestLevel;
import nl.saxion.gameapp.GameApp;

public class Main {
    public static void main(String[] args) {
        // Add screens
        GameApp.addScreen("MainMenuScreen", new MainMenuScreen());
        GameApp.addScreen("TestScreen", new TestLevel());

        // Start game loop and show main menu screen
        GameApp.start("VMPS", 1280, 720, 60, false, "MainMenuScreen");
    }
}
