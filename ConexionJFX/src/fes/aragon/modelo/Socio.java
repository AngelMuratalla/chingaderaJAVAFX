package fes.aragon.modelo;

public class Socio {
	private int id_sco;
	private int id_cto;
	
	public Socio() {
		
	}

	public Socio(int id_sco, int id_cto) {
		super();
		this.id_sco = id_sco;
		this.id_cto = id_cto;
	}

	public int getId_sco() {
		return id_sco;
	}

	public void setId_sco(int id_sco) {
		this.id_sco = id_sco;
	}

	public int getId_cto() {
		return id_cto;
	}

	public void setId_cto(int id_cto) {
		this.id_cto = id_cto;
	}
	
	
}
