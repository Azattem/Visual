import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class VisualDraw {
    private Canvas canvas;
    private int width;
    private int height;
    private double x0;
    private double y0;
    private double scale;

    private int shiftKoef;

    private int paletteKoef;
    private int paletteSize;
    private int RGBPalitre;

    VisualDraw(Canvas canvas) {
        this.canvas = canvas;
        this.width = (int) canvas.getWidth();
        this.height = (int) canvas.getHeight();
        this.x0 = (width / 6) * 3;
        this.y0 = (height / 6) * 3;
        this.RGBPalitre = 2;
        this.paletteKoef = 8;//min=2;max=256
        this.paletteSize = paletteKoef * paletteKoef * (paletteKoef / 2);
        this.shiftKoef=3;
    }
    public void update() {
        Complex z;
        Color[] colorArray = ColorArray.colorArray(paletteKoef, RGBPalitre);
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                double x = (i - x0) / scale;
                double y = (j - y0) / scale;
                z = new Complex(x, y);

                int color = getColor(z, paletteSize);

                    canvas.getGraphicsContext2D().getPixelWriter().setColor(i, j, colorArray[color]);



                if (i == width / 3 || i == (width / 3) * 2) {
                    canvas.getGraphicsContext2D().getPixelWriter().setColor(i, j, Color.GRAY);
                }
                if (j == height / 3 || j == (height / 3) * 2) {
                    canvas.getGraphicsContext2D().getPixelWriter().setColor(i, j, Color.GRAY);
                }


            }
        }

    }
    public void updateScale(double Scale) {
        scale = (Math.min(height, width) / 2) * Scale;
    }

    public void updateRGB(int UpdateRGB) {

        RGBPalitre = UpdateRGB;
    }

    public void updateXY(int approxBox, double x0Mem, double y0Mem) {
        int shiftX = 0;
        int shiftY = 0;
        boolean reset = false;

        int shiftXdelta = width /shiftKoef;
        int shiftYdelta = height / shiftKoef;
        switch (approxBox) {
            case (1):
                shiftX = shiftXdelta;
                shiftY = shiftYdelta;
                break;
            case (2):
                shiftY = shiftYdelta;
                break;
            case (3):
                shiftX = -shiftXdelta;
                shiftY = shiftYdelta;
                break;
            case (4):
                shiftX = shiftXdelta;
                break;
            case (5):
                reset = true;
                break;
            case (6):
                shiftX = -shiftXdelta;

                break;
            case (7):
                shiftX = shiftXdelta;
                shiftY = -shiftYdelta;
                break;
            case (8):
                shiftY = -shiftYdelta;
                break;
            case (9):
                shiftX = -shiftXdelta;
                shiftY = -shiftYdelta;
                break;
        }

        x0 = x0Mem + shiftX;
        y0 = y0Mem + shiftY;
        if (reset == true) {
            reset = false;
            updateScale(0.5);
            x0 = (width / 6) * 3;
            y0 = (height / 6) * 3;
        }
    }



    public void setDismensions(int x, int y) {
        this.x0 = (width / 2) + x;
        this.y0 = (height / 2) + y;
    }


    private static int getColor(Complex z0, int paletteSize) {
        Complex z = z0;

        for (int i = paletteSize - 1; i > 1; i--) {
            if (z.abs() > 2) {
                return i;
            }
            z = z.mul(z).add(z0);
        }

        return 0;
    }

    public double getX0() {
        return x0;
    }

    public double getY0() {
        return y0;
    }

    public int getShiftKoef() {
        return shiftKoef;
    }

    public void setShiftKoef(int Koef) {
        this.shiftKoef = 7-Koef;

    }

    public void setPaletteKoef(int paletteKoef) {
        this.paletteKoef = paletteKoef;
    }
}
