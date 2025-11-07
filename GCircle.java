import java.awt.Color;

import acm.graphics.*;

class GCircle extends GCompound{
    // circle
    public GCircle(int centerX, int centerY, int sizeProv, Color color) {
        int size = sizeProv/600;
        GOval oval1 = new GOval(centerX-size/2,centerY-size/2,size,size);
        oval1.setColor(color);
        oval1.setFilled(true);
        oval1.setFillColor(color);
        add(oval1);

        GOval oval2 = new GOval(centerX-size/2+size*0.1,centerY-size/2+size*0.1,size*0.8,size*0.8);
        oval2.setColor(TicTaToe.bgColor);
        oval2.setFilled(true);
        oval2.setFillColor(TicTaToe.bgColor);
        add(oval2);
        //System.out.println("Computer Symbol Complete ");

    }
}
