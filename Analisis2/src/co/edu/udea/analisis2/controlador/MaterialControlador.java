/**
 * Sample Skeleton for 'IngresoPropietario.fxml' Controller Class
 */
package co.edu.udea.analisis2.controlador;

import co.edu.udea.analisis2.modelo.Material;
import co.edu.udea.analisis2.modelo.dao.MaterialDAO;
import co.edu.udea.analisis2.modelo.dao.impl.FileMaterialDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MaterialControlador {

    Material material;
    MaterialDAO materialDAO = new FileMaterialDAO();

    private Stage stagePrincipal;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtISBN"
    private TextField txtISBN; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitulo"
    private TextField txtTitulo; // Value injected by FXMLLoader

    @FXML // fx:id="txtAutor"
    private TextField txtAutor; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdioma"
    private TextField txtIdioma; // Value injected by FXMLLoader

    @FXML // fx:id="txtPais"
    private TextField txtPais; // Value injected by FXMLLoader

    @FXML // fx:id="btnAgregar"
    private Button btnAgregar; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancealr"
    private Button btnCancealr; // Value injected by FXMLLoader

    @FXML // fx:id="txtCategoria"
    private TextField txtCategoria; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnio"
    private TextField txtAnio; // Value injected by FXMLLoader

    @FXML // fx:id="txtEditorial"
    private TextField txtEditorial; // Value injected by FXMLLoader

    @FXML // fx:id="txtDiasPres"
    private TextField txtDiasPres; // Value injected by FXMLLoader

    @FXML
    void DoAgregar(ActionEvent event) {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String isbn = txtISBN.getText();
        String anio = txtAnio.getText();
        String idioma = txtIdioma.getText();
        String pais = txtPais.getText();
        String categoria = txtCategoria.getText();
        String editorial = txtEditorial.getText();
        String diasPres = txtDiasPres.getText();

        if ((isbn.equals("")) || (titulo.equals("")) || (autor.equals("")) || (anio.equals("")) || (idioma.equals("")) || (pais.equals(""))
                || (categoria.equals("")) || (editorial.equals("")) || (diasPres.equals(""))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No puede quedar ningun campo el blanco");

            alert.showAndWait();
        } else {

            material = new Material(isbn, titulo, autor, anio, idioma, pais, categoria, editorial, Integer.valueOf(diasPres));

            if (materialDAO.guardarMaterial(material)) {
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Agregado");
                alert.setHeaderText(null);
                alert.setContentText("El Material fue agregado satisfactoriamente");
                
                 alert.showAndWait();

                stagePrincipal.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("El ISBN que intenta ingresar ya existe");

                alert.showAndWait();

            }
        }

    }

    @FXML
    void DoCancelar(ActionEvent event) {
        stagePrincipal.close();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtISBN != null : "fx:id=\"txtISBN\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert txtTitulo != null : "fx:id=\"txtTitulo\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert txtAutor != null : "fx:id=\"txtAutor\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert txtIdioma != null : "fx:id=\"txtIdioma\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert txtPais != null : "fx:id=\"txtPais\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert btnAgregar != null : "fx:id=\"btnAgregar\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert btnCancealr != null : "fx:id=\"btnCancealr\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert txtCategoria != null : "fx:id=\"txtCategoria\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert txtAnio != null : "fx:id=\"txtAnio\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert txtEditorial != null : "fx:id=\"txtEditorial\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
        assert txtDiasPres != null : "fx:id=\"txtDiasPres\" was not injected: check your FXML file 'IngresoMaterial.fxml'.";
    }
}
