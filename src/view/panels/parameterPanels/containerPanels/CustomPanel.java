package view.panels.parameterPanels.containerPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.tree.nodes.MyTreeNode;
import model.tree.nodes.ProductNode;
import model.tree.nodes.parameterContainers.AuthorContainer;
import model.tree.nodes.parameterContainers.CustomContainer;
import model.tree.nodes.parameterContainers.DShortCutContainer;
import model.tree.nodes.parameterContainers.LogoContainer;
import model.tree.nodes.parameterContainers.LookAndFeelContainer;
import model.tree.nodes.parameterContainers.NameContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;
import model.tree.nodes.parameterContainers.StartAIContainer;
import model.tree.nodes.parameterContainers.TOUContainer;
import observer.MyObserver;
import view.panels.parameterPanels.PlusXPanel;

public class CustomPanel extends MyContainerPanel implements MyObserver {

	private static final long serialVersionUID = 5858269703517684539L;

	private ArrayList<PlusXPanel> paramPanels;

	private JPanel paramPanelsPanel;
	private JScrollPane scrollPane;

	private JPanel addPanel;

	private JButton btnAdd;
	private JComboBox cbParam;

	private MyTreeNode parent;
	
	public CustomPanel(Boolean editable, MyTreeNode parent) {
		super(editable);
		paramPanels = new ArrayList<>();
		this.parent = parent;
	}

	public ArrayList<PlusXPanel> getParamPanels() {
		return paramPanels;
	}

	public void setParamPanels(ArrayList<PlusXPanel> paramPanels) {
		this.paramPanels = paramPanels;
	}

	@Override
	public void update(Object obj) {
		if (obj instanceof CustomContainer) {
			CustomContainer container = (CustomContainer) obj;

			removeDeletedContainerPanels(container);
			addPanelsForNewContainers(container);
			setComboBox();

			paramPanelsPanel.revalidate();
			paramPanelsPanel.repaint();
		}
	}

	private void setComboBox() {
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel<>(ContainerTypes.values());
		cbParam.setModel(boxModel);
		cbParam.removeItem(ContainerTypes.Custom);

		if(parent instanceof ProductNode) {
			cbParam.removeItem(ContainerTypes.DesktopShortcut);
			cbParam.removeItem(ContainerTypes.StartAfterInstalation);
		}
		
		for (PlusXPanel plusXPanel : paramPanels) {
			cbParam.removeItem(((MyContainerPanel) plusXPanel.getPanel()).getContainer().getContainerType());
		}
	}

	private void removeDeletedContainerPanels(CustomContainer container) {
		ArrayList<PlusXPanel> toDelete = new ArrayList<>();

		for (PlusXPanel plusXPanel : paramPanels) {
			boolean hasContainer = false;
			for (ParameterContainer subContainer : container.getSubContainers()) {
				if (subContainer == ((MyContainerPanel) plusXPanel.getPanel()).getContainer()) {
					hasContainer = true;
				}
			}
			if (!hasContainer)
				toDelete.add(plusXPanel);
		}

		for (PlusXPanel panelToDelete : toDelete) {
			paramPanels.remove(panelToDelete);
			paramPanelsPanel.remove(panelToDelete);
		}
	}

	private void addPanelsForNewContainers(CustomContainer container) {
		for (ParameterContainer subContainer : container.getSubContainers()) {
			boolean hasPanel = false;
			for (PlusXPanel plusXPanel : paramPanels) {
				if (((MyContainerPanel) plusXPanel.getPanel()).getContainer() == subContainer)
					hasPanel = true;
			}

			if (!hasPanel) {
				PlusXPanel newPanel = new PlusXPanel(makeContainerPanel(subContainer), this);
				paramPanels.add(newPanel);
				paramPanelsPanel.add(newPanel);
				((MyContainerPanel) newPanel.getPanel()).showContainerValues();
			}
		}
	}

	@Override
	protected void initialize() {
		paramPanelsPanel = new JPanel();
		paramPanelsPanel.setLayout(new BoxLayout(paramPanelsPanel, BoxLayout.Y_AXIS));
		scrollPane = new JScrollPane(paramPanelsPanel);

		cbParam = new JComboBox(ContainerTypes.values());
		cbParam.removeItem(ContainerTypes.Custom);

		addPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		addPanel.setLayout(flowLayout);

		btnAdd = new JButton("Add");

		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);

		addPanel.add(cbParam);
		addPanel.add(btnAdd);

		add(scrollPane, BorderLayout.CENTER);
		add(addPanel, BorderLayout.SOUTH);

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cbParam.getSelectedItem() != null)
					((CustomContainer) container).addContainer(
							container.getParameterNode().makeContainer((ContainerTypes) cbParam.getSelectedItem()));
			}
		});
	}

	@Override
	public void showContainerValues() {
		update(container);
	}

	@Override
	public void saveContainerValues() {
		for (PlusXPanel panel : paramPanels) {
			((MyContainerPanel) panel.getPanel()).saveContainerValues();
		}
	}

	@Override
	public void remove(Component comp) {
		super.remove(comp);
		if (comp instanceof MyContainerPanel) {
			MyContainerPanel containerPanel = (MyContainerPanel) comp;
			((CustomContainer) container).removeContainer(containerPanel.getContainer());
		}
	}

	private MyContainerPanel makeContainerPanel(ParameterContainer container) {

		if (container instanceof AuthorContainer)
			return new AuthorPanel(container,true);

		if (container instanceof DShortCutContainer)
			return new DShortCutPanel(container,true);

		if (container instanceof LogoContainer)
			return new LogoPanel(container,true);

		if (container instanceof LookAndFeelContainer)
			return new LookNFeelPanel(container,true);

		if (container instanceof NameContainer)
			return new NamePanel(container,true);

		if (container instanceof StartAIContainer)
			return new StartAIPanel(container,true);

		if (container instanceof TOUContainer)
			return new TOUPanel(container,true);

		return null;
	}

}
