package rezervacija_sjedala;

import javax.swing.SwingUtilities;
import static java.lang.Integer.valueOf;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

public class GUI {
	JFrame frmProzor1, frmAdmin1, frmKorisnik1, frmAdmin2, frmAdmin3, frmKorisnik2, frmKorisnik3, frmKorisnik4;
	Connect c = new Connect();

	public GUI() {
		prozor1();
		frmProzor1.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeLater(() -> {
				new GUI();
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void prozor1() {
	
		frmProzor1 = new JFrame();
		frmProzor1.getContentPane().setBackground(new Color(250, 235, 215));
		frmProzor1.setTitle("Rezervacija sjedala u dvorani");
		frmProzor1.setBounds(80, 100, 680, 458);
		frmProzor1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProzor1.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Administrator");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(81, 134, 171, 61);
		frmProzor1.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Korisnik");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(80, 220, 146, 35);
		frmProzor1.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Izlaz");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(81, 287, 105, 35);
		frmProzor1.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("ODABERI");
		btnNewButton.addActionListener(e -> {

			JPasswordField pf = new JPasswordField();
			int ok = JOptionPane.showConfirmDialog(null, pf, "Unesite lozinku", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (ok == JOptionPane.OK_OPTION) {
				String password = new String(pf.getPassword());

				if (password.equals("1234")) {
					admin1();
					frmAdmin1.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Unjeli ste pogrešnu šifru!");
				}
			}

		});
		btnNewButton.setBackground(new Color(250, 240, 230));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(375, 152, 146, 23);
		frmProzor1.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ODABERI");
		btnNewButton_1.addActionListener(e -> {

			korisnik1();
			frmKorisnik1.setVisible(true);
		});
		btnNewButton_1.setBackground(new Color(250, 240, 230));
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_1.setBounds(377, 225, 144, 23);
		frmProzor1.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("ODABERI");
		btnNewButton_2.addActionListener(e -> {
			frmProzor1.dispose();
		});
		btnNewButton_2.setBackground(new Color(250, 240, 230));
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton_2.setBounds(375, 292, 144, 23);
		frmProzor1.getContentPane().add(btnNewButton_2);

	}

	public void admin1() {
		frmAdmin1 = new JFrame();
		frmAdmin1.getContentPane().setBackground(new Color(250, 235, 215));
		frmAdmin1.setTitle("Administrator");
		frmAdmin1.setBounds(100, 100, 766, 386);
		frmAdmin1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmAdmin1.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Unos dvorane");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(64, 91, 199, 21);
		frmAdmin1.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Unos dogadaja");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(64, 150, 199, 21);
		frmAdmin1.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Azuriranje dvorane");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(64, 213, 199, 21);
		frmAdmin1.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Azuriranje dogadaja");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(64, 271, 199, 21);
		frmAdmin1.getContentPane().add(lblNewLabel_3);

		JButton btnNewButton = new JButton("ODABERI");
		btnNewButton.addActionListener(e -> {
			Dvorana dvNull = new Dvorana();
			admin2(dvNull,0);
			frmAdmin2.setVisible(true);
		});
		btnNewButton.setBackground(new Color(250, 240, 230));
		btnNewButton.setBounds(357, 89, 152, 23);
		frmAdmin1.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ODABERI");
		btnNewButton_1.addActionListener(e -> {
			Dogadaj dogNull = new Dogadaj();
			admin3(dogNull,0);
			frmAdmin3.setVisible(true);
		});
		btnNewButton_1.setBackground(new Color(250, 240, 230));
		btnNewButton_1.setBounds(357, 148, 152, 23);
		frmAdmin1.getContentPane().add(btnNewButton_1);

		c.connect();
		ArrayList<Dvorana> dvList = new ArrayList<>(c.selectAllDvorana());
		c.close();
		String[] array=new String[dvList.size()];
		int i=0;
		for(Dvorana dv : dvList) {
			array[i] = dv.getNaziv_dvorane();
			i++;
		}
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(357, 214, 147, 22);
		frmAdmin1.getContentPane().add(comboBox);

		c.connect();
		ArrayList<Dogadaj> dogList = new ArrayList<>(c.selectAllDogadaj());
		c.close();
		String[] array2 = new String[dogList.size()];
		int j =0;
		for(Dogadaj dog : dogList) {
			array2[j] = dog.getNaziv_dogadaja();
			j++;
		}
		JComboBox comboBox_1 = new JComboBox(array2);
		comboBox_1.setBounds(357, 272, 147, 22);
		frmAdmin1.getContentPane().add(comboBox_1);
		
		JButton btnNewButton_2 = new JButton("AZURIRAJ");
		btnNewButton_2.addActionListener(e -> {
			int index = Arrays.asList(array).indexOf(comboBox.getSelectedItem());
			admin2(dvList.get(index),1);
			frmAdmin2.setVisible(true);
		});
		btnNewButton_2.setBackground(new Color(250, 240, 230));
		btnNewButton_2.setBounds(539, 211, 152, 23);
		frmAdmin1.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("AZURIRAJ");
		btnNewButton_3.addActionListener(e -> {
			int index2 = Arrays.asList(array2).indexOf(comboBox_1.getSelectedItem());
			admin3(dogList.get(index2),1);
			frmAdmin3.setVisible(true);
		});
		btnNewButton_3.setBackground(new Color(250, 240, 230));
		btnNewButton_3.setBounds(539, 269, 152, 23);
		frmAdmin1.getContentPane().add(btnNewButton_3);
	}

	public void korisnik1() {
		frmKorisnik1 = new JFrame();
		frmKorisnik1.getContentPane().setBackground(new Color(250, 235, 215));
		frmKorisnik1.setTitle("Korisnik");
		frmKorisnik1.setBounds(100, 100, 688, 355);
		frmKorisnik1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmKorisnik1.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nova rezervacija");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(76, 79, 176, 36);
		frmKorisnik1.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Prikaz rezervacija");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(76, 171, 176, 36);
		frmKorisnik1.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("ODABERI");
		btnNewButton.addActionListener(e -> {

			korisnik2();
			frmKorisnik2.setVisible(true);
		});
		btnNewButton.setBackground(new Color(250, 240, 230));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(424, 88, 143, 23);
		frmKorisnik1.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ODABERI");
		btnNewButton_1.addActionListener(e -> {

			JTextField tf = new JTextField();
			int ok = JOptionPane.showConfirmDialog(null, tf, "Unesite email", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (ok == JOptionPane.OK_OPTION) {
				String email = new String(tf.getText());
				c.connect();
				int provjera = c.selectKorisnikId(email);
				c.close();
				if (provjera != -1) {
					korisnik4(provjera,email);
					frmKorisnik4.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");
				}
			}

		});
		btnNewButton_1.setBackground(new Color(250, 240, 230));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(424, 180, 143, 23);
		frmKorisnik1.getContentPane().add(btnNewButton_1);

	}

	public void admin2(Dvorana dv,int flag) {
		JTextField textField;
		JTextField textField_1;
		JTextField textField_2;
		frmAdmin2 = new JFrame();
		frmAdmin2.getContentPane().setBackground(new Color(250, 235, 215));
		frmAdmin2.setTitle("Administrator");
		frmAdmin2.setBounds(100, 100, 631, 336);
		frmAdmin2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmAdmin2.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Unesite ime dvorane");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(60, 66, 221, 24);
		frmAdmin2.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Unesite broj mjesta");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(60, 126, 221, 34);
		frmAdmin2.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Unesite poziciju sjedala");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(60, 202, 221, 34);
		frmAdmin2.getContentPane().add(lblNewLabel_2);
				
		textField = new JTextField(dv.getNaziv_dvorane());
		textField.setBounds(375, 70, 168, 20);
		frmAdmin2.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(dv.getBrSjedala());
		textField_1.setBounds(375, 135, 168, 20);
		frmAdmin2.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField(dv.getPozicije());
		textField_2.setBounds(375, 202, 168, 20);
		frmAdmin2.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("SPREMI");
		btnNewButton.addActionListener(e -> {

			frmAdmin2.setVisible(false);
			if(flag==0) {
				c.connect();
				c.insertDvorana(textField.getText(), textField_1.getText(), textField_2.getText());
				c.close();
				JOptionPane.showInternalMessageDialog(null, "Dvorana uspjesno unesena!", "information",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				c.connect();
				c.updateDvorana(dv.getId(),textField.getText(), textField_1.getText(), textField_2.getText());
				c.close();
				JOptionPane.showInternalMessageDialog(null, "Dvorana uspjesno azurirana!", "information",
						JOptionPane.INFORMATION_MESSAGE);
			}

		});
		btnNewButton.setBounds(161, 247, 95, 43);
		frmAdmin2.getContentPane().add(btnNewButton);

		

	}

	public void admin3(Dogadaj dog, int flag) {
		JTextField textField;
		JTextField textField_1;

		frmAdmin3 = new JFrame();
		frmAdmin3.getContentPane().setBackground(new Color(250, 235, 215));
		frmAdmin3.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
		frmAdmin3.setTitle("Administrator");
		frmAdmin3.setBounds(100, 100, 739, 366);
		frmAdmin3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmAdmin3.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Unesite naziv dogadaja");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(73, 87, 261, 14);
		frmAdmin3.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Unesite vrijeme dogadaja");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(73, 157, 261, 20);
		frmAdmin3.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Odaberite redni broj dvorane");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(73, 228, 261, 20);
		frmAdmin3.getContentPane().add(lblNewLabel_2);

		textField = new JTextField(dog.getNaziv_dogadaja());
		textField.setBounds(439, 86, 181, 20);
		frmAdmin3.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(dog.getVrijeme_odrzavanja());
		textField_1.setBounds(439, 156, 181, 20);
		frmAdmin3.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		c.connect();
		ArrayList<Integer> dlist = new ArrayList<>(c.selectAllDvoranaId());
		c.close();
		Integer[] array = dlist.toArray(new Integer[dlist.size()]);
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(440, 229, 180, 22);
		frmAdmin3.getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("SPREMI");
		btnNewButton.addActionListener(e -> {
			int dId = (int) comboBox.getSelectedItem();
			String stanje = "";
			Dvorana d = new Dvorana();
			c.connect();
			d = c.selectDvoranaById(dId);
			int j = Integer.parseInt(d.getBrSjedala());
			c.close();

			for (int i = 0; i < j; i++) {
				stanje += "false,";
			}
			
			frmAdmin3.setVisible(false);
			if(flag==0) {
				c.connect();
				c.insertDogadaj(textField.getText(), textField_1.getText(), stanje, dId);
				c.close();
				JOptionPane.showInternalMessageDialog(null, "Dogadaj uspjesno unesen!", "information",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				c.connect();
				c.updateDogadaj(dog.getId(),textField.getText(), textField_1.getText(),dog.getPozicije_stanja(), dId);
				c.close();
				JOptionPane.showInternalMessageDialog(null, "Dogadaj uspjesno azuriran!", "information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(314, 262, 97, 44);
		frmAdmin3.getContentPane().add(btnNewButton);


	}

	public void korisnik2() {
		JTextField textField;
		JTextField textField_1;
		frmKorisnik2 = new JFrame();
		frmKorisnik2.getContentPane().setBackground(new Color(250, 235, 215));
		frmKorisnik2.setTitle("Korisnik");
		frmKorisnik2.setBounds(100, 100, 659, 360);
		frmKorisnik2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmKorisnik2.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Unesite ime i prezime");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(63, 55, 234, 43);
		frmKorisnik2.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Unesite email adresu");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(63, 116, 234, 43);
		frmKorisnik2.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Odaberite dogadaj");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(218, 183, 234, 30);
		frmKorisnik2.getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(377, 68, 188, 20);
		frmKorisnik2.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(377, 118, 188, 20);
		frmKorisnik2.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		c.connect();
		ArrayList<Dogadaj> dogList = new ArrayList<>(c.selectAllDogadaj());
		c.close();
		String[] array = new String[dogList.size()];
		int j =0;
		for(Dogadaj dog : dogList) {
			array[j] = dog.getNaziv_dogadaja();
			j++;
		}
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBackground(new Color(250, 240, 230));
		comboBox.setBounds(211, 238, 199, 22);
		frmKorisnik2.getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(496, 274, 100, 38);
		frmKorisnik2.getContentPane().add(btnNewButton);

		btnNewButton.addActionListener(e -> {

			String dnaziv = (String) comboBox.getSelectedItem();
			int index = Arrays.asList(array).indexOf(dnaziv);
			int id = dogList.get(index).getId();
			String email = textField_1.getText();
			c.connect();
			int provjera = c.selectKorisnikId(textField_1.getText());
			c.close();
			if (provjera == -1) {

				c.connect();
				c.insertKorisnik(textField.getText(), textField_1.getText());
				c.close();

			}

			c.connect();
			Dogadaj d = c.selectDogadajById(id);
			c.close();
			korisnik3(d, id, email);
			frmKorisnik3.setVisible(true);
		});
	}

	public void korisnik3(Dogadaj dog, int dogadajId, String email) {
		frmKorisnik3 = new JFrame();
		JTextField textField;
		frmKorisnik3.setTitle("Rezervacija");
		frmKorisnik3.getContentPane().setBackground(new Color(250, 235, 215));
		frmKorisnik3.setBounds(100, 100, 676, 442);
		frmKorisnik3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmKorisnik3.getContentPane().setLayout(null);

		JTextPane txtpnPlatno = new JTextPane();
		txtpnPlatno.setBackground(new Color(230, 230, 250));
		txtpnPlatno.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtpnPlatno.setText("PLATNO");
		txtpnPlatno.setEditable(false);
		txtpnPlatno.setBounds(249, 80, 152, 35);
		frmKorisnik3.getContentPane().add(txtpnPlatno);

		JLabel lblNewLabel_1 = new JLabel("Naziv dogadaja");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(32, 30, 111, 29);
		frmKorisnik3.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("IZLAZ");
		btnNewButton.addActionListener(e -> {
			frmKorisnik3.dispose();
			frmKorisnik2.dispose();
			frmKorisnik1.dispose();
			frmProzor1.dispose();

		});
		btnNewButton.setBounds(532, 354, 89, 23);
		frmKorisnik3.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Vrijeme odrzavanja");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(364, 33, 111, 22);
		frmKorisnik3.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(dog.getNaziv_dogadaja());
		lblNewLabel_3.setBounds(153, 28, 152, 35);
		frmKorisnik3.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(dog.getVrijeme_odrzavanja());
		lblNewLabel_4.setBounds(485, 30, 152, 33);
		frmKorisnik3.getContentPane().add(lblNewLabel_4);

		JPanel panel = new JPanel();
		panel.setBounds(57, 126, 522, 173);
		frmKorisnik3.getContentPane().add(panel);

		Dvorana dv = new Dvorana();
		c.connect();
		dv = c.selectDvoranaById(dog.getIdDvorana());
		int br_mjesta = Integer.parseInt(dv.getBrSjedala());
		String[] pozicije = dv.getPozicije().split(",");
		c.close();
		String[] pozicije_stanje = dog.getPozicije_stanja().split(",");

		JToggleButton[] seats = new JToggleButton[br_mjesta];

		ActionListener listener = actionEvent -> {
			String odabrano_sjedalo = actionEvent.getActionCommand();
			c.connect();
			int korisnikId = c.selectKorisnikId(email);
			c.close();
			c.connect();
			c.insertRezervacija(odabrano_sjedalo, dogadajId, korisnikId);
			c.close();

			int index = Arrays.asList(pozicije).indexOf(odabrano_sjedalo);
			String novo_stanje = "";
			for (int j = 0; j < br_mjesta; j++) {
				if (j == index)
					novo_stanje += "true,";
				else
					novo_stanje = novo_stanje  + pozicije_stanje[j] + ",";
			}
			c.connect();
			c.updateDogadajPozicije(dogadajId, novo_stanje);
			c.close();
			Mail mail =new Mail(email,"Rezervacija uspjesno obavljena!");
        	mail.sendEmail();
        	frmKorisnik3.setVisible(false);
			JOptionPane.showInternalMessageDialog(null, "Sjedalo je uspjesno rezervirano!", "information",
					JOptionPane.INFORMATION_MESSAGE);

		};
		for (int ii = 0; ii < seats.length; ii++) {
			JToggleButton tb = new JToggleButton(pozicije[ii]);

			seats[ii] = tb;

			if (pozicije_stanje[ii].equals("true")) {
				tb.setSelected(true);
			}
			tb.addActionListener(listener);
			panel.add(tb);

		}
	}

	
	public void korisnik4(int korisnikId,String email) {
		frmKorisnik4 = new JFrame();
		frmKorisnik4.setTitle("Sve Vase rezervacije");
		frmKorisnik4.getContentPane().setBackground(new Color(250, 235, 215));
		frmKorisnik4.setBounds(100, 100, 620, 357);
		frmKorisnik4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmKorisnik4.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 70, 510, 207);
		frmKorisnik4.getContentPane().add(panel);
		
		ArrayList<Rezervacija> rlist = new ArrayList<>();
		c.connect();
		rlist=c.selectRezervacijeByKorisnikId(korisnikId);
		c.close();
		
		for(Rezervacija r : rlist) {
			Dogadaj dog = new Dogadaj();
			c.connect();
			dog = c.selectDogadajById(r.getDogadaj_id());
			c.close();
			Dvorana dv = new Dvorana();
			c.connect();
			dv = c.selectDvoranaById(dog.getIdDvorana());
			c.close();
			
			panel.add(new JLabel("Naziv dogadjaja: " + dog.getNaziv_dogadaja() + ", Vrijeme: " + dog.getVrijeme_odrzavanja() + ", Dvorana: "+ dv.getNaziv_dvorane() + ", Sjedalo: " + r.getSjedalo()));
			JButton btnNewButton = new JButton("IZBRISI");
			
			int br_mjesta = Integer.parseInt(dv.getBrSjedala());
			String[] pozicije = dv.getPozicije().split(",");
			String[] pozicije_stanje = dog.getPozicije_stanja().split(",");

			btnNewButton.addActionListener(e -> {
				c.connect();
				c.deleteRezervacija(r.getId());
				c.close();
				int index = Arrays.asList(pozicije).indexOf(r.getSjedalo());

				String novo_stanje = "";
				for (int j = 0; j < br_mjesta; j++) {
					if (j == index)
						novo_stanje += "false,";
					else
						novo_stanje = novo_stanje  + pozicije_stanje[j] + ",";
				}
				
				c.connect();
				c.updateDogadajPozicije(r.getDogadaj_id(), novo_stanje);
				c.close();
				Mail mail =new Mail(email,"Rezervacija uspjesno izbrisana!");
	        	mail.sendEmail();
				frmKorisnik4.setVisible(false);
				JOptionPane.showInternalMessageDialog(null, "Rezervacija je izbrisana!", "information",
						JOptionPane.INFORMATION_MESSAGE);
			});
			panel.add(btnNewButton);
		}

	}
}