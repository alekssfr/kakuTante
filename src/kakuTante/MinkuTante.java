package kakuTante;

import java.io.File;
import java.time.Year;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class MinkuTante {
	
	static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			
			virkne = virkne.trim();
		}while(!Pattern.matches("^[\\p{L} ]+$", virkne));
		
		return virkne;
	}
	
	static int skaitlaParbaude(String zinojums, int min, int max) {
		String ievade;
		int skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(zinojums, min);
			if(ievade == null)
				return -1;
			
			try {
				skaitlis = Integer.parseInt(ievade); 
					if(skaitlis<min || skaitlis>max) {
						JOptionPane.showMessageDialog(null, "Norāditais skaitlis ir arpus"
								+ "pielaujama intervala","Bridinajums", JOptionPane.WARNING_MESSAGE);
						continue;
				}
					
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Netika ievadīts vesels skaitlis!",
						"Kļūda", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
//		Minka runcis = new Minka("Muris", "Meinkūns", "Pelēks", "Pēteris",
//				2021, true, "loto");
//		
//		JOptionPane.showMessageDialog(null, runcis.nolasitAtributus());
//		runcis.medit();
		
		String izvelne, failaNosaukums =
				System.getProperty("user.home") + File.separator+
				"Desktop"+ File.separator+"minkas.txt";
		Minka runcis = null;
		String[] darbibuSaraksts = {"Izveidot kaķi", "Izsaukt metodi",
				"Saglabat failā", "Apskatīt failā saglabātos kaķus",
				"Aizvērt"};
		
		do {
			izvelne = (String) JOptionPane.showInputDialog(null,
					"Izvelies darbibu", "darbibu izvele",
					JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts,
					darbibuSaraksts[0]);
			
			if(izvelne == null) {
				izvelne = "Aizvērt";
			}
			
			switch(izvelne) {
			case "Izveidot kaķi":
				String minkasVards, skirne, spalvasKrasa, saimnieks,
				cels;
				int dzGads = 0;
				boolean siksnina;
				
				minkasVards = virknesParbaude("Ievadi kaķa vārdu", "Rudis");
				skirne = virknesParbaude("Norādi kaka skirni", "Meinkuns");
				spalvasKrasa = virknesParbaude("Kada ir kazoka krasa?", "Peleka");
				saimnieks = virknesParbaude("Kā sauc"+minkasVards+" saimnieku?", "Mirdza");
				cels = virknesParbaude("Ievadi bildes nosaukumu","rudis");
				dzGads = skaitlaParbaude("Noradi kaka dzimsanas gadu",(Year.now().getValue())-19, (Year.now().getValue()));
				int poga = JOptionPane.showConfirmDialog(null, "Vai kaķim ir siksnina?","Siksnina",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(poga == -1)
					break;
				
				siksnina = (poga == 0) ? true : false;
				runcis = new Minka(minkasVards, skirne, spalvasKrasa,
						saimnieks, dzGads, siksnina, cels);
				break;
				
			
			}
			
		}while(!izvelne.equals("Aizvērt"));
	}

}
