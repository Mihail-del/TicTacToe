/* Task One
 auth: Pulov Mykhailo

написати гру в хрестики нулики на дошці розмірності 3*3
Вимоги:
* в кінці гри візуально виділити лінію перемоги,
* виводиться хто переміг,
* можливість грати знову.
 */

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;


public class TicTaToe extends GraphicsProgram {
    // ===== CONSTANTS =====
    int BOARD_SIZE = 800;
    boolean isAnimated = true;
    boolean duoMode = false;
    boolean randomSymbol = false;
    boolean intelligenceComputerChoice = true;


    // ===== COLORS =====
    public static Color bgColor = new Color(154, 148, 135);
    Color lineColor = new Color(112, 95, 72);
    Color textColor = new Color(236, 227, 225);
    Color textBgColor = new Color(86, 87, 72);

    Color crossColor = new Color(40, 92, 78);
    Color circleColor = new Color(221, 110, 50);
    Color fatLineColor = new Color(209, 80, 80);


    // ===== VARIABLES =====
    public static boolean crossTurn = true;
    public int steps = 0;
    public String result = " ";
    public int combo;
    public boolean stopGame = false;
    public int mousePosX, mousePosY;
    public boolean choiceScreenWait = false;
    boolean choiceRandomScreenWait  = false;

    int cellOneCenterX;
    int cellOneCenterY;
    int cellOneMinX;
    int cellOneMaxX;
    int cellOneMinY;
    int cellOneMaxY;
    public boolean cellOneFree = true;
    public static String cellOneContent = "1";

    int cellTwoCenterX;
    int cellTwoCenterY;
    int cellTwoMinX;
    int cellTwoMaxX;
    int cellTwoMinY;
    int cellTwoMaxY;
    public boolean cellTwoFree = true;
    public static String cellTwoContent = "2";

    int cellThreeCenterX;
    int cellThreeCenterY;
    int cellThreeMinX;
    int cellThreeMaxX;
    int cellThreeMinY;
    int cellThreeMaxY;
    public boolean cellThreeFree = true;
    public static String cellThreeContent = "3";

    int cellFourCenterX;
    int cellFourCenterY;
    int cellFourMinX;
    int cellFourMaxX;
    int cellFourMinY;
    int cellFourMaxY;
    public boolean cellFourFree = true;
    public static String cellFourContent = "4";

    int cellFiveCenterX;
    int cellFiveCenterY;
    int cellFiveMinX;
    int cellFiveMaxX;
    int cellFiveMinY;
    int cellFiveMaxY;
    public boolean cellFiveFree = true;
    public static String cellFiveContent = "5";

    int cellSixCenterX;
    int cellSixCenterY;
    int cellSixMinX;
    int cellSixMaxX;
    int cellSixMinY;
    int cellSixMaxY;
    public boolean cellSixFree = true;
    public static String cellSixContent = "6";

    int cellSevenCenterX;
    int cellSevenCenterY;
    int cellSevenMinX;
    int cellSevenMaxX;
    int cellSevenMinY;
    int cellSevenMaxY;
    public boolean cellSevenFree = true;
    public static String cellSevenContent = "7";

    int cellEightCenterX;
    int cellEightCenterY;
    int cellEightMinX;
    int cellEightMaxX;
    int cellEightMinY;
    int cellEightMaxY;
    public boolean cellEightFree = true;
    public static String cellEightContent = "8";

    int cellNineCenterX;
    int cellNineCenterY;
    int cellNineMinX;
    int cellNineMaxX;
    int cellNineMinY;
    int cellNineMaxY;
    public boolean cellNineFree = true;
    public static String cellNineContent = "9";


    // ===== RANDOM =====
    private RandomGenerator rgen = RandomGenerator.getInstance();

    // ===== run =====
    public void run() {
        setSize(BOARD_SIZE, BOARD_SIZE);

        addMouseListeners();
        startProcces();
    }

