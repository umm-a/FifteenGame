import javax.swing.*;
import java.util.Arrays;

public class JButtonSwapPlacesInArray {

    public JButton[][] theJButtonArraySwap(JButton chosenNumber, JButton placementZero, int rowForChosenNr, int columnForChosenNr, int rowForZero, int columnForZero, JButton[][] myMultiArray){
        myMultiArray[rowForChosenNr][columnForChosenNr]=chosenNumber;
        myMultiArray[rowForZero][columnForZero]=placementZero;
      return myMultiArray;
    }
}