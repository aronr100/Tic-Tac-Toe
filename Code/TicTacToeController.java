import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToeController {
    private TicTacToeView view;
    private TicTacToeModel2 model;
   
    public TicTacToeController(TicTacToeModel2 m, TicTacToeView v) {
        model = m;
        view = v;
        hookUpListeners();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeModel2 model = new TicTacToeModel2();
            TicTacToeView view = new TicTacToeView();
            new TicTacToeController(model, view);
        });
    }
    public void hookUpListeners() {
        JButton[][] buttons = view.getButtons();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                final int r = row;
                final int c = col;

                buttons[r][c].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (model.placeMark(r, c)) {
                            buttons[r][c].setText(String.valueOf(model.getCurrentPlayer()));
                            buttons[r][c].setEnabled(false);

                            if (model.checkForWin()) {
                               view.setStatus("<html> <span style='color:#FFD720; font-weight:bold; font-size:25px;'>*Player " + model.getCurrentPlayer() + " is the winner!*</span></html>");
                                disableButtons();
                            } else if (model.isBoardFull()) {
                                view.setStatus("It is a draw!");
                                disableButtons();
                            } else {
                                model.switchPlayer();
                                view.setStatus("It is Player " + model.getCurrentPlayer() + "'s Turn");
                            }
                        }
                    }
                });
            }
        }
    }







    public void disableButtons() {
        JButton[][] buttons = view.getButtons();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setEnabled(false);
    }
}

