public class BSTNode {
    private Record item;
    private BSTNode leftChild;
    private BSTNode rightChild;
    private BSTNode parent;

    // Constructor for the class BSTNode
    public BSTNode(Record item) {
        this.item = item;
        leftChild = null;
        rightChild = null;
        parent = null;
    }

    // Getter method to get the record
    public Record getRecord() {
        return item;
    }

    // Getter method to set the record
    public void setRecord(Record d) {
        item = d;
    }

    // Getter method to get the left child
    public BSTNode getLeftChild() {
        return leftChild;
    }

    // Getter method to get the right child
    public BSTNode getRightChild() {
        return rightChild;
    }

    // Getter method to get the parent
    public BSTNode getParent() {
        return parent;
    }

    // Setter method to set the left child
    public void setLeftChild(BSTNode u) {
        leftChild = u;
    }

    // Setter method to set the right child
    public void setRightChild(BSTNode u) {
        rightChild = u;
    }

    // Setter method to set the parent
    public void setParent(BSTNode u) {
        parent = u;
    }

    // Method to check if the node is a leaf
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    protected void copy(BSTNode other) {
        this.setRecord(other.getRecord());
        this.setLeftChild(other.getLeftChild());
        this.setRightChild(other.getRightChild());
        this.setParent(other.getParent());
    }
}
// END OF CODE //