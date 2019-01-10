package controller.actions.actionListeners.installListeners;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import app.AppCore;
import controller.actions.actionListeners.MyActionListener;
import model.InstallData;
import model.Pair;
import model.tree.nodes.ModuleNode;
import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ParameterNode;
import model.tree.nodes.ProductNode;
import model.tree.nodes.parameterContainers.CustomContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;
import view.panels.parameterPanels.containerPanels.ContainerTypes;
import view.tabs.MyTab;

public class ExportListener extends MyActionListener {

	@Override
	protected void myActionPerformed(ActionEvent event) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		chooser.showSaveDialog(AppCore.getInstance().getMainFrame());

		File file = chooser.getSelectedFile();
		if (file != null) {

			MyTreeNode myTreeNode = ((MyTab) AppCore.getInstance().getNodeTabPanel().getTabbedPane()
					.getSelectedComponent()).getNode();

			if (myTreeNode instanceof ProductNode) {
				ProductNode productNode = (ProductNode) myTreeNode;

				InstallData instalData = new InstallData();

				// getting free parameters
				instalData.setDefaultContainers(getFreeContainers(productNode));

				// getting modules
				for (MyTreeNode node : productNode.getChildren()) {
					if (node instanceof ModuleNode) {
						instalData.getModules().add(getFreeContainers((ModuleNode) node));
					}
				}

				FileOutputStream fileOutputStream;
				try {
					fileOutputStream = new FileOutputStream(file);
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

					objectOutputStream.writeObject(instalData);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Selected tab is not a product.");
			}
		} else {
			System.out.println("No file selected.");
		}
	}

	private Pair<Pair<String, String>, ArrayList<ParameterContainer>> getFreeContainers(ModuleNode myTreeNode) {
		String moduleName = null;
		String moduleLocation = null;

		if (myTreeNode instanceof ModuleNode) {
			moduleName = myTreeNode.getName();
			moduleLocation = myTreeNode.getFilePath();
		}

		ArrayList<ParameterContainer> freeContainers = new ArrayList<>();

		for (MyTreeNode node : myTreeNode.getChildren()) {
			if (node instanceof ParameterNode) {
				ParameterContainer container = ((ParameterNode) node).getContainer();
				if (container != null) {
					if (container.getContainerType() == ContainerTypes.Custom)
						freeContainers.addAll(((CustomContainer) container).getSubContainers());
					else
						freeContainers.add(container);
				}
			}
		}

		return new Pair<Pair<String, String>, ArrayList<ParameterContainer>>(
				new Pair<String, String>(moduleName, moduleLocation), freeContainers);
	}

	private ArrayList<ParameterContainer> getFreeContainers(ProductNode productNode) {

		ArrayList<ParameterContainer> freeContainers = new ArrayList<>();

		for (MyTreeNode node : productNode.getChildren()) {
			if (node instanceof ParameterNode) {
				ParameterContainer container = ((ParameterNode) node).getContainer();
				if (container.getContainerType() == ContainerTypes.Custom)
					freeContainers.addAll(((CustomContainer) container).getSubContainers());
				else
					freeContainers.add(container);
			}
		}

		return freeContainers;
	}
}
