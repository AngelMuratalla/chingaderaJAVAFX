package fes.aragon.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fes.aragon.modelo.Barco;
import fes.aragon.modelo.Usuario;
import fes.aragon.repository.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

public class AgregarBarcoController implements Initializable{
	@FXML
	private TextField txtMatricula = new TextField();
	@FXML
	private TextField txtNombre = new TextField();
	@FXML
	private ComboBox<Usuario> cmbPatron = new ComboBox<>();
	@FXML
	private ComboBox<Usuario> cmbDueño = new ComboBox<>();
	@FXML
	private Button btnAgregar = new Button();
	@FXML
	private Button btnCancelar = new Button();

	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void evntAgregar(ActionEvent event) {

		Conexion cnn;
		try {
			
			cnn = new Conexion();
			Barco barco = new Barco(txtMatricula.getText(), txtNombre.getText(), 
			cmbPatron.getValue(), cmbDueño.getValue());
			
			Stage escenario = (Stage) btnAgregar.getScene().getWindow();
			Alert confirmacion = new Alert(AlertType.CONFIRMATION);
			confirmacion.setContentText("¿Seguro de registrar el Barco: " + barco.getNombre() + "\nMatricula: " + barco.getMatricula());
			confirmacion.showAndWait();
			ButtonType respuesta = confirmacion.getResult();

			if (respuesta == ButtonType.OK) {
				Usuario u = barco.getDueno();
				int idDueno =  cnn.insertarDueno(u);
				cnn.insertarBarco(barco,idDueno);
			}
			
			cnn.cerrarConexion();
			escenario.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void evntCancelar(ActionEvent event) {
		// TODO Autogenerated
		Stage escenario = (Stage) btnCancelar.getScene().getWindow();
		Alert confirmacion = new Alert(AlertType.CONFIRMATION);
		confirmacion.setContentText("¿Seguro de cancelar la insercion?");
		confirmacion.setTitle("¡Cuidado!");
		confirmacion.showAndWait();
		ButtonType respuesta = confirmacion.getResult();

		if (respuesta == ButtonType.OK) {
			escenario.close();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Conexion cnn;
		ObservableList<Usuario> listaContactos = FXCollections.observableArrayList();
		ObservableList<Usuario> listaPatrones =  FXCollections.observableArrayList();
		ArrayList<Usuario> listaC;
		ArrayList<Usuario> listaP;
		try {

			cnn = new Conexion();
			listaC = cnn.consultarTodosUsuarios();
			for (Usuario contacto : listaC) {
				listaContactos.add(contacto);
			}
			cmbDueño.setItems(listaContactos);
			
			listaP = cnn.consultarTodosPatrones();
			for (Usuario patron : listaP) {
				listaPatrones.add(patron);
			}			
			cmbPatron.setItems(listaPatrones);
			
			cnn.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
