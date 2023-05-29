package fes.aragon.modelo;

public class Dueno {
	
	private int id_dno;
	private int id_cto;
	
	public Dueno() {
		
	}
	
	public Dueno(int id_dno, int id_cto) {
		super();
		this.id_dno = id_dno;
		this.id_cto = id_cto;
	}

	public int getId_dno() {
		return id_dno;
	}

	public void setId_dno(int id_dno) {
		this.id_dno = id_dno;
	}

	public int getId_cto() {
		return id_cto;
	}

	public void setId_cto(int id_cto) {
		this.id_cto = id_cto;
	}
	
	
	
}
