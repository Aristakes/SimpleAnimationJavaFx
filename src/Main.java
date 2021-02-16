import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Circle circle = new Circle(50, 100, 50);

        circle.setFill(Color.RED);
        circle.setStroke(Color.BLACK);

        TranslateTransition translateTransition = new TranslateTransition();

        translateTransition.setByX(500);

        translateTransition.setDuration(Duration.millis(1000));

        translateTransition.setCycleCount(500);

        translateTransition.setAutoReverse(true);

        translateTransition.setNode(circle);


        Button buttonStart = new Button("Start");

        buttonStart.setLayoutX(300);
        buttonStart.setLayoutY(250);

        //Code by Stalk


        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (buttonStart.getText().equals("Start")) {

                    buttonStart.setText("Stop");

                    translateTransition.play();

                } else if (buttonStart.getText().equals("Stop")) {

                    buttonStart.setText("Start");

                    if (translateTransition.getByX() == 500) {
                        translateTransition.setFromX(0);
                    }

                    translateTransition.stop();

                }


            }
        });


        Group root = new Group();


        root.getChildren().addAll(circle, buttonStart);

        Scene scene = new Scene(root, 600, 600);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Simple Animation JavaFx");

        primaryStage.show();





    }

    public static void main(String[] args) {
        launch(args);
    }


}
