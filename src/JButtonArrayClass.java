import javax.swing.*;

public class JButtonArrayClass extends JFrame {
    int rows = 0;
    int columns = 0;
    String[] arrayNumbersString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", " "};
    JButtonArrayClass(int rows, int columns){
        JButton[][] myMultiArray = new JButton[rows][columns];
        int räknare = 0;
        for (int row = 0; row < myMultiArray.length; row++) {
            for (int column = 0; column < myMultiArray[row].length; column++) {
                myMultiArray[row][column]=new JButton(arrayNumbersString[räknare]);
          //      System.out.println(myMultiArray[row][column].getText());
                räknare++;
            }
        }
    }
    public JButton[][] returnJButtonArray(String buttonNumber, JButton[][] buttons){
        int rowOfButton = 0;
        int columnOfButton = 0;
        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons[row].length; column++) {
                if(buttons[row][column].getText().equals(buttonNumber)){
                    rowOfButton=row;
                    columnOfButton=column;
                  //  System.out.println("row of button: " + rowOfButton + " column of button: " + columnOfButton);
                    buttons = swapPlacesInArray(rowOfButton, columnOfButton, buttons);
                    return buttons;
                }
            }
        }
        return buttons;
    }

    public JButton[][] swapPlacesInArray(int rowOfArray, int columnOfArray, JButton[][] myMultiArray) {
        JButtonSwapPlacesInArray a = new JButtonSwapPlacesInArray();
        JButton[][] placementOfZero = new JButton[4][4];
        int rowi = 0;
        int columni = 0;
        for (int row = 0; row < myMultiArray.length; row++) {
            for (int column = 0; column < myMultiArray[row].length; column++) {
                if (myMultiArray[row][column].getText().equals(" ")) {
                    placementOfZero[row][column] = myMultiArray[row][column];
                  //  System.out.println(placementOfZero[row][column].getText() + " is of position row: " + row + " column: " + column);
                    rowi = row;
                    columni = column;
                }
            }
        }

        JButton[][] tempArrayFromPlacementOfZero = new JButton[rowi][columni];
        JButton[][] tempArrayFromInput = new JButton[rowOfArray][columnOfArray];

        int tempRow = rowi;
        int tempColumn = columni;

    //    System.out.println("Placement of zero, row: " + rowi + " column: " + columni);
     //   System.out.println("Placement of input, row: " + rowOfArray + " column: " + columnOfArray);
        if (rowOfArray == rowi + 1 && columnOfArray == columni) {
            rowi = rowOfArray; //inputs föredetta plats
            rowOfArray = tempRow;//nollans föredetta plats
            columni = columnOfArray; //inputs föredetta plats
            columnOfArray = tempColumn;//nollans föredetta plats
         //   System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);
            return a.theJButtonArraySwap(myMultiArray[rowi][columni], myMultiArray[rowOfArray][columnOfArray], rowOfArray, columnOfArray, rowi, columni, myMultiArray);
        } else if (rowOfArray == rowi - 1 && columnOfArray == columni) {//raden ovanför
            rowi = rowOfArray;
            rowOfArray = tempRow;
            columni = columnOfArray;
            columnOfArray = tempColumn;
          //  System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);
            return a.theJButtonArraySwap(myMultiArray[rowi][columni], myMultiArray[rowOfArray][columnOfArray], rowOfArray, columnOfArray, rowi, columni, myMultiArray);
        } else if (rowOfArray == rowi && columnOfArray == columni + 1) {//kolumnen till höger
            rowi = rowOfArray;
            rowOfArray = tempRow;
            columni = columnOfArray;
            columnOfArray = tempColumn;
            //System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);
            return a.theJButtonArraySwap(myMultiArray[rowi][columni], myMultiArray[rowOfArray][columnOfArray], rowOfArray, columnOfArray, rowi, columni, myMultiArray);
        } else if (rowOfArray == rowi && columnOfArray == columni - 1) {//kolumnen till vänster
            rowi = rowOfArray;
            rowOfArray = tempRow;
            columni = columnOfArray;
            columnOfArray = tempColumn;
          //  System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);
            return a.theJButtonArraySwap(myMultiArray[rowi][columni], myMultiArray[rowOfArray][columnOfArray], rowOfArray, columnOfArray, rowi, columni, myMultiArray);
        }
        return myMultiArray;
    }

    public static void main(String[] args) {
       /* boolean run=true;
        while (run==true) {
            try {
                int rows = Integer.parseInt(JOptionPane.showInputDialog("Rows? Between 4 and 7"));
                int columns = Integer.parseInt(JOptionPane.showInputDialog("Columns? Between 4 and 7"));
                if((4<=rows && rows<=7 && 4<=columns && columns<=7)) {
                    FifteenGameGUI fifteenGame = new FifteenGameGUI(rows, columns);
                    run = false;
                }else {
                    JOptionPane.showMessageDialog(null, "Sorry, you messed up. We'll try again!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "So... input is messed up.");
                }
                }*/ //If one wishes to add some custom rows and columns, it may be added but needs additional steps. I would make a new constructor for PlayGUI etc.

    }
}
