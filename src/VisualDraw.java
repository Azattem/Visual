import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class VisualDraw {
private static HashMap<Character,Color> SymbolCatalog = new HashMap<>();
private Color[][] VisualMatrix;

VisualDraw(char[][] Matrix){
        VisualMatrix = ConvertMatrix(Matrix);
}

private Color[][] ConvertMatrix(char[][] SymbolMatrix){
Color[][] Matrix = new Color[SymbolMatrix.length][SymbolMatrix[0].length];
    for (int i = 0; i < SymbolMatrix.length; i++) {
        for (int j = 0; j < SymbolMatrix[0].length; j++) {
            System.out.println(i+" "+j);
        char Symbol = SymbolMatrix[i][j];
        if(!SymbolCatalog.containsKey(Symbol)){
        while (true){
            System.out.println("1");
            Color s = Color.rgb(random(0,255),random(0,255),random(0,255));
            if(!SymbolCatalog.containsValue(s)) {
                SymbolCatalog.put(SymbolMatrix[i][j], s);
                break;
            }
        }
        }
        Matrix[i][j] = SymbolCatalog.get(SymbolMatrix[i][j]);
        }
    }
return  Matrix;
}

private int random(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

public void Stamp(Canvas g){
for (int i = 0; i < VisualMatrix.length; i++) {
    for (int j = 0; j < VisualMatrix[0].length; j++) {
        g.getGraphicsContext2D().getPixelWriter().setColor(i,j,VisualMatrix[i][j]);
    }
}
}
}

