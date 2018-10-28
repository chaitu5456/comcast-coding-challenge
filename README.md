# comcast-coding-challenge

## Compilation & Execution from Command Line Terminal
1. Go to the source folder(src), compile java classes using the entire package structure
javac com/comcast/coding/Options.java com/comcast/coding/AddDigits.java

2. Execute the AddDigits class which is our main class
java com.comcast.coding.AddDigits abc123
Expected: Sum is :6

java com.comcast.coding.AddDigits abc123 -x
Expected: Sum is :39

3. Give the entire path of the text file, I included data.txt under /src folder
java com.comcast.coding.AddDigits -f data.txt
Expected : Sum is :6

java com.comcast.coding.AddDigits -f data.txt -x
Expected: Sum is :39

java com.comcast.coding.AddDigits -f
Expected: Error: -f takes an argument

## Compilation and Execution with IDE
1. import project to respective IDE
2. make sure JUnit jar exists in the in the  project
3. right click on AddDigits.java and select Run As --> Run Configurations --> go to 'Arguments' section from the pop up window
4. give the arguments under Program Arguments section --> click on 'run' desired output shows on the console IDE
5. Below are few arguments under Program Arguments section
  i) abc123
  ii) abc123 -x
  iii) -f abc123 -x
5. run the SumTests.java by clicking on run as JUnit class to execute test cases

## Sample test results
java com.comcast.coding.AddDigits abc123
Sum is :6

java com.comcast.coding.AddDigits abc123 -x
Sum is :39

java com.comcast.coding.AddDigits
IllegalArgumentException(Arguments list is empty)

--data.txt file has "abc123" as text
java com.comcast.coding.AddDigits -f data.txt 
Sum is :6

java com.comcast.coding.AddDigits qq
Sum is 0;

java com.comcast.coding.AddDigits -f src/data.txt -m
Error: Unknown option : -m

java com.comcast.coding.AddDigits -x
Error: -x cannot be only argument

java com.comcast.coding.AddDigits -f
Error: -f takes an argument

java com.comcast.coding.AddDigits -f daaaa.txt
File does not exist

