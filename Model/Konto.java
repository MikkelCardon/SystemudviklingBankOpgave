package Model;

import java.util.ArrayList;

public class Konto {

	private int nr;
	private ArrayList<Transaktion> transaktioner;
	private KontoType kontoType;
	private Tilstand tilstand;
	private int saldo;

	public Konto(KontoType kontoType, int nr, int saldo) {

		this.kontoType = kontoType;
		this.nr = nr;
		this.tilstand = Tilstand.AABEN;
		transaktioner = new ArrayList<Transaktion>();
		this.saldo = saldo;
	}

	public int getNr() {
		return this.nr;
	}

	public int getSaldo() {
		return saldo;
	}

	public void changeSaldo(int saldo) {
		this.saldo += saldo;
	}

	public void addTransaktion(Transaktion transaktion){
		transaktioner.add(transaktion);
	}

	public Tilstand getTilstand() {
		return tilstand;
	}

	public void setTilstand(Tilstand tilstand) {
		this.tilstand = tilstand;
	}


	@Override
	public String toString() {
		return "Saldo på konto nr. " + getNr() + " med kontotype: "+ kontoType.getNavn()+ " er " + saldo;
	}
}
