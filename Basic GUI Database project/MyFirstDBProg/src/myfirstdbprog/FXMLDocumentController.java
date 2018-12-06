package myfirstdbprog;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
  

public class FXMLDocumentController implements Initializable 
{  
    final String PASS = "" ;  
    @FXML
    private TextField tid;
    @FXML
    private TextField tname;
    @FXML
    private TextArea taddress;
    @FXML
    private Button bsave;
    @FXML
    private Button bclear;
    @FXML
    private Label status;
    @FXML
    private Button bshow;
    
    Connection con = null;
    Statement stm;
    ResultSet rs;
    @FXML
    private Button bdelete;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try{
            if(con == null)
                con = getConnection();
        }
        catch(Exception err){
            System.out.println(err);
        }
    }        

    @FXML
    private void doSave(ActionEvent event) 
    {
        String id = tid.getText().trim();
        String name = tname.getText().trim();
        String address = taddress.getText().trim();
        
        String sql = "insert into home values("+id+",'"+name+"','"+address+"')";
        System.out.println(sql);
        try
        {
              
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/home?user=root&password=" + PASS);
            stm = con.createStatement();            
            
            if(stm.executeUpdate(sql) == 1) status.setText("Success ...");
            else status.setText("Operation Faild ...");            
         
            stm.close();
            con.close();
        }
        catch(Exception err)
        {
            status.setText(""+err);
        }       
    }

    @FXML
    private void doClear(ActionEvent event) 
    {
        tid.setText("");
        tname.setText("");
        taddress.setText("");
        status.setText("");
    }

    @FXML
    private void doShow(ActionEvent event) 
    {
        String id = tid.getText().trim();        
        
        String sql = "select name, address from home where id ="+id;
        System.out.println(sql);
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");           
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/home?user=root&password=" + PASS);
            stm = con.createStatement();            
            
            rs = stm.executeQuery(sql);
            while(rs.next())
            {
                tname.setText(""+rs.getString(1));
                taddress.setText(""+rs.getString(2));
            }
         
            rs.close();
            stm.close();
            con.close();
        }
        catch(Exception err)
        {
            status.setText(""+err);
        }       
    }

    @FXML
    private void doDelete(ActionEvent event) {
         String id = tid.getText(); 
         String sql = "delete from home where id="+id;
        
        
        System.out.println(sql);
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");           
            //con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/home?user=root&password=" + PASS);
            if(con == null)
                con = getConnection();
            
            stm = con.createStatement();            
            
            if(stm.executeUpdate(sql) == 1) status.setText("Success ...");
            else status.setText("Operation Faild ...");
//            while(rs.next())
//            {
//                tname.setText(""+rs.getString(1));
//                taddress.setText(""+rs.getString(2));
//            }
         
            //rs.close();
            stm.close();
            //con.close();
        }
        catch(Exception err)
        {
            status.setText(""+err);
        }       
    }
    
    private Connection getConnection(){
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/home?user=root&password=" + PASS);
            
        }catch (SQLException sqle){
            System.out.println(sqle);
        }
        
        return con;
    }

    @FXML
    private void doUpdate(ActionEvent event) {
        String id = tid.getText().trim();
        String name = tname.getText().trim();
        String address = taddress.getText().trim();
        
        String sql = "update home set name ='"+name+"',address = '"+address+"' where id = "+id;
        //update home set Name ='xyz', address='abc', where id = 1;
        System.out.println(sql);
        try
        {
              
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/home?user=root&password=" + PASS);
            stm = con.createStatement();            
            
            if(stm.executeUpdate(sql) == 1) status.setText("Success ...");
            else status.setText("Operation Faild ...");            
         
            stm.close();
            con.close();
        }
        catch(Exception err)
        {
            status.setText(""+err);
        }    
    }
}