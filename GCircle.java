import java.awt.Color;
import acm.program.*;
import acm.graphics.*;

class GCircle extends GCompound{
    // circle
    public GCircle(int centerX, int centerY, int sizeProv, Color color) {
        int size = sizeProv/600;
        for (int i = 0; i < 360; i++) {
            double angle = 2 * Math.PI * i / 360; // angle for each oval

            // Coordinates of the oval center
            double x = centerX + size/2 * Math.cos(angle);
            double y = centerY + size/2 * Math.sin(angle);

            // Top-left corner for GOval
            double ovalX = x - size/20;
            double ovalY = y - size/20;

            GOval oval = new GOval(ovalX, ovalY, size/10, size/10);
            oval.setFilled(true);
            oval.setFillColor(color);
            oval.setColor(color);
            add(oval);
        }
        System.out.println("Computer Symbol Complete ");

    }
}
