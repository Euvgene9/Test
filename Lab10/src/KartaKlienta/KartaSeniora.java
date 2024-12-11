package KartaKlienta;

public class KartaSeniora extends KartaKlienta{

	public KartaSeniora(int numer, String nazwisko) {
        super(numer, nazwisko);
    }

    @Override
    public double rabat() {
        return 0.15;
    }
    
    @Override
    public String toString() {
    	return "Karta Seniora "+super.toString();
    }
}
