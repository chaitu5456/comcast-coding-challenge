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
