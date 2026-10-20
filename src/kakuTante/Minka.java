package kakuTante;

import java.awt.Image;
import java.net.URL;
import java.time.Year;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Minka {
	// Atribūti
	String vards, skirne, spalvasKrasa, saimnieks;
	int vecums, medijumuSk, izsalkums;
	boolean siksnina;
	ImageIcon bilde;
	Random rand = new Random();

	// Konstruktors
	public Minka(String vards, String skirne, String spalvasKrasa, String saimnieks,
			int dzGads, boolean siksnina, String cels) {
		this.vards = vards;
		this.skirne = skirne;
		this.spalvasKrasa = spalvasKrasa;
		this.saimnieks = saimnieks;
		vecums = Year.now().getValue() - dzGads;
		medijumuSk = 0;
		izsalkums = kungis();
		this.siksnina = siksnina;
		bilde = iestatiBildi(cels);
	}
	//  Metodes
	public int kungis() {
		return rand.nextInt(5)+1;
	}
	
	public ImageIcon iestatiBildi(String cels) {
		if(!cels.endsWith(".png"))
			cels += ".png";
		
		URL resurss = getClass().getResource("/atteli/"+cels);
		if(resurss != null)
			return new ImageIcon(new ImageIcon(resurss).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		
		else {
			JOptionPane.showMessageDialog(null, "Nevar atrast bildi "+cels, "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	void murrat() {
		JOptionPane.showMessageDialog(null, vards + " saka 'murr murr murr'",
				"Paziņojums", JOptionPane.INFORMATION_MESSAGE, bilde);
	}
	
	String nolasitAtributus() {
		return vards +" ir "+vecums+" gadus vecs "+skirne+" šķirnes kakis ar "+spalvasKrasa
				+" krasas kazoku\n"
				+ "Kaķim "+((siksnina)? "ir" : "nav")+" siksnina.\n"
						+ "Saimnieka vards: "+saimnieks+
						"\nMedijumu skaits"+medijumuSk;
	}
	
	String pabarot(String ediens) {
		if(izsalkums>0) {
			bilde = iestatiBildi("trauks");
			JOptionPane.showMessageDialog(null, "Ņamm namm nammm, man garso "+ediens,
					"informacija", JOptionPane.INFORMATION_MESSAGE,
					bilde);
			ediens = "tuksa blodina";
			izsalkums--;
		}else {
			JOptionPane.showMessageDialog(null, "murr, esmu paredies un "+ ediens+
					" nevelos!", "sigma", JOptionPane.WARNING_MESSAGE);
			izsalkums = kungis();
		}
		return ediens;
	}
	
	void gulet() {
		JOptionPane.showMessageDialog(null, saimnieks + "! aizmirsi iedot segu!",
				"Kluda", JOptionPane.ERROR_MESSAGE);
	}
	
	void gulet(String prieksmets) {
		if(prieksmets.equalsIgnoreCase("sedzina")) {
			bilde = iestatiBildi("gul");
			JOptionPane.showMessageDialog(null, "zzzzzzzz",
					"info", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, saimnieks+"! "+prieksmets+" ej dirst",
					"bridinajums", JOptionPane.WARNING_MESSAGE);
		}
	}
	void palielinatVecumu() {
		if(vecums<20) {
		vecums++;
		bilde = iestatiBildi("kuka");
		JOptionPane.showMessageDialog(null, vards+" vecums palielinats par 1 gadu!",
				"svinibas", JOptionPane.INFORMATION_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null, "sasniegts max vecums!","bridinajums",
					JOptionPane.WARNING_MESSAGE);
	}
	
	void nolasitVecumu() {
		JOptionPane.showMessageDialog(null, vards+" ir "+vecums+
				" gadus vecs", "info my dawglicous", JOptionPane.INFORMATION_MESSAGE);
	}
	
	void medit() {
		if((rand.nextInt(3))==0) {
			medijumuSk++;
			bilde = iestatiBildi("nokerts");
			JOptionPane.showMessageDialog(null, "medijums tika nokerts","good shi homie",
					JOptionPane.INFORMATION_MESSAGE, bilde);
		}else {
			bilde = iestatiBildi("aizlaidas");
			JOptionPane.showMessageDialog(null, "medijums aizbeg bruh",
					"epic fail", JOptionPane.INFORMATION_MESSAGE, bilde);
		}
	}
}
