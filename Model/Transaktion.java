package Model;
import java.time.LocalDate;

public class Transaktion {
	private Konto fraKonto;
	private Konto tilKonto;
	private int beløb;
	private LocalDate dato;

	public Transaktion(Konto fraKonto, Konto tilKonto,int beløb) {
		this.fraKonto = fraKonto;
		this.tilKonto = tilKonto;

		this.beløb = beløb;
		this.dato = LocalDate.now();
	}

	public int getBeløb() {
		return this.beløb;
	}

	public LocalDate getDato() {
		return this.dato;
	}

}
