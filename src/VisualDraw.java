import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;


public class VisualDraw {
    private Canvas canvas;
    private int width;
    private int height;
    private double x0;
    private double y0;
    private double scale;
    private double lenghtX0 = 1 * scale;
    private double lenghtY0 = 1 * scale;
    VisualDraw( Canvas canvas){
    this.canvas = canvas;
        System.out.println((int)canvas.getWidth());
    this.width = (int)canvas.getWidth();
    this.height = (int)canvas.getHeight();
    this.x0 = (width / 2);
    this.y0 = (height / 2);

    }
    public void UpdateScale(double Scale){
    scale = Math.min(height,width)/Scale;
    }

    public void Update(){
        Complex z;
        Color[]colors256=colorArray();
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                double x = (i - x0) / lenghtX0;
                double y = (j - y0) / lenghtY0;
                System.out.println(x+" "+y);
                z = new Complex(x, y);
                System.out.println(z.x+" "+z.y);
                int color = getColor(z);
                //System.out.println(colors256[color]);
                canvas.getGraphicsContext2D().getPixelWriter().setColor(i,j,colors256[color]);
            }
        }
    }
    public void SetDismensions(int x,int y){
    this.x0 = (width / 2+x);
    this.y0 = (height / 2+y);
    }
    private static Color[] colorArray() {
        int red[] = {0, 36, 73, 109, 146, 182, 219, 255};
        int green[] = red;
        int blue[] = {0, 85, 170, 255};
        Color colors256[] = new Color[256];
        int m = 0;

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                for (int k = 0; k < 4; k++) {
                    System.out.println(red[i]+" "+green[j]+" "+blue[k]);
                    colors256[m++] = Color.rgb(red[i], green[j], blue[k]);

                }
            }
        }
        return colors256;
    }
    private static int getColor(Complex z0) {
        Complex z = z0;

        for (int i = 255; i > 1; i--) {
            if (z.abs() > 2) {
                return i;
            }
            z = z.mul(z).add(z0);
        }

        return 0;
    }

}
