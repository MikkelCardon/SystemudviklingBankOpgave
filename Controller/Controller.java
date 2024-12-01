package Controller;

import Model.Konto;
import Model.KontoType;
import Model.Tilstand;
import Model.Transaktion;
import Storage.Storage;

public class Controller {

    public static KontoType createKontoType(String navn, String beskrivelse) {
        KontoType kontoType = new KontoType(navn, beskrivelse);
        Storage.addKontoType(kontoType);
        return kontoType;
    }

    public static Konto createKonto(KontoType kontoType, int startSaldo) {
        int nr = Storage.getKonti().size() + 1;
        Konto konto = new Konto(kontoType, nr, startSaldo);
        Storage.addKonto(konto);

        return konto;
    }

    public static Tilstand lukKonto(Konto konto){
        konto.setTilstand(Tilstand.LUKKET);
        return Tilstand.LUKKET;
    }

    public static void foretagTransaktion(Konto kontoFra, Konto kontoTil, int beløb) {
        Tilstand tilstand = kontoFra.getTilstand();
        if (kontoFra.getTilstand() == Tilstand.LUKKET || kontoTil.getTilstand() == Tilstand.LUKKET){
            System.out.println("Transakton kan ikke laves, konto er " + tilstand);
            return;
        }

        try {
            createTransaktion(kontoFra, kontoTil, beløb);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Transaktion createTransaktion(Konto kontoFra, Konto kontoTil, int beløb) {
        Transaktion transaktion = null;
        if (kontoFra.getTilstand() == Tilstand.AABEN && kontoTil.getTilstand() == Tilstand.AABEN) {
            transaktion = new Transaktion(kontoFra, kontoTil, beløb);
            kontoFra.addTransaktion(transaktion);
            kontoTil.addTransaktion(transaktion);
            kontoFra.changeSaldo(-beløb);
            kontoTil.changeSaldo(beløb);
            if (kontoFra.getSaldo() < 0) {
                kontoFra.setTilstand(Tilstand.OVERTRUKKET);
            } else {
                kontoFra.setTilstand(Tilstand.AABEN);
            }

        } else
            throw new RuntimeException("Du forsøger at hæve på en overtrukket konto!");

        return transaktion;
    }

}
