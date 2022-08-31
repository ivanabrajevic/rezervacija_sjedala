package rezervacija_sjedala;


public class Dvorana {
	
	private String naziv_dvorane;	
	private int id;
	private String brSjedala;
	private String pozicije;
	
	public Dvorana() {
		super();
	}
	
	

	public String getNaziv_dvorane() {
		return naziv_dvorane;
	}

	public void setNaziv_dvorane(String naziv_dvorane) {
		this.naziv_dvorane = naziv_dvorane;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrSjedala() {
		return brSjedala;
	}

	public void setBrSjedala(String brSjedala) {
		this.brSjedala = brSjedala;
	}

	public String getPozicije() {
		return pozicije;
	}

	public void setPozicije(String pozicije) {
		this.pozicije = pozicije;
	}



	@Override
	public String toString() {
		return "dvorana [naziv_dvorane=" + naziv_dvorane + ", id=" + id + ", brSjedala=" + brSjedala + ", pozicije="
				+ pozicije + "]";
	}

	
	
	
	
	

}
