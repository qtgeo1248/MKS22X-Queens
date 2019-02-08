import java.lang.Math;

public class QueenBoard {

    private int[][] board;

    public QueenBoard(int size) {
        board = new int[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0; //0 represents a non-attacked space
            }
        }
    }

    public String toStringSupposedToBe() { //this is what's it supposed to be for the assignment
        String output = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) { //puts in the chars
                if (board[i][j] == -1) { //-1 represents queen
                    output += "Q ";
                    System.out.println("a");
                } else {
                    output += "_ ";
                }
            }
            output = output.substring(0, output.length()- 1) + "\n"; //removes extra space
        }
        return output.substring(0, output.length() - 1); //removes extra \n
    }

    public String toString() { //this is only for debugging purposes
        String output = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1) {
                    output += "Q ";
                } else {
                    output += board[i][j] + " ";
                }
            }
            output = output.substring(0, output.length() - 1) + "\n"; //removes extra space
        }
        return output.substring(0, output.length() - 1); //removes extra \n
    }

    public boolean addQueen(int r, int c) { //REMEMBER PRIVATE //this function adds a queen only if the space is zero
        if (board[r][c] == 0) {
            board[r][c] = -1;
            for (int i = c; i < board[r].length; i++) { //adds everything in row
                if (board[r][i] != -1) {
                    board[r][i]++;
                }
            }
            for (int i = 0; c + i < board[r].length && r + i < board.length; i++) { //adds everything in top left to bottom right diagonal
                if (board[r + i][c + i] != -1) {
                    board[r + i][c + i]++;
                }
            }
            for (int i = 0; c + i < board[r].length && r - i >= 0; i++) { //adds everything in bottom left to top right diagonal
                if (board[r - i][c + i] != -1) {
                    board[r - i][c + i]++;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    public boolean removeQueen(int r, int c) { //REMEMBER PRIVATE //this function removes queen only if it exists
        if (board[r][c] == -1) {
            for (int i = c; i < board[r].length; i++) { //subtractrs everything in row
                if (board[r][i] != -1) {
                    board[r][i]--;
                }
            }
            for (int i = 0; c + i < board[r].length && r + i < board.length; i++) { //subtracts everything in top left to bottom right diagonal
                if (board[r + i][c + i] != -1) {
                    board[r + i][c + i]--;
                }
            }
            for (int i = 0; c + i < board[r].length && r - i >= 0; i++) { //subtracts everything in bottom left to top right diagonal
                if (board[r - i][c + i] != -1) {
                    board[r - i][c + i]--;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
