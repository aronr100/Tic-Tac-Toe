import java.awt.*;
import javax.swing.*;

public class TicTacToeView extends JFrame {
    private JButton[][] buttons;
    private JLabel statusLabel;




    public TicTacToeView() {
        setTitle("TicTacToe Swing Version");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);          //sets up the window (size and layout)
        setLayout(new BorderLayout());

        // create the tictactoe grid 
        buttons = new JButton[3][3];
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        Font buttonFont = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(buttonFont);
                gridPanel.add(buttons[i][j]);
            }
        }

        // create the labels
        statusLabel = new JLabel("Player X's Turn");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // add components to the window
        add(gridPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);  // puts the window in the centre
        setVisible(true);
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    // test
    public static void main(String[] args) {
        new TicTacToeView();
    }
}


