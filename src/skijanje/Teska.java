package skijanje;

public class Teska extends Deonica {

	public Teska(double length, double incline) {
		super(length, incline);
		oznaka='T';
	
	}
	
	public char oznaka() {
		return oznaka;
	}

	public double ubrzanje() {
		double b = Math.toRadians(nagib);
		ubrzanje=9.81*Math.sin(b);
		return ubrzanje;
	}
	
	
	
}
