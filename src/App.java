import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;

public class App extends Application {
    private Model model;
    private View view;

    public static void main(String[] args) {
        launch(args);
    }

    private void setup() {
        model = new Model(-2, 1, 1000, -1, 1, 1000);
        view = new View(model);
    }

    @Override
    public void start(Stage stage) throws Exception {
        setup();
        view.run(stage);
    }
}
