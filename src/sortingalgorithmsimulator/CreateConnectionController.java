/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithmsimulator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lotus Computer
 */
public class CreateConnectionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    private void setBubbleSort(ActionEvent event) {
        String sortName="Bubble_Sort";
        
        String serveraddress=FXMLDocumentController.serverip;
        Client client=new Client(sortName,serveraddress);
        client.start();
    }

    @FXML
    private void setInsertionSort(ActionEvent event) {
        String sortName="Insertion_Sort";
        
        String serveraddress=FXMLDocumentController.serverip;
        Client client=new Client(sortName,serveraddress);
        client.start();
    }

    @FXML
    private void setSelectionSort(ActionEvent event) {
        String sortName="Selection_Sort";
        
        String serveraddress=FXMLDocumentController.serverip;
        Client client=new Client(sortName,serveraddress);
        client.start();
    }

    @FXML
    private void setMergeSort(ActionEvent event) {
        String sortName="Merge_Sort";
        
        String serveraddress=FXMLDocumentController.serverip;
        Client client=new Client(sortName,serveraddress);
        client.start();
    }

    @FXML
    private void setQuickSort(ActionEvent event) {
        String sortName="Quick_Sort";
        
        String serveraddress=FXMLDocumentController.serverip;
        Client client=new Client(sortName,serveraddress);
        client.start();
    }

    @FXML
    private void setHeapSort(ActionEvent event) {
        String sortName="Heap_Sort";
        
        String serveraddress=FXMLDocumentController.serverip;
        Client client=new Client(sortName,serveraddress);
        client.start();
    }
    
}
