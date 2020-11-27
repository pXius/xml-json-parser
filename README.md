# XML-JSON Parser    
### What is it?
A CLI tool to parse XML or JSON data with a  **_specific_**  node or property structure.

### How specific?
Even though the utility was made with a specific node or property structure in mind, it was designed to be modular and easily expandable with other structures.  
The XML is parsed by making use of a "SAX Handler" while the JSON is parsed using a class model and Gson by Google.

A what?  
The point is, a handler or class model can be created for any node or property structure and simply passed to the existing parse methods.

### Why SAX and not DOM?
While DOM parsing might be faster because the whole XML tree is loaded into memory, this could become a limitation when XML files get large. SAX on the other hand is event based. This means only the parts being parsed are loaded into memory, making it much more efficient for large XML files.

Considering future modularity, SAX was chosen.

## Requirements:
**Java 11 or higher.**  

You can check your Java version by running the following in terminal:  
`java -version`  

You can download the latest version form => [HERE](https://www.java.com/en/download/)

## How To Use:
#### JAR in CLI.
Download the utility from the release section: => [HERE](https://github.com/pXius/xml-json-parser/releases)  

Run the utility using 'java -jar' followed by the filepath of the file you would like to parse:  
i.e.   
`java -jar menu.jar /the/path/to/your/file.json`

#### Sorting:
The utility supports sorting by name. Use **'asc'** or **'desc'** after the filename to sort the file in ascending or descending order respectively.  
i.e.  
`java -jar menu.jar myfile.xml desc` or `java -jar menu.jar anotherfile.json asc`  

If no sorting argument is passed, or an invalid argument is passed, the utility will not sort the file and keep the original order.  

#### Run from Source.
(Hard Mode)  
Alternatively you can clone this repo and run the source code in an IDE.  
Be sure to build the Maven project first, using the included pom.xml to satisfy the dependencies.  

## Testing:
A suite of testing classes are included in this repo, along with a testData folder. The test data folder includes the original XML and JSON files after which this utility was built, as well as "broken or modified" versions of these files to satisfy unexpected data tests.

### Dependencies:
- Commons-IO
- Gson
- Lombok
- Junit-Jupiter
