package states;

import javafx.scene.Scene;

public abstract class BasicState {

    Scene s;
    boolean state;
    StateHandler stateHandler;

    public BasicState(StateHandler sh){
        stateHandler = sh;
    };

    public abstract Scene getScene();
    public abstract void setState(boolean s);
    public abstract boolean getState();


}
