import java.awt.*;

public class IntelligenceChoice{
    /**
     * Method to calculate the optimal defence cell
     * @return
     */
    public static int IntelligenceChoiceDefence() {
        // horizontal
        if (checkCombo123(TicTaToe.isCrossTurn()) != -1){
            System.out.println("Intelligence combo 123");
            return checkCombo123(TicTaToe.isCrossTurn());
        }
        else if (checkCombo456(TicTaToe.isCrossTurn()) != -1){
            System.out.println("Intelligence combo 456");
            return checkCombo456(TicTaToe.isCrossTurn());
        }
        else if (checkCombo789(TicTaToe.isCrossTurn()) != -1){
            System.out.println("Intelligence combo 789");
            return checkCombo789(TicTaToe.isCrossTurn());
        }

        // vertical
        else if (checkCombo147(TicTaToe.isCrossTurn()) != -1){
            System.out.println("Intelligence combo 147");
            return checkCombo147(TicTaToe.isCrossTurn());
        }
        else if (checkCombo258(TicTaToe.isCrossTurn()) != -1) {
            System.out.println("Intelligence combo 147");
            return checkCombo258(TicTaToe.isCrossTurn());
        }
        else if (checkCombo369(TicTaToe.isCrossTurn()) != -1) {
            System.out.println("Intelligence combo 147");
            return checkCombo369(TicTaToe.isCrossTurn());
        }

        // diagonal
        else if (checkCombo159(TicTaToe.isCrossTurn()) != -1) {
            System.out.println("Intelligence combo 159");
            return checkCombo159(TicTaToe.isCrossTurn());
        }
        else if (checkCombo357(TicTaToe.isCrossTurn()) != -1) {
            System.out.println("Intelligence combo 357");
            return checkCombo357(TicTaToe.isCrossTurn());
        }


        // if no defence needed
        return -1;
    }

