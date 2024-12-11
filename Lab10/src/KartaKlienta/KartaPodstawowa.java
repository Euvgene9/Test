package KartaKlienta;

public class KartaPodstawowa extends KartaKlienta{
	
	public KartaPodstawowa(int numer, String nazwisko) {
        super(numer, nazwisko);
    }

    @Override
    public double rabat() {
        return 0.0;
    }
    
    @Override
    public String toString() {
    	return "Karta Podstawowa "+super.toString();
    }

}
