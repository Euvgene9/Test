package Transakcja;

import KartaKlienta.*;

public class Transakcja {

    private static int numerTransakcji=0;
    private double kwota;
    private KartaKlienta karta;

    
    public Transakcja() {
        this.kwota = 0.0;
        this.karta=null;
        numerTransakcji++;
    }

    public Transakcja(double kwota, KartaKlienta karta) {
        this.kwota = kwota;
        this.karta=karta;;
        numerTransakcji++;
    }

    public double kwotaDoZaplaty() {
        return kwota * (1 - getKarta().rabat());
    }

    @Override
    public String toString() {
        return "Transakcja{" +" kwota=" + kwota + ", { karta=" + getKarta() + ", kwotaDoZaplaty=" + kwotaDoZaplaty() + '}';
      }

	public KartaKlienta getKarta() {
		return karta;
	}

	public void setKarta(KartaKlienta karta) {
		this.karta = karta;
	}

	public static int getNumerTransakcji() {
		return numerTransakcji;
	}

	public static void setNumerTransakcji(int numerTransakcji) {
		Transakcja.numerTransakcji = numerTransakcji;
	}
	
	
}
