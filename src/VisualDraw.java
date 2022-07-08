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



    public void updateMouseXYStay(double mouseX, double mouseY, double x0Mem, double y0Mem) {

        x0 = x0Mem;
        y0 = y0Mem;


    }
    public void updateMouseXY(double mouseX, double mouseY, double x0Mem, double y0Mem) {

        x0 = x0Mem+(width/2-mouseX);
        y0 = y0Mem+(height/2-mouseY);


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



}