    // ===== STARTING THE PROCCES =====
    public void startProcces(){
        if (randomSymbol) {
            choiceRandomScreen();
        } else{
            choiceScreen();
        }

        calculateSizes();
        if (crossTurn) steps=1;
    }

    // ===== GAMING PROCESS =====
    public void mousePressed(MouseEvent e){
        boolean stepMade = false;

        if (choiceScreenWait){
            removeAll();
            drawtable();
            if (mousePosX<=getWidth()/2)
                crossTurn = true;
            else {
                crossTurn = true;
                if (!duoMode)
                    makeComputerStep();
                crossTurn = false;
            }

            choiceScreenWait=false;

        }

        else if (choiceRandomScreenWait) {
            removeAll();
            drawtable();
            choiceRandomScreenWait=false;

            if (!crossTurn) {
                steps=0;
                crossTurn=true;
                if (!duoMode)
                    makeComputerStep();
            }
        }

        else if (!stopGame) {
            // cell One clicked
            if (e.getX() > cellOneMinX && e.getX() < cellOneMaxX && e.getY() > cellOneMinY && e.getY() < cellOneMaxY) {

                if (cellOneFree) {

                    cellOneFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellOneCenterX, cellOneCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellOneContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellOneCenterX, cellOneCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellOneContent = "Circle";
                    }
                    crossTurn = !crossTurn;

                    stepMade = true;
                }
            }

            // cell Two clicked
            else if (e.getX() > cellTwoMinX && e.getX() < cellTwoMaxX && e.getY() > cellTwoMinY && e.getY() < cellTwoMaxY) {
                if (cellTwoFree) {
                    cellTwoFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellTwoCenterX, cellTwoCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellTwoContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellTwoCenterX, cellTwoCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellTwoContent = "Circle";
                    }
                    crossTurn = !crossTurn;

                    stepMade = true;
                }
            }

