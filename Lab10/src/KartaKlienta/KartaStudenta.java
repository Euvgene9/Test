package KartaKlienta;

public class KartaStudenta extends KartaKlienta {

	public KartaStudenta(int numer, String nazwisko) {
        super(numer, nazwisko);
    }

    @Override
    public double rabat() {
        return 0.1;
    }
    
    @Override
    public String toString() {
    	return "Karta Studenta "+super.toString();
    }
}
