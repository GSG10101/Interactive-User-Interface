public class Record {
    private Key theKey;
    private String data;

    // Constructor for the class Record
    public Record(Key k, String theData) {
        theKey = k;
        data = theData;
    }

    // Getter method to get the key
    public Key getKey() {
        return theKey;
    }

    // Getter method to get the data
    public String getDataItem() {
        return data;
    }
}
// END OF CODE //