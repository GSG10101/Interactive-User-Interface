
public class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BSTNode getRoot(){
        return root;
    }
    // Getter Method to get the Record in the dictionary with the given Key
    public BSTNode get(BSTNode r, Key k) {
        return helper_get(r, k);
    }

    // Recursive helper method to find the record in the binary tree
    private BSTNode helper_get(BSTNode node, Key k) {
        // Base case returns null if the record is not found in the dictionary
        if (node == null) {
            return null;
        }

        // A cmp reference to find if the given key is bigger or smaller than the current key
        int cmp = k.compareTo(node.getRecord().getKey());

        // If the given key value is less than the current key the node moves towards left of the tree
        if (cmp < 0) {
            return helper_get(node.getLeftChild(), k);
        }
        // Otherwise if the given key value is more than the current key the node moves towards right of the tree
        else if (cmp > 0) {
            return helper_get(node.getRightChild(), k);
        }
        // If the record with the same key has been found
        else {
           return node;
        }
    }

    // Method to insert a record into the dictionary
    public void insert(BSTNode r,Record d) throws DictionaryException {
        root = helper_insert(r, d);
    }

    // Recursive helper method to insert the record in the binary tree
    private BSTNode helper_insert(BSTNode node, Record d) throws DictionaryException {
        // Base case inserts the record
        if (node == null) {
            return new BSTNode(d);
        }

        // A cmp reference to find if the given key is bigger or smaller than the current key
        int cmp = d.getKey().compareTo(node.getRecord().getKey());

        // If the given key value is less than the current key the node moves towards left of the tree
        if (cmp < 0) {
            node.setLeftChild(helper_insert(node.getLeftChild(), d));
        }
        // Otherwise if the given key value is more than the current key the node moves towards right of the tree
        else if (cmp > 0) {
            node.setRightChild(helper_insert(node.getRightChild(), d));
        }
        // if the record already esists in the dictionary throws a Exception
        else {
            throw new DictionaryException("Key already exists");
        }

        // Returns the node of the binary tree
        return node;
    }

    // Method to remove the record with the given Key
    public void remove(BSTNode r, Key k) throws DictionaryException {
        root = helper_remove(r, k);
    }

    // Recursive helper method to remove the record in the binary tree
    private BSTNode helper_remove(BSTNode node, Key k) throws DictionaryException {
        // if the record is not present in the dictionary thorw an Exception
        if (node == null) {
            throw new DictionaryException("Key not found");
        }

        // A cmp reference to find if the given key is bigger or smaller than the current key
        int cmp = k.compareTo(node.getRecord().getKey());

        // If the given key value is less than the current key the node moves towards left of the tree
        if (cmp < 0) {
            node.setLeftChild(helper_remove(node.getLeftChild(), k));
        }
        // Otherwise if the given key value is more than the current key the node moves towards right of the tree
        else if (cmp > 0) {
            node.setRightChild(helper_remove(node.getRightChild(), k));
        }
        // if the current node is an internal node with either child being null
        else {
            // if the leftchild is null, shift to the right side of the tree
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            }
            // else if the right child is null, shift to the lfet side of the tree
            else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            // else find the minimum record in the tree and set it at the record which is to be removed
            else {
                node.setRecord(findMin(node.getRightChild()));
                node.setRightChild(removeMin(node.getRightChild()));
            }
        }

        // Returns the node of the binary tree
        return node;
    }

    // A private method to find the Minimun reocrd in the dictionary. Helps in methods: removeMin() & remove()
    private Record findMin(BSTNode node) {
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node.getRecord();
    }

    // A private method that removes the record. Used int the else condition of the remove() method
    private BSTNode removeMin(BSTNode node) {
        if (node.getLeftChild() == null) {
            return node.getRightChild();
        }
        node.setLeftChild(removeMin(node.getLeftChild()));
        return node;
    }

    // Method to return the successor of the given Key
    public BSTNode successor(BSTNode r, Key k) {
        return helper_successor(r, k);
    }

    // Recursive helper method to find the successor in the binary tree
    private BSTNode helper_successor(BSTNode node, Key k) {
        // Base case returns null if the given Key has no successor.
        if (node == null) {
            return null;
        }

        // A cmp reference to find if the given key is bigger or smaller than the current key
        int cmp = k.compareTo(node.getRecord().getKey());

        // If the given key value is less than the current key the node moves towards left of the tree
        if (cmp < 0) {
            BSTNode successor = helper_successor(node.getLeftChild(), k);
            return successor != null ? successor : node;
        }
        // Otherwise if the given key value is more than the current key the node moves towards right of the tree
        else {
            return helper_successor(node.getRightChild(), k);
        }
    }

    // Method to return the predecessor of the given Key
    public BSTNode predecessor(BSTNode r, Key k) {
        return helper_predecessor(r, k);
    }

    // Recursive helper method to find the predecessor in the binary tree
    private BSTNode helper_predecessor(BSTNode node, Key k) {
        // Base case returns null if the given Key has no predecessor
        if (node == null) {
            return null;
        }

        // A cmp reference to find if the given key is bigger or smaller than the current key
        int cmp = k.compareTo(node.getRecord().getKey());

        // If the given key value is less than the current key the node moves towards left of the tree
        if (cmp > 0) {
            BSTNode predecessor = helper_predecessor(node.getRightChild(), k);
            return predecessor != null ? predecessor : node;
        }
        // Otherwise if the given key value is more than the current key the node moves towards right of the tree
        else {
            return helper_predecessor(node.getLeftChild(), k);
        }
    }

    // Method to returns the Record with the smallest key in the ordered dictionary

    public BSTNode smallest(BSTNode r) {
        BSTNode smallestNode = findSmallest(r);
        // Returns the smallest record if not null /or null if otherwise
        return (smallestNode != null) ? smallestNode : null;
    }

    // Private Helper method to find the smallest record in the ordered dictionary
    private BSTNode findSmallest(BSTNode node) {
        // Base case null if the dictionary is empty
        if (node == null) {
            return null;
        }

        // While loop to get the leftmost node of the binary search tree
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }

        // Returns the node of tree
        return node;
    }

    // Method to find the largest record in the ordered dictionary
    public BSTNode largest(BSTNode r) {
        BSTNode largestNode = findLargest(r);
        return (largestNode != null) ? largestNode : null;
    }

    // Private Helper method to find the largest record in the ordered dictionary
    private BSTNode findLargest(BSTNode node) {
        // Base case null if the dictionary is empty
        if (node == null) {
            return null;
        }

        // While loop to get the rightmost node of the binary search tree
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }

        // Returns the node of tree
        return node;
    }
}
// END OF CODE //