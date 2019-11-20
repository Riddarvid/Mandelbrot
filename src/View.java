import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.stage.Stage;
import model.Model;

public class View {
    Model model;

    public View(Model model) {
        this.model = model;
    }

    public void run(Stage stage) throws Exception {
        stage.setTitle("Mandelbrot");


        Group root = new Group();
        Canvas canvas = new Canvas(model.getnX(), model.getnY());
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        PixelWriter pixelWriter = graphics.getPixelWriter();
        boolean[][] points = model.getPoints();
        long xAxis = Math.round(- model.getMinX() / model.getStepX());
        long yAxis = Math.round(- model.getMinY() / model.getStepY());
        for (int y = 0; y < model.getnY(); y++) {
            for (int x = 0; x < model.getnX(); x++) {
                if (x == xAxis || y == yAxis) {
                    pixelWriter.setArgb(x, y, 0xFFFF0000);
                } else if (points[y][x]) {
                    pixelWriter.setArgb(x, y, 0xFF000000);
                } else {
                    pixelWriter.setArgb(x, y, 0xFF0000FF);
                }
            }
        }
        Scene scene = new Scene(root, model.getnX(), model.getnY());
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();
    }
}
