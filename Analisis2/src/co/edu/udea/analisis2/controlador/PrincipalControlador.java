/**
 * Sample Skeleton for 'Laboratiorio.fxml' Controller Class
 */
package co.edu.udea.analisis2.controlador;


import co.edu.udea.analisis2.vista.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrincipalControlador {

    private Main ProgramaPrincipal;
    

   @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnMaterial"
    private Button btnMaterial; // Value injected by FXMLLoader

    @FXML
    void doIngresarMat(ActionEvent event) {
           
         ProgramaPrincipal.mostrarIngresoMaterial();

    }



    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    /*void mostrar(String mensaje){
        txtResult.appendText(mensaje + " ");
    }*/
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    assert btnMaterial != null : "fx:id=\"btnMaterial\" was not injected: check your FXML file 'Principal.fxml'.";

    }
}
