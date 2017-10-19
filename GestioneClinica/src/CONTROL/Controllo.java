package CONTROL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collection;
import java.util.Collections;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import MODEL.Dottore;
import MODEL.Gestione;
import VIEW.Finestra;

public class Controllo implements ActionListener, ChangeListener, KeyListener{
	private Finestra f;
	private Gestione g;
	private boolean gRic;
	
	public Controllo(Finestra f, Gestione g) {
		this.f = f;
		this.g = g;
		
		f.getBtnInserisci().addActionListener(this);
		f.getComboBox().addActionListener(this);
		f.getTabbedPane().addChangeListener(this);
		f.getTxtNum1().addKeyListener(this);
		f.getTxtNum2().addKeyListener(this);
		f.getTxtNum3().addKeyListener(this);
		f.getTxtPrefix1().addKeyListener(this);
		f.getTxtPrefix2().addKeyListener(this);
		f.getTxtPrefix3().addKeyListener(this);
		f.getBtnRic().addActionListener(this);
		f.getBtnOrdina().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		//---- Inserimento dottore ----//
		
		if(evt.getSource() == f.getBtnInserisci()) {
			
			boolean err = false;
			String nomeT = null;
			String cognT = null;
			String sessoT = null;
			String specT = null;
			
			if(f.getTxtCognome().getText().length() >1) {
				System.out.println("debug");
				cognT = f.getTxtCognome().getText();
				cognT = cognT.substring(0, 1).toUpperCase() + cognT.substring(1);
			}else {
				f.errore(1);
				err = true;
			}
			
			if(f.getTxtNome().getText().length() >1) {
				nomeT = f.getTxtNome().getText();
				nomeT = nomeT.substring(0, 1).toUpperCase() + cognT.substring(1);
			}else {
				f.errore(0);
				err = true;
			}
			
					
			if(f.getRdbtnF().isSelected()) {
				sessoT = "F";
			}else {
				sessoT = "M";
			}
			
			if((f.getTxtSpec().getText().length() >1) && err!= true) {
				specT = f.getTxtSpec().getText();
			}else {
				f.errore(2);
				err = true;
			}
			specT = f.getTxtSpec().getText();
			String[] numT = new String[3];
			
			
			switch(f.getComboBox().getSelectedIndex()){
				case 0:{
					
				}break;
				case 1:{
					numT[0] = f.getTxtPrefix1().getText() + "  " + f.getTxtNum1().getText();
				}break;
				case 2:{
					numT[0] = f.getTxtPrefix1().getText() + "  " + f.getTxtNum1().getText();
					numT[1] = f.getTxtPrefix2().getText() + "  " + f.getTxtNum2().getText();
				}break;
				case 3:{
					numT[0] = f.getTxtPrefix1().getText() + "  " + f.getTxtNum1().getText();
					numT[1] = f.getTxtPrefix2().getText() + "  " + f.getTxtNum2().getText();
					numT[2] = f.getTxtPrefix3().getText() + "  " + f.getTxtNum3().getText();
				}
			}
			
			if(err == false) {
				Dottore d = new Dottore(nomeT,cognT,sessoT,specT,numT);
				g.inserisci(d);
			}
			//System.out.println(g.stampa(0));
		}
		
		//---- Gestione numeri ----//
		
		if(evt.getSource() == f.getComboBox()) {
			switch(Integer.parseInt((String)f.getComboBox().getSelectedItem())) {
				case 0:{
					vis1(false);
					vis2(false);
					vis3(false);
				}break;
				case 1:{
					vis1(true);
					vis2(false);
					vis3(false);
				}break;
				case 2:{
					vis1(true);
					vis2(true);
					vis3(false);
				}break;
				case 3:{
					vis1(true);
					vis2(true);
					vis3(true);
				}
			}

		}
		
		//---- Ricerca dottore ----//
		
		if(evt.getSource() == f.getBtnRic()) {

			f.getModello().clear();
			char cognRic = (char) f.getcBoxRic().getSelectedItem();
			
			for(int i = 0; i < g.getSize(); i++) {
				if(g.getDottore(i).getCognome().charAt(0) == cognRic) {
					f.getModello().addElement(g.getDottore(i));
				}
			}
			gRic = true;
			f.getTabbedPane().setSelectedIndex(1);
		}
		
		if(evt.getSource() == f.getBtnOrdina()){
			Collections.sort(g.getVet());
			f.getLblOrdinamentoCompletato().setVisible(true);
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		if(f.getTabbedPane().getSelectedIndex() ==1 && gRic == false){
			f.getModello().clear();
			for(int i = 0; i < g.getSize(); i++){
				f.getModello().addElement(g.getDottore(i));
			}
		}else{
			gRic = false;
		}
		
		if(f.getTabbedPane().getSelectedIndex() == 3){
			f.getLblOrdinamentoCompletato().setVisible(false);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(f.getTxtPrefix1().getText().length() >= 3){
			arg0.consume();
		}
		
		if(f.getTxtNum1().getText().length() >= 7){
			arg0.consume();
		}
		
		
			
	}
	
	public void canc(){
		f.getTxtCognome().setText("");
	}
	
	public void vis1(boolean b) {
		f.getTxtPrefix1().setVisible(b);
		f.getLblBarra1().setVisible(b);
		f.getTxtNum1().setVisible(b);
	}
	
	public void vis2(boolean b) {
		f.getTxtPrefix2().setVisible(b);
		f.getLblBarra2().setVisible(b);
		f.getTxtNum2().setVisible(b);
	}
	
	public void vis3(boolean b) {
		f.getTxtPrefix3().setVisible(b);
		f.getLblBarra3().setVisible(b);
		f.getTxtNum3().setVisible(b);
	}

	
}
