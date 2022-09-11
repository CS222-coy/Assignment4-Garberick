package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;


import java.io.IOException;
public class Main extends Application {
    Text scenetitle;
    Label description;
    TextField numberToCheck;
    Button checkButton;
    Text answer;
    Text evenOrOddText;
    @Override
    public void start(Stage stage) throws IOException {
        // set up alignment inside the window
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);  // set an internal gap between items of 10 pixels
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25)); // outside padding between grid & wind.
                // set up contents of the scene (interior of the window) inside the grid
                scenetitle = new Text("Guess a number");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1); // col 0, row 0, span 2 cols, span 1 row
        description = new Label("Enter a number:");
        grid.add(description, 0, 1); // col 0 row 1
        numberToCheck = new TextField();
        grid.add(numberToCheck, 1, 1);
        checkButton = new Button("Check this number!");
        grid.add(checkButton, 1, 4);
        answer = new Text();
        grid.add(answer, 1, 6);
        evenOrOddText = new Text();
        grid.add(evenOrOddText, 1, 8);
        // tie the button to an action
        checkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleButtonClick();
            }
        });
        // Scene is the window, specify the minimum dimensions (pixels)
        Scene scene = new Scene(grid, 400, 240);
        // stage -- what is displayed in the window
        stage.setTitle("Silly Method Application");
        stage.setScene(scene);
        stage.show();
    }
    private void handleButtonClick() {
        int userNum = 0;
        SillyMethods sillyMethods = new SillyMethods();
        String userEntry = numberToCheck.getText();
        // check that they entered a number
        try {
            userNum = Integer.parseInt(userEntry);
        } catch (final NumberFormatException error) {
            answer.setFill(Color.FIREBRICK);
            answer.setText("Please enter an integer.");
            return;
        }
        if (sillyMethods.didGuess42(userNum)) {
            answer.setFill(Color.DARKGREEN);
            answer.setText("You guessed 42! Good job\n"+sillyMethods.countTo(userNum));
        } else {
            answer.setFill(Color.FIREBRICK);
            answer.setText("That's not the number I want\n"+sillyMethods.countTo(userNum));
        }
        if (sillyMethods.isEven(userNum)) {
            evenOrOddText.setFill(Color.DARKGREEN);
            evenOrOddText.setText("That is an even number");
        } else {
            evenOrOddText.setFill(Color.DARKGREEN);
            evenOrOddText.setText("That is an odd number");
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
