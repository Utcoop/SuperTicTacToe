package edu.ithaca.dturnbull.supertictactoe;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.*;

public class tic_tac_toe implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel[] panels = new JPanel[9];
    private JButton[] buttons = new JButton[81];
    private boolean xTurn = true;

    public tic_tac_toe() {
        frame = new JFrame("Super Tic-Tac-Toe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3, 5, 5));
        mainPanel.setBackground(Color.black);
        for (int i = 0 ; i < 9 ; i++){
            panels[i] = new JPanel();
            panels[i].setLayout(new GridLayout(3,3,3,3));
            panels[i].setBackground(Color.gray);
            mainPanel.add(panels[i]);
        }
        int c = 0;
        for (int i = 1; i <= 81; i++) {
            buttons[i-1] = new JButton("");
            buttons[i-1].setName(Integer.toString(i-1));
            buttons[i-1].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i-1].addActionListener(this);
            panels[c].add(buttons[i-1]);
            if (i%9==0){
                c++;
            }
        }
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (xTurn) {
            button.setText("X");
        } else {
            button.setText("O");
        }
        button.setEnabled(false);
        int num = Integer.parseInt(button.getName())%9;
        boolean isFull = true;
        for (int i = 0; i < panels.length; i++){
            if (panels[num]==panels[i]){
                for (Component j: panels[i].getComponents()){
                    JButton temp = (JButton) j;
                    if (temp.getText().equals("")){
                        j.setEnabled(true);
                        isFull = false;
                    }
                }
            }else{
                 for (Component j: panels[i].getComponents()){
                    j.setEnabled(false);
                }
            }
        }
        if (isFull){
            for (int i = 0; i < panels.length; i++){
                if (panels[num]!=panels[i]){
                    for (Component j: panels[i].getComponents()){
                        JButton temp = (JButton) j;
                        if (temp.getText().equals("")){
                            j.setEnabled(true);
                        }
                    }
                }
            }
        }
        xTurn = !xTurn;
        //checkForWinner();
    }

    public void checkForWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[0].getText() + " wins!");
            resetGame();
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " wins!");
            resetGame();
            return;
        }

        // Check for tie
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "Tie game!");
            resetGame();
        }
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        new tic_tac_toe();
    }
}