    public static int checkCombo123(boolean isCrossTurn) {
        if (isCrossTurn) {
            if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellTwoContent().equals("Circle") && TicTaToe.getCellThreeContent().equals("3"))
                return 3;
            else if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellTwoContent().equals("2") && TicTaToe.getCellThreeContent().equals("Circle"))
                return 2;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellTwoContent().equals("Circle") && TicTaToe.getCellThreeContent().equals("Circle"))
                return 1;
        }
        else {
            if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellTwoContent().equals("Cross") && TicTaToe.getCellThreeContent().equals("3"))
                return 3;
            else if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellTwoContent().equals("2") && TicTaToe.getCellThreeContent().equals("Cross"))
                return 2;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellTwoContent().equals("Cross") && TicTaToe.getCellThreeContent().equals("Cross"))
                return 1;
        }
        return -1;
    }

    public static int checkCombo456(boolean isCrossTurn) {
        if (isCrossTurn) {
            if (TicTaToe.getCellFourContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellSixContent().equals("6"))
                return 6;
            else if (TicTaToe.getCellFourContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellSixContent().equals("Circle"))
                return 5;
            else if (TicTaToe.getCellFourContent().equals("4") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellSixContent().equals("Circle"))
                return 4;
        }
        else {
            if (TicTaToe.getCellFourContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellSixContent().equals("6"))
                return 6;
            else if (TicTaToe.getCellFourContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellSixContent().equals("Cross"))
                return 5;
            else if (TicTaToe.getCellFourContent().equals("4") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellSixContent().equals("Cross"))
                return 4;
        }
        return -1;
    }

    public static int checkCombo789(boolean isCrossTurn) {
        if (isCrossTurn) {
            if (TicTaToe.getCellSevenContent().equals("Circle") && TicTaToe.getCellEightContent().equals("Circle") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellSevenContent().equals("Circle") && TicTaToe.getCellEightContent().equals("8") && TicTaToe.getCellNineContent().equals("Circle"))
                return 8;
            else if (TicTaToe.getCellSevenContent().equals("7") && TicTaToe.getCellEightContent().equals("Circle") && TicTaToe.getCellNineContent().equals("Circle"))
                return 7;
        }
        else {
            if (TicTaToe.getCellSevenContent().equals("Cross") && TicTaToe.getCellEightContent().equals("Cross") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellSevenContent().equals("Cross") && TicTaToe.getCellEightContent().equals("7") && TicTaToe.getCellNineContent().equals("Cross"))
                return 8;
            else if (TicTaToe.getCellSevenContent().equals("8") && TicTaToe.getCellEightContent().equals("Cross") && TicTaToe.getCellNineContent().equals("Cross"))
                return 7;
        }
        return -1;
    }

    public static int checkCombo147(boolean isCrossTurn) {
        if (isCrossTurn) {
            if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellFourContent().equals("Circle") && TicTaToe.getCellSevenContent().equals("7"))
                return 7;
            else if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellFourContent().equals("4") && TicTaToe.getCellSevenContent().equals("Circle"))
                return 4;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellFourContent().equals("Circle") && TicTaToe.getCellSevenContent().equals("Circle"))
                return 1;
        }
        else {
            if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellFourContent().equals("Cross") && TicTaToe.getCellSevenContent().equals("7"))
                return 7;
            else if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellFourContent().equals("4") && TicTaToe.getCellSevenContent().equals("Cross"))
                return 4;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellFourContent().equals("Cross") && TicTaToe.getCellSevenContent().equals("Cross"))
                return 1;
        }
        return -1;
    }

    public static int checkCombo258(boolean isCrossTurn) {
        if (isCrossTurn) {
            if (TicTaToe.getCellTwoContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellEightContent().equals("8"))
                return 8;
            else if (TicTaToe.getCellTwoContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellEightContent().equals("Circle"))
                return 5;
            else if (TicTaToe.getCellTwoContent().equals("2") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellEightContent().equals("Circle"))
                return 2;
        }
        else {
            if (TicTaToe.getCellTwoContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellEightContent().equals("8"))
                return 8;
            else if (TicTaToe.getCellTwoContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellEightContent().equals("Cross"))
                return 5;
            else if (TicTaToe.getCellTwoContent().equals("2") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellEightContent().equals("Cross"))
                return 2;
        }
        return -1;
    }

    public static int checkCombo369(boolean isCrossTurn) {
        if (isCrossTurn) {
            if (TicTaToe.getCellThreeContent().equals("Circle") && TicTaToe.getCellSixContent().equals("Circle") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellThreeContent().equals("Circle") && TicTaToe.getCellSixContent().equals("6") && TicTaToe.getCellNineContent().equals("Circle"))
                return 6;
            else if (TicTaToe.getCellThreeContent().equals("3") && TicTaToe.getCellSixContent().equals("Circle") && TicTaToe.getCellNineContent().equals("Circle"))
                return 3;
        }
        else {
            if (TicTaToe.getCellThreeContent().equals("Cross") && TicTaToe.getCellSixContent().equals("Cross") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellThreeContent().equals("Cross") && TicTaToe.getCellSixContent().equals("6") && TicTaToe.getCellNineContent().equals("Cross"))
                return 6;
            else if (TicTaToe.getCellThreeContent().equals("3") && TicTaToe.getCellSixContent().equals("Cross") && TicTaToe.getCellNineContent().equals("Cross"))
                return 3;
        }
        return -1;
    }

    public static int checkCombo159(boolean isCrossTurn) {
        if (isCrossTurn) {
            if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellNineContent().equals("Circle"))
                return 5;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellNineContent().equals("Circle"))
                return 1;
        }
        else {
            if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellNineContent().equals("Cross"))
                return 5;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellNineContent().equals("Cross"))
                return 1;
        }
        return -1;
    }

    public static int checkCombo357(boolean isCrossTurn) {
        if (isCrossTurn) {
            if (TicTaToe.getCellThreeContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellSevenContent().equals("7"))
                return 7;
            else if (TicTaToe.getCellThreeContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellSevenContent().equals("Circle"))
                return 5;
            else if (TicTaToe.getCellThreeContent().equals("3") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellSevenContent().equals("Circle"))
                return 3;
        }
        else {
            if (TicTaToe.getCellThreeContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellSevenContent().equals("7"))
                return 7;
            else if (TicTaToe.getCellThreeContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellSevenContent().equals("Cross"))
                return 5;
            else if (TicTaToe.getCellThreeContent().equals("3") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellSevenContent().equals("Cross"))
                return 3;
        }
        return -1;
    }




    /**
     * Method to calculate the optimal attack cell
     * @return
     */
    public static int IntelligenceChoiceAttack() {
        // horizontal
        if (checkComboAttack123(TicTaToe.isCrossTurn()) != -1){
            System.out.println("Intelligence combo 123");
            return checkComboAttack123(TicTaToe.isCrossTurn());
        }
        else if (checkComboAttack456(TicTaToe.isCrossTurn()) != -1){
            System.out.println("Intelligence combo 456");
            return checkComboAttack456(TicTaToe.isCrossTurn());
        }
        else if (checkComboAttack789(TicTaToe.isCrossTurn()) != -1){
            System.out.println("Intelligence combo 789");
            return checkComboAttack789(TicTaToe.isCrossTurn());
        }

        // vertical
        else if (checkComboAttack147(TicTaToe.isCrossTurn()) != -1){
            System.out.println("Intelligence combo 147");
            return checkComboAttack147(TicTaToe.isCrossTurn());
        }
        else if (checkComboAttack258(TicTaToe.isCrossTurn()) != -1) {
            System.out.println("Intelligence combo 258");
            return checkComboAttack258(TicTaToe.isCrossTurn());
        }
        else if (checkComboAttack369(TicTaToe.isCrossTurn()) != -1) {
            System.out.println("Intelligence combo 369");
            return checkComboAttack369(TicTaToe.isCrossTurn());
        }

        // diagonal
        else if (checkComboAttack159(TicTaToe.isCrossTurn()) != -1) {
            System.out.println("Intelligence combo 159");
            return checkComboAttack159(TicTaToe.isCrossTurn());
        }
        else if (checkComboAttack357(TicTaToe.isCrossTurn()) != -1) {
            System.out.println("Intelligence combo 357");
            return checkComboAttack357(TicTaToe.isCrossTurn());
        }


        // if no attack possible
        return -1;
    }


    public static int checkComboAttack123(boolean isCrossTurn) {
        if (!isCrossTurn) {
            if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellTwoContent().equals("Circle") && TicTaToe.getCellThreeContent().equals("3"))
                return 3;
            else if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellTwoContent().equals("2") && TicTaToe.getCellThreeContent().equals("Circle"))
                return 2;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellTwoContent().equals("Circle") && TicTaToe.getCellThreeContent().equals("Circle"))
                return 1;
        }
        else {
            if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellTwoContent().equals("Cross") && TicTaToe.getCellThreeContent().equals("3"))
                return 3;
            else if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellTwoContent().equals("2") && TicTaToe.getCellThreeContent().equals("Cross"))
                return 2;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellTwoContent().equals("Cross") && TicTaToe.getCellThreeContent().equals("Cross"))
                return 1;
        }
        return -1;
    }

    public static int checkComboAttack456(boolean isCrossTurn) {
        if (!isCrossTurn) {
            if (TicTaToe.getCellFourContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellSixContent().equals("6"))
                return 6;
            else if (TicTaToe.getCellFourContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellSixContent().equals("Circle"))
                return 5;
            else if (TicTaToe.getCellFourContent().equals("4") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellSixContent().equals("Circle"))
                return 4;
        }
        else {
            if (TicTaToe.getCellFourContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellSixContent().equals("6"))
                return 6;
            else if (TicTaToe.getCellFourContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellSixContent().equals("Cross"))
                return 5;
            else if (TicTaToe.getCellFourContent().equals("4") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellSixContent().equals("Cross"))
                return 4;
        }
        return -1;
    }

    public static int checkComboAttack789(boolean isCrossTurn) {
        if (!isCrossTurn) {
            if (TicTaToe.getCellSevenContent().equals("Circle") && TicTaToe.getCellEightContent().equals("Circle") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellSevenContent().equals("Circle") && TicTaToe.getCellEightContent().equals("8") && TicTaToe.getCellNineContent().equals("Circle"))
                return 8;
            else if (TicTaToe.getCellSevenContent().equals("7") && TicTaToe.getCellEightContent().equals("Circle") && TicTaToe.getCellNineContent().equals("Circle"))
                return 7;
        }
        else {
            if (TicTaToe.getCellSevenContent().equals("Cross") && TicTaToe.getCellEightContent().equals("Cross") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellSevenContent().equals("Cross") && TicTaToe.getCellEightContent().equals("7") && TicTaToe.getCellNineContent().equals("Cross"))
                return 8;
            else if (TicTaToe.getCellSevenContent().equals("8") && TicTaToe.getCellEightContent().equals("Cross") && TicTaToe.getCellNineContent().equals("Cross"))
                return 7;
        }
        return -1;
    }

    public static int checkComboAttack147(boolean isCrossTurn) {
        if (!isCrossTurn) {
            if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellFourContent().equals("Circle") && TicTaToe.getCellSevenContent().equals("7"))
                return 7;
            else if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellFourContent().equals("4") && TicTaToe.getCellSevenContent().equals("Circle"))
                return 4;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellFourContent().equals("Circle") && TicTaToe.getCellSevenContent().equals("Circle"))
                return 1;
        }
        else {
            if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellFourContent().equals("Cross") && TicTaToe.getCellSevenContent().equals("7"))
                return 7;
            else if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellFourContent().equals("4") && TicTaToe.getCellSevenContent().equals("Cross"))
                return 4;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellFourContent().equals("Cross") && TicTaToe.getCellSevenContent().equals("Cross"))
                return 1;
        }
        return -1;
    }

    public static int checkComboAttack258(boolean isCrossTurn) {
        if (!isCrossTurn) {
            if (TicTaToe.getCellTwoContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellEightContent().equals("8"))
                return 8;
            else if (TicTaToe.getCellTwoContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellEightContent().equals("Circle"))
                return 5;
            else if (TicTaToe.getCellTwoContent().equals("2") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellEightContent().equals("Circle"))
                return 2;
        }
        else {
            if (TicTaToe.getCellTwoContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellEightContent().equals("8"))
                 return 8;
            else if (TicTaToe.getCellTwoContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellEightContent().equals("Cross"))
                return 5;
            else if (TicTaToe.getCellTwoContent().equals("2") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellEightContent().equals("Cross"))
                return 2;
        }
        return -1;
    }

    public static int checkComboAttack369(boolean isCrossTurn) {
        if (!isCrossTurn) {
            if (TicTaToe.getCellThreeContent().equals("Circle") && TicTaToe.getCellSixContent().equals("Circle") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellThreeContent().equals("Circle") && TicTaToe.getCellSixContent().equals("6") && TicTaToe.getCellNineContent().equals("Circle"))
                return 6;
            else if (TicTaToe.getCellThreeContent().equals("3") && TicTaToe.getCellSixContent().equals("Circle") && TicTaToe.getCellNineContent().equals("Circle"))
                return 3;
        }
        else {
            if (TicTaToe.getCellThreeContent().equals("Cross") && TicTaToe.getCellSixContent().equals("Cross") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellThreeContent().equals("Cross") && TicTaToe.getCellSixContent().equals("6") && TicTaToe.getCellNineContent().equals("Cross"))
                return 6;
            else if (TicTaToe.getCellThreeContent().equals("3") && TicTaToe.getCellSixContent().equals("Cross") && TicTaToe.getCellNineContent().equals("Cross"))
                return 3;
        }
        return -1;
    }

    public static int checkComboAttack159(boolean isCrossTurn) {
        if (!isCrossTurn) {
            if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellOneContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellNineContent().equals("Circle"))
                return 5;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellNineContent().equals("Circle"))
                return 1;
        }
        else {
            if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellNineContent().equals("9"))
                return 9;
            else if (TicTaToe.getCellOneContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellNineContent().equals("Cross"))
                return 5;
            else if (TicTaToe.getCellOneContent().equals("1") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellNineContent().equals("Cross"))
                return 1;
        }
        return -1;
    }

    public static int checkComboAttack357(boolean isCrossTurn) {
        if (!isCrossTurn) {
            if (TicTaToe.getCellThreeContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellSevenContent().equals("7"))
                return 7;
            else if (TicTaToe.getCellThreeContent().equals("Circle") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellSevenContent().equals("Circle"))
                return 5;
            else if (TicTaToe.getCellThreeContent().equals("3") && TicTaToe.getCellFiveContent().equals("Circle") && TicTaToe.getCellSevenContent().equals("Circle"))
                return 3;
        }
        else {
            if (TicTaToe.getCellThreeContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellSevenContent().equals("7"))
                return 7;
            else if (TicTaToe.getCellThreeContent().equals("Cross") && TicTaToe.getCellFiveContent().equals("5") && TicTaToe.getCellSevenContent().equals("Cross"))
                return 5;
            else if (TicTaToe.getCellThreeContent().equals("3") && TicTaToe.getCellFiveContent().equals("Cross") && TicTaToe.getCellSevenContent().equals("Cross"))
                return 3;
        }
        return -1;
    }
}
