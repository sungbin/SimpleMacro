package SimpleMacro;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RightButton {
    public final Button button;
    public final Button resetButton;

    char val = 'c';

    public RightButton(char name) {
        Button btn = new Button();
        btn.setText(String.valueOf(name));
        btn.setOnAction(action);
        this.button = btn;
        Button resetButton = new Button();
        resetButton.setText("set");
        resetButton.setOnAction(setAction);
        this.resetButton = resetButton;
    }

    private EventHandler<ActionEvent> action = (actionEvent -> {
        StatusBar.record = StatusBar.record + toChar();
        StatusBar.update();
    });


    //TODO: change char, and update StatusBar
    private EventHandler<ActionEvent> setAction = (actionEvent -> {
        System.out.println("clicked: " + toString());
    });


    public char toChar() {
        return val;
    }
}
