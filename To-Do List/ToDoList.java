import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
public class ToDoListApp extends Application {
    private ArrayList<CheckBox> tasks = new ArrayList<>();
    private VBox taskList = new VBox(5);

    private void updateList() {
        taskList.getChildren().clear();
        for (CheckBox taskCheckBox : tasks) {
            taskList.getChildren().add(taskCheckBox);
        }
    }
    public boolean isEmpty(){
        return tasks.isEmpty();
    }

    @Override
    public void start(Stage primaryStage) {
        TextField task = new TextField();
        task.setText("Enter a new task");

        Button add = new Button("Add Task");
        Button remove = new Button("Remove Task");
        remove.setStyle("-fx-text-color: red;");
        add.setOnAction(e -> {
            String taskt = task.getText();
            if (!taskt.isEmpty()) {
                CheckBox taskc= new CheckBox(taskt);
                tasks.add(taskc);
                updateList();
                task.clear();
            }
        });
        remove.setOnAction(e -> {
            tasks.removeIf(CheckBox::isSelected); // Remove checked tasks
            updateList();
        });

        VBox vBox = new VBox(10, task, add, taskList,remove);

        vBox.setStyle("-fx-padding: 20px;");
        primaryStage.setScene(new Scene(vBox, 300, 400));
        primaryStage.setTitle("To-Do List");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}