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
    private static double xShift=0;
    private static double yShift=0;

    private int paletteKoef;
    private int paletteSize;
    private int RGBPalitre;
    private static Color[] colorArray;

    VisualDraw(Canvas canvas) {
        this.canvas = canvas;
        this.width = (int) canvas.getWidth();
        this.height = (int) canvas.getHeight();
        this.x0 = (width / 6) * 3;
        this.y0 = (height / 6) * 3;
        this.RGBPalitre = 2;
        this.paletteKoef = 16;//min=2;max=256
        this.paletteSize = paletteKoef * paletteKoef * (paletteKoef / 2);
        this.shiftKoef=3;

    }

    public void setColorArray(Color[] colorArray) {
        this.colorArray = colorArray;
    }

    public int getPaletteKoef() {
        return paletteKoef;
    }

    public void update() {
        Complex z;
        //Color[] colorArray = ColorArray.colorArray(paletteKoef, RGBPalitre);
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                double x = (i - x0) / scale;
                double y = (j - y0) / scale;
                z = new Complex(x, y);

                int color = getColor(z, paletteSize);


                canvas.getGraphicsContext2D().getPixelWriter().setColor(i, j, colorArray[color]);



/*
                if (i == width / 3 || i == (width / 3) * 2) {
                    canvas.getGraphicsContext2D().getPixelWriter().setColor(i, j, Color.GRAY);
                }
                if (j == height / 3 || j == (height / 3) * 2) {
                    canvas.getGraphicsContext2D().getPixelWriter().setColor(i, j, Color.GRAY);
                }
*/

            }
        }

    }
    public void updateScale(double Scale) {
        scale = (Math.min(height, width) / 2) * Scale;
    }

    public void updateRGB(int UpdateRGB) {

        RGBPalitre = UpdateRGB;
    }



    public void updateMouseXYScale(double mouseX, double mouseY, double x0Mem, double y0Mem) {
        System.out.println("stay "+xShift + " " + yShift+" m "+mouseX+" "+mouseY);
        updateMouseXY(width/2,height/2,x0Mem,y0Mem);
        x0 = x0Mem+(xShift/100)*100-width/2;
        y0 = y0Mem+(yShift/100)*100-height/2;


    }

    public void updateMouseXYStay(double mouseX, double mouseY, double x0Mem, double y0Mem) {

        x0 = x0Mem;
        y0 = y0Mem;

    }
    public void updateMouseXY(double mouseX, double mouseY, double x0Mem, double y0Mem) {

        xShift=x0Mem+(width/2-mouseX);
        yShift=y0Mem+(height/2-mouseY);
        x0 = xShift;
        y0 = yShift;


    }


    private static int getColor(Complex z0, int paletteSize) {
        Complex z = z0;
        int hole=1;
        for (int i = paletteSize - 1; i > 1; i-=hole) {
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
