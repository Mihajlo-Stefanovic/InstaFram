package model.tree.nodes.parameterContainers;

import view.panels.parameterPanels.containerPanels.ContainerTypes;

public class TOUContainer extends ParameterContainer {

	private static final long serialVersionUID = -2063267942590769892L;
	
	private String termsOfUse;

	public TOUContainer() {
		super(ContainerTypes.TermsOfUse,4);
	}

	public TOUContainer(String termsOfUse) {
		super(ContainerTypes.TermsOfUse,4);
		if(termsOfUse!=null)
			this.termsOfUse = new String(termsOfUse);
	}

	public String getTermsOfUSe() {
		return termsOfUse;
	}

	public void setTermsOfUSe(String termsOfUSe) {
		this.termsOfUse = termsOfUSe;
	}

	@Override
	public ParameterContainer getCopy() {
		return new TOUContainer(termsOfUse);
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof TOUContainer) {
				TOUContainer oth = (TOUContainer) obj;
				if(oth.getTermsOfUSe() == null && termsOfUse == null)
					return true;
				if (oth.getTermsOfUSe().equals(termsOfUse))
					return true;
			}
		} catch (NullPointerException e) {
		}
		return false;
	}
}
