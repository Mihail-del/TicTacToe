import java.awt.Color;
import acm.program.*;
import acm.graphics.*;

class Gcross extends GCompound{
    // cross
    public Gcross(int x, int y, int sizeProv, Color color) {
        int size = sizeProv/600;
        int startX1 = x - size/2 - size/20;
        int startY1 = y - size/2 - size/20;
        for (int i = 0; i < size; i++) {
            GOval cross = new GOval(startX1+i, startY1+i, size/10, size/10);
            cross.setColor(color);
            cross.setFilled(true);
            cross.setFillColor(color);
            add(cross);
        }

        int startX2 = x - size/2 - size/20;
        int startY2 = y + size/2 - size/20;
        for (int i = 0; i < size; i++) {
            GOval cross = new GOval(startX2+i, startY2-i, size/10, size/10);
            cross.setColor(color);
            cross.setFilled(true);
            cross.setFillColor(color);
            add(cross);
        }
    }
}
