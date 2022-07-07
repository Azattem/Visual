import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SceneController {
    @FXML
    public TextField Scale;
    public TextField Scalex;
    public TextField Scaley;
    public javafx.scene.canvas.Canvas Canvas;
    public void Update() {
        VisualDraw draw=new VisualDraw(Canvas);
        draw.SetDismensions(GetScaleX(),GetScaleY());
        draw.UpdateScale(GetScale());
        draw.Update();
    }
    private void ChangeScale(int s) {
    if(Integer.parseInt(Scale.getText())+s>=1) {
        Scale.setText((Integer.parseInt(Scale.getText()) + s) + "");
    }
    }
    private void ChangeScaleX(int s) {
            Scalex.setText((Integer.parseInt(Scalex.getText()) + s) + "");
    }
    private void ChangeScaleY(int s) {
            Scaley.setText((Integer.parseInt(Scaley.getText()) + s) + "");
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
