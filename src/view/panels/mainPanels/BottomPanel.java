package view.panels.mainPanels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.User;

public class BottomPanel extends JPanel {

	private static final long serialVersionUID = -5304441375603751439L;
	private JPanel datumPanel = new JPanel();
	private JPanel korisnikPanel = new JPanel();
	private JPanel akcijaPanel = new JPanel();
	private JPanel statusPanel = new JPanel();

	private JLabel lbDatum = new JLabel();
	private JLabel lbUser = new JLabel();
	private JLabel lbAkcija = new JLabel();
	private JLabel lbStatus = new JLabel();

	public BottomPanel() {
		setLayout(new GridLayout(1, 4));
		addPanels();
	}

	private void addPanels() {
		add(datumPanel);
		datumPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		datumPanel.setBackground(Color.GRAY);
		datumPanel.add(lbDatum);
		setClock();

		add(korisnikPanel);
		korisnikPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		korisnikPanel.setBackground(Color.WHITE);
		lbUser.setText("User: ");
		korisnikPanel.add(lbUser);

		add(akcijaPanel);
		akcijaPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		akcijaPanel.setBackground(Color.GRAY);
		lbAkcija.setText("Action: ");
		akcijaPanel.add(lbAkcija);

		add(statusPanel);
		statusPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBackground(Color.WHITE);
		lbStatus.setText("Status: ");
		statusPanel.add(lbStatus);
	}

	private void setClock() {
		
		  Thread clock = new Thread() { @Override
		public void run () { try { while (true) {
		  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); Date date = new
		  Date();
		 
		  lbDatum.setText("Date & Time: (" + sdf.format(date) + ")"); sleep(1000); }
		  } catch (InterruptedException err) { err.printStackTrace(); } } };
		  clock.start();
		 
	}

	public void setUser(User user) {
		lbUser.setText("User: " + user.getUserName());
	}
}
