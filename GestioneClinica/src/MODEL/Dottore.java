package MODEL;

public class Dottore implements Comparable<Dottore> {
	private String nome,cognome,sesso,specializzazione;
	private String[] numeriT;
	
	public Dottore(String nome, String cognome, String sesso, String specializzazione,String[] numeriT) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.specializzazione = specializzazione;
		this.numeriT = new String[3];
		this.numeriT = numeriT;
		System.out.println(this.numeriT[0]);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getSpecializzazione() {
		return specializzazione;
	}
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	public String[] getNumeriT() {
		return numeriT;
	}
	public void setNumeriT(String[] numeriT) {
		this.numeriT = numeriT;
	}
	
	@Override
	public String toString() {
		String ret;
		
		ret = "<html><body>";
		ret += "<h2>" + this.cognome + " " + this.nome + "</h2><br>";
		ret += "<h4>	Sesso: " + this.sesso + "<br>";
		ret += "	Specializzazione: " + this.specializzazione + "<br>";
		for(int i = 0; i < 3; i++) {
			if(numeriT[i] != null) {
				ret += "	Numero: " + numeriT[i] + "<br>"; 
			}
		}
		
		ret += "</h4></body></html>";
		
		return ret;
	}
	@Override
	public int compareTo(Dottore dot) {
		// TODO Auto-generated method stub
		return cognome.compareTo(dot.getCognome());
	}
	
	
	
	
	
}
