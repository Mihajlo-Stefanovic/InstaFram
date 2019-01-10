package view.dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import app.AppCore;

public abstract class MyJDialog extends JDialog {

	private static final long serialVersionUID = 2999110275625945134L;
	protected JButton btnOk;
	protected JButton btnCancel;

	public MyJDialog(String title) {
		setTitle(title);
		setLayout(null);

		setSize(400, 170);
		setResizable(false);
		
		setLocationRelativeTo(AppCore.getInstance().getMainFrame());

		initializeDefault();
	}

	private void initializeDefault() {
		btnOk = new JButton("Ok");
		btnCancel = new JButton("Cancel");
		
		btnOk.setBounds(120, 100, 70, 25);
		btnCancel.setBounds(210, 100, 80, 25);

		add(btnOk);
		add(btnCancel);

		setDefaultActions();
	}

	protected void setDefaultActions() {
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doAction();
			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
	}

	protected abstract void initialize();

	protected abstract void doAction();
	public void close() {
		dispose();
		setVisible(false);
	}
	
	public abstract Object showDialog();
}
