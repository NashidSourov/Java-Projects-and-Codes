package mycalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable 
{     

    @FXML
    private TextField display;
    @FXML
    private Button b0;
    @FXML
    private Button bequal;
    @FXML
    private Button badd;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button bsub;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button bmultiply;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Button bdiv;
        
    private String displayText = "";
    private String operation;
    private double x;
    private double y;
    private double z;
    @FXML
    private Button bdot;
    @FXML
    private Button bclear;
    @FXML
    private Button bpercent;
    @FXML
    private Button broot;
    @FXML
    private Button bsquare;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }        

    @FXML
    private void doDisplay(ActionEvent event) 
    {
        Button b = (Button)event.getSource();
        displayText += b.getText();        
        display.setText(displayText);
    }    

    @FXML
    private void doResult(ActionEvent event) 
    {
        y = Integer.parseInt(display.getText());
        
        if(operation.compareTo("+") == 0) z = x + y;
        if(operation.compareTo("-") == 0) z = x - y;
        if(operation.compareTo("*") == 0) z = x * y;
        if(operation.compareTo("/") == 0) z = x / y;
        if(operation.compareTo("%") == 0) z = x % y;
        if(operation.compareTo("√") == 0) z = (double) Math.sqrt(x);
        if(operation.compareTo("x^2") == 0) z = x*x;
        
        
        
        display.setText(""+z);
    }

    @FXML
    private void doOperation(ActionEvent event) 
    {
        x = Integer.parseInt(display.getText());
        
        displayText = "";
        display.setText("");
        
        Button b = (Button)event.getSource();        
        operation = b.getText();
        displayText = "";
        display.setText("");
    }
}
