package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Finestra extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelIns;
	private JPanel panelStampa;
	private JPanel panelRicerca;
	private JPanel panel_3;
	private JLabel lblCognome;
	private JTextField txtCognome;
	private JLabel lblNome;
	private JTextField txtNome;
	private JPanel panel;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblSpecializzazione;
	private JTextField txtSpec;
	private JLabel lblNumeroiDiTelefono;
	private JComboBox comboBox;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JTextField txtNum3;
	private JButton btnInserisci;
	private JScrollPane scrollPane;
	private JList list;
	private DefaultListModel modello;
	private JComboBox cBoxRic;
	private JTextField txtPrefix1;
	private JTextField txtPrefix2;
	private JTextField txtPrefix3;
	private JLabel lblBarra1;
	private JLabel lblBarra2;
	private JLabel lblBarra3;
	private JButton btnRic;
	private JButton btnOrdina;
	private JLabel lblPremereIlPulsante;
	private JLabel lblOrdinamentoCompletato;


	/**
	 * Create the frame.
	 */
	public Finestra() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch(Exception e) {
		}
		setTitle("Treviso Medical Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 629, 388);
		contentPane.add(tabbedPane);
		
		panelIns = new JPanel();
		tabbedPane.addTab("Inserimento", null, panelIns, null);
		panelIns.setLayout(null);
		
		lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(24, 58, 63, 14);
		panelIns.add(lblCognome);
		
		txtCognome = new JTextField();
		txtCognome.setBounds(179, 55, 141, 20);
		panelIns.add(txtCognome);
		txtCognome.setColumns(10);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 124, 46, 14);
		panelIns.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(179, 121, 141, 20);
		panelIns.add(txtNome);
		txtNome.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Sesso", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(339, 11, 258, 127);
		panelIns.add(panel);
		panel.setLayout(null);
		
		rdbtnM = new JRadioButton("M");
		buttonGroup.add(rdbtnM);
		rdbtnM.setBounds(37, 63, 43, 29);
		rdbtnM.setSelected(true);
		panel.add(rdbtnM);
		
		rdbtnF = new JRadioButton("F");
		buttonGroup.add(rdbtnF);
		rdbtnF.setBounds(181, 63, 33, 29);
		panel.add(rdbtnF);
		
		lblSpecializzazione = new JLabel("Specializzazione");
		lblSpecializzazione.setBounds(24, 175, 94, 14);
		panelIns.add(lblSpecializzazione);
		
		txtSpec = new JTextField();
		txtSpec.setBounds(179, 172, 224, 20);
		panelIns.add(txtSpec);
		txtSpec.setColumns(10);
		
		lblNumeroiDiTelefono = new JLabel("Numero/i di telefono");
		lblNumeroiDiTelefono.setBounds(24, 232, 121, 14);
		panelIns.add(lblNumeroiDiTelefono);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(235, 229, 46, 20);
		
		panelIns.add(comboBox);
		
		txtNum1 = new JTextField();
		txtNum1.setBounds(235, 265, 193, 20);
		//txtNum1.setDocument(new JTextFieldLimit(7));
		panelIns.add(txtNum1);
		txtNum1.setColumns(10);
		txtNum1.setVisible(false);
		
		txtNum2 = new JTextField();
		txtNum2.setColumns(10);
		//txtNum2.setDocument(new JTextFieldLimit(7));
		txtNum2.setBounds(235, 296, 193, 20);
		panelIns.add(txtNum2);
		txtNum2.setVisible(false);
		
		txtNum3 = new JTextField();
		txtNum3.setColumns(10);
		//txtNum3.setDocument(new JTextFieldLimit(7));
		txtNum3.setBounds(235, 327, 193, 20);
		panelIns.add(txtNum3);
		txtNum3.setVisible(false);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(508, 326, 89, 23);
		panelIns.add(btnInserisci);
		
		txtPrefix1 = new JTextField();
		txtPrefix1.setBounds(102, 265, 63, 20);
		//txtPrefix1.setDocument(new JTextFieldLimit(3));
		panelIns.add(txtPrefix1);
		txtPrefix1.setColumns(10);
		
		txtPrefix2 = new JTextField();
		txtPrefix2.setColumns(10);
		//txtPrefix2.setDocument(new JTextFieldLimit(3));
		txtPrefix2.setBounds(102, 296, 63, 20);
		panelIns.add(txtPrefix2);
		
		txtPrefix3 = new JTextField();
		txtPrefix3.setColumns(10);
		//txtPrefix3.setDocument(new JTextFieldLimit(3));
		txtPrefix3.setBounds(102, 327, 63, 20);
		panelIns.add(txtPrefix3);
		
		lblBarra1 = new JLabel("/");
		lblBarra1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarra1.setBounds(179, 268, 46, 14);
		panelIns.add(lblBarra1);
		
		lblBarra2 = new JLabel("/");
		lblBarra2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarra2.setBounds(179, 299, 46, 14);
		panelIns.add(lblBarra2);
		
		lblBarra3 = new JLabel("/");
		lblBarra3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarra3.setBounds(179, 330, 46, 14);
		panelIns.add(lblBarra3);
		
		panelStampa = new JPanel();
		tabbedPane.addTab("Stampa", null, panelStampa, null);
		panelStampa.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 624, 360);
		panelStampa.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		modello = new DefaultListModel();
		list.setModel(modello);
		
		panelRicerca = new JPanel();
		tabbedPane.addTab("Ricerca dottore", null, panelRicerca, null);
		panelRicerca.setLayout(null);
		
		cBoxRic = new JComboBox();
		cBoxRic.setMaximumRowCount(24);
		cBoxRic.setBounds(199, 168, 53, 25);
		for(int i = 65; i < 91; i++) {
			char c;
			c = (char)i;
			cBoxRic.addItem(c);
		}
		panelRicerca.add(cBoxRic);
		
		btnRic = new JButton("Invia");
		btnRic.setBounds(308, 169, 89, 23);
		panelRicerca.add(btnRic);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Ordina", null, panel_3, null);
		panel_3.setLayout(null);
		
		btnOrdina = new JButton("Ordina");
		btnOrdina.setBounds(267, 167, 89, 23);
		panel_3.add(btnOrdina);
		
		lblPremereIlPulsante = new JLabel("Premere il pulsante per ordinare i dottori");
		lblPremereIlPulsante.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPremereIlPulsante.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremereIlPulsante.setBounds(134, 98, 379, 41);
		panel_3.add(lblPremereIlPulsante);
		
		lblOrdinamentoCompletato = new JLabel("Ordinamento completato!");
		lblOrdinamentoCompletato.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrdinamentoCompletato.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdinamentoCompletato.setBounds(134, 234, 383, 41);
		panel_3.add(lblOrdinamentoCompletato);
		
		txtPrefix1.setVisible(false);
		lblBarra1.setVisible(false);
		txtPrefix2.setVisible(false);
		lblBarra2.setVisible(false);
		txtPrefix3.setVisible(false);
		lblBarra3.setVisible(false);
		lblOrdinamentoCompletato.setVisible(false);
		
		this.setVisible(true);
	}

	public void errore(int e) {
		switch(e) {
			case 0:{
				JOptionPane.showMessageDialog(this, "Inserisci un nome");
			}break;
			case 1:{
				JOptionPane.showMessageDialog(this, "Inserisci un cognome");
			}break;
			case 2:{
				JOptionPane.showMessageDialog(this, "Inserisci una specializzazione");
			}break;
		}
	}

	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}



	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}



	public JPanel getPanelIns() {
		return panelIns;
	}



	public void setPanelIns(JPanel panelIns) {
		this.panelIns = panelIns;
	}



	public JPanel getPanelStampa() {
		return panelStampa;
	}



	public void setPanelStampa(JPanel panelStampa) {
		this.panelStampa = panelStampa;
	}



	public JPanel getPanelRicerca() {
		return panelRicerca;
	}



	public void setPanelRicerca(JPanel panelRicerca) {
		this.panelRicerca = panelRicerca;
	}



	public JPanel getPanel_3() {
		return panel_3;
	}



	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}



	public JLabel getLblCognome() {
		return lblCognome;
	}



	public void setLblCognome(JLabel lblCognome) {
		this.lblCognome = lblCognome;
	}



	public JTextField getTxtCognome() {
		return txtCognome;
	}



	public void setTxtCognome(JTextField txtCognome) {
		this.txtCognome = txtCognome;
	}



	public JLabel getLblNome() {
		return lblNome;
	}



	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}



	public JTextField getTxtNome() {
		return txtNome;
	}



	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}



	public JPanel getPanel() {
		return panel;
	}



	public void setPanel(JPanel panel) {
		this.panel = panel;
	}



	public JRadioButton getRdbtnM() {
		return rdbtnM;
	}



	public void setRdbtnM(JRadioButton rdbtnM) {
		this.rdbtnM = rdbtnM;
	}



	public JRadioButton getRdbtnF() {
		return rdbtnF;
	}



	public void setRdbtnF(JRadioButton rdbtnF) {
		this.rdbtnF = rdbtnF;
	}



	public JLabel getLblSpecializzazione() {
		return lblSpecializzazione;
	}



	public void setLblSpecializzazione(JLabel lblSpecializzazione) {
		this.lblSpecializzazione = lblSpecializzazione;
	}



	public JTextField getTxtSpec() {
		return txtSpec;
	}



	public void setTxtSpec(JTextField txtSpec) {
		this.txtSpec = txtSpec;
	}



	public JLabel getLblNumeroiDiTelefono() {
		return lblNumeroiDiTelefono;
	}



	public void setLblNumeroiDiTelefono(JLabel lblNumeroiDiTelefono) {
		this.lblNumeroiDiTelefono = lblNumeroiDiTelefono;
	}



	public JComboBox getComboBox() {
		return comboBox;
	}



	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}



	public JTextField getTxtNum1() {
		return txtNum1;
	}



	public void setTxtNum1(JTextField txtNum1) {
		this.txtNum1 = txtNum1;
	}



	public JTextField getTxtNum2() {
		return txtNum2;
	}



	public void setTxtNum2(JTextField txtNum2) {
		this.txtNum2 = txtNum2;
	}



	public JTextField getTxtNum3() {
		return txtNum3;
	}



	public void setTxtNum3(JTextField txtNum3) {
		this.txtNum3 = txtNum3;
	}



	public JButton getBtnInserisci() {
		return btnInserisci;
	}



	public void setBtnInserisci(JButton btnInserisci) {
		this.btnInserisci = btnInserisci;
	}



	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}



	public JScrollPane getScrollPane() {
		return scrollPane;
	}



	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}



	public JList getList() {
		return list;
	}



	public void setList(JList list) {
		this.list = list;
	}



	public DefaultListModel getModello() {
		return modello;
	}



	public void setModello(DefaultListModel modello) {
		this.modello = modello;
	}



	public JComboBox getComboBoxRic() {
		return cBoxRic;
	}



	public void setComboBoxRic(JComboBox comboBoxRic) {
		this.cBoxRic = comboBoxRic;
	}



	public JTextField getTxtPrefix1() {
		return txtPrefix1;
	}



	public void setTxtPrefix1(JTextField txtPrefix1) {
		this.txtPrefix1 = txtPrefix1;
	}



	public JTextField getTxtPrefix2() {
		return txtPrefix2;
	}



	public void setTxtPrefix2(JTextField txtPrefix2) {
		this.txtPrefix2 = txtPrefix2;
	}



	public JTextField getTxtPrefix3() {
		return txtPrefix3;
	}



	public void setTxtPrefix3(JTextField txtPrefix3) {
		this.txtPrefix3 = txtPrefix3;
	}



	public JLabel getLblBarra1() {
		return lblBarra1;
	}



	public void setLblBarra1(JLabel lblBarra1) {
		this.lblBarra1 = lblBarra1;
	}



	public JLabel getLblBarra2() {
		return lblBarra2;
	}



	public void setLblBarra2(JLabel lblBarra2) {
		this.lblBarra2 = lblBarra2;
	}



	public JLabel getLblBarra3() {
		return lblBarra3;
	}



	public void setLblBarra3(JLabel lblBarra3) {
		this.lblBarra3 = lblBarra3;
	}

	public JComboBox getcBoxRic() {
		return cBoxRic;
	}

	public void setcBoxRic(JComboBox cBoxRic) {
		this.cBoxRic = cBoxRic;
	}

	public JButton getBtnRic() {
		return btnRic;
	}

	public void setBtnRic(JButton btnRic) {
		this.btnRic = btnRic;
	}

	public JButton getBtnOrdina() {
		return btnOrdina;
	}

	public void setBtnOrdina(JButton btnOrdina) {
		this.btnOrdina = btnOrdina;
	}

	public JLabel getLblOrdinamentoCompletato() {
		return lblOrdinamentoCompletato;
	}

	public void setLblOrdinamentoCompletato(JLabel lblOrdinamentoCompletato) {
		this.lblOrdinamentoCompletato = lblOrdinamentoCompletato;
	}
	
	
}
