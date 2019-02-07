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
}
