# Book Management System - Java Implementation

## Overview
This project implements a **Book Management System** using Java. It provides functionalities to manage a circular linked list of books, allowing users to **add, modify, delete, search, and store records**. The system reads book records from a file and performs various operations via a menu-driven interface.

## Features
- **Book Management**: Add, update, delete, and display books.
- **Circular Linked List Implementation**: Efficient data storage and retrieval.
- **File Handling**:
  - Reads book records from `Books.txt`.
  - Stores records in year-specific files.
  - Saves updated records in `Updated_Books.txt`.
- **Search and Sorting Operations**:
  - Extract books by author.
  - Insert books at specific positions.
  - Swap books by ISBN.
  - Remove duplicate book records.

## File Structure
```
├── Book.java        # Represents a book object with attributes and methods
├── BookList.java    # Implements a circular linked list for book storage
├── driver.java      # Main class for handling user interactions and operations
```

## Compilation and Execution
### 1. Compile the Java files
```bash
javac Book.java BookList.java driver.java
```

### 2️. Run the Program
```bash
java driver
```

## Functionality Overview
### **Book Class (`Book.java`)**
- Stores **title, author, price, ISBN, genre, and year**.
- Provides **getter and setter methods**.
- Implements **toString()** and **equals()** for comparisons.

### **Book List (`BookList.java`)**
- Implements a **circular linked list** for storing books.
- **Key Methods:**
  - `addToStart(Book book)`: Adds a book at the start.
  - `storeRecordsByYear(int year)`: Stores records in a year-specific file.
  - `insertBefore(long ISBN, Book book)`: Inserts a book before a given ISBN.
  - `insertBetween(long ISBN1, long ISBN2, Book book)`: Inserts a book between two ISBNs.
  - `delConsecutiveRepeatedRecords()`: Deletes consecutive duplicate records.
  - `extractAuthList(String author)`: Extracts books by a specific author.
  - `swap(long ISBN1, long ISBN2)`: Swaps two books by ISBN.
  - `commit()`: Saves the list to `Updated_Books.txt`.

### **Driver (`driver.java`)**
- Reads book records from `Books.txt`.
- Stores future year records in `YearErr.txt`.
- Displays a **menu-driven interface** for the user to perform operations.
- Provides options to **add, modify, delete, store, extract, and swap book records**.

## Menu Options
Upon running `driver.java`, the program displays:
```
Here are the options:
1. Store records by year.
2. Delete consecutive repeated records.
3. Create new list with the records of a specific author.
4. Insert a new book record before another record.
5. Insert a new book record between two records.
6. Swap two records.
7. Commit a list to the Updated_Books file.
8. Quit.
```

## Example Input/Output
### **Example Book Record (Books.txt)**
```
The Great Gatsby,F. Scott Fitzgerald,10.99,1234567890123,Fiction,1925
1984,George Orwell,8.99,9876543210987,Dystopian,1949
```

### **Example Console Output**
```
Here is the list:
==========================
The Great Gatsby, F. Scott Fitzgerald, 10.99, 1234567890123, Fiction, 1925
1984, George Orwell, 8.99, 9876543210987, Dystopian, 1949

Enter an option:
1
Enter year to store all records of that year into its own file:
1925
File Created.
```

## Contributions
Feel free to fork the repository and submit pull requests for improvements!

