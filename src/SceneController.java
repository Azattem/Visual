import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SceneController {
    @FXML
    public TextField Scale;
      private static double x0Mem;
    private static double y0Mem;
    private static double mouseX;
    private static double mouseY;
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

        if(noFirstRun){
            mouseX=x0Mem;
            mouseY=y0Mem;
            draw.updateMouseXYStay(mouseX,mouseY,x0Mem,y0Mem);
           approxBox=0;
        }
        noFirstRun=true;
        draw.update();
        x0Mem=draw.getX0();
        y0Mem=draw.getY0();

    }
    public void updateMouse(MouseEvent e) {

        VisualDraw draw = new VisualDraw(Canvas);
        draw.updateScale(getScale());
        draw.updateRGB(RGBPalitre);

        if(noFirstRun){
             mouseX=e.getSceneX();
             mouseY=e.getSceneY();
            draw.updateMouseXY(mouseX,mouseY,x0Mem,y0Mem);
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
