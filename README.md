README: Multichoice Assignment

Thank you for allowing me to attempt this assignment. 
Below are the instructions for downloading, compiling and executing the project. 

1. Visit my github repository (https://github.com/N87Ash/MultiChoiceAssignment) and click the "Clone or download" dropdown
2. Select the Download ZIP option
3. Once the ZIP has been download to your local directory, open eclipse and select "File" followed by "Import" then select "Existing projects into workspace from the menu options and click "Next". 
4. Select the archive file radio button and browse to file in your local directory and then select "Finish"

Now that we have the project available locally, I'll briefly explain the project structure: 

***NB: Whilst coding my solution, I made use of JAVA 1.7 and JUnit 4

My project consists of 2 packages, "test" and "utilities" and few text files in the main directory (maps). The utilities package contains Vector2i.java and Node.java. Vector2i simply handles X and Y co-ordinates whilst the Node class uses the Vector2i object to further define a tile on a map. The MapCreator.java contained in utilities is responsible for converting a text file into a 2d array. Lastly, PathFinder.java is responsible for taking a map object and determining the shortest path from start to finish (if possible). 

The test package contains two JUnit test classes. The MapCreatorServiceTest.java runs a few test cases. It firstly attempts to create a map from a file that does not contain a start point or endpoint (invalid map). Next it generates a Map from the file provided with the assignment. The map is printed to the screen and the start and end point co-ordinates are determined. 

The PatherFinderServiceTest.java  tests the functionality of PathFinder.java. It first attempts to determine the path for an invalid map, then attempts the same on a working map. The shortest possible routes is outlined with the "#" symbol.

4. On the test package, right click the MapCreatorServiceTest.java and "Run As" and then select the "JUnit Test case" option
5. Likewise, Run the PathFinderServiceTest.java as a JUint Test case

 
  