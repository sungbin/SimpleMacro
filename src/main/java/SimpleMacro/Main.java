package SimpleMacro;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    GridPane mainGrid;
    GridPane lGrid;
    GridPane cGrid;
    GridPane rGrid;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Semi Mecro");

        mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(25, 25, 25, 25));

        lGrid = new GridPane();
        lGrid.setAlignment(Pos.CENTER_LEFT);
        lGrid.setHgap(10);
        lGrid.setVgap(10);
        lGrid.setPadding(new Insets(25, 100, 25, 25));

        rGrid = new GridPane();
        rGrid.setAlignment(Pos.CENTER_LEFT);
        rGrid.setHgap(10);
        rGrid.setVgap(10);
        rGrid.setPadding(new Insets(25, 25, 25, 100));

        StatusBar.init();

        cGrid = new GridPane();
        cGrid.setAlignment(Pos.CENTER_LEFT);
        cGrid.setHgap(10);
        cGrid.setVgap(10);
        cGrid.setPadding(new Insets(0, 0, 0, 0));

        cGrid.add(StatusBar.recordText,0,0,2,2);
        cGrid.add(StatusBar.rmButton,2,0);

        mainGrid.add(lGrid,0,1);
        mainGrid.add(StatusBar.status,0,0,1,1);
        mainGrid.add(cGrid,0,2,2,2);
        mainGrid.add(rGrid,2,1);


        // main
        for(int leftCount = 0; leftCount < 4; leftCount++) {
            addLeftButton("l-button" + leftCount, leftCount);
        }

        for(int rightCount = 0; rightCount < 4; rightCount++) {
            addRightButton("r-button" + rightCount, rightCount);
        }


        primaryStage.setScene(new Scene(mainGrid, 700, 300));
        primaryStage.show();
    }

    private void addRightButton(String name, int y) {

        RightButton rightButton = new RightButton('c');
        rGrid.add(rightButton.resetButton,0, y);
        rGrid.add(rightButton.button, 1, y);

//        Text lb1t = new Text(String.valueOf(rightButton.toChar()));
//        lb1t.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
//        rGrid.add(lb1t, 2, y);
    }


    public static void main(String[] args) {
        launch(args);
    }

    void addLeftButton(String name, int y) {

        LeftButton leftButton = new LeftButton(name);
        lGrid.add(leftButton.resetButton,0, y);
        lGrid.add(leftButton.button, 1, y);

        Text lb1t = new Text(leftButton.toString());
        lb1t.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        lGrid.add(lb1t, 2, y);
    }
}