            // cell Three clicked
            else if (e.getX() > cellThreeMinX && e.getX() < cellThreeMaxX && e.getY() > cellThreeMinY && e.getY() < cellThreeMaxY) {
                if (cellThreeFree) {
                    cellThreeFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellThreeCenterX, cellThreeCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellThreeContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellThreeCenterX, cellThreeCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellThreeContent = "Circle";
                    }
                    crossTurn = !crossTurn;

                    stepMade = true;
                }
            }

            // cell Four clicked
            else if (e.getX() > cellFourMinX && e.getX() < cellFourMaxX && e.getY() > cellFourMinY && e.getY() < cellFourMaxY) {
                if (cellFourFree) {
                    cellFourFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellFourCenterX, cellFourCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellFourContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellFourCenterX, cellFourCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellFourContent = "Circle";
                    }
                    crossTurn = !crossTurn;

                    stepMade = true;
                }
            }

            // cell Five clicked
            else if (e.getX() > cellFiveMinX && e.getX() < cellFiveMaxX && e.getY() > cellFiveMinY && e.getY() < cellFiveMaxY) {
                if (cellFiveFree) {
                    cellFiveFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellFiveCenterX, cellFiveCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellFiveContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellFiveCenterX, cellFiveCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellFiveContent = "Circle";
                    }
                    crossTurn = !crossTurn;

                    stepMade = true;
                }
            }

            // cell Six clicked
            else if (e.getX() > cellSixMinX && e.getX() < cellSixMaxX && e.getY() > cellSixMinY && e.getY() < cellSixMaxY) {
                if (cellSixFree) {
                    cellSixFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellSixCenterX, cellSixCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellSixContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellSixCenterX, cellSixCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellSixContent = "Circle";
                    }
                    crossTurn = !crossTurn;

                    stepMade = true;
                }
            }

            // cell Seven clicked
            else if (e.getX() > cellSevenMinX && e.getX() < cellSevenMaxX && e.getY() > cellSevenMinY && e.getY() < cellSevenMaxY) {
                if (cellSevenFree) {
                    cellSevenFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellSevenCenterX, cellSevenCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellSevenContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellSevenCenterX, cellSevenCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellSevenContent = "Circle";
                    }
                    crossTurn = !crossTurn;

                    stepMade = true;
                }
            }

            // cell Eight clicked
            else if (e.getX() > cellEightMinX && e.getX() < cellEightMaxX && e.getY() > cellEightMinY && e.getY() < cellEightMaxY) {
                if (cellEightFree) {
                    cellEightFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellEightCenterX, cellEightCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellEightContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellEightCenterX, cellEightCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellEightContent = "Circle";
                    }
                    crossTurn = !crossTurn;


                    stepMade = true;
                }
            }

            // cell Nine clicked
            else if (e.getX() > cellNineMinX && e.getX() < cellNineMaxX && e.getY() > cellNineMinY && e.getY() < cellNineMaxY) {
                if (cellNineFree) {
                    cellNineFree = false;
                    steps++;

                    if (crossTurn) {
                        Gcross cross = new Gcross(cellNineCenterX, cellNineCenterY, 100 * BOARD_SIZE, crossColor);
                        add(cross);
                        cellNineContent = "Cross";
                    } else {
                        GCircle cross = new GCircle(cellNineCenterX, cellNineCenterY, 100 * BOARD_SIZE, circleColor);
                        add(cross);
                        cellNineContent = "Circle";
                    }
                    crossTurn = !crossTurn;

                    stepMade = true;
                }
            }


            // check combinations
            result = checkCombos();
            if (result.equals(" ") && !duoMode && stepMade)
                makeComputerStep();
            result = checkCombos();

            if (!result.equals(" ") || (!cellOneFree && !cellTwoFree && !cellThreeFree && !cellFourFree && !cellFiveFree && !cellSixFree && !cellSevenFree && !cellEightFree && !cellNineFree)) {
                stopGame = true;
                if (result.equals(" "))
                    result = "Draw!";

                println(result);

                cellOneFree = false;
                cellTwoFree = false;
                cellThreeFree = false;
                cellFourFree = false;
                cellFiveFree = false;
                cellSixFree = false;
                cellSevenFree = false;
                cellEightFree = false;
                cellNineFree = false;

                drawFatLine();



                // RESULTS
                GRect resultLabelBG = new GRect(getWidth()/6, getHeight()/4.3, getWidth()/6*4, getHeight()/10*2);
                resultLabelBG.setFilled(true);
                resultLabelBG.setFillColor(textBgColor);
                add(resultLabelBG);

                GLabel resultLabel = new GLabel(result);
                resultLabel.setFont("Monospaced-" + BOARD_SIZE / 10);
                if (result.equals("Draw!"))
                    resultLabel.setLocation(getWidth() * 0.36, getHeight() * 0.37);
                else if (result.equals("Cross won!"))
                    resultLabel.setLocation(getWidth() * 0.2, getHeight() * 0.37);
                else
                    resultLabel.setLocation(getWidth() * 0.18, getHeight() * 0.37);

                resultLabel.setColor(textColor);
                add(resultLabel);


                // restart game
                GRect pressToStartBG = new GRect(getWidth() * 0.28, getHeight() * 0.73, getWidth() * 0.44, getHeight() * 0.08);
                pressToStartBG.setFilled(true);
                pressToStartBG.setFillColor(textBgColor);
                add(pressToStartBG);

                GLabel pressToStart = new GLabel("Press to start");
                pressToStart.setFont("Monospaced-" + BOARD_SIZE / 20);
                pressToStart.setLocation(getWidth() * 0.29, getHeight() * 0.79);
                pressToStart.setColor(textColor);
                add(pressToStart);

                // exit
                GRect pressToExitBG = new GRect(getWidth() * 0.28, getHeight() * 0.83, getWidth() * 0.44, getHeight() * 0.08);
                pressToExitBG.setFilled(true);
                pressToExitBG.setFillColor(textBgColor);
                add(pressToExitBG);

                GLabel pressToExit = new GLabel("Press to exit");
                pressToExit.setFont("Monospaced-" + BOARD_SIZE / 20);
                pressToExit.setLocation(getWidth() * 0.305, getHeight() * 0.89);
                pressToExit.setColor(textColor);
                add(pressToExit);
            }
        }

        else {
            if (mousePosX>getWidth()*0.28 && mousePosX<getWidth()*0.72) {
                if (mousePosY > getHeight() * 0.73 && mousePosY < getHeight() * 0.81) {
                    println("Restarting");
                    restartGame();
                }
                else if (mousePosY > getHeight()*0.83 && mousePosY < getHeight()*0.91) {
                    println("Exiting");
                    exit();
                }
            }
        }

    }

    // ===== PREPARING FOR RESTART =====
    private void restartGame() {
        // --- reset model (flags, owners, flow) ---
        crossTurn = true;
        steps = 0;
        result = " ";
        stopGame = false;
        combo = 0;
        isAnimated = false;

        cellOneFree = true;
        cellOneContent = "1";

        cellTwoFree = true;
        cellTwoContent = "2";

        cellThreeFree = true;
        cellThreeContent = "3";

        cellFourFree = true;
        cellFourContent = "4";

        cellFiveFree = true;
        cellFiveContent = "5";

        cellSixFree = true;
        cellSixContent = "6";

        cellSevenFree = true;
        cellSevenContent = "7";

        cellEightFree = true;
        cellEightContent = "8";

        cellNineFree = true;
        cellNineContent = "9";


        // --- reset view ---
        removeAll();            // clear canvas
        if (randomSymbol) {
            choiceRandomScreen();
        } else{
            choiceScreen();
        }

        calculateSizes();
    }



    // ===== COMPUTER CALCULATES STEP =====
    private void makeComputerStep(){
        if (cellOneFree || cellTwoFree || cellThreeFree || cellFourFree || cellFiveFree || cellSixFree || cellSevenFree || cellEightFree || cellNineFree) {
            //println("Computer Step");

            int compSelectCell = 0;

            while (true) {
                compSelectCell = rgen.nextInt(1, 9);
                //compSelectCell = 1;
                //println(compSelectCell);

                if (compSelectCell == 1) {
                    if (cellOneFree) break;
                } else if (compSelectCell == 2) {
                    if (cellTwoFree) break;
                } else if (compSelectCell == 3) {
                    if (cellThreeFree) break;
                } else if (compSelectCell == 4) {
                    if (cellFourFree) break;
                } else if (compSelectCell == 5) {
                    if (cellFiveFree) break;
                } else if (compSelectCell == 6) {
                    if (cellSixFree) break;
                } else if (compSelectCell == 7) {
                    if (cellSevenFree) break;
                } else if (compSelectCell == 8) {
                    if (cellEightFree) break;
                } else if (compSelectCell == 9) {
                    if (cellNineFree) break;
                }
            }


            if (intelligenceComputerChoice) {
                int intelligenceDefence = IntelligenceChoice.IntelligenceChoiceDefence();
                int intelligenceAttack = IntelligenceChoice.IntelligenceChoiceAttack();

                if (intelligenceDefence != -1 && intelligenceAttack == -1){
                    compSelectCell = intelligenceDefence;
                    println("|  Intelligence Defence");
                }

                if (intelligenceAttack != -1){
                    compSelectCell = intelligenceAttack;
                    println("|  Intelligence Atack");
                }

                if (intelligenceDefence == -1 && intelligenceAttack == -1){
                    println("|  Random Step");
                }
            }


            drawCompSymbol(compSelectCell);
            steps++;
            crossTurn = !crossTurn;
        }
    }

    private void drawCompSymbol(int cell){
        //println("Computer Symbol");
        if (cell == 1){
            cellOneFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellOneCenterX, cellOneCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                //println("Computer Symbol Complete");
                cellOneContent = "Cross";
            } else {
                GCircle circle = new GCircle(cellOneCenterX, cellOneCenterY, 100 * BOARD_SIZE, circleColor);
                add(circle);
                //println("Computer Symbol Complete " + (cellOneCenterX + " " + cellOneCenterY + " " + 100 * BOARD_SIZE + " " + circleColor));
                cellOneContent = "Circle";
            }
        }

        else if (cell == 2){
            cellTwoFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellTwoCenterX, cellTwoCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                cellTwoContent = "Cross";
            } else {
                GCircle cross = new GCircle(cellTwoCenterX, cellTwoCenterY, 100 * BOARD_SIZE, circleColor);
                add(cross);
                cellTwoContent = "Circle";
            }
        }

        else if (cell == 3){
            cellThreeFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellThreeCenterX, cellThreeCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                cellThreeContent = "Cross";
            } else {
                GCircle cross = new GCircle(cellThreeCenterX, cellThreeCenterY, 100 * BOARD_SIZE, circleColor);
                add(cross);
                cellThreeContent = "Circle";
            }
        }

        else if (cell == 4){
            cellFourFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellFourCenterX, cellFourCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                cellFourContent = "Cross";
            } else {
                GCircle cross = new GCircle(cellFourCenterX, cellFourCenterY, 100 * BOARD_SIZE, circleColor);
                add(cross);
                cellFourContent = "Circle";
            }
        }

        else if (cell == 5){
            cellFiveFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellFiveCenterX, cellFiveCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                cellFiveContent = "Cross";
            } else {
                GCircle cross = new GCircle(cellFiveCenterX, cellFiveCenterY, 100 * BOARD_SIZE, circleColor);
                add(cross);
                cellFiveContent = "Circle";
            }
        }

        else if (cell == 6){
            cellSixFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellSixCenterX, cellSixCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                cellSixContent = "Cross";
            } else {
                GCircle cross = new GCircle(cellSixCenterX, cellSixCenterY, 100 * BOARD_SIZE, circleColor);
                add(cross);
                cellSixContent = "Circle";
            }
        }

        else if (cell == 7){
            cellSevenFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellSevenCenterX, cellSevenCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                cellSevenContent = "Cross";
            } else {
                GCircle cross = new GCircle(cellSevenCenterX, cellSevenCenterY, 100 * BOARD_SIZE, circleColor);
                add(cross);
                cellSevenContent = "Circle";
            }
        }

        else if (cell == 8){
            cellEightFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellEightCenterX, cellEightCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                cellEightContent = "Cross";
            } else {
                GCircle cross = new GCircle(cellEightCenterX, cellEightCenterY, 100 * BOARD_SIZE, circleColor);
                add(cross);
                cellEightContent = "Circle";
            }
        }

        else if (cell == 9){
            cellNineFree = false;

            println(cell);
            if (crossTurn) {
                Gcross cross = new Gcross(cellNineCenterX, cellNineCenterY, 100 * BOARD_SIZE, crossColor);
                add(cross);
                cellNineContent = "Cross";
            } else {
                GCircle cross = new GCircle(cellNineCenterX, cellNineCenterY, 100 * BOARD_SIZE, circleColor);
                add(cross);
                cellNineContent = "Circle";
            }
        }
    }

    // ===== DRAWING A FAT WINNING LINE =====
    private void drawFatLine(){
        int x1=0, y1=0, x2=0, y2=0;
        int linePadding = 10;

        if (combo==123){
            x1 = cellOneCenterX-getWidth()/linePadding;
            y1 = cellOneCenterY;
            x2 = cellThreeCenterX+getWidth()/linePadding;
            y2 = cellThreeCenterY;
        }
        else if (combo==456){
            x1 = cellFourCenterX-getWidth()/linePadding;
            y1 = cellFourCenterY;
            x2 = cellSixCenterX+getWidth()/linePadding;
            y2 = cellSixCenterY;
        }
        else if (combo==789){
            x1 = cellSevenCenterX-getWidth()/linePadding;
            y1 = cellSevenCenterY;
            x2 = cellNineCenterX+getWidth()/linePadding;
            y2 = cellNineCenterY;
        }
        else if (combo==147){
            x1 = cellOneCenterX;
            y1 = cellOneCenterY-getHeight()/linePadding;
            x2 = cellSevenCenterX;
            y2 = cellSevenCenterY+getHeight()/linePadding;
        }
        else if (combo==258){
            x1 = cellTwoCenterX;
            y1 = cellTwoCenterY-getHeight()/linePadding;
            x2 = cellEightCenterX;
            y2 = cellEightCenterY+getHeight()/linePadding;
        }
        else if (combo==369){
            x1 = cellThreeCenterX;
            y1 = cellThreeCenterY-getHeight()/linePadding;
            x2 = cellNineCenterX;
            y2 = cellNineCenterY+getHeight()/linePadding;
        }
        else if (combo==159){
            x1 = cellOneCenterX-getWidth()/linePadding;
            y1 = cellOneCenterY-getHeight()/linePadding;
            x2 = cellNineCenterX+getWidth()/linePadding;
            y2 = cellNineCenterY+getHeight()/linePadding;
        }
        else if (combo==357){
            x1 = cellThreeCenterX+getWidth()/linePadding;
            y1 = cellThreeCenterY-getHeight()/linePadding;
            x2 = cellSevenCenterX-getWidth()/linePadding;
            y2 = cellSevenCenterY+getHeight()/linePadding;
        }

        GFatLine fatLine = new GFatLine(x1, y1, x2, y2, 10 * BOARD_SIZE, fatLineColor);
        add(fatLine);
    }

    // ===== CHECKING COMBOS =====
    private String checkCombos(){
        String result = " ";
        // horizontal
        if (cellOneContent.equals(cellTwoContent) && cellOneContent.equals(cellThreeContent)){
            println("Combo 1.1 - 1.2 - 1.3");
            combo = 123;
            result = cellOneContent + " won!";
        }
        if (cellFourContent.equals(cellFiveContent) && cellFourContent.equals(cellSixContent)){
            println("Combo 2.1 - 2.2 - 2.3");
            combo = 456;
            result = cellFourContent + " won!";
        }
        if (cellSevenContent.equals(cellEightContent) && cellSevenContent.equals(cellNineContent)){
            println("Combo 3.1 - 3.2 - 3.3");
            combo = 789;
            result = cellSevenContent + " won!";
        }

        // vertical
        if (cellOneContent.equals(cellFourContent) && cellOneContent.equals(cellSevenContent)){
            println("Combo 1.1 - 2.1 - 3.1");
            combo = 147;
            result = cellOneContent + " won!";
        }
        if (cellTwoContent.equals(cellFiveContent) && cellTwoContent.equals(cellEightContent)){
            println("Combo 1.2 - 2.2 - 3.2");
            combo = 258;
            result = cellTwoContent + " won!";
        }
        if (cellThreeContent.equals(cellSixContent) && cellThreeContent.equals(cellNineContent)){
            println("Combo 3.1 - 3.2 - 3.3");
            combo = 369;
            result = cellThreeContent + " won!";
        }

        // diagonal
        if (cellOneContent.equals(cellFiveContent) && cellOneContent.equals(cellNineContent)){
            println("Combo 1.1 - 2.2 - 3.3");
            combo = 159;
            result = cellOneContent + " won!";
        }
        if (cellThreeContent.equals(cellFiveContent) && cellThreeContent.equals(cellSevenContent)){
            println("Combo 1.3 - 2.2 - 3.1");
            combo = 357;
            result = cellThreeContent + " won!";
        }

        return result;
    }


























    // ===== START MENU WITH CHOOSING A FIRST STEP =====
    private void choiceScreen(){
        setBackground(bgColor);
        GLabel mainLabel = new GLabel("First step is by");
        mainLabel.setFont("Monospaced-" + BOARD_SIZE /12);
        mainLabel.setLocation(getWidth()*0.1, getHeight()*0.2);
        add(mainLabel);

        Gcross cross = new Gcross(getWidth()/4, getHeight()/5*3, 150* BOARD_SIZE, crossColor);
        add(cross);
        GCircle circle = new GCircle(getHeight()/4*3, getHeight()/5*3, 150* BOARD_SIZE, circleColor);
        add(circle);

        choiceScreenWait = true;
    }

    public void mouseMoved(MouseEvent e){
        //System.out.println("Mouse: "+e.getX()+", "+e.getY());
        mousePosX = e.getX();
        mousePosY = e.getY();
    }




    // ===== START MENU WITH DEFINING THE RANDOM FIRST STEP =====
    private void choiceRandomScreen() {
        setBackground(bgColor);

        GLabel mainLabel = new GLabel("First step is by");
        mainLabel.setFont("Monospaced-" + BOARD_SIZE /12);
        mainLabel.setLocation(getWidth()*0.1, getHeight()*0.2);
        add(mainLabel);

        boolean firstCross = true;
        Gcross cross = new Gcross(getWidth()/2, getHeight()/2, 200* BOARD_SIZE, crossColor);
        add(cross);
        GCircle circle = new GCircle(getWidth()/2, getHeight()/2, 200* BOARD_SIZE, circleColor);
        add(circle);


        for (int i = 0; i < rgen.nextInt(25, 26); i++) {
            firstCross = !firstCross;
            if (firstCross) {
                circle.setVisible(false);
                cross.setVisible(true);
            } else{
                circle.setVisible(true);
                cross.setVisible(false);
            }

            if (isAnimated)
                pause(i*i);
        }
        crossTurn = firstCross;

        GLabel pressToStart = new GLabel("Press to start");
        pressToStart.setFont("Monospaced-" + BOARD_SIZE /20);
        pressToStart.setLocation(getWidth()*0.29, getHeight()*0.9);
        add(pressToStart);

        choiceRandomScreenWait = true;
    }


    // ===== DRAWING THE TABLE =====
    private void drawtable() {
        // inners
        GRect line1 = new GRect(0, getHeight() /3- getHeight() /100, getWidth(), getHeight() /50);
        line1.setFilled(true);
        line1.setFillColor(lineColor);
        line1.setColor(lineColor);
        add(line1);

        GRect line2 = new GRect(0, getHeight() *2/3- getHeight() /100, getWidth(), getHeight() /50);
        line2.setFilled(true);
        line2.setFillColor(lineColor);
        line2.setColor(lineColor);
        add(line2);

        GRect line3 = new GRect(getWidth() /3- getWidth() /100, 0, getWidth() /50, getHeight());
        line3.setFilled(true);
        line3.setFillColor(lineColor);
        line3.setColor(lineColor);
        add(line3);

        GRect line4 = new GRect(getWidth() *2/3- getWidth() /100, 0, getWidth() /50, getHeight());
        line4.setFilled(true);
        line4.setFillColor(lineColor);
        line4.setColor(lineColor);
        add(line4);

        // borders
        GRect border1 = new GRect(0, 0, getWidth()/100.0, getHeight());
        border1.setFilled(true);
        border1.setFillColor(lineColor);
        border1.setColor(lineColor);
        add(border1);

        GRect border2 = new GRect(0, getHeight() - getHeight()/100.0, getWidth(), getHeight()/100.0);
        border2.setFilled(true);
        border2.setFillColor(lineColor);
        border2.setColor(lineColor);
        add(border2);

        GRect border3 = new GRect(0, 0, getWidth(), getHeight() /100.0);
        border3.setFilled(true);
        border3.setFillColor(lineColor);
        border3.setColor(lineColor);
        add(border3);

        GRect border4 = new GRect(getWidth() - getHeight() /100, 0, getHeight() /100, getHeight());
        border4.setFilled(true);
        border4.setFillColor(lineColor);
        border4.setColor(lineColor);
        add(border4);


    }












    // ===== CALCULATING ALL THE SIZES VARIABLES =====
    private void calculateSizes() {
        cellOneCenterX = getWidth()/6;
        cellOneCenterY = getHeight()/6;
        cellOneMinX = cellOneCenterX-getWidth()/6;
        cellOneMaxX = cellOneCenterX+getWidth()/6;
        cellOneMinY = cellOneCenterY-getHeight()/6;
        cellOneMaxY = cellOneCenterY+getHeight()/6;

        cellTwoCenterX = getWidth()/2;
        cellTwoCenterY = getHeight()/6;
        cellTwoMinX = cellTwoCenterX-getWidth()/6;
        cellTwoMaxX = cellTwoCenterX+getWidth()/6;
        cellTwoMinY = cellTwoCenterY-getHeight()/6;
        cellTwoMaxY = cellTwoCenterY+getHeight()/6;

        cellThreeCenterX = getWidth()/6*5;
        cellThreeCenterY = getHeight()/6;
        cellThreeMinX = cellThreeCenterX-getWidth()/6;
        cellThreeMaxX = cellThreeCenterX+getWidth()/6;
        cellThreeMinY = cellThreeCenterY-getHeight()/6;
        cellThreeMaxY = cellThreeCenterY+getHeight()/6;

        cellFourCenterX = getWidth()/6;
        cellFourCenterY = getHeight()/2;
        cellFourMinX = cellFourCenterX-getWidth()/6;
        cellFourMaxX = cellFourCenterX+getWidth()/6;
        cellFourMinY = cellFourCenterY-getHeight()/6;
        cellFourMaxY = cellFourCenterY+getHeight()/6;

        cellFiveCenterX = getWidth()/2;
        cellFiveCenterY = getHeight()/2;
        cellFiveMinX = cellFiveCenterX-getWidth()/6;
        cellFiveMaxX = cellFiveCenterX+getWidth()/6;
        cellFiveMinY = cellFiveCenterY-getHeight()/6;
        cellFiveMaxY = cellFiveCenterY+getHeight()/6;

        cellSixCenterX = getWidth()/6*5;
        cellSixCenterY = getHeight()/2;
        cellSixMinX = cellSixCenterX-getWidth()/6;
        cellSixMaxX = cellSixCenterX+getWidth()/6;
        cellSixMinY = cellSixCenterY-getHeight()/6;
        cellSixMaxY = cellSixCenterY+getHeight()/6;

        cellSevenCenterX = getWidth()/6;
        cellSevenCenterY = getHeight()/6*5;
        cellSevenMinX = cellSevenCenterX-getWidth()/6;
        cellSevenMaxX = cellSevenCenterX+getWidth()/6;
        cellSevenMinY = cellSevenCenterY-getHeight()/6;
        cellSevenMaxY = cellSevenCenterY+getHeight()/6;

        cellEightCenterX = getWidth()/2;
        cellEightCenterY = getHeight()/6*5;
        cellEightMinX = cellEightCenterX-getWidth()/6;
        cellEightMaxX = cellEightCenterX+getWidth()/6;
        cellEightMinY = cellEightCenterY-getHeight()/6;
        cellEightMaxY = cellEightCenterY+getHeight()/6;

        cellNineCenterX = getWidth()/6*5;
        cellNineCenterY = getHeight()/6*5;
        cellNineMinX = cellNineCenterX-getWidth()/6;
        cellNineMaxX = cellNineCenterX+getWidth()/6;
        cellNineMinY = cellNineCenterY-getHeight()/6;
        cellNineMaxY = cellNineCenterY+getHeight()/6;
    }









    // ===== GETTERS =====
    public static boolean isCrossTurn() {
        return crossTurn;
    }

    public static String getCellOneContent() {
        return cellOneContent;
    }

    public static String getCellTwoContent() {
        return cellTwoContent;
    }

    public static String getCellThreeContent() {
        return cellThreeContent;
    }

    public static String getCellFourContent() {
        return cellFourContent;
    }


    public static String getCellFiveContent() {
        return cellFiveContent;
    }


    public static String getCellSixContent() {
        return cellSixContent;
    }

    public static String getCellSevenContent() {
        return cellSevenContent;
    }

    public static String getCellEightContent() {
        return cellEightContent;
    }

    public static String getCellNineContent() {
        return cellNineContent;
    }
}