package kakuTante;

import javax.swing.JOptionPane;

public class MinkuTante {

	public static void main(String[] args) {
		Minka runcis = new Minka("Muris", "Meinkūns", "Pelēks", "Pēteris",
				2021, true, "loto");
		
		JOptionPane.showMessageDialog(null, runcis.nolasitAtributus());
		runcis.medit();
	}

}
