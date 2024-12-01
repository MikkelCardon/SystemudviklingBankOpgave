package Storage;

import Model.Konto;
import Model.KontoType;

import java.util.ArrayList;

public class Storage {

	private static ArrayList<KontoType> kontoTyper = new ArrayList<KontoType>();
	private static ArrayList<Konto> konti = new ArrayList<Konto>();

	public static void addKontoType(KontoType kontoType) {
		if (!kontoTyper.contains(kontoType)) {
			kontoTyper.add(kontoType);
		}
	}
	public static void addKonto(Konto konto) {
		if (!konti.contains(konto)) {
			konti.add(konto);
		}
	}

	public static ArrayList<Konto> getKonti(){
		return new ArrayList<Konto>(konti);
	}

}
