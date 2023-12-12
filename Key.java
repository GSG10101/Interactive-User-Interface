public class Key {
    private String label;
    private int type;

    // Constructor for the class Key
    public Key(String theLabel, int theType) {
        // Convert theLabel to lowercase and store it in the instance variable label
        label = theLabel.toLowerCase();
        type = theType;
    }

    // Getter method to get the label
    public String getLabel() {
        return label;
    }

    // Getter method to get the type
    public int getType() {
        return type;
    }

    // Method to compare two Key objects
    public int compareTo(Key k) {
        if (this.label.equals(k.label)) {
            // If labels are equal, compare by type
            if (this.type == k.type) {
                return 0; // Labels and types are equal
            }
            else if (this.type < k.type) {
                return -1; // Label is equal, but type is smaller
            }
            else {
                return 1; // Label is equal, but type is greater
            }
        }
        else {
            // Lastly, Comparing labels lexicographically
            return this.label.compareTo(k.label);
        }
    }
}
// END OF CODE //