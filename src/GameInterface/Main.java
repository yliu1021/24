package GameInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setPrefSize(400, 600);
        RowConstraints rowC = new RowConstraints();
        rowC.setPrefHeight(400);
        root.getRowConstraints().add(rowC);
        GridPane buttonGrid = new GridPane();
        buttonGrid.setPrefSize(400,400);
        buttonGrid.setGridLinesVisible(true);
        final int numCols = 20;
        final int numRows = 20;

        for(int i = 0;i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            buttonGrid.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            buttonGrid.getRowConstraints().add(rowConst);
        }
        //fill grid with buttons
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++) {
                Button b = new Button("_");
                buttonGrid.add(b, i, j);
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {//start
                        //disable all buttons on the grid
                        buttonGrid.setDisable(true);

                    }
                }
                );

            }
        root.add(buttonGrid, 0, 0);

        Label label = new Label("         Numbers: ");

        RowConstraints rowC2 = new RowConstraints();
        rowC2.setPrefHeight(200);
        root.getRowConstraints().add(rowC2);
        ColumnConstraints colC = new ColumnConstraints();
        colC.setPrefWidth(100);
        root.getColumnConstraints().add(colC);
        root.add(label, 0, 1);

        GridPane numGrid = new GridPane();
        GridPane operandGrid = new GridPane();

        operandGrid.add();
        root.add(numGrid,1,1);

        for (int i = 1; i <= 10;i++){//start for
            Button b = new Button(""+(i-1));
            b.setOnAction(new EventHandler<ActionEvent>() {
                              @Override
                              public void handle(ActionEvent e) {//start
                                  //reenable all buttons on the grid
                                  buttonGrid.setDisable(false);
                                  //
                              }
                          }
            );
            root.add(b, i, 1);
        }//end for



//
        primaryStage.setTitle("Don't be mat, iz just gaem");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);

    }
}
