
package sortingalgorithmsimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SortingAlgorithmSimulator extends Application {
    
    static Stage stage1;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage1=stage;
        stage.setScene(scene);
        FXMLDocumentController ob=new FXMLDocumentController();
        ob.closeStage(stage);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
