package com.codecool.fiveinarow;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game implements GameInterface {

    private int[][] board;
    private Display display; // initialize the Display typed display

    public Game(int nRows, int nCols, Display display) { // as parameter we give display to the constructor
        board = new int[nRows][nCols];
        for (int row = 0; row < nRows; row++) {
            for (int column = 0; column < nCols; column++) {
                board[row][column] = 0;
            }
        }
        this.display = display;  //
    }


    public int[][] getBoard() { // The getter method returns the value of the attribute.
        return board;
    }


    public void setBoard(int[][] board) { //The setter method takes a parameter and assigns it to the attribute.
        this.board = board;
    }


    public int[] getMove(int player) {
        String input = getInput();
        char row = input.charAt(0);
        char column = input.charAt(1);
        int rowValue = (int) row - 65;
        int columnValue = Character.getNumericValue(column);
        //System.out.println("You chose:" + Arrays.toString(coords));
        return new int[]{columnValue, rowValue};
    }


    public boolean checkIfValidCoordinate(int rowVal, int columnVal) { // TO-D0 check if coord is out of range, or if the input is valid
        String errorMessage = display.redColor + "The coordinate is already taken!" + display.closeTag;
        if (board[rowVal][columnVal] != 0) {
            System.out.println(errorMessage);
            return false;
        } else {
            return true;
        }
    }


    public String getInput() { // TO-DO correct this + add check on the input if its a char and an integer !
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a coordinate!");
//        if (input.next().equals("quit")) {
//            quitGame();
//            return null;
//        } else {
        return input.next().toUpperCase(Locale.ROOT);
    }


    public int[] getAiMove(int player) {
        int row = 0;
        int col = 0;
        while (board[row][col] == 0) {
            row = (int) (Math.random() * board.length);
            col = (int) (Math.random() * board[0].length);
        }
        System.out.println(row);
        return new int[]{row, col};

    }


    public void mark(int player, int row, int col) {
        int playerValue;
        if (player == 1) {
            playerValue = 1;
        } else {
            playerValue = 2;
        }
        board[row][col] = playerValue;
    }


    public boolean hasWon(int player, int howMany) { // T0-DO  column and row checking should be separated into two functions?
        return false;
    }


    public boolean isFull() {
        for (int[] row : board) {
            for (int column : row) {
                if (column == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public void enableAi(int player) {
        player = 2;
    }


    public int[] getAiMove() {
        return null;
    }


    public void quitGame() {
        System.out.println("Thanks for playing! Bye!");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("Interrupted "
                    + "while Sleeping");
        }
        System.exit(0);
    }


    public void play(int howMany) {
        display.ascii();
        String gameMode = display.menu();
        System.out.println(gameMode);
        int player = 1;
        while (true) {
            display.printBoard(board);
            display.displayTurn(player);
            int[] coords = getMove(player);
            int row = coords[0];
            int col = coords[1];
            if (checkIfValidCoordinate(row, col)) {
                mark(player, row, col);
            }
            display.clearScreen();
            if (hasWon(player, howMany)) {
                display.printBoard(board);
                display.printResult(player);
                quitGame();
            }
            if (isFull()) {
                quitGame();
            }
            player = player == 1 ? 2 : 1;
        }
    }
}
