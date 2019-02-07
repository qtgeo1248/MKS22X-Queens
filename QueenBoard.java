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

    public String toString() {
        String output = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

            }
        }
        return output;
    }
}
