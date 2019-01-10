package view.panels.installationPanels.installationContainerPanels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import app.AppCore;
import model.exceptions.MyException;
import model.exceptions.exceptionTypes.MyExceptionSubTypes;
import model.tree.nodes.parameterContainers.LogoContainer;
import model.tree.nodes.parameterContainers.ParameterContainer;

public class InstallationLogoPanel extends InstallationContainerPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5311393709453284070L;
	private BufferedImage logo;

	public InstallationLogoPanel() {
		super();
	}

	public InstallationLogoPanel(ParameterContainer container) {
		super(container);
		setPreferredSize(new Dimension(500, 500));
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(logo, 0, 0, this);           
    }
	
	@Override
	protected void initialize() {

	}

	@Override
	public void showContainerValues() {
		try {                
	          logo = ImageIO.read(new File(((LogoContainer) container).getPathToPicture()));
	          this.validate();
	          this.repaint();
	       } catch (IOException ex) {
	    	   AppCore.getInstance().getExceptionManager()
				.handleException(new MyException(MyExceptionSubTypes.INSTALL.NOSUCHFILE));
	       }
	}

	@Override
	public void doAction() {
		
	}

}
