package model.holders;

import javax.swing.ImageIcon;

public class LoadedImages {
	private ImageIcon newProjectIcon = new ImageIcon("Images/newProjectIcon.png");
	
	private ImageIcon openProjectIcon = new ImageIcon("Images/openProjectIcon.png");
	private ImageIcon closeProjectIcon = new ImageIcon("Images/closeProjectIcon.png");
	
	private ImageIcon saveProjectIcon = new ImageIcon("Images/saveProjectIcon.png");
	private ImageIcon saveProjectAsIcon = new ImageIcon("Images/saveProjectAsIcon.png");
	
	private ImageIcon addNodeIcon = new ImageIcon("Images/addNodeIcon.png");
	private ImageIcon deleteNodeIcon = new ImageIcon("Images/deleteNodeIcon.png");
	private ImageIcon addTreeIcon = new ImageIcon("Images/addTreeIcon.png");
	
	private ImageIcon tabIcon = new ImageIcon("Images/tabIcon.png"); 
	
	private ImageIcon myPicIcon = new ImageIcon("Images/MyPicture.jpg");

	public LoadedImages() {
		newProjectIcon = new ImageIcon("Images/newProjectIcon.png");
		
		openProjectIcon = new ImageIcon("Images/openProjectIcon.png");
		closeProjectIcon = new ImageIcon("Images/closeProjectIcon.png");
		
		saveProjectIcon = new ImageIcon("Images/saveProjectIcon.png");
		saveProjectAsIcon = new ImageIcon("Images/saveProjectAsIcon.png");
		
		addNodeIcon = new ImageIcon("Images/addNodeIcon.png");
		deleteNodeIcon = new ImageIcon("Images/deleteNodeIcon.png");
		addTreeIcon = new ImageIcon("Images/addTreeIcon.png");
	}

	public ImageIcon getNewProjectIcon() {
		return newProjectIcon;
	}

	public ImageIcon getOpenProjectIcon() {
		return openProjectIcon;
	}

	public ImageIcon getCloseProjectIcon() {
		return closeProjectIcon;
	}

	public ImageIcon getSaveProjectIcon() {
		return saveProjectIcon;
	}

	public ImageIcon getSaveProjectAsIcon() {
		return saveProjectAsIcon;
	}

	public ImageIcon getAddNodeIcon() {
		return addNodeIcon;
	}

	public ImageIcon getDeleteNodeIcon() {
		return deleteNodeIcon;
	}

	public ImageIcon getAddTreeIcon() {
		return addTreeIcon;
	}
	
	public ImageIcon getMyPicIcon() {
		return myPicIcon;
	}
}
