package model.tree.nodes;

public enum MyTreeNodeTypes {
	BasicNode(0), WorkSpace(1), SoftwareCompany(2), Product(3), Module(4), Parameter(5);
	
    private final int value;
    private MyTreeNodeTypes(int value) {
        this.value = value;
    }
	
    public int getValue() {
        return value;
    }
}
