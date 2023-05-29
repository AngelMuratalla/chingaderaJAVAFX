package fes.aragon.controller;

import fes.aragon.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CambiarPrivilegiosController {


    @FXML
    private Button btnAceptarCP;

    @FXML
    private Button btnCancelarCP;

    @FXML
    private ComboBox<?> cmbDuenoCP;

    @FXML
    private ComboBox<?> cmbPatronCP;

    @FXML
    private ComboBox<?> cmbSocioCP;

    @FXML
    private RadioButton rdBtnDuenoCP;

    @FXML
    private RadioButton rdBtnPatronCP;

    @FXML
    private RadioButton rdBtnSocioCP;

    @FXML
    void eventCambiar(ActionEvent event) {
    	
 
    }

    @FXML
    void eventCancelar(ActionEvent event) {
    	Stage escenario = (Stage) btnCancelarCP.getScene().getWindow();
		Alert confirmacion = new Alert(AlertType.CONFIRMATION);
		confirmacion.setContentText("¿Seguro de cancelar?");
		confirmacion.setTitle("¡Cuidado!");
		confirmacion.showAndWait();
		ButtonType respuesta = confirmacion.getResult();

		if (respuesta == ButtonType.OK) {
			escenario.close();
		}
    }

}
