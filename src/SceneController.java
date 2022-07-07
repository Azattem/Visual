import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SceneController {
    @FXML
    public TextField Scale;
    public TextField Scalex;
    public TextField Scaley;
    @FXML
    private javafx.scene.canvas.Canvas Canvas;

    public void Update() {
        int width = 400;
        int height = 400;
        double x0 = (width / 2);
        double y0 = (height / 2);
        double scale = GetScale();
        double lenghtX0 = GetScaleX() * scale;
        double lenghtY0 = GetScaleY() * scale;
        ConsolDraw c = new ConsolDraw(width, height);
        Complex z;
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                double x = (i - x0) / lenghtX0;
                double y = (j - y0) / lenghtY0;
                z = new Complex(x, y);

                int color = getColor(z);

                c.draw64Color(i, j, color - 192);
                //c.draw16Color(i, j, color-240);

            }
        }
        c.show();
        System.out.println(1);
        VisualDraw visualDraw = new VisualDraw(c.GetMatrix());
        System.out.println(2);
        visualDraw.Stamp(Canvas);
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


    private void ChangeScale(int s) {
    if(Integer.parseInt(Scale.getText())+s>=1) {
        Scale.setText((Integer.parseInt(Scale.getText()) + s) + "");
    }
    }
    private void ChangeScaleX(int s) {
        if(Integer.parseInt(Scalex.getText())+s>=1) {
            Scalex.setText((Integer.parseInt(Scalex.getText()) + s) + "");
        }
    }
    private void ChangeScaleY(int s) {
        if(Integer.parseInt(Scaley.getText())+s>=1) {
            Scaley.setText((Integer.parseInt(Scaley.getText()) + s) + "");
        }
    }
    private int GetScale(){
    return Integer.parseInt(Scale.getText());
    }
    private int GetScaleX(){
        return Integer.parseInt(Scalex.getText());
    }
    private int GetScaleY(){
        return Integer.parseInt(Scaley.getText());
    }

    @FXML
    private void Increase(ActionEvent actionEvent) {
        ChangeScale(1);
    }

    @FXML
    private void Decrease(ActionEvent actionEvent) {
        ChangeScale(-1);
    }
    @FXML
    private void Increase10(ActionEvent actionEvent) {
        ChangeScale(+10);
    }
    @FXML
    private void Decrease10(ActionEvent actionEvent) {
        ChangeScale(-10);
    }
    @FXML
    private void IncreaseX(ActionEvent actionEvent) {
        ChangeScaleX(1);
    }

    @FXML
    private void DecreaseX(ActionEvent actionEvent) {
        ChangeScaleX(-1);
    }
    @FXML
    private void Increase10X(ActionEvent actionEvent) {
        ChangeScaleX(+10);
    }
    @FXML
    private void Decrease10X(ActionEvent actionEvent) {
        ChangeScaleX(-10);
    }
    @FXML
    private void IncreaseY(ActionEvent actionEvent) {
        ChangeScaleY(1);
    }

    @FXML
    private void DecreaseY(ActionEvent actionEvent) {
        ChangeScaleY(-1);
    }
    @FXML
    private void Increase10Y(ActionEvent actionEvent) {
        ChangeScaleY(+10);
    }
    @FXML
    private void Decrease10Y(ActionEvent actionEvent) {
        ChangeScaleY(-10);
    }
}
