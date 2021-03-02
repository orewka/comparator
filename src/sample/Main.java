package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private final String s1 = "В программе отсутствуют : ";
    private final String s2 = "В спецификации отсутствуют : ";

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea1 = new TextArea("Specification");
        TextArea textArea2 = new TextArea("Program");
        Button button = new Button("Compare");
        Label label1 = new Label("t1");
        Label label2 = new Label("t2");
        textArea1.setPrefColumnCount(20);
        textArea1.setPrefRowCount(10);
        textArea2.setPrefColumnCount(20);
        textArea2.setPrefRowCount(10);
        Comparator comparator = new Comparator();
        List<List<String>> strings = new ArrayList<>();
        button.setOnAction(event -> {
            strings.addAll(comparator.compare(textArea1.getText(), textArea2.getText()));
            label1.setText(comparator.q1 + " " + s2 + strings.get(1).toString());
            label2.setText(comparator.q2 + " " + s1 + strings.get(0).toString());
            comparator.clearResults();
        });
        FlowPane root = new FlowPane(10, 10, textArea1, textArea2, button, label1, label2);
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Comparator");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
