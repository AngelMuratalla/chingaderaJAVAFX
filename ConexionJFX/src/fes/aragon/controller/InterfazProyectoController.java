package fes.aragon.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import fes.aragon.modelo.Barco;
import fes.aragon.modelo.Entrada;
import fes.aragon.modelo.Salida;
import fes.aragon.modelo.Usuario;
import fes.aragon.repository.Conexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InterfazProyectoController implements Initializable {

	Usuario seleccionado;
	Barco barcoSeleccionado;
	
	@FXML
    private Button btnBuscar_Us1;

    @FXML
    private Button btnCancelarSel_Us1;


    @FXML
    private Button btnGuardar_Us1;


    @FXML
    private Button btnSeleccionar_Us1;

    @FXML
    private Button btnVerTodos_Us1;


    @FXML
    private TableColumn<?, ?> clmNombre_Us1;


    @FXML
    private TableColumn<?, ?> clmPatron_Us1;


    @FXML
    private TableColumn<?, ?> clmSocio_Us1;


    @FXML
    private TableColumn<?, ?> clmTelefono_Us1;

    @FXML
    private ComboBox<?> cmbRubroBusqueda_Us1;

    @FXML
    private ComboBox<?> cmbSocio1;

    @FXML
    private ComboBox<?> cmbSocio11;

    @FXML
    private ComboBox<?> cmbSocio111;

    @FXML
    private RadioButton rdbtnPatron_Us1;

    @FXML
    private RadioButton rdbtnPatron_Us11;

    @FXML
    private RadioButton rdbtnPatron_Us111;

   
    @FXML
    private TableView<?> tblTabla_Us1;


    @FXML
    private TextField txtBuscar_Us1;
	
	@FXML
    private TableView<Usuario> tblTabla_Us ;
	
    @FXML
    private TableView<Barco> tblBarcos;
	
    @FXML
    private TableView<Entrada> tblEntradas;
    
    @FXML
    private TableView<Salida> tblSalidas;
    
    @FXML
    private Button btnBuscar_Sal;
    
    @FXML
    private Button btnCancelarSeleccion_Bar;
    
    @FXML
    private Button btnCancelarSel_Us;

    @FXML
    private Button btnRegistrarSalida;

    @FXML
    private RadioButton rdbtnPatron_Us = new RadioButton();

    @FXML
    private TableColumn<Salida, String> clmDestino_Sal;

    @FXML
    private TextField txtBuscar_Us = new TextField();

    @FXML
    private TextField txtMatricula_Bar;

    @FXML
    private Button btnSeleccionar_Us;
    
    @FXML
    private Button btnCP_Us;

    @FXML
    private TableColumn<Barco, String> clmNombre_Bar;

    @FXML
    private TextField txtNombre_Bar;

    @FXML
    private Button btnBuscar_Ent;

    @FXML
    private TableColumn<Usuario, String> clmNombre_Us;

    @FXML
    private Button btnSeleccionar_Bar;

    @FXML
    private Button btnVerTodos_Us;

    @FXML
    private TextField txtEmail_Us;

    @FXML
    private Button btnGuardar_Us = new Button();

    @FXML
    private Button btnGuardarCambios_Bar;

    @FXML
    private TableColumn<Entrada, Integer> clmNumeroAmarre_Ent;

    @FXML
    private TableColumn<Salida, String> clmMatricula_Sal;

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private TableColumn<Salida, String> clmFechaSalida_Sal;

    @FXML
    private Button btnBuscar_Us;

    @FXML
    private TableColumn<Entrada, String> clmFechaLlegada_Ent;

    @FXML
    private ComboBox<Usuario> cmbPatron_Bar;

    @FXML
    private Button btnLimpiarBusqueda;

    @FXML
    private TextField txtBuscar_Bar;

    @FXML
    private TableColumn<Usuario, String> clmSocio_Us;

    @FXML
    private TextField txtApellidoPaterno_Us;

    @FXML
    private ComboBox<String> cmbRubroBusqueda_Ent  = new ComboBox<String>();

    @FXML
    private TextField txtBuscar_Sal;

    @FXML
    private TextField txtNombre_Us;

    @FXML
    private Button btnVerTodos_Ent;

    @FXML
    private ComboBox<String> cmbRubroBusqueda_Sal  = new ComboBox<String>();

    @FXML
    private ComboBox<Usuario> cmbDueño_Bar;

    @FXML
    private TableColumn<Usuario, String> clmEmail_Us;

    @FXML
    private TableColumn<Barco, String> clmMatricula_Bar;

    @FXML
    private Button btnBuscar_Bar;

    @FXML
    private TextField txtTelefono_Us;

    @FXML
    private TextField txtBuscar_Ent;

    @FXML
    private TableColumn<Barco, String> clmPatron_Bar;

    @FXML
    private TableColumn<Usuario, String> clmPatron_Us;

    @FXML
    private Button btnAgregarNuevo_Us;

    @FXML
    private Button btnVerTodos_Sal;

    @FXML
    private ComboBox<String> cmbRubroBusqueda_Us = new ComboBox<String>();

    @FXML
    private Button btnAgregarNuevo_Bar = new Button();

    @FXML
    private ComboBox<Usuario> cmbSocio;

    @FXML
    private TableColumn<Entrada, String> clmMatricula_Ent;

    @FXML
    private Button btnCrearEntrada;

    @FXML
    private ComboBox<String> cmbFecha_Sal =  new ComboBox<String>();

    @FXML
    private TableColumn<Barco, String> clmDueño_Bar;

    @FXML
    private Button btnVerTodos_Bar = new Button();


    @FXML
    private ComboBox<String> cmbFecha_Ent  = new ComboBox<String>();

    @FXML
    private TableColumn<Usuario, String> clmTelefono_Us;

    @FXML
    private Button btnLimpiarBusqueda_Sal;

    @FXML
    private ComboBox<String> cmbRubroBusqueda_Bar = new ComboBox<String>();

    @FXML
    private TextField txtApellidoMaterno_Us;

 
    /*---------------------------------------------------------------INICIO COMPONENTES SECCIÓN USUARIOS--------------------------------------------------*/
    
    @FXML
    void eventoVerTodos_Us(ActionEvent event) {
    	rellenarTablaUsuarios();
    }
    
    @FXML
    void eventoBuscar_Us(ActionEvent event) {
    	
    	String rubro = cmbRubroBusqueda_Us.getValue();
    	String busqueda = txtBuscar_Us.getText();
    	
    	
    	if(rubro == null || busqueda.isEmpty() || busqueda.equalsIgnoreCase("Buscar ...")) {
    	
    		//Dar mensaje de aviso
    		enviarAviso("Se necesita un rubro de busqueda y algo dentro de 'Buscar'.", "Error en la busqueda");
  
    	} else {
    		
    		//Realiza busqueda
    		//Posible mejora agregar por nombre y apellidos
        	try {
    			Conexion cnn = new Conexion();
    			ArrayList<Usuario> usuarios = cnn.consultarUsuarios(rubro.toLowerCase(), busqueda);
    			this.tblTabla_Us.setItems(FXCollections.observableArrayList(usuarios));
    			cnn.cerrarConexion();
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	
    	}
    	
    }

    @FXML
    void eventoAgregarNuevo_Us(ActionEvent event) {
    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/AgregarUsuario.fxml"));
			Scene escena = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(escena);
			escenario.initStyle(StageStyle.UNDECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    @FXML
    void eventoEliminarUsuario(ActionEvent event) {

    }

    @FXML
    void eventoPatron_Us(ActionEvent event) {

    }
    
    @FXML
    void eventoSocio_Us(ActionEvent event) {

    }

    
    
   
    @FXML
    void eventoSeleccionar_Us(ActionEvent event) {
    	
    	Usuario u = tblTabla_Us.getSelectionModel().getSelectedItem();
    	
    	if(!(u == null)) {
    		habilitarModificarUsuario("H");
        	vaciarModificarUsuario();
        	    	
        	seleccionado = u;
        	
        	txtNombre_Us.setText(u.getNombre());
        	txtApellidoPaterno_Us.setText(u.getApPat());
        	txtApellidoMaterno_Us.setText(u.getApMat());
        	txtEmail_Us.setText(u.getEmail());
        	txtTelefono_Us.setText(u.getTelefono());	
        	comboBoxSocios();
        	
        	
    		if(u.daElSocio()!=null) {
    			cmbSocio.setValue(u.daElSocio());
    		}
    		
    		if (u.daElPatron()) {
    			rdbtnPatron_Us.setSelected(u.daElPatron());
    		}
    		
    	}
    }
    
    @FXML
    void evntCancelarSel_Us(ActionEvent event) {
    	vaciarModificarUsuario();
    	habilitarModificarUsuario("D");
    }
    
    void comboBoxSocios() {
    	ObservableList<Usuario> listaContactos = FXCollections.observableArrayList();
		ArrayList<Usuario> lista;
		
		try {

			Conexion cnn = new Conexion();
			lista = cnn.consultarTodosSocios();
			listaContactos.add(new Usuario(0, "Este usuario ", "es ", "Socio", "", ""));
			
			for (Usuario contacto : lista) {
				listaContactos.add(contacto);
			}
			
			cmbSocio.setItems(listaContactos);
			
			cnn.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void eventoModificarPrivilegios(ActionEvent event) {
    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/ModificarPrivilegios.fxml"));
			Scene escena = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(escena);
			escenario.initStyle(StageStyle.UNDECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

        
    @FXML
    void eventoGuardar_Us(ActionEvent event) {
    	
    	Usuario u = seleccionado;
    	Conexion cnn;
    	
    	seleccionado.setNombre(txtNombre_Us.getText());
    	seleccionado.setApPat(txtApellidoPaterno_Us.getText());
    	seleccionado.setApMat(txtApellidoMaterno_Us.getText());
    	seleccionado.setEmail(txtEmail_Us.getText());
    	seleccionado.setTelefono(txtTelefono_Us.getText());
    	
    	
		try {
			cnn = new Conexion();
			
			if(rdbtnPatron_Us.isSelected()) {
	    		if(!u.daElPatron()) {
	    			cnn.InsertarPatron(u.getIdContacto(), cnn.getIdSocio(cmbSocio.getValue().getIdContacto()));
	    		}
	    	}else {
	    		if(u.daElPatron()) {
	    			cnn.eliminarElPatron(u);
	    		}
	    	}
			cnn.actualizarPatron(u, cnn.getIdSocio(cmbSocio.getValue().getIdContacto()));
			cnn.actualizarUsuario(u);
	    	cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		System.out.println(u);
		
		vaciarModificarUsuario();
		habilitarModificarUsuario("D");
		rellenarTablaUsuarios();
		
    	seleccionado = null; 
    }

    private void rellenarTablaUsuarios() {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Usuario> usuarios = cnn.consultarTodosUsuarios();
			this.tblTabla_Us.setItems(FXCollections.observableArrayList(usuarios));
			cmbRubroBusqueda_Us.setValue(null);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    private void habilitarModificarUsuario(String habilitado) {
    	switch(habilitado) {
    		
    		// Para habilitar
    		case "H":
    			txtNombre_Us.setDisable(false);
    	    	txtApellidoPaterno_Us.setDisable(false);
    	    	txtApellidoMaterno_Us.setDisable(false);
    	    	txtEmail_Us.setDisable(false);
    	    	txtTelefono_Us.setDisable(false);
    	    	cmbSocio.setDisable(false);
    	    	rdbtnPatron_Us.setDisable(false);
    	    	rdbtnPatron_Us.setDisable(false);
    	    	btnCancelarSel_Us.setDisable(false);
    	    	btnGuardar_Us.setDisable(false);
    			break;
    			
    		// Para desabilitar
    		case "D":
    			txtNombre_Us.setDisable(true);
    	    	txtApellidoPaterno_Us.setDisable(true);
    	    	txtApellidoMaterno_Us.setDisable(true);
    	    	txtEmail_Us.setDisable(true);
    	    	txtTelefono_Us.setDisable(true);
    	    	cmbSocio.setDisable(true);
    	    	rdbtnPatron_Us.setDisable(true);
    	    	rdbtnPatron_Us.setDisable(true);
    	    	btnCancelarSel_Us.setDisable(true);
    	    	btnGuardar_Us.setDisable(true);
    	    	break;
    	}
    }

    
    private void vaciarModificarUsuario() {
    	txtNombre_Us.setText("");
    	txtApellidoPaterno_Us.setText("");
    	txtApellidoMaterno_Us.setText("");
    	txtEmail_Us.setText("");
    	txtTelefono_Us.setText("");
    	rdbtnPatron_Us.setSelected(false);
    	cmbSocio.setValue(null);
    }

    
    /*---------------------------------------------------------------FIN DE COMPONENTES SECCIÓN USUARIOS--------------------------------------------------*/

    /*---------------------------------------------------------------INICIO DE COMPONENTES SECCIÓN BARCOS--------------------------------------------------*/
    @FXML
    void eventoVerTodos_Bar(ActionEvent event) {
    	rellenarTablaBarcos();
    }

    @FXML
    void eventoAgregarNuevo_Bar(ActionEvent event) {
    	
    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/AgregarBarco.fxml"));
			Scene escena = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(escena);
			escenario.initStyle(StageStyle.UNDECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoSeleccionar_Bar(ActionEvent event) {
    	
    	Barco bc = tblBarcos.getSelectionModel().getSelectedItem();
    	
    	if(!(bc == null)) {
    		habilitarModificarBarco("H");
        	vaciarModificarBarco();
        	
        	txtNombre_Bar.setText(bc.getNombre());
        	txtMatricula_Bar.setText(bc.getMatricula());
        	comboBoxPatrones(bc);
        	comboBoxDuenos(bc);
        	barcoSeleccionado = bc;
        	
    		
    	}
    }



    @FXML
    void eventoGuardarCambios_Bar(ActionEvent event) {

    	String numMatricula = barcoSeleccionado.getMatricula();
    	
    	barcoSeleccionado.setMatricula(txtMatricula_Bar.getText());
    	barcoSeleccionado.setNombre(txtNombre_Bar.getText());
    	barcoSeleccionado.setPatron(cmbPatron_Bar.getValue());
    	barcoSeleccionado.setDueno(cmbDueño_Bar.getValue());

    	Conexion cnn;
		try {
			cnn = new Conexion();
			cnn.actualizarBarco(barcoSeleccionado, numMatricula);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	vaciarModificarBarco();
    	habilitarModificarBarco("D");
    	rellenarTablaBarcos();
    }
    
    @FXML
    void evntCancelarSel_Bar(ActionEvent event) {
    	vaciarModificarBarco();
    	habilitarModificarBarco("D");
    }

    @FXML
    void eventoBuscar_Bar(ActionEvent event) {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Barco> barcos = cnn.consultarBarcos(cmbRubroBusqueda_Bar.getValue().toLowerCase(), txtBuscar_Bar.getText());
			this.tblBarcos.setItems(FXCollections.observableArrayList(barcos));
			cmbRubroBusqueda_Bar.setValue(null);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private void rellenarTablaBarcos() {
    	try {
			Conexion cnn = new Conexion();
			ArrayList<Barco> barcos = cnn.consultarTodosBarcos();
			this.tblBarcos.setItems(FXCollections.observableArrayList(barcos));
			cmbRubroBusqueda_Bar.setValue(null);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void habilitarModificarBarco(String habilitado) {
    	switch(habilitado) {
    		
    		// Para habilitar
    		case "H":
    			txtNombre_Bar.setDisable(false);
    	    	txtMatricula_Bar.setDisable(false);
    	    	cmbPatron_Bar.setDisable(false);
    	    	cmbDueño_Bar.setDisable(false);
    	    	btnCancelarSeleccion_Bar.setDisable(false);
    	    	btnGuardarCambios_Bar.setDisable(false);
    			break;
    			
    		// Para desabilitar
    		case "D":
    			txtNombre_Bar.setDisable(true);
    	    	txtMatricula_Bar.setDisable(true);
    	    	cmbPatron_Bar.setDisable(true);
    	    	cmbDueño_Bar.setDisable(true);
    	    	btnCancelarSeleccion_Bar.setDisable(true);
    	    	btnGuardarCambios_Bar.setDisable(true);
    			break;
    	}
    }

    
    private void vaciarModificarBarco() {
    	txtNombre_Bar.setText("");
    	txtMatricula_Bar.setText("");
    	cmbPatron_Bar.setValue(null);
    	cmbDueño_Bar.setValue(null);
    }
    
    void comboBoxPatrones(Barco bc) {
    	ObservableList<Usuario> listaContactos = FXCollections.observableArrayList();
		ArrayList<Usuario> lista;
		
		try {

			Conexion cnn = new Conexion();
			lista = cnn.consultarTodosPatrones();
			listaContactos.add(new Usuario(0, "Este usuario ", "es ", "Socio", "", ""));
			
			Usuario u = cnn.buscarBarco(bc.getMatricula()).getPatron() ;

			for (Usuario contacto : lista) {
				listaContactos.add(contacto);
			}
			
			cmbPatron_Bar.setItems(listaContactos);
			cmbPatron_Bar.setValue(u);
			cnn.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void comboBoxDuenos(Barco bc) {
    	ObservableList<Usuario> listaContactos = FXCollections.observableArrayList();
		ArrayList<Usuario> lista;
		
		try {

			Conexion cnn = new Conexion();
			lista = cnn.consultarTodosDuenos();
			listaContactos.add(new Usuario(0, "Este usuario ", "es ", "Socio", "", ""));
			
			Usuario u = cnn.buscarBarco(bc.getMatricula()).getDueno() ;
			
			for (Usuario contacto : lista) {
				listaContactos.add(contacto);
			}
			
			cmbDueño_Bar.setItems(listaContactos);
			cmbDueño_Bar.setValue(u);
			cnn.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    /*---------------------------------------------------------------FIN DE COMPONENTES SECCIÓN BARCOS--------------------------------------------------*/
    

    @FXML
    void eventoVerTodos_Ent(ActionEvent event) {

    	try {
			Conexion cnn = new Conexion();
			ArrayList<Entrada> entradas = cnn.consultarTodasEntradas();
			this.tblEntradas.setItems(FXCollections.observableArrayList(entradas));
			cmbRubroBusqueda_Ent.setValue(null);
			cmbFecha_Ent.setValue(null);
			txtBuscar_Ent.setText("");
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoCrearEntrada(ActionEvent event) {

    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/CrearEntrada.fxml"));
			Scene escena = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(escena);
			escenario.initStyle(StageStyle.UNDECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoLimpiarBusqueda(ActionEvent event) {

    	txtBuscar_Ent.setText("");
    	cmbRubroBusqueda_Ent.setValue(null);
    	cmbFecha_Ent.setValue(null);
    	tblEntradas.setItems(null);
    
    	
    }

    @FXML
    void eventoBuscar_Ent(ActionEvent event) {

    	ArrayList<String> rubroBusEnt = new ArrayList<>();
		rubroBusEnt.add("Matricula");
		rubroBusEnt.add("Num. Amarre");
		
    	try {
			Conexion cnn = new Conexion();
			int desicion = rubroBusEnt.indexOf(cmbRubroBusqueda_Ent.getValue());
			String cadDesicion, busqueda, filtroFecha = "";
			if(desicion == 0) {
				cadDesicion = "num_mta like ";
				busqueda = "'%" + txtBuscar_Ent.getText() + "%'";
			}else {
				cadDesicion = "num_ams = ";
				busqueda ="" + Integer.parseInt(txtBuscar_Ent.getText());
			}
			
			if(cmbFecha_Ent.getValue() != null) {
				filtroFecha =" and fecha_llegada = '" + cmbFecha_Ent.getValue() + "'";
			}
			ArrayList<Entrada> entradas = cnn.consultarEntradas(cadDesicion,busqueda,filtroFecha);
			this.tblEntradas.setItems(FXCollections.observableArrayList(entradas));
			
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @FXML
    void eventoVerTodos_Sal(ActionEvent event) {

    	try {
			Conexion cnn = new Conexion();
			ArrayList<Salida> salidas = cnn.consultarTodasSalidas();
			this.tblSalidas.setItems(FXCollections.observableArrayList(salidas));
			cmbRubroBusqueda_Sal.setValue(null);
			cmbFecha_Sal.setValue(null);
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoRegistrarSalida(ActionEvent event) {

    	try {
    		
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("/fes/aragon/fxml/RegistrarSalida.fxml"));
			Scene escena = new Scene(root);
			Stage escenario = new Stage();
			escenario.setScene(escena);
			escenario.initStyle(StageStyle.UNDECORATED);
			escenario.initModality(Modality.APPLICATION_MODAL);
			escenario.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void eventoLimpiarBusqueda_Sal(ActionEvent event) {
    	txtBuscar_Sal.setText("");
    	cmbRubroBusqueda_Sal.setValue(null);
    	cmbFecha_Sal.setValue(null);
    	tblSalidas.setItems(null);
    }

    @FXML
    void eventoBuscar_Sal(ActionEvent event) {
    	ArrayList<String> rubroBusSal = new ArrayList<>();
		rubroBusSal.add("Matricula");
		rubroBusSal.add("Destino");
		
    	try {
			Conexion cnn = new Conexion();
			int desicion = rubroBusSal.indexOf(cmbRubroBusqueda_Sal.getValue());
			String cadDesicion, busqueda, filtroFecha = "";
			if(desicion == 0) {
				cadDesicion = "num_mta like ";
				busqueda = "'%" + txtBuscar_Sal.getText() + "%'";
			}else {
				cadDesicion = "destino like ";
				busqueda ="'%" + txtBuscar_Sal.getText()+"%'";
			}
			
			if(cmbFecha_Sal.getValue() != null) {
				filtroFecha =" and fecha_salida = '" + cmbFecha_Sal.getValue() + "'";
			}
			ArrayList<Salida> salidas = cnn.consultarSalidas(cadDesicion,busqueda,filtroFecha);
			this.tblSalidas.setItems(FXCollections.observableArrayList(salidas));
			cnn.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    /*----------------------------------VENTANAS DE ALERTA--------------------------------------- */
    private void enviarAviso(String mensaje, String titulo) {
    	Alert confirmacion = new Alert(AlertType.INFORMATION);
		confirmacion.setContentText(mensaje);
		confirmacion.setTitle(titulo);
		confirmacion.showAndWait();
    }
    /*----------------------------------VENTANAS DE ALERTA--------------------------------------- */
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Conexion cnn;
		
		txtBuscar_Us.setOnMouseClicked(event ->{
			txtBuscar_Us.setText("");
		});
		
		txtBuscar_Bar.setOnMouseClicked(event ->{
			txtBuscar_Bar.setText("");
		});
		
		txtBuscar_Ent.setOnMouseClicked(event ->{
			txtBuscar_Ent.setText("");
		});
		
		txtBuscar_Sal.setOnMouseClicked(event ->{
			txtBuscar_Sal.setText("");
		});
		
		ObservableList<String>  rubrosUsu = FXCollections.observableArrayList();
		ArrayList<String> rubroBusUsu = new ArrayList<>();
		rubroBusUsu.add("Nombre");
		rubroBusUsu.add("Telefono");
		rubroBusUsu.add("Email");
		for (String cadena : rubroBusUsu) {
			rubrosUsu.add(cadena);
		}
		cmbRubroBusqueda_Us.setItems(rubrosUsu);
		
		ObservableList<String>  rubrosBar = FXCollections.observableArrayList();
		ArrayList<String> rubroBusBar = new ArrayList<>();
		rubroBusBar.add("Nombre");
		rubroBusBar.add("Matricula");
		for (String cadena : rubroBusBar) {
			rubrosBar.add(cadena);
		}
		cmbRubroBusqueda_Bar.setItems(rubrosBar);
		
		ObservableList<String>  rubrosEnt = FXCollections.observableArrayList();
		ArrayList<String> rubroBusEnt = new ArrayList<>();
		rubroBusEnt.add("Matricula");
		rubroBusEnt.add("Num. Amarre");
		for (String cadena : rubroBusEnt) {
			rubrosEnt.add(cadena);
		}
		cmbRubroBusqueda_Ent.setItems(rubrosEnt);
		
		ObservableList<String>  rubrosSal = FXCollections.observableArrayList();
		ArrayList<String> rubroBusSal = new ArrayList<>();
		rubroBusSal.add("Matricula");
		rubroBusSal.add("Destino");
		for (String cadena : rubroBusSal) {
			rubrosSal.add(cadena);
		}
		cmbRubroBusqueda_Sal.setItems(rubrosSal);
		
		ObservableList<String> fechasEntrada = FXCollections.observableArrayList();
		ArrayList<String> fechasE;
		ObservableList<String> fechasSalida = FXCollections.observableArrayList();
		ArrayList<String> fechasS;
		try {
			
			cnn = new Conexion();
			fechasE = cnn.consultarFechaEntradas();
			for (String entrada : fechasE) {
				fechasEntrada.add(entrada);
			}
			cmbFecha_Ent.setItems(fechasEntrada);
			
			fechasS = cnn.consultarFechaSalida();
			for (String salida : fechasS) {
				fechasSalida.add(salida);
			}
			cmbFecha_Sal.setItems(fechasSalida);
			cnn.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		clmNombre_Us.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		clmTelefono_Us.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		clmEmail_Us.setCellValueFactory(new PropertyValueFactory<>("email"));
		clmSocio_Us.setCellValueFactory(new PropertyValueFactory<>("socio"));
		clmPatron_Us.setCellValueFactory(new PropertyValueFactory<>("patron"));
		
		clmNombre_Bar.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		clmMatricula_Bar.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		clmPatron_Bar.setCellValueFactory(new PropertyValueFactory<>("nomPatron"));
		clmDueño_Bar.setCellValueFactory(new PropertyValueFactory<>("nomDueno"));
		
		clmMatricula_Ent.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		clmFechaLlegada_Ent.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		clmNumeroAmarre_Ent.setCellValueFactory(new PropertyValueFactory<>("numAmarre"));
		
		clmMatricula_Sal.setCellValueFactory(new PropertyValueFactory<>("matricula"));
		clmFechaSalida_Sal.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		clmDestino_Sal.setCellValueFactory(new PropertyValueFactory<>("destino"));
	
		habilitarModificarUsuario("D");
		habilitarModificarBarco("D");
	}
    

}