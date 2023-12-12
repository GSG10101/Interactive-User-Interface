
## Overview
This Java project implements an ordered dictionary using a binary search tree. It includes classes for handling keys, records, BST nodes, a binary search tree, and a dictionary. Additionally, there's a text-based user interface for manipulating the dictionary.

## Classes
1. **Key**: Represents the key of data items stored in the binary search tree.
   - `public Key(String theLabel, int theType)`
   - `public String getLabel()`
   - `public int getType()`
   - `public int compareTo(Key k)`

2. **Record**: Represents records stored in the internal nodes of the binary search tree.
   - `public Record(Key k, String theData)`
   - `public Key getKey()`
   - `public String getDataItem()`

3. **BSTNode**: Represents a node of the binary search tree.
   - `public BSTNode(Record item)`
   - Other accessor and mutator methods...

4. **BinarySearchTree**: Represents a binary search tree.
   - `public BinarySearchTree()`
   - Other methods for insertion, removal, searching, etc...

5. **BSTDictionary**: Implements an ordered dictionary using a binary search tree.
   - Implements `BSTDictionaryADT` interface.
   - `public BSTDictionary()`
   - Other methods specified in the interface...

6. **Interface**: Implements the text-based user interface.
   - `public static void main(String[] args)`
   - Command processing methods...

## How to Run
1. Compile all Java files: `javac *.java`
2. Run the Interface class with the input file: `java Interface inputFile`

## Input File Format
The first line contains a string; this is the label attribute
of the first Record object to store in the ordered dictionary. The second line ℓ contains the type and
data of the first Record object:
• If the first character of ℓ is ’-’ then the rest of the line contains the name of a sound file
• If the first character of ℓ is ’+’ then the rest of the line contains the name of a music file
• If the first character of ℓ is ’*’ then the rest of the line contains the name of a voice file.
• If the first character of ℓ is ’/’ then the rest of the line contains a translation to French.
• Otherwise ℓ contains a String from which your program can infer the type attribute of the
record. If ℓ only contains one string of the form x.y, then
– if y = "gif" then type = 7 and data = ℓ
– if y = "jpg" then type = 6 and data = ℓ
– if y = "html" then type = 8 and data = ℓ
• Otherwise type = 1 and data = ℓ.

## User Commands
**define w**
If the ordered dictionary has a Record object d whose Key attribute has label = w and type
= 1, then your program must print the data attribute of this record on the screen.
If the above Record object is not in the ordered dictionary then the program must print the
message:
"The word w is not in the ordered dictionary"
• **translate w**
If the ordered dictionary has a Record object d whose Key attribute has label = w and type
= 2, then your program must print the data attribute of this record on the screen. If the
above Record object is not in the ordered dictionary then the program must print the message:
"There is no definition for the word w"
**• sound w**
If the ordered dictionary has a Record object d whose Key attribute has label = w and type
= 3, then your program must play the audio file whose name is stored in the data attribute of
this record on the screen. If the above Record object is not in the ordered dictionary then the
program must print the message: "There is no sound file for w"
• **play w**
If the ordered dictionary has a Record object d whose Key attribute has label = w and type
= 4, then your program must play the audio file whose name is stored in the data attribute of
this record on the screen. If the above Record object is not in the ordered dictionary then the
program must print the message: "There is no music file for w"
• **say w**
If the ordered dictionary has a Record object d whose Key attribute has label = w and type
= 5, then your program must play the audio file whose name is stored in the data attribute of
this record on the screen. If the above Record object is not in the ordered dictionary then the
program must print the message: "There is no voice file for w"
• **show w**
If the ordered dictionary has a Record object d whose Key attribute has label = w and type
= 6, then your program must show the image file whose name is stored in the data attribute
of this record on the screen. If the above Record object is not in the ordered dictionary then
the program must print the message:: "There is no image file for w"
**animate w**
If the ordered dictionary has a Record object d whose Key attribute has label = w and type
= 7, then your program must show the image file whose name is stored in the data attribute
of this record on the screen. If the above Record object is not in the ordered dictionary then
the program must print the message:: "There is no animated image file for w"
• **browse w**
If the ordered dictionary has a Record object d whose Key attribute has label = w and type
= 8, then your program must show the webpage whose URL is stored in the data attribute of
this record on the screen. If the above Record object is not in the ordered dictionary then the
program must print the message:: "There is no webpage called w"
**delete w k**
Removes from the ordered dictionary the Record object with key (w,k), or if no such record
exists, it prints
No record in the ordered dictionary has key (w,k).
• **add w t c**
Inserts a Record object ((w,t),c) into the ordered dictionary if there is no record with key
(w,t) already there; otherwise it prints
A record with the given key (w,t) is already in the ordered dictionary.
• **list prefix**
Here prefix is a string with one or more letters. Your program must print the label attributes
(if any) of all the Record objects in the ordered dictionary that start with prefix; if prefix is
the label attribute of a Record object in the ordered dictionary, then prefix must be printed
also. If several Record objects in the dictionary have the same label attribute w, and w starts
with prefix, then the string w will be printed as many times as the number of Record objects
in the ordered dictionary that contain i
• **first**
This command must print all the attributes of the Record object in the ordered dictionary with
smallest key. For example, for the above ordered dictionary the command first must print:
computer,1,An electronic machine frequently used by Computer Science students.
• **last**
This command must print all the attributes of the Record object in the ordered dictionary
with largest key. For example, for the above ordered dictionary the command last must print:
ping,3,ping.wav.
• **exit**
This command terminates the program.
• If an invalid command is entered your program must print the message
Invalid command.

### Example Usage
Assuming the ordered dictionary is populated with the following entries:

```plaintext
Key: ("computer", 1)   Data: "An electronic machine frequently used by Computer Science students."
Key: ("computer", 6)   Data: "computer.jpg"
Key: ("flower", 8)     Data: "http://www.csd.uwo.ca/flower.html"
Key: ("ping", 3)       Data: "ping.wav"
Key: ("course", 5)     Data: "course.wav"
Key: ("computer", 7)   Data: "compute.gif"
