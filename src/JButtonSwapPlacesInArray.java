import javax.swing.*;
import java.util.Arrays;

public class JButtonSwapPlacesInArray {

    public JButton[][] theJButtonArraySwap(JButton chosenNumber, JButton placementZero, int rowForChosenNr, int columnForChosenNr, int rowForZero, int columnForZero, JButton[][] myMultiArray){
        myMultiArray[rowForChosenNr][columnForChosenNr]=chosenNumber;//JButton for the chosen number
        myMultiArray[rowForZero][columnForZero]=placementZero;

     /*   System.out.println("\n\nNEW ORDER");
        for (int r = 0; r < myMultiArray.length; r++) {
            for (int c = 0; c < myMultiArray[r].length; c++) {
                System.out.println(myMultiArray[r][c].getText());
            }
        }*/
      return myMultiArray;
    }
}