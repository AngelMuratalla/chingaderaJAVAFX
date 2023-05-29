package fes.aragon.modelo;

public class Patron {
	
	private int id_ptn;
	private int id_cto;
	private int id_sco;
	
	public Patron() {
		
	}

	public Patron(int id_ptn, int id_sco, int id_cto) {
		super();
		this.id_ptn = id_ptn;
		this.id_cto = id_cto;
		this.id_sco = id_sco;
	}

	public int getId_ptn() {
		return id_ptn;
	}

	public void setId_ptn(int id_ptn) {
		this.id_ptn = id_ptn;
	}

	public int getId_cto() {
		return id_cto;
	}

	public void setId_cto(int id_cto) {
		this.id_cto = id_cto;
	}

	public int getId_sco() {
		return id_sco;
	}

	public void setId_sco(int id_sco) {
		this.id_sco = id_sco;
	}
	
	
	//hasdddddd
	public void getSocioAfiliado() {
		
	}
	
}
