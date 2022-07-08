import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SceneController {
    @FXML
    public TextField Scale;
    public TextField Scalex;
    public TextField Scaley;
    public TextField Shift;
    public TextField PaletteKoef;
    private static double x0Mem;
    private static double y0Mem;
    private static int RGBPalitre = 2;
    private static int approxBox = 0;
    private static boolean noFirstRun=false;
    public javafx.scene.canvas.Canvas Canvas;



    //Mouseevent позволяет получить кординаты мышки при нажатие оформляеться как написанно ниже, образаеясь к пременой e там есть методы для получения кардинат
    //public void update(MouseEvent e) {
    public void update() {

        VisualDraw draw = new VisualDraw(Canvas);
        draw.updateScale(getScale());
        draw.updateRGB(RGBPalitre);
        draw.setShiftKoef(Integer.parseInt(Shift.getText()));
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


    private double getScale() {
        return Double.parseDouble(Scale.getText());
    }

      @FXML
    private void shiftIncrease(ActionEvent actionEvent) {
        int currentScale=Integer.parseInt(Shift.getText());
        if (currentScale <5){
            Shift.setText(currentScale +1 + "");
            update();
        }

    }@FXML
    private void shiftDecrease(ActionEvent actionEvent) {
        int currentScale=Integer.parseInt(Shift.getText());
        if (Integer.parseInt(Shift.getText()) >1){
            Shift.setText(currentScale -1 + "");
            update();
        }
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
    private void increase1(ActionEvent actionEvent) {
        changeScale(1);
    }

    @FXML
    private void decrease1(ActionEvent actionEvent) {
        changeScale(-1);
    }

    @FXML
    private void increase10(ActionEvent actionEvent) {
        changeScale(+10);
    }

    @FXML
    private void decrease10(ActionEvent actionEvent) {
        changeScale(-10);
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
