package skijanje;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;

public class Staza {

	List<Deonica> deonica_lista= new LinkedList<Deonica>();
	String naziv;
	
	
	public Staza(String ime) {
		naziv=ime;
	}


	public void dodaj(Deonica deonica) {
		deonica_lista.add(deonica);
	}


	public int broj() {
		return deonica_lista.size();
	}


	public double duzina() {
		double ukupna_duzina=0;
		for(Deonica deonica:deonica_lista) {
			ukupna_duzina+=deonica.duzina();
		}
		return ukupna_duzina;
	}


	public double nagib() {
		double maks_nagib=0;
		for(Deonica deonica:deonica_lista) {
			if(deonica.nagib()>maks_nagib) {
				maks_nagib=deonica.nagib();
			}
		}
		return maks_nagib;
	}


	public char oznaka() throws GOznaka {
		HashMap<Character, Integer> oznaka_mapa = new HashMap<Character, Integer>();
		for(Deonica deonica:deonica_lista) {
			oznaka_mapa.putIfAbsent(deonica.oznaka(), 0);
		}
		
		for(Deonica deonica:deonica_lista) { //mozda mozes da spojis ova dva
			oznaka_mapa.put(deonica.oznaka(), oznaka_mapa.get(deonica.oznaka())+1);
		}
		
		int maxValueInMap=(Collections.max(oznaka_mapa.values()));  // This will return max value in the HashMap
		for (Entry<Character, Integer> entry : oznaka_mapa.entrySet()) {
	        if (maxValueInMap==entry.getValue()) {
	            char x = entry.getKey();
	            return x;
	        }
	    }
		throw new GOznaka();
	}


	public double brzina(double brzina) {
		double ukupna_brzina=brzina;
		for(Deonica deonica: deonica_lista) {
			ukupna_brzina=deonica.brzina(ukupna_brzina); //ovde ne treba uvek da pocne od nule, nego treba da pocne od krajnje brzine prethodne deonice
		}
		return ukupna_brzina;
	}


	public double vreme(double brzina) {
		double ukupno_vreme=0;
		double ukupna_brzina=brzina;
		for(Deonica deonica: deonica_lista) {
			
			ukupno_vreme+=deonica.vreme(ukupna_brzina); //ovde ne treba uvek da pocne od nule, nego treba da pocne od krajnje brzine prethodne deonice
			ukupna_brzina=deonica.brzina(ukupna_brzina);
		}
		return ukupno_vreme;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv);
		sb.append("|");
		sb.append(broj());
		sb.append("|");
		sb.append(duzina());
		sb.append("|");
		sb.append(nagib());
		sb.append("\n");
		sb.append("[");
		for (int i=0; i<deonica_lista.size(); i++) {
			if(i!=deonica_lista.size()-1) {
				sb.append(deonica_lista.get(i));
				sb.append(",");
			}else {
				sb.append(deonica_lista.get(i));
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	
	
	

}
