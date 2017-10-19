package MAIN;

import CONTROL.Controllo;
import MODEL.Gestione;
import VIEW.Finestra;

public class Main {

	public static void main(String[] args) {
		Finestra f = new Finestra();
		Gestione g = new Gestione();
		Controllo c = new Controllo(f,g);
	}

}
