package KartaKlienta;

public abstract class KartaKlienta {
	
	protected int numer;
    protected String nazwisko;


    public KartaKlienta() {
        this.numer = 0;
        this.nazwisko = null;
    }

    
    public KartaKlienta(int numer, String nazwisko) {
        this.numer = numer;
        this.nazwisko = nazwisko;
    }

    
    public abstract double rabat();
    
    @Override
    public String toString() {
    	return "numer=" + numer +", nazwisko='" + nazwisko + '\'' + '}';
    }
        

}
