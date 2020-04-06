package SimpleMacro;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class StatusBar {

    public static String record = "xyx"; //TODO: remove

    public static Button rmButton;
    public static Text recordText;

    public static Text status;

    public static enum PageStatus {
        Ready,
        Run,
        SetKeyboard,
        SetMouse,
    };
    public static PageStatus pageStatus;

    public static String getStatus() {
        switch (pageStatus) {
            case Ready:
                return "Ready to Run!";

            case Run: return "Running";

            case SetKeyboard: return "Enter keyboard";

            case SetMouse: return "Click Mouse";

            default: return "ERROR";
        }

    }

    public static void init() {
        pageStatus = PageStatus.Ready;

        status = new Text(getStatus());
        status.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));

        recordText = new Text(record);
        recordText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

        rmButton = new Button();
        rmButton.setText("BackSpace");
        rmButton.setOnAction((actionEvent ->  {
                record = record.toString().substring(0, record.length()-1);
                update();
        }));
    }

    //TODO:
    public static void update() {
        recordText.setText(record);
    }
}
