package rezervacija_sjedala;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connect {

	private Connection conn;
	private String URL = "jdbc:sqlite:bazapodataka.db";

	public void connect() {
		Connection co;
		try {

			co = DriverManager.getConnection(URL);
			conn = co;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList selectAllDvoranaId() {
		String sql = "SELECT * FROM dvorana";
		ArrayList<Integer> dlist = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				dlist.add(rs.getInt("id"));
			}
			rs.close();
			return dlist;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList selectAllDvorana() {
		String sql = "SELECT * FROM dvorana";
		ArrayList<Dvorana> dlist = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Dvorana d = new Dvorana();
				d.setId(rs.getInt("id"));
				d.setNaziv_dvorane(rs.getString("naziv"));
				d.setBrSjedala(rs.getString("broj_sjedala"));
				d.setPozicije(rs.getString("pozicije"));
				dlist.add(d);
			}
			rs.close();
			return dlist;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ArrayList selectAllDogadaj() {
		String sql = "SELECT * FROM dogadaj";
		ArrayList<Dogadaj> dlist = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Dogadaj d = new Dogadaj();
				d.setId(rs.getInt("id"));
				d.setNaziv_dogadaja(rs.getString("naziv"));
				d.setVrijeme_odrzavanja(rs.getString("vrijeme_odrzavanja"));
				d.setIdDvorana(rs.getInt("dvorana_id"));
				d.setPozicije_stanja(rs.getString("pozicije"));
				dlist.add(d);
			}
			rs.close();
			return dlist;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public void insertDvorana(String naziv, String br_sjedala, String pozicije) {

		String sql = "INSERT INTO dvorana(naziv,broj_sjedala,pozicije) VALUES(?,?,?)";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, naziv);
			pstmt.setString(2, br_sjedala);
			pstmt.setString(3, pozicije);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertDogadaj(String naziv, String vrijeme, String stanje, int dvorana_id) {

		String sql = "INSERT INTO dogadaj(naziv,vrijeme_odrzavanja,pozicije,dvorana_id) VALUES(?,?,?,?)";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, naziv);
			pstmt.setString(2, vrijeme);
			pstmt.setString(3, stanje);
			pstmt.setInt(4, dvorana_id);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Dvorana selectDvoranaById(int dId) {
		String sql = "SELECT * FROM dvorana WHERE id=?";
		Dvorana d = new Dvorana();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dId);
			ResultSet rs = pstmt.executeQuery();
			d.setId(rs.getInt("id"));
			d.setNaziv_dvorane(rs.getString("naziv"));
			d.setBrSjedala(rs.getString("broj_sjedala"));
			d.setPozicije(rs.getString("pozicije"));
			rs.close();

			return d;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return null;

	}

	public void insertKorisnik(String ime_prezime, String mail) {

		String sql = "INSERT INTO korisnik(ime_prezime, email) VALUES(?,?) ";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ime_prezime);
			pstmt.setString(2, mail);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public int selectKorisnikId(String email) {
		String sql = "SELECT  id  FROM korisnik WHERE email=?";

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			if (rs.isBeforeFirst()) {

				int id = rs.getInt("id");
				rs.close();
				return id;
			} else
				return -1;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return -1;

	}

	public Dogadaj selectDogadajById(int dId) {
		String sql = "SELECT * FROM dogadaj WHERE id=?";
		Dogadaj d = new Dogadaj();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dId);
			ResultSet rs = pstmt.executeQuery();
			d.setId(rs.getInt("id"));
			d.setNaziv_dogadaja(rs.getString("naziv"));
			d.setVrijeme_odrzavanja(rs.getString("vrijeme_odrzavanja"));
			d.setIdDvorana(rs.getInt("dvorana_id"));
			d.setPozicije_stanja(rs.getString("pozicije"));
			rs.close();

			return d;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return null;

	}

	public void insertRezervacija(String sjedalo, int id_dogadaj, int id_korisnik) {

		String sql = "INSERT INTO rezervacija(sjedalo,id_dogadaj,id_korisnik) VALUES(?,?,?)";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sjedalo);
			pstmt.setInt(2, id_dogadaj);
			pstmt.setInt(3, id_korisnik);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateDogadajPozicije(int dId, String pozicije) {
		String sql = "UPDATE dogadaj SET pozicije = ? WHERE id = ?";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pozicije);
			pstmt.setInt(2, dId);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList selectRezervacijeByKorisnikId(int kId) {
		String sql = "SELECT * FROM rezervacija WHERE id_korisnik=?";
		ArrayList<Rezervacija> rlist = new ArrayList<>();
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Rezervacija r = new Rezervacija();
				r.setId(rs.getInt("id"));
				r.setDogadaj_id(rs.getInt("id_dogadaj"));
				r.setSjedalo(rs.getString("sjedalo"));
				rlist.add(r);
			}
			rs.close();
			return rlist;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return null;

	}
	
	public void deleteRezervacija(int rId) {
		String sql ="DELETE FROM rezervacija WHERE id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rId);
            pstmt.executeUpdate();
		}catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}
	
	public void updateDvorana(int id, String naziv, String br_sjedala, String pozicije) {
		String sql = "UPDATE dvorana SET naziv = ?, broj_sjedala=?, pozicije=? WHERE id = ?";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, naziv);
			pstmt.setString(2, br_sjedala);
			pstmt.setString(3, pozicije);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateDogadaj(int id,String naziv, String vrijeme, String stanje,int dvorana_id) {
		String sql = "UPDATE dogadaj SET naziv = ?, vrijeme_odrzavanja=?, pozicije=?, dvorana_id=? WHERE id = ?";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, naziv);
			pstmt.setString(2, vrijeme);
			pstmt.setString(3, stanje);
			pstmt.setInt(4, dvorana_id);
			pstmt.setInt(5, id);
			
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	
}
