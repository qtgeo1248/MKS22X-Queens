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

    public String toString() { //this is what's it supposed to be for the assignment
        String output = "";
        if (board.length == 0) {
            return output;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) { //puts in the chars
                if (board[i][j] == -1) { //-1 represents queen
                    output += "Q ";
                } else {
                    output += "_ ";
                }
            }
            output = output.substring(0, output.length()- 1) + "\n"; //removes extra space
        }
        return output.substring(0, output.length() - 1); //removes extra \n
    }

    private String toStringDebug() { //this is only for debugging purposes
        String output = "";
        if (board.length == 0) {
            return output;
        }
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

    private boolean addQueen(int r, int c) { //REMEMBER PRIVATE //this function adds a queen only if the space is zero
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
    private boolean removeQueen(int r, int c) { //REMEMBER PRIVATE //this function removes queen only if it exists
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
            board[r][c] = 0;
            return true;
        } else {
            return false;
        }
    }

    public boolean solve() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        if (board.length == 0) {
            return true;
        }
        return solveHelp(0, 0); //temp for now while testing
    }
    private boolean solveHelp(int c, int prevRow) {
        if (c == board[0].length) { //base case
            return true;
        } else {
            boolean isTrue = false;
            for (int i = 0; i < board.length; i++) {
                if (board[i][c] == 0) { //case when you find a spot to put a queen
                    addQueen(i, c);
                    isTrue = solveHelp(c + 1, i) || isTrue;
                }
            }
            if (isTrue) {
                return isTrue;
            } else {
                if (c != 0) {
                    removeQueen(prevRow, c - 1); //this removes the previous queen so you can retry a different one
                }
                return false;
            }
        }
    }

    public int countSolutions() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        if (board.length == 0) {
            return 1;
        }
        return countHelp(0, 0); //temp
    }
    private int countHelp(int c, int prevRow) {
        if (c == board[0].length) {
            removeQueen(prevRow, c - 1);
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][c] == 0) {
                    addQueen(i, c);
                    count += countHelp(c + 1, i);
                }
            }
            if (c != 0) {
                removeQueen(prevRow, c - 1);
            }
            return count;
        }
    }
}
