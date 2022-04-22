package skijanje;

import java.util.Locale;

public abstract class Deonica {

	  static {
	        Locale.setDefault(Locale.US);
	    }
	protected double duzina;
	protected double nagib;
	protected char oznaka; 
	protected double ubrzanje;
	
	public Deonica(double length, double incline){
		duzina=length;
		nagib=incline;
	}
	
	abstract public char oznaka();
	
	abstract public double ubrzanje();
	
	public double duzina() {
		return duzina;
	}
	
	public double nagib() {
		return nagib;
	}
	
	public double brzina(double pocetna_brzina) {
		double krajnja_brzina;
		double medjubrzina=2*ubrzanje*duzina+Math.pow(pocetna_brzina, pocetna_brzina);
		krajnja_brzina=Math.sqrt(medjubrzina);
		return krajnja_brzina;
	}
	
	public double vreme(double pocetna_brzina) {
		double vreme;
		vreme=(brzina(pocetna_brzina)-pocetna_brzina)/ubrzanje;
		return vreme;
	}
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append(oznaka()).append("(").append(duzina).append(",").append(nagib).append(")");
		
		return sb.toString();
	}
	
	
}
