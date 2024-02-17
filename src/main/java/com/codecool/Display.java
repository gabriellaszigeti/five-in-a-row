package com.codecool.fiveinarow;

import java.util.Locale;
import java.util.Scanner;

public class Display {

    public String greenColor = "\u001b[32;1m";
    public String redColor = "\u001b[31;1m";
    public String blueColor = "\033[1;94m";
    public String yellowColor = "\u001b[35;1m";
    public String closeTag = "\u001b[0m";


    public void printBoard(int[][] board) {
        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder displayBoard = new StringBuilder("  ");
        for (int row = 0; row < board.length; row++) {
            displayBoard.append(row + 1).append("  ");
        }
        displayBoard.append("\n");
        for (int row = 0; row < board.length; row++) {
            displayBoard.append(abc[row]).append("  ");
            for (int col = 0; col < board[row].length; col++) {
                switch (board[col][row]) {
                    case 1:
                        displayBoard.append(blueColor).append("X  ").append(closeTag);
                        break;
                    case 2:
                        displayBoard.append(yellowColor).append("O  ").append(closeTag); // this is the same as = displayBoard.append( yellowColor + "O  " + closeTag);
                        break;
                    default:
                        displayBoard.append(".  ");
                }
            }
            displayBoard.append("\n");
        }
        System.out.println(displayBoard);
    }


    public void printResult(int player) {
        if (player == 1) {
            System.out.println("\n" + "X won!");
        } else if (player == 2) {
            System.out.println("\n" + "O won!");
        }
    }


    public  void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public void displayTurn(int player) {
        if (player == 1) {
            System.out.println("It's " + blueColor + "X" + closeTag + "-s turn!");
        } else {
            System.out.println("It's " + yellowColor + "O" + closeTag + "-s turn!");
        }
    }


    public String menu(){
        Scanner gameMode = new Scanner(System.in);
        System.out.println(greenColor + "Welcome to five in a row game!\n" + closeTag);
        System.out.println(greenColor + "Choose game mode:\n" + closeTag);
        System.out.println(greenColor + "(1) Human-Human\n"+ closeTag );
        System.out.println(greenColor + "(2) Human-Ai\n"+ closeTag );
        return gameMode.next();
    }

    public void  ascii(){
        String ascii =

        greenColor +
        "     |     |     |     |     |     |\n" +
        "     |  1  |  2  |  3  |  4  |  5  |\n" +
        "_____|_____|_____|_____|_____|_____|\n" +
        "     |     |     |     |     |     |\n" +
        "  A  |  .  |  .  |  .  |  O  |  .  |\n" +
        "_____|_____|_____|_____|_____|_____|\n" +
        "     |     |     |     |     |     |\n" +
        "  B  |  O  |  X  |  X  |  O  |  X  |\n" +
        "_____|_____|_____|_____|_____|_____|\n" +
        "     |     |     |     |     |     |\n" +
        "  C  |  O  |  .  |  .  |  0  |  .  |\n" +
        "     |     |     |     |     |     |\n" + closeTag;

    System.out.println(ascii);}


}