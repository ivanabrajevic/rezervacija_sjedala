package rezervacija_sjedala;

import java.io.IOException;


public class Dogadaj {
	private String naziv_dogadaja;
	private String vrijeme_odrzavanja;
	private int id;
	private int idDvorana;
	private String pozicije_stanja;
	
	public Dogadaj() {
		super();
	}

	public Dogadaj(String naziv_dogadaja, String vrijeme_odrzavanja) throws ClassNotFoundException, IOException {
	
		this.naziv_dogadaja=naziv_dogadaja;
		this.vrijeme_odrzavanja=vrijeme_odrzavanja;
	}

	public String getNaziv_dogadaja() {
		return naziv_dogadaja;
	}

	public void setNaziv_dogadaja(String naziv_dogadaja) {
		this.naziv_dogadaja = naziv_dogadaja;
	}

	public String getVrijeme_odrzavanja() {
		return vrijeme_odrzavanja;
	}

	public void setVrijeme_odrzavanja(String vrijeme_odrzavanja) {
		this.vrijeme_odrzavanja = vrijeme_odrzavanja;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDvorana() {
		return idDvorana;
	}

	public void setIdDvorana(int idDvorana) {
		this.idDvorana = idDvorana;
	}

	public String getPozicije_stanja() {
		return pozicije_stanja;
	}

	public void setPozicije_stanja(String pozicije_stanja) {
		this.pozicije_stanja = pozicije_stanja;
	}

	@Override
	public String toString() {
		return "dogadaj [naziv_dogadaja=" + naziv_dogadaja + ", vrijeme_odrzavanja=" + vrijeme_odrzavanja + ", id=" + id
				+ ", idDvorana=" + idDvorana + ", pozicije_stanja=" + pozicije_stanja + "]";
	}



	
	
	
	
	
	
	
	

}
