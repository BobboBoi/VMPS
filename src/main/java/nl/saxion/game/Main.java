package nl.saxion.game;

import nl.saxion.game.vmps.screens.MainMenuScreen;
import nl.saxion.game.vmps.screens.TestScreen;
import nl.saxion.gameapp.GameApp;

public class Main {
    public static void main(String[] args) {
        // Add screens
        GameApp.addScreen("MainMenuScreen", new MainMenuScreen());
        GameApp.addScreen("TestScreen", new TestScreen());

        // Start game loop and show main menu screen
        GameApp.start("Your Game Name", 800, 450, 60, false, "MainMenuScreen");
    }
}
