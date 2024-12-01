package Model;

import Controller.Controller;
import Storage.Storage;

public class TilstandeTest {

	public static void main(String[] args) {

		KontoType kontotype = Controller
				.createKontoType(
						"Ungdomskonto",
						"En kontotype til unge under 25, som for at beskytte du unge ikke tillader at der hæves på en konto med saldo under 0");

		Konto k1 = Controller.createKonto(kontotype, 1000);
		Konto k2 = Controller.createKonto(kontotype, 500);



		Controller.foretagTransaktion(k1, k2, 200);
		Controller.foretagTransaktion(k1, k2, 800);
		Controller.foretagTransaktion(k1, k2, 200);
		Controller.foretagTransaktion(k1, k2, 200);
		Controller.foretagTransaktion(k1, k2, 200);


		for (Konto konto : Storage.getKonti()) {
			System.out.println(konto);
		}


	}
}
