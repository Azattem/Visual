import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SceneController {
    @FXML
    public TextField Scale;
    public TextField Scalex;
    public TextField Scaley;
    public static double x0Mem;
    public static double y0Mem;
    public static int RGBPalitre = 2;
    public static int approxBox = 0;
    private static boolean noFirstRun=false;
    public javafx.scene.canvas.Canvas Canvas;





    public void update() {

        VisualDraw draw = new VisualDraw(Canvas);
       draw.updateScale(getScale());
        draw.updateRGB(RGBPalitre);
        if(noFirstRun){
            draw.updateXY(approxBox,x0Mem,y0Mem);
            approxBox=0;
        }
        noFirstRun=true;
        draw.update();
        x0Mem=draw.getX0();
        y0Mem=draw.getY0();
    }



    private void changeScale(double s) {
        double currentScale=Double.parseDouble(Scale.getText());
        if (currentScale + (currentScale*s/100) >= 0) {
            Scale.setText(currentScale + (currentScale*s/100) + "");
            update();
        }
    }

    private void changeScaleX(int s) {
        Scalex.setText((Integer.parseInt(Scalex.getText()) + s) + "");
    }

    private void changeScaleY(int s) {
        Scaley.setText((Integer.parseInt(Scaley.getText()) + s) + "");
    }

    private double getScale() {
        return Double.parseDouble(Scale.getText());
    }

    private int getScaleX() {
        return Integer.parseInt(Scalex.getText());
    }

    private int getScaleY() {
        return Integer.parseInt(Scaley.getText());
    }

    @FXML
    private void approx1(ActionEvent actionEvent) {
        approxBox=1;
        update();
    }
    @FXML
    private void approx2(ActionEvent actionEvent) {
        approxBox=2;
        update();
    }
    @FXML
    private void approx3(ActionEvent actionEvent) {
        approxBox=3;
        update();
    }
    @FXML
    private void approx4(ActionEvent actionEvent) {
        approxBox=4;
        update();
    }
    @FXML
    private void approx5(ActionEvent actionEvent) {
        approxBox=5;
        update();
    }@FXML
    private void approx6(ActionEvent actionEvent) {
        approxBox=6;
        update();
    }@FXML
    private void approx7(ActionEvent actionEvent) {
        approxBox=7;
        update();
    }@FXML
    private void approx8(ActionEvent actionEvent) {
        approxBox=8;
        update();
    }@FXML
    private void approx9(ActionEvent actionEvent) {
        approxBox=9;
        update();
    }
    @FXML
    private void increase(ActionEvent actionEvent) {
        changeScale(1);
    }

    @FXML
    private void decrease(ActionEvent actionEvent) {
        changeScale(-1);
    }

    @FXML
    private void increase1(ActionEvent actionEvent) {
        changeScale(+10);
    }

    @FXML
    private void decrease1(ActionEvent actionEvent) {
        changeScale(-10);
    }

    @FXML
    private void increaseX(ActionEvent actionEvent) {
        changeScaleX(1);
    }

    @FXML
    private void decreaseX(ActionEvent actionEvent) {
        changeScaleX(-1);
    }

    @FXML
    private void increase10X(ActionEvent actionEvent) {
        changeScaleX(+10);
    }

    @FXML
    private void decrease10X(ActionEvent actionEvent) {
        changeScaleX(-10);
    }

    @FXML
    private void increaseY(ActionEvent actionEvent) {
        changeScaleY(1);
    }

    @FXML
    private void decreaseY(ActionEvent actionEvent) {
        changeScaleY(-1);
    }

    @FXML
    private void increase10Y(ActionEvent actionEvent) {
        changeScaleY(+10);
    }

    @FXML
    private void decrease10Y(ActionEvent actionEvent) {
        changeScaleY(-10);
    }

    @FXML
    private void RGBChange(ActionEvent actionEvent) {
        if (RGBPalitre < 7) {
            RGBPalitre++;
        }
        if (RGBPalitre == 7) {
            RGBPalitre = 1;
        }
        update();

    }

    @FXML
    private void RGBRandom(ActionEvent actionEvent) {
        RGBPalitre = 7;

        update();

    }

}
