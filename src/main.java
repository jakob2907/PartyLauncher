import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import states.SelectState;
import states.StartScreen;
import states.StartState;
import states.StateHandler;

public class main extends Application {

    Stage window;

    private StateHandler stateHandler;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        stateHandler = new StateHandler(window);

        //StartState st = new StartState(stateHandler);
        //StartScreen sc = new StartScreen(stateHandler);
        SelectState ss = new SelectState(stateHandler);

        Scene s = ss.getScene();
        //Scene s = stateHandler.getScene();


        window.setScene(s);
        window.getIcons().add(new Image("/graphics/StageIconChess.png"));
        window.resizableProperty().setValue(Boolean.FALSE);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
