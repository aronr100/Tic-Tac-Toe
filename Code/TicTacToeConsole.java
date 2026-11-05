import java.util.Scanner;

public class TicTacToeConsole {
    private TicTacToeModel2 modelBoard;
    private int usersCol;
    private int usersRow;
    private Scanner inputScan;
   
   

    public TicTacToeConsole(TicTacToeModel2 m) {
        modelBoard = m;
        inputScan = new Scanner(System.in);
    }

    public static void main(String[] args) {
        TicTacToeModel2 model = new TicTacToeModel2();
        TicTacToeConsole game = new TicTacToeConsole(model);
        game.playTiTaTo();
    }

    public void playTiTaTo() {
        boolean gameEnded = false;
        System.out.println("Welcome to the TicTacToe game!");



        while (!gameEnded) {
            showDisplayBoard();
            System.out.println("Player " + modelBoard.getCurrentPlayer() + ", please enter your move (TIP:rows[0-2] and columns[0-2]):");
            usersRow = inputScan.nextInt();
            usersCol = inputScan.nextInt();

            if (!modelBoard.placeMark(usersRow,usersCol)) {
                System.out.println("You can't play that move! Please try again.");
                continue;
            }

            if (modelBoard.checkForWin()) {
                showDisplayBoard();
                System.out.println("Player " + modelBoard.getCurrentPlayer() + " is the victor!");
                gameEnded = true;
            } else if (modelBoard.isBoardFull()) {
                showDisplayBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                modelBoard.switchPlayer();
            }
        }
    }

    public void showDisplayBoard() {
        System.out.println("The Current board:    ");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                char mark = modelBoard.getMark(i, j);
                System.out.print((mark == ' ') ? "_" : mark);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i<2) System.out.println("---------");
        }
    }
}




