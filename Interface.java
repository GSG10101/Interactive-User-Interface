import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Interface {

    public static void main(String[] args) {

        // Check if no inputFile is provided

        // Create a BSTDictionary object
        BSTDictionary dictionary;

        try{
            // Initialise the dictionary
            dictionary = new BSTDictionary();
            // Read the input file
            BufferedReader fileReader = new BufferedReader(new FileReader("./Assignment4/large.txt"));


            String line; // Reads a single line of the txt file
            String currentLabel = null; // Store the current label for the line in  the while loop
            int currentType = 0; // Initialises the current type to store the type of the label
            String currentData = null; // Initialises the current data to store the data in the second line

            // A while loop which iterates over the entire txt file until it is exhausted, or it catches an Exception
            while ((line = fileReader.readLine()) != null) { // Keeps on reading the line until it is null

                if(currentLabel == null) currentLabel = line.toLowerCase(); // The first line of the input file gives the Record Label and converts it into lower case

                // Finding the type of the file
                else if(currentType == 0){

                    currentData = line.substring(1); // Stores the Data ignoring the symbol at index 0;

                    // Symbol "/" represents a translation file to French with Record type 2
                    if(line.startsWith("/")) currentType = 2;

                    // Symbol "-" represents a sound file with Record type 3
                    else if(line.startsWith("-")) currentType = 3;

                    // Symbol "+" represents a music file with Record type 4
                    else if (line.startsWith("+")) currentType = 4;

                    // Symbol "*" represents a voice file with Record type 5
                    else if(line.startsWith("*")) currentType = 5;


                    // If the file is of the form x.y: //

                    // if the line ends with .jpg extension Record type = 6
                    else if (line.endsWith(".jpg")){currentData = line.substring(0);
                        currentType = 6;
                    }

                    // if the line ends with .gif extension Record type = 7
                    else if (line.endsWith(".gif")){currentData = line.substring(0);
                        currentType = 7;
                    }

                    // if the line ends with .html extension Record type = 8
                    else if (line.endsWith(".html")) {
                        currentData = line.substring(0);
                        currentType = 8;
                    }

                    // Otherwise for string literal Record type = 1
                    else{
                        currentData = line.substring(0);
                        currentType = 1;
                    }

                    // Lastly it adds to the dictionary the current label, current type and the current data of the single line in the txt file
                    dictionary.put(new Record(new Key(currentLabel,currentType),currentData));

                    // Resetting the variables for the next txt line
                    currentLabel = null;
                    currentType = 0;
                    currentData = null;
                }
            }
            // Finally closes the input file
            fileReader.close();

        }
        // Catches IOE exception for file not found and any Dictionary Exception
        catch (IOException | DictionaryException e){
            System.out.println(e);
            return;
        }
        // Next part of the Interface Class //

        // Keyboard Commands

        StringReader keyboard = new StringReader(); // Initialises the keyboard as an object for the StringReader Class
        String line;  // Stores the command


        // Similar to the previous while loop, it goes on until the user enter the command exit
        while(!(line = keyboard.read("Enter next command: ")).equals("exit")){

            // Splits the line into a String array based on whitespaces
            // I used split function instead of StringTokenizer Java class

            String[] command = line.split(" "); // creates a command array of String

            // if the user entered the command define

            if (command[0].equals("define")){
                // Makes sure that the input is correct and the command array length is 2
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid!");continue;
                }
                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(),1);
                // if the key exists in the dictionary, it prints out the data
                if(dictionary.get(k) != null) System.out.println(dictionary.get(k).getDataItem());
                // And else if it does not exist in the dictionary
                else System.out.printf("The word %s is not in the ordered dictionary\n",command[1]);
            }

            // if the user entered the command translate
            else if (command[0].equals("translate")){
                // Makes sure that the input is correct and the command array length is 2
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid!");continue;
                }
                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(),2);
                // if the key exists in the dictionary, it prints out the data
                if(dictionary.get(k) != null) System.out.println(dictionary.get(k).getDataItem());
                    // And else if it does not exist in the dictionary
                else System.out.printf("There is no definition for the word %s\n",command[1]);
            }

            // if the user entered the command sound
            else if (command[0].equals("sound")){
                // Makes sure that the input is correct and the command array length is 2
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid!");continue;
                }

                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(), 3);

                // if the key exists in the dictionary, it plays the sound
                if(dictionary.get(k) != null) {
                    SoundPlayer player = new SoundPlayer(); // Initialises player for the SoundPlayer Class
                    try {
                        String s = dictionary.get(k).getDataItem(); // Stores the data of the record that is to be played
                        player.play(s); // This plays the file
                    }
                    // Catch any Multimedia Exception
                    catch (MultimediaException e) {
                        throw new RuntimeException(e);
                    }
                }
                // if there exists no such file
                else System.out.printf("There is no sound file for %s\n",command[1]);
            }

            // if the user entered the command play
            else if (command[0].equals("play")){
                // Makes sure that the input is correct and the command array length is 2
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid!");continue;
                }

                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(), 4);
                // if the key exists in the dictionary, it plays the sound
                if(dictionary.get(k) != null) {
                    SoundPlayer player = new SoundPlayer(); // Initialises player for the SoundPlayer Class
                    try {
                        String s = dictionary.get(k).getDataItem(); // Stores the data of the record that is to be played
                        player.play(s); // This plays the file
                    }
                    // Catch any Multimedia Exception
                    catch (MultimediaException e) {
                        throw new RuntimeException(e);
                    }
                }
                // if there exists no such file
                else System.out.printf("There is no music file for %s\n", command[1]);
            }

            // if the user entered the command say
            else if (command[0].equals("say")){
                // Makes sure that the input is correct and the command array length is 2
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid!");continue;
                }
                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(), 5);

                // if the key exists in the dictionary, it plays the sound
                if(dictionary.get(k) != null) {
                    SoundPlayer player = new SoundPlayer();  // Initialises player for the SoundPlayer Class
                    try {
                        String s = dictionary.get(k).getDataItem(); // Stores the data of the record that is to be played
                        player.play(s); // This plays the file
                    }
                    // Catch any Multimedia Exception
                    catch (MultimediaException e) {
                        throw new RuntimeException(e);
                    }
                }
                // if there exists no such file
                else System.out.printf("There is no voice file for %s\n", command[1]);
            }

            // if the user entered the command show
            else if (command[0].equals("show")){
                // Makes sure that the input is correct and the command array length is 2
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid!");continue;
                }
                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(), 6);

                // if the key exists in the dictionary, it shows the image
                if(dictionary.get(k) != null) {
                    PictureViewer picture = new PictureViewer(); // Initialises picture of the PictureViewer class
                    String filename = dictionary.get(k).getDataItem(); // Stores the data of the record that is to be viewed

                    try {
                        picture.show(filename); // shows the file
                    }
                    // Catch any Multimedia Exception
                    catch (MultimediaException e) {
                        throw new RuntimeException(e);
                    }
                }
                // if there exists no such file
                else System.out.printf("There is no image file for %s\n", command[1]);
            }

            // if the user entered the command animate
            else if (command[0].equals("animate")){
                // Makes sure that the input is correct and the command array length is 2
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid!");continue;
                }
                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(), 7);

                // if the key exists in the dictionary, it animates the gif
                if(dictionary.get(k) != null) {
                    PictureViewer picture = new PictureViewer(); // Initialises picture of the PictureViewer class
                    String filename = dictionary.get(k).getDataItem(); // Stores the data of the record that is to be animated
                    try {
                        picture.show(filename); // animates the file
                    }
                    // Catch any Multimedia Exception
                    catch (MultimediaException e) {
                        throw new RuntimeException(e);
                    }
                }
                // if there exists no such file
                else System.out.printf("There is no animated image file for %s\n", command[1]);
            }

            // if the user entered the command browse
            else if (command[0].equals("browse")){
                // Makes sure that the input is correct and the command array length is 2
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid!");continue;
                }
                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(), 8);
                // if the key exists in the dictionary, it opens the html
                if(dictionary.get(k) != null) {
                    ShowHTML link = new ShowHTML(); // Initialises link for the ShowHTML Class
                    String filename = dictionary.get(k).getDataItem(); // Stores the data of the record that is to be opened
                    link.show(filename); // opens the link
                }
                // if there exists no such file
                else System.out.printf("There is no webpage called %s\n", command[1]);
            }

            // if the user entered the command delete
            else if (command[0].equals("delete")){
                // Makes sure that the input is correct and the command array length is 3
                // to not catch out of bound error
                if(command.length != 3){
                    System.out.println("Invalid!");continue;
                }
                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1].toLowerCase(),Integer.parseInt(command[2]));
                // if the key exists in the dictionary, it deletes it
                if(dictionary.get(k) != null) {
                    try {
                        dictionary.remove(k); // deletes the record from the dictionary
                    }
                    // Catch any Dictionary Exception
                    catch (DictionaryException e) {
                        throw new RuntimeException(e);
                    }
                }
                // if there exists no such file
                else System.out.printf("No record in the ordered dictionary has key (%s, %s)\n",command[1],command[2]);
            }

            // if the user entered the command add
            else if (command[0].equals("add")){
                // Makes sure that the input is correct and the command array length is 4
                // to not catch out of bound error

                // Creating a new key based on the user input stored in the command array at index 1
                Key k = new Key(command[1],Integer.parseInt(command[2]));
                // Creates a record with key k and DataItem at index 3
                Record record = new Record(k, command[3]);

                // if the key exists in the dictionary, it adds it
                if(dictionary.get(k) == null) {
                    try {
                        dictionary.put(record); // adds the record into the dictionary
                    }
                    // Catch any Dictionary Exception
                    catch (DictionaryException e) {
                        throw new RuntimeException(e);
                    }
                }
                // if there exists no such file
                else System.out.printf("A record with the given key (%s ,%s) is already in the ordered dictionary.\n", command[1],command[2]);

            }

            // if the user entered the command list
            else if (command[0].equals("list")){
                // Makes sure that the input is correct and the command array length is 4
                // to not catch out of bound error
                if(command.length != 2){
                    System.out.println("Invalid! Please enter the prefix as well.");continue;
                    }

                String prefix = command[1].toLowerCase(); // Stores the input 'prefix' into the String prefix
                // Creating a new key based on the prefix
                Key k = new Key(prefix,1);

                // Finds a Record with the excat prefix and type in the dictionary
                Record prefixRecord = dictionary.get(k);

                boolean found = false; // checks if there is any label with the prefix

                // if there exists exact prefix with get(), it prints the label of the record
                if(prefixRecord != null){
                    System.out.print(prefixRecord.getKey().getLabel());
                    found = true; // Found a record with the prefix
                }
                // else /or checks other records for the same prefix
                Record successorRecord = dictionary.successor(k);

                // A while loop to iterate over the successors of the key while the successor is not null and have the prefix
                while(successorRecord != null && successorRecord.getKey().getLabel().startsWith(prefix)){
                    System.out.print(successorRecord.getKey().getLabel()+", "); // prints the label
                    successorRecord = dictionary.successor(successorRecord.getKey()); // proceeds to the next successor
                    found = true; // Found a record with the prefix
                }

                if(found)System.out.println(); // Move to the next line after printing the labels if there were records with the given prefixes
                // else if there are no records with the given prefix
                else System.out.printf("No label attributes in the ordered dictionary start with prefix %s\n", prefix);
            }

            // if the user entered the command first
            else if(command[0].equals("first")){
                // Makes sure that the input is correct and the command array length is 1
                // to not catch out of bound error
                if(command.length != 1){
                    System.out.println("Invalid!");continue;
                }
                // gets the smallest record in the dictionary
                Record smallest = dictionary.smallest();
                // Prints the record
                System.out.printf("%s, %d, %s\n",smallest.getKey().getLabel(),smallest.getKey().getType(),smallest.getDataItem());
            }

            // if the user entered the command last
            else if (command[0].equals("last")){
                // Makes sure that the input is correct and the command array length is 1
                // to not catch out of bound error
                if(command.length != 1){
                    System.out.println("Invalid!");continue;
                }
                // gets the largest record in the dictionary
                Record largest = dictionary.largest();
                // Prints the record
                System.out.printf("%s, %d, %s\n",largest.getKey().getLabel(),largest.getKey().getType(),largest.getDataItem());
            }

            // if the user enters any command that is not listed above
            else System.out.println("Invalid command.");
        }
    }
}
// END OF CODE //