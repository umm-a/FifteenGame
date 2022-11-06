import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import static javax.swing.SwingConstants.CENTER;

public class FifteenGameGUI extends JFrame implements ActionListener{
    Border border = BorderFactory.createLineBorder(new Color(65, 136, 109, 255), 1);
    // Base definitions
    final Font buttonFont = new Font("Bold Serif", Font.BOLD, 16);
    final int button_r = 65;
    final int button_g = 136;
    final int button_b = 123;
    final Color button_color = new Color(button_r, button_g, button_b);
    Color current_button_color = button_color;
    int rows = 4;
    int columns = 4;
    List<String> correctNumberOrder = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", " ");

    JButton[][] buttons = new JButton[rows][columns];
    JPanel spelGrid = new JPanel();
    JButton newGameButton = new JButton("\uD83C\uDF43 N E W  G A M E \uD83C\uDF43");
    JPanel panel = new JPanel();

    JLabel win = new JLabel("");

    public FifteenGameGUI() {
        setTitle("★ \uD835\uDFED\uD835\uDFF1 ★");
        spelGrid.setLayout(new GridLayout(rows, columns));
        int räknare=0;

        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons[row].length; column++) {
                buttons[row][column]= new JButton(correctNumberOrder.get(räknare));
                buttons[row][column].setBackground(new Color(0xBAC2BA));
                spelGrid.add(buttons[row][column]);
                buttons[row][column].addActionListener(this);
                räknare++;
                buttons[row][column].setForeground(new Color(7, 26, 14, 163));
                buttons[row][column].setFont(new Font("Bold Serif", Font.BOLD, 16));
                buttons[row][column].setBorder(border);
                buttons[row][column].setFocusPainted(false);
            }
        }

        panel.setLayout(new BorderLayout());
        panel.add(newGameButton, BorderLayout.NORTH);
        panel.add(spelGrid, BorderLayout.CENTER);

        panel.add(win, BorderLayout.SOUTH);
        newGameButton.addActionListener(this);
        newGameButton.setBackground((new Color(0x162D24)));
        newGameButton.setForeground(new Color(186, 224, 219, 163));
        newGameButton.setFont(new Font("Bold Serif", Font.BOLD, 16));
        newGameButton.setBorder(border);
        newGameButton.setPreferredSize(new Dimension(330, 60));
        newGameButton.setFocusPainted(false);
        newGameButton.addMouseListener(mouseClickListener);
        win.setPreferredSize(new Dimension(330, 0));
        add(panel);
        panel.setBackground(new Color(1));
        spelGrid.setPreferredSize(new Dimension(400, 300));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public Color increaseColorOrReset(Color someColor) {

        int next_r = someColor.getRed() + 3;
        int next_g = someColor.getGreen() + 4;
        int next_b = someColor.getBlue() + 3;

        final int max_color_value = 210;

        if (next_g > max_color_value)
            return new Color(button_r, button_g, button_b);
        else
            return new Color(next_r, next_g, next_b);
    }
    public void newGrid(JButton[][] buttons, JPanel spelGrid, Color button_color) {
        spelGrid.removeAll();
        spelGrid.setLayout(new GridLayout(4, 4));
        int[] räknare = new int[16];
        int i=0;


        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons[row].length; column++) {
                try {
                    räknare[i] = Integer.parseInt(buttons[row][column].getText());
                    buttons[row][column] = new JButton(String.valueOf(räknare[i]));

                    spelGrid.add(buttons[row][column]);
                    buttons[row][column].addActionListener(this);
                } catch (NumberFormatException e){
                    buttons[row][column] = new JButton(" ");
                    spelGrid.add(buttons[row][column]);
                    buttons[row][column].addActionListener(this);
                }
                buttons[row][column].setBackground(button_color);
                buttons[row][column].setForeground(new Color(7, 26, 14, 163));
                buttons[row][column].setFont(buttonFont);
                buttons[row][column].setBorder(border);
                buttons[row][column].setFocusPainted(false);

                button_color = increaseColorOrReset(button_color);
                i++;
            }
        }
    }

    public void newGameGrid(JButton[][] buttons, JPanel spelGrid, Color button_color) {
        spelGrid.removeAll();
        spelGrid.setLayout(new GridLayout(rows, columns));
        Integer[] räknare = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        List<Integer> räknareList = Arrays.asList(räknare);
        Collections.shuffle(räknareList);
        räknareList.toArray(räknare);
        final Color buttonForegroundColor = new Color(7, 26, 14, 163);

        int i=0;
        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons[row].length; column++) {

                if(räknare[i]==0){
                    buttons[row][column] = new JButton(" ");
                    spelGrid.add(buttons[row][column]);
                    buttons[row][column].addActionListener(this);
                } else {
                    try {
                        buttons[row][column] = new JButton(String.valueOf(räknare[i]));
                        spelGrid.add(buttons[row][column]);
                        buttons[row][column].addActionListener(this);
                    } catch (NumberFormatException e) {
                        System.out.println("HOW?");
                    }
                }
                buttons[row][column].setBackground(button_color);
                buttons[row][column].setForeground(buttonForegroundColor);
                buttons[row][column].setFont(buttonFont);
                buttons[row][column].setBorder(border);
                buttons[row][column].setFocusPainted(false);
                i++;
            }
        }
    }

    public List<String> JButtonsToString(JButton[][] buttons) {
        ArrayList<String> buttonsToString = new ArrayList<>();
        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons[row].length; column++) {
                buttonsToString.add(buttons[row][column].getText());
            }
        }
        return buttonsToString;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButtonArrayClass jbac = new JButtonArrayClass(rows, columns);

        if(e.getSource() == newGameButton) {
            newGameGrid(buttons, spelGrid, button_color);
            win.setPreferredSize(new Dimension(0,0));
            } else {
            System.out.println("Chosen number\n" + ((JButton) e.getSource()).getText());
            buttons = jbac.returnJButtonArray(((JButton) e.getSource()).getText(), buttons);
            current_button_color = increaseColorOrReset(current_button_color);
            newGrid(buttons, spelGrid, current_button_color);

            if(JButtonsToString(buttons).equals(correctNumberOrder)) {
                win.setText("WINNER!!");
                win.setFont(new Font("Monospaced", Font.BOLD, 18));
                panel.setBackground((new Color(0xFFA359)));
                win.setForeground(new Color(0xFFFFFF));
                win.setHorizontalAlignment(CENTER);
                win.setPreferredSize(new Dimension(330, 50));
            }
        }
            revalidate();
            repaint();
        }
    MouseListener mouseClickListener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource()==newGameButton) {
                newGameButton.setForeground(new Color(0xFFFFFF));
                newGameButton.setBackground((new Color(0x1E071E)));
            }

        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getSource()==newGameButton) {
                newGameButton.setForeground(new Color(0x6EB298));
            }
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource()==newGameButton)
                newGameButton.setBackground((new Color(0x130F1C)));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource()==newGameButton) {
                newGameButton.setBackground((new Color(0x1B3D30)));
            }
        }
    };

        public static void main (String[]args){
            new FifteenGameGUI();
        }



}




