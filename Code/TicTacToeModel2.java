public class TicTacToeModel2 {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeModel2() {
        board = new char[3][3];
        currentPlayer = 'X';
        initialiseBoard();
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getMark(int row, int col) {
        return board[row][col];
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }
         // this checks if the player has won after a move
    public boolean checkForWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    public void resetBoard() {
        currentPlayer = 'X';
        initialiseBoard();
    }

    private void initialiseBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++)
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;
        return false;
    }

    private boolean checkColumns() {
        for (int j = 0; j < 3; j++)
            if (board[0][j] == currentPlayer &&
                board[1][j] == currentPlayer &&
                board[2][j] == currentPlayer)
                return true;
        return false;
    }
    private boolean checkDiagonals() {
        return (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer);
    }
}


