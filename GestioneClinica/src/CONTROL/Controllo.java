package CONTROL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
		f.getBtnRic().addActionListener(this);
		f.getBtnOrdina().addActionListener(this);
		
		
		f.getTxtNum1().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent t1) {
				if(f.getTxtNum1().getText().length() >= 7) {
					t1.consume();
				}
			}
		});
		f.getTxtNum2().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent t2) {
				if(f.getTxtNum2().getText().length() >= 7) {
					t2.consume();
				}
			}
		});
		f.getTxtNum3().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent t3) {
				if(f.getTxtNum3().getText().length() >= 7) {
					t3.consume();
				}
			}
		});
		f.getTxtPrefix1().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent p1) {
				if(f.getTxtPrefix1().getText().length() >= 3) {
					p1.consume();
				}
			}
		});
		f.getTxtPrefix2().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent p2) {
				if(f.getTxtPrefix2().getText().length() >= 3) {
					p2.consume();
				}
			}
		});
		f.getTxtPrefix3().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent p3) {
				if(f.getTxtPrefix3().getText().length() >= 3) {
					p3.consume();
				}
			}
		});
		
		
		
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
			
			if(!(f.getTxtSpec().getText().length() >1) && err) {
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
			
			cancella();
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
	}
	
	
	private void canc(){
		f.getTxtCognome().setText("");
	}
	
	private void vis1(boolean b) {
		f.getTxtPrefix1().setVisible(b);
		f.getLblBarra1().setVisible(b);
		f.getTxtNum1().setVisible(b);
	}
	
	private void vis2(boolean b) {
		f.getTxtPrefix2().setVisible(b);
		f.getLblBarra2().setVisible(b);
		f.getTxtNum2().setVisible(b);
	}
	
	private void vis3(boolean b) {
		f.getTxtPrefix3().setVisible(b);
		f.getLblBarra3().setVisible(b);
		f.getTxtNum3().setVisible(b);
	}

	private void cancella() {
		f.getTxtCognome().setText("");
		f.getTxtNome().setText("");
		f.getTxtSpec().setText("");
		f.getTxtNum1().setText("");
		f.getTxtNum2().setText("");
		f.getTxtNum3().setText("");
		f.getTxtPrefix1().setText("");
		f.getTxtPrefix2().setText("");
		f.getTxtPrefix3().setText("");
	}
}
