The basic part of the program contains classes that stored the data of the given tabular function in an ArrayList type structure with subsequent writing to a file. The classes were extended to store the data of the function specified in the table in TreeSet and TreeMap type structures. The following classes were used to write to the file:
1. BufferedReader class - reads text from the input character stream, buffering the read characters. The use of a buffer is designed to increase the performance of reading data from a stream;
2. FileReader and FileWriter classes - used to write or read text files.
3. The StringTokenizer class is intended for decomposing a string into components. Tokenation refers to the process of dividing a string sequence into parts;
4. PrintWriter class – prints formatted representations of objects to the text output stream.
The TreeMap <K, V> class represents a mapping in the form of a tree. It inherits from the AbstractMap class and implements the NavigableMap interface, and therefore also the SortedMap interface. Therefore, in contrast to the HashMap collection, in TreeMap all objects are automatically sorted according to the growth of their keys.
The generalized TreeSet <E> class represents a data structure in the form of a tree in which all objects are stored in ascending order. TreeSet inherits from the AbstractSet class and implements the NavigableSet interface, and thus the SortedSet interface.
Similar to the variant from the base part - with the ArrayList structure, the created TreeSetInterpolation and TreeMapInterpolation classes imitate the Interpolator class, which implements the Evaluatable interface. The classes themselves use TreeSet or TreeMap for Point2D type objects - coordinates of points obtained in the process of calculating the function.
The classes contain the following overridden methods defined for the TreeSet structure for the TreeSetInterpolation class and TreeMap for the TreeMapInterpolation class:
1. clear() – method for deleting all points;
2. numPoints() – a method that returns the size of the structure;
3. addPoint(Point2D pt) – a method that adds a new element;
4. getPoint(int i) - a method that returns the value of points;
5. setPoint(int i, Point2D pt) – method that sets the point value;
6. removeLastPoint() – method that removes the last element;
7. sort() – sorting method.
Note. The sort method is empty, because in the TreeSet structure all objects are stored in ascending order, in the TreeMap structure all objects are automatically sorted by their keys.
The complete implementation code for the TreeSet type structure is given in Listing A.1, and for the TreeMap type structure in Listing A.2.
Let's create classes for writing and reading from a data file of a new structure: FileTreeSetInterpolation, which inherits from TreeSetInterpolation, for a structure of the TreeSet type, FileTreeMarInterpolation, which inherits from TreeMarInterpolation, for a structure of the TreeMar type. Both classes contain all the fields and methods of the parent class, but add methods for reading and writing the file.
Methods:
1. readFromFile(String fileName) – method for reading a file;
2. writeToFile(String fileName) is a method for writing to a file.
The complete implementation code is given for the TreeSet type structure in Listing A.3, and for the TreeMap type structure in Listing A.4.
 The results of the work are shown in Listing B.1 and Listing B.2 for the TreeSet type structure and Listing B.3 and Listing B.4 for the TreeMap type structure.
