package model.tree;

public class MyJTreeWSavedVersion extends MyJTree {

	private static final long serialVersionUID = 7281349743060321771L;
	
	private MyJTree savedVersion;

	public MyJTreeWSavedVersion() {
		super();
		savedVersion = new MyJTree();
	}
	
	public void setSavedVersion() {
		savedVersion = new MyJTree(this);
	}

	public boolean isSaved() {
		//sysoTree(this);
		//sysoTree(savedVersion);
		return this.equalsTree(savedVersion);
	}

}
