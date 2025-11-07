import java.awt.Color;
import acm.program.*;
import acm.graphics.*;

class GFatLine extends GCompound{
    // cross
    public GFatLine(int x1, int y1, int x2, int y2, int sizeProv, Color color) {
        int size = sizeProv/600;

        double quant = x2-x1;
        if ((y2-y1)>quant)
            quant = y2-y1;

        double deltaX = (x2-x1) / quant;
        double deltaY = (y2-y1) / quant;


        for (int i = 0; i < quant; i++) {
            GOval oval = new GOval(x1+(i*deltaX)-size/2.0, y1+(i*deltaY)-size/2.0, size, size);
            oval.setColor(color);
            oval.setFilled(true);
            oval.setFillColor(color);
            add(oval);
        }
    }
}