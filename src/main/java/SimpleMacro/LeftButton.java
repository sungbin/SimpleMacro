package SimpleMacro;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class LeftButton {
    public final Button button;
    public final Button resetButton;
    public final String name;

    double x = 0.0;
    double y = 0.0;

    public LeftButton(String name) {
        Button btn = new Button();
        btn.setText(name);
        btn.setOnAction(action);
        this.button = btn;
        this.name = name;

        Button resetButton = new Button();
        resetButton.setText("set");
        resetButton.setOnAction(resetAction);
        this.resetButton = resetButton;
    }


    //TODO:
    private EventHandler<ActionEvent> action = (actionEvent -> {
        System.out.println("clicked: " + toString());
    });


    private EventHandler<ActionEvent> resetAction = (actionEvent -> {
        System.out.println("reset: " + toString());
    });


    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
