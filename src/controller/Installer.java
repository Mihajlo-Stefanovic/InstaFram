package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import app.AppCore;
import controller.actions.windowListeners.InstallationFrameWindowListener;
import model.InstallData;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import view.panels.installationPanels.ChoseModulesPanel;
import view.panels.installationPanels.InstallationPanelsHolder;

public class Installer {

	private JFrame installFrame;
	private InstallationPanelsHolder installationPanel;

	private InstallData installData;

	private int onModule;
	private int onContainer;

	private ArrayList<Integer> numOfModulForInstal;

	private ArrayList<File> toMakeDShortCut;
	private ArrayList<File> toOpen;

	public Installer() {
	}

	public void install(InstallData installData) {
		onModule = -1;
		onContainer = 0;

		this.installData = installData;
		installData.sortContainers();

		numOfModulForInstal = new ArrayList<>();
		toMakeDShortCut = new ArrayList<>();
		toOpen = new ArrayList<>();

		setUpInstallFrameLook();
		setUpInstallFrameActions();

		showNextContainer();
	}

	private void setUpInstallFrameActions() {
		installationPanel.getBtnNext().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doAction();
				showNextContainer();
			}
		});
		installationPanel.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (installFrame.getWindowListeners().length == 1)
					installFrame.getWindowListeners()[0].windowClosing(new WindowEvent(installFrame, 0));
				else
					System.out.println("More than one window listener is not supported on installation frame!");
			}
		});

		installFrame.addWindowListener(new InstallationFrameWindowListener());
		installFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}

	protected void doAction() {
		installationPanel.getContainerPanel().doAction();
	}

	private void showNextContainer() {
		try {
			if (onModule == -1) {
				if (onContainer < installData.getDefaultContainers().size()) {
					showContainer();
					onContainer++;
				} else {
					onContainer = 0;
					onModule += 1;
					choseModules();
				}
			} else if (onModule < installData.getModules().size()) {
				if (!numOfModulForInstal.contains(onModule)) {
					onModule += 1;
					showNextContainer();
				} else if (onContainer < installData.getModules().get(onModule).getSecond().size()) {
					if (onContainer == 0)
						JOptionPane.showMessageDialog(installFrame, "Entering "
								+ installData.getModules().get(onModule).getFirst().getFirst() + " module.");
					showContainer();
					onContainer += 1;
				} else {
					onContainer = 0;
					onModule += 1;
					showNextContainer();
				}
			} else {
				for (File file : toMakeDShortCut) {
					String fileName = file.toPath().toString();
					int i = fileName.lastIndexOf('\\');

					if (i > 0) {
						fileName = fileName.substring(i + 1);
					}

					Files.copy(file.toPath(), new File(
							javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory().toPath()
									+ File.separator + fileName).toPath());
				}
				Desktop desktop = Desktop.getDesktop();
				for (File file : toOpen) {
					desktop.open(file);
				}

				JOptionPane.showMessageDialog(installFrame, "Installation finished successfully!");
				installFrame.dispose();
				installFrame.setVisible(false);
			}

		} catch (NoSuchFileException e) {
			AppCore.getInstance().getExceptionManager()
					.handleException(new MyException(MyExceptionSubTypes.INSTALL.NOSUCHFILE));
			installFrame.dispose();
			installFrame.setVisible(false);
		} catch (IllegalArgumentException e) {
			AppCore.getInstance().getExceptionManager()
					.handleException(new MyException(MyExceptionSubTypes.INSTALL.NOSUCHFILE));
			installFrame.dispose();
			installFrame.setVisible(false);
		} catch (FileAlreadyExistsException e) {
			System.out.println("File allready exists.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showContainer() {
		if (onModule == -1) {
			installationPanel.setInstallationPanel(installData.getDefaultContainers().get(onContainer));
		} else
			installationPanel.setInstallationPanel(installData.getModules().get(onModule).getSecond().get(onContainer));
	}

	private void setUpInstallFrameLook() {
		installFrame = new JFrame();

		installationPanel = new InstallationPanelsHolder();
		installFrame.add(installationPanel);

		installFrame.setTitle("Instalation");

		installFrame.setSize(500, 500);
		installFrame.setResizable(false);

		installFrame.setLocationRelativeTo(AppCore.getInstance().getMainFrame());

		installFrame.setVisible(true);
	}

	private void choseModules() {
		installationPanel.setInstallationPanel(new ChoseModulesPanel(installData.getModules()));
	}

	public InstallationPanelsHolder getInstallationPanel() {
		return installationPanel;
	}

	public JFrame getInstallFrame() {
		return installFrame;
	}

	public ArrayList<Integer> getNumOfModulForInstal() {
		return numOfModulForInstal;
	}

	public void setNumOfModulForInstal(ArrayList<Integer> numOfModulForInstal) {
		this.numOfModulForInstal = numOfModulForInstal;
	}

	public ArrayList<File> getToMakeDShortCut() {
		return toMakeDShortCut;
	}

	public ArrayList<File> getToOpen() {
		return toOpen;
	}

}
