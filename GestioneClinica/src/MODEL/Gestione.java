package MODEL;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

public class Gestione{
	private ArrayList<Dottore> vet;
	
	public Gestione(){
		vet = new ArrayList<Dottore>();
	}
	
	public void inserisci(Dottore d) {
		vet.add(d);
	}
	
	public Dottore stampa(int i) {
		return vet.get(i);
	}
	
	public int getSize(){
		return vet.size();
	}
	
	public Dottore getDottore(int i){
		return vet.get(i);
	}
	
	public ArrayList<Dottore> getVet(){
		return vet;
	}
}
