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
    private Player player = new Player();

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
        scoreKeep(num);
    }

    public void scoreKeep(int num) throws IllegalArgumentException{
        int col = 0;
        int row = 0;
        switch (num){
            case 0: num = 0;
                    col = num%3;
                    row = num/3;
                    System.out.println("Case 0 ");
                    break;
            case 1: num = 1;
                    col = num%3;
                    row = num/3;
                    System.out.print("Case 1 ");
                    break;
            case 2: num = 2;
                    col = num%3;
                    row = num/3;
                    System.out.print("Case 2 ");
                    break;
            case 3: num = 3;
                    col = num%3;
                    row = num/3;
                    System.out.print("Case 3 ");
                    break;
            case 4: num = 4;
                    col = num%3;
                    row = num/3;
                    System.out.print("Case 4 ");
                    break;
            case 5: num = 5;
                    col = num%3;
                    row = num/3;
                    System.out.print("Case 5 ");
                    break;
            case 6: num = 6;
                    col = num%3;
                    row = num/3;
                    System.out.print("Case 6 ");    
                    break;
            case 7: num = 7;
                    col = num%3;
                    row = num/3;
                    System.out.print("Case 7 ");
                    break;
            case 8: num = 8;
                    col = num%3;
                    row = num/3;
                    System.out.print("Case 8 ");
                    break;
            default: //throw new IllegalArgumentException("Invalid Tile Name");
        }
        System.out.println(player.takeTurn(row, col, player.getCurrentPlayer()));
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