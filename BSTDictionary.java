
public class BSTDictionary implements BSTDictionaryADT {
    private BinarySearchTree tree;

    public BSTDictionary() {
        tree = new BinarySearchTree();
    }

    // Getter Method to get the Record in the dictionary with the given Key
    public Record get(Key k) {
        BSTNode node = tree.get(tree.getRoot(), k);
        return node != null ? node.getRecord() : null;
    }

    // Method to insert a record into the dictionary
    public void put(Record d) throws DictionaryException {
        tree.insert(tree.getRoot(),d);
    }

    // Method to remove the record with the given Key
    public void remove(Key k) throws DictionaryException {
        tree.remove(tree.getRoot(),k);
    }

    // Method to return the successor of the given Key
    public Record successor(Key k) {
        return tree.successor(tree.getRoot(),k).getRecord();
    }

    // Method to return the predecessor of the given Key
    public Record predecessor(Key k) {
        return tree.predecessor(tree.getRoot(),k).getRecord();
    }

    // Method to returns the Record with the smallest key in the ordered dictionary
    public Record smallest() {
        return tree.smallest(tree.getRoot()).getRecord();
    }

    // Method to find the largest record in the ordered dictionary
    public Record largest() {
        return tree.largest(tree.getRoot()).getRecord();
    }

}
// END OF CODE //