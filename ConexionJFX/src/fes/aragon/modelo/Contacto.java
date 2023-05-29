package fes.aragon.modelo;

public class Contacto {
	private int id_cto;
	private String nombre;
	private String ap_paterno;
	private String ap_materno;
	private String telefono;
	private String email;
	
	public Contacto() {
		
	}
	
	public Contacto(int id_cto, String nombre, String ap_paterno, String ap_materno, String telefono, String email) {
		super();
		this.id_cto = id_cto;
		this.nombre = nombre;
		this.ap_paterno = ap_paterno;
		this.ap_materno = ap_materno;
		this.telefono = telefono;
		this.email = email;
	}

	public int getId_cto() {
		return id_cto;
	}

	public void setId_cto(int id_cto) {
		this.id_cto = id_cto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_paterno() {
		return ap_paterno;
	}

	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}

	public String getAp_materno() {
		return ap_materno;
	}

	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
