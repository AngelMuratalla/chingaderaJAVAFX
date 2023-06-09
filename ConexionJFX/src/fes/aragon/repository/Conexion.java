package fes.aragon.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fes.aragon.modelo.Amarre;
import fes.aragon.modelo.AmarreOcupado;
import fes.aragon.modelo.Barco;
import fes.aragon.modelo.Contacto;
import fes.aragon.modelo.Dueno;
import fes.aragon.modelo.Entrada;
import fes.aragon.modelo.Patron;
import fes.aragon.modelo.Salida;
import fes.aragon.modelo.Socio;
import fes.aragon.modelo.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Conexion {

	private String url = "jdbc:mariadb://127.0.0.1:3306/club_nautico?serverTimezone = UTC";
	private String usuario = "root";
	private String clave = "57358978";
	private Connection conexion;

	public Conexion() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		conexion = DriverManager.getConnection(url, usuario, clave);
	}

	public Usuario consultarUnUsuario(String busqueda) throws SQLException {
		String query = "SELECT * FROM contactos where id_cto = " + busqueda;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		Usuario u = null;
		while (rs.next()) {
			u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
		}
		rs.close();
		st.close();

		return u;
	}
	
	public ArrayList<Usuario> consultarTodosUsuarios() throws SQLException {
		String query = "SELECT * FROM contactos";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<Usuario> consultarTodosSocios() throws SQLException {
		String query = "select * from contactos a, socios b where a.id_cto = b.id_cto;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}
	

	
	public ArrayList<Usuario> consultarTodosPatrones() throws SQLException {
		String query = "SELECT * FROM contactos a, patrones b where a.id_cto = b.id_cto;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<Usuario> consultarTodosDuenos() throws SQLException {
		String query = "SELECT * FROM contactos a, duenos b where a.id_cto = b.id_cto;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Barco> consultarTodosBarcos() throws SQLException {
		String query = "SELECT * FROM barcos";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Barco> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Barco(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Entrada> consultarTodasEntradas() throws SQLException {
		String query = "SELECT * FROM entradas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Entrada> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Entrada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<String> consultarFechaEntradas() throws SQLException {
		String query = "SELECT distinct fecha_llegada FROM entradas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(rs.getString(1));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Salida> consultarTodasSalidas() throws SQLException {
		String query = "SELECT * FROM salidas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Salida> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Salida(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<String> consultarFechaSalida() throws SQLException {
		String query = "SELECT distinct fecha_salida FROM salidas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<String> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(rs.getString(1));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Usuario> consultarUsuarios(String seleccion, String busqueda) throws SQLException {
		String query = "SELECT * FROM contactos where " + seleccion + " like " + "'%" + busqueda + "%'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Usuario> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Barco> consultarBarcos(String seleccion, String busqueda) throws SQLException {
		String query = "SELECT * FROM barcos where " + seleccion + " like " + "'%" + busqueda + "%'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Barco> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Barco(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Entrada> consultarEntradas(String seleccion, String busqueda, String filtroFecha)
			throws SQLException {
		
		String query = "SELECT * FROM entradas where " + seleccion + busqueda + filtroFecha;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Entrada> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Entrada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public boolean estaDentroBarco(Barco b) throws SQLException {
		ArrayList<Entrada> entradas = consultarEntradas("num_mta = ", b.getMatricula()  , "");
		ArrayList<Salida> salidas = consultarSalidas("num_mta = ", b.getMatricula(), "");
		
		return entradas.size() > salidas.size(); 
	}

	public ArrayList<Salida> consultarSalidas(String seleccion, String busqueda, String filtroFecha)
			throws SQLException {
		String query = "SELECT * FROM salidas where " + seleccion + busqueda + filtroFecha;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Salida> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Salida(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public int InsertarUsuario(Usuario u) throws SQLException {
		// TODO Auto-generated method stub
		int id = 0;
		String query = "INSERT INTO contactos VALUES (null,?,?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApPat());
		ps.setString(3, u.getApMat());
		ps.setString(4, u.getTelefono());
		ps.setString(5, u.getEmail());
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return id;
		
		
	}

	public int InsertarSocio(int idUsuario) throws SQLException {

		int id = 0;
		String query = "INSERT INTO socios VALUES (null,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idUsuario);
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return id;
	}

	public int insertarDueno(Usuario contacto) throws SQLException {
		int id = 0;
		String query = "INSERT INTO duenos VALUES (null,?)";
		PreparedStatement ps = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, contacto.getIdContacto());
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		ps.close();
		rs.close();
		
		return id;
	}
	public void InsertarPatron(int idUsuario, int idSocio) throws SQLException {

		String query = "INSERT INTO patrones (id_sco , id_cto) VALUES ( " + idSocio + " , " + idUsuario +" )" ;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		st.close();
		rs.close();
		
	}
	
	public void insertarBarco(Barco barco, int idDueno) throws SQLException {
		String query = "INSERT INTO barcos (num_matricula , nombre, id_ptn, id_dno) VALUES ( '" + barco.getMatricula() + 
				"' , '" + barco.getNombre() + "' , " + barco.getPatron().getIdContacto()+" , "+ idDueno +" )" ;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		st.close();
		rs.close();
		
	}
	
	public int getIdSocio(int idUsuario) throws SQLException {
		int id = -1;
		
		String query = "SELECT id_sco FROM socios where id_cto = " + idUsuario;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		return id;
	}
	
	public boolean getExisteSocio(int idContacto) throws SQLException {
		String query = "select * from socios where id_cto = " + idContacto;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		int id;
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public  boolean getExistePatron(int idContacto) throws SQLException {
		String query = "select * from patrones where id_cto = " + idContacto;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		int id;
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getIdPatron(Usuario patron) throws SQLException{

		int id = -1;
		String query = "SELECT id_ptn FROM patrones where id_cto = " + patron.getIdContacto();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			id = rs.getInt(1);
		}
		
		return id;
	}
	
	public ArrayList<Amarre> getAmarresDispobibles() throws SQLException{
		String query = "select * from amarres where disponibilidad =  1;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Amarre> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Amarre(rs.getInt(1), rs.getString(2),rs.getDouble(3),rs.getInt(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<AmarreOcupado> getAmarresOcupados() throws SQLException {
		String query = "Select * from entradas  a, amarres b, barcos c where a.num_mta = c.num_matricula and a.num_ams = b.num_amarres and b.disponibilidad = 0;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		ArrayList<AmarreOcupado> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new AmarreOcupado(new Amarre(rs.getInt(5), rs.getString(6), rs.getDouble(7), rs.getInt(8)), 
					new Barco(rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12))));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public void registrarEntrada(Barco barco, Amarre amarre, String fecha) throws SQLException {
		String query = "INSERT INTO entradas VALUES ( null, '" + fecha + "' , " + amarre.getNumAmarre() + ","+ barco.getMatricula()+ " )" ;
		ocuparAmarre(amarre.getNumAmarre());
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		st.close();
		rs.close();
		
		
	}

	private void ocuparAmarre(int numAmarre) throws SQLException {
		// TODO Auto-generated method stub
		String query = "UPDATE amarres SET disponibilidad = 0 where num_amarres = " + numAmarre;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		st.close();
		rs.close();
	}
	
	
	public void insertarAmarre(Amarre a) throws SQLException {
		
		if(exiteAmarre(a)) {
			desabilitarAnterioresAmarres(a);
		}
		
		String query = "INSERT INTO amarres (num_amarres , fecha_registro, cuota, disponibilidad) VALUES "
				+ "( " + a.getNumAmarre() + " , '" + a.getFechaRegistro() + "' , " +a.getCuota()
				+" , "+ a.getDisponibilidad() +" )" ;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		
		
		st.close();
		rs.close();
	}

	private void desabilitarAnterioresAmarres(Amarre a) throws SQLException {
		
		
		String query = "UPDATE amarres SET disponibilidad = NULL where num_amarres = " + a.getNumAmarre();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		st.close();
		rs.close();
		
	}

	private boolean exiteAmarre(Amarre a) throws SQLException {

		String query = "select * from amarres where num_amarres = " + a.getNumAmarre();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	public int consultarEstadoAmarre(Amarre a) throws SQLException {
		String query = "select * from amarres where num_amarres = " + a.getNumAmarre() + " order by fecha_registro desc";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Amarre> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Amarre(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
		}
		rs.close();
		st.close();

		int disponibilidad;
		if(datos.size()>0) {
			Amarre amarre = datos.get(datos.size()-1);
			disponibilidad = amarre.getDisponibilidad();
		}else {
			disponibilidad = 1;
		}
			
		return disponibilidad;
	}

	public void registrarSalida(Salida salida, AmarreOcupado aoc) throws SQLException {
		String query = "INSERT INTO salidas VALUES  (null, '" + salida.getFecha() + "' , '" + salida.getDestino() + "' , '" + salida.getMatricula()
				+ "')" ;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		liberarAmarre(aoc.getAmarre());
		
		
		st.close();
		rs.close();
		
	}
	
	private  void liberarAmarre(Amarre a) throws SQLException {
		String query = "UPDATE amarres SET disponibilidad = NULL where num_amarres = " + a.getNumAmarre();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		st.close();
		rs.close();
	}
	
	public Usuario getSocioDePatron(int idPatron) throws SQLException {
		String query = "SELECT * FROM contactos a , socios b, patrones c where c.id_sco = b.id_sco and a.id_cto = b.id_cto and c.id_ptn = " + idPatron;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		Usuario u = null;
		while (rs.next()) {
			u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
		}
		rs.close();
		st.close();

		return u;
	}
	
	

	public void actualizarUsuario(Usuario u) throws SQLException {
		String query = "UPDATE contactos "+
				"SET nombre ='" + u.getNombre()+"',ap_paterno = '"+u.getApPat()+"', ap_materno = '"+u.getApMat()+"', "
						+ "telefono = '"+u.getTelefono()+"', email = '"+u.getEmail()+"' WHERE id_cto = " +u.getIdContacto();
		
		System.out.println(query);
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.close();
		st.close();

		
	}

	public void eliminarElPatron(Usuario u) throws SQLException {
		String query = "UPDATE patrones "+
				"SET id_cto = 0 WHERE id_cto = " + u.getIdContacto();		
		System.out.println(query);
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.close();
		st.close();

		
		
	}
	
	/*------------------------------INICIO BUSQUEDAS INDIVIDUALES----------------------------------------------*/
	public Contacto buscarContacto(int id_cto) throws SQLException, SQLDataException {
		
		String query = "SELECT * FROM contactos where id_cto = " + id_cto;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println();
		rs.next();
		
		Contacto ct = new Contacto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		
		rs.close();
		st.close();
		return ct;
		
	}
	
	
	public Patron buscarPatron(int id_ptn) throws SQLException, SQLDataException {
		
		String query = "SELECT * FROM patrones where id_ptn = " + id_ptn;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		Patron pt = new Patron(rs.getInt(1), rs.getInt(2), rs.getInt(3));
		
		rs.close();
		st.close();
		return pt;
		
	}
	
	
	public Dueno buscarDueno(int id_dno) throws SQLException, SQLDataException {
		
		String query = "SELECT * FROM duenos where id_dno = " + id_dno;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		Dueno dn = new Dueno(rs.getInt(1), rs.getInt(2));
		
		rs.close();
		st.close();
		return dn;
		
	}
	
	public Socio buscarSocio(int id_sco) throws SQLException, SQLDataException {
		
		String query = "SELECT * FROM socios where id_sco = " + id_sco;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		Socio so = new Socio(rs.getInt(1), rs.getInt(2));
		
		rs.close();
		st.close();
		return so;
		
	}
	
	public Barco buscarBarco(String num_matricula) throws SQLException, SQLDataException {
		
		String query = String.format("SELECT * FROM barcos where num_matricula = '%s' ", num_matricula);
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		Barco bc = new Barco(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
		
		rs.close();
		st.close();
		return bc;
		
	}
	
	/*public Entrada buscarEntrada(int id_eta) throws SQLException, SQLDataException {
		
		String query = "SELECT * FROM entradas where id_eta = " + id_eta;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		Entrada eda = new Entrada(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
		rs.close();
		st.close();
		return eda;
		
	}
	
	public Salida buscarSalida(int id_sla) throws SQLException, SQLDataException {
		
		String query = "SELECT * FROM entradas where id_eta = " + id_sla;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		Salida sla = new Salida(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		rs.close();
		st.close();
		return sla;
		
	}*/
	
	/*public Amarre buscarAmarre(int num_ams) throws SQLException, SQLDataException {
		
		String query = "SELECT * FROM amarres where num_amarres = " + num_ams;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		
		Amarre ame = new Amarre(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getBoolean(4));
		rs.close();
		st.close();
		return ame;
		
	}*/
	
	
	/*------------------------------FIN BUSQUEDAS INDIVIDUALES----------------------------------------------*/
	

		public void actualizarBarco(Barco bc, String num_matricula) throws SQLException {
			
			String query = String.format("UPDATE barcos SET num_matricula = '%s', nombre = '%s', id_ptn = '%s', id_dno = '%s'  WHERE num_matricula='%s'", bc.getMatricula(),
					bc.getNombre(), bc.getIdPatron(), bc.getIdDueno(), num_matricula);
			
			System.out.println(query);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.close();
			st.close();
		}
		

		public void actualizarPatron(Usuario u, int idSocio) throws SQLException {
			// TODO Auto-generated method stub
			if(getIdSocio(u.getIdContacto())!=idSocio) {
				String query = "UPDATE patrones "+
						"SET id_sco = " + idSocio +" WHERE id_cto = " + u.getIdContacto();		
				System.out.println(query);
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(query);
				rs.close();
				st.close();
			}
		}
		

		public void cerrarConexion() throws SQLException {
			conexion.close();
		}
	

	

	

	

	



}
