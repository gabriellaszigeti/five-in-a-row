package com.codecool.fiveinarow;

public class FiveInARow {

    public static void main(String[] args) {
        Display display = new Display();  /// Display is the type= its a class , and the new object is created from it
        Game game = new Game(11, 11, display); // as a parameter the newly created object of the class is given to the game object
        game.enableAi(1);
        game.enableAi(2);
        game.play(5);

    }
}