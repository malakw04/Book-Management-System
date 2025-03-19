
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


//-----------------------------------------------------
//Assignment 4
//Part: 4
//Written by: Malak Abdelkafy(40235257)
//-----------------------------------------------------


/**
 * driver Class
 * @author malakabdelkafy
 *
 */
public class driver {

	/**
	 * main method
	 * @param args as a String[]
	 */
	public static void main(String[] args) {
		

		ArrayList<Book> arrLst = new ArrayList<Book>();
        
        BookList bkLst = new BookList();
        
       
        
        /**
         * reads each record in the Books.txt file and creates an object from each of them
         * if the year is greater than 2023, then the object is added to the array list
         * if the year is less than 2023, the object is added to the start of the booklist
         */
        try(Scanner sc = new Scanner(new FileInputStream("Books.txt"))){
        
        	
            while (sc.hasNextLine()) {
            	
                String line = sc.nextLine();
                String[] fields = line.split(",");

                
                Book b = new Book();
                b.setTitle(fields[0]);
                b.setAuthor(fields[1]);
                b.setPrice(Double.parseDouble(fields[2]));
                b.setISBN(Long.parseLong(fields[3]));
                b.setGenre(fields[4]);
                b.setYear(Integer.parseInt(fields[5]));
                
           
                if(b.getYear() > 2023) {
                	
                	arrLst.add(b);
                	

                	try(PrintWriter pw = new PrintWriter(new FileOutputStream("YearErr.txt"))){
                		
                		for(Book book : arrLst) {
                		
                                pw.println(book);
                             
                		}
                            
                		pw.close();
                        
                     }
                	
                	catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                
                else {
                	
                bkLst.addToStart(b);
                
                }
                
            }
                
            sc.close();
             
            }
        
           catch (FileNotFoundException e1) {
                    	
                       e1.printStackTrace();
                    }

        
        Scanner input = new Scanner(System.in);
        int choice = 0;
        
        
        System.out.println();
    	System.out.println("Here is the list:");
        System.out.println("==========================");
        System.out.println();
        bkLst.displayContent();
        
        while(choice != 8) {
        	
            System.out.println("Here are the options:");
            
            System.out.println("1. Store records by year.");
            System.out.println("2. Delete consecutive repeated records."); 
            System.out.println("3. Create new list with the records of a specific author.");
            System.out.println("4. Insert a new book record before another record.");
            System.out.println("5. Insert a new book record between two records.");
            System.out.println("6. Swap two records.");
            System.out.println("7. Commit a list to the Updated_Books file.");
            System.out.println("8. Quit.");
            
            System.out.println("\nSelect an option:");
            choice = input.nextInt();

            switch (choice) {
            
            
        
                case 1:
            	
                System.out.println("Enter year to store all records of that year into its own file: ");
                int yr = input.nextInt();
                System.out.println();
                
                bkLst.storeRecordsByYear(yr);
                System.out.println("File Created.");
                System.out.println();
                bkLst.displayContent();
                break;
             
                //says duplicates are removed without removing them
                case 2:
                	
                	System.out.println("Before removing duplicates:");
                	System.out.println();
                	System.out.println("Here is the list:");
                    System.out.println("==========================");
                    bkLst.displayContent();
                    
                    boolean deleted = bkLst.delConsecutiveRepeatedRecords();
                    System.out.println();
                    
                    if (deleted) {
                        System.out.println("Duplicates removed");
                    } else {
                        System.out.println("No duplicates found");
                    }
                    
                    System.out.println();
                    System.out.println("After removing duplicates:");
                    System.out.println();
                    System.out.println("Here is the list:");
                    System.out.println("==========================");
                    bkLst.displayContent();
                    
                    break;
                    
                //works without input
                case 3:
                	
                	System.out.println("Enter Author Name: ");
//                	String auth = input.nextLine();
                    bkLst.extractAuthList("Roy Malan");
                    bkLst.displayContent();
              
                	break;
                
                //input issue with title and genre
                case 4:
                	
                    System.out.println("Enter book details:");
                    
                    System.out.println("Title: ");
                    String title = input.nextLine();
                    
                    System.out.print("Author: ");
                    String author = input.nextLine();
                    
                    System.out.println("Price: ");
                    double price = input.nextDouble();
                    
                    System.out.println("ISBN: ");
                    long isbn = input.nextLong();
                    
                    System.out.println("Genre: ");
                    String genre = input.nextLine();
                    
                    System.out.println("Year: ");
                    int year = input.nextInt();
                    
                    
                    Book newBook = new Book();
                    newBook.setTitle(title);
                    newBook.setAuthor(author);
                    newBook.setPrice(price);
                    newBook.setISBN(isbn);
                    newBook.setGenre(genre);
                    newBook.setYear(year);
                    
                    System.out.println("Enter ISBN number:");
                    long isbn1 = input.nextLong();
                    
                    bkLst.insertBefore(isbn1, newBook);
                    bkLst.displayContent();
               
                    break;
                    
                 //input issue  with title and genre 
                case 5:
                	
                	System.out.println("Enter first ISBN number:");
                    long isbn1st = input.nextLong();
                    
                    System.out.println("Enter second ISBN number:");
                    long isbn2nd = input.nextLong();
                    
                    System.out.println("Enter book details:");
                   
                    System.out.println("Title: ");
                    String Title = input.nextLine();
                    
                    System.out.println("Author: ");
                    String Author = input.nextLine();
                    
                    System.out.println("Price: ");
                    double Price = input.nextDouble();
                    
                    System.out.println("ISBN: ");
                    long Isbn = input.nextLong();
                    
                    System.out.println("Genre: ");
                    String Genre = input.nextLine();
                    
                    System.out.println("Year: ");
                    int Year = input.nextInt();
                    
                    Book Book = new Book();
                    Book.setTitle(Title);
                    Book.setAuthor(Author);
                    Book.setPrice(Price);
                    Book.setISBN(Isbn);
                    Book.setGenre(Genre);
                    Book.setYear(Year);
                    
                    bkLst.insertBetween(isbn1st, isbn2nd, Book);
                    bkLst.displayContent();
                    
                  break; 
                  
                //prints out the record of the first or second isbn
                case 6:
                	
                	System.out.println("Enter first ISBN number:");
                    long fIsbn = input.nextLong();
                    
                    System.out.println("Enter second ISBN number:");
                    long sIsbn = input.nextLong();
                    
                    bkLst.swap(fIsbn, sIsbn);
                    bkLst.displayContent();
                
                    break;
                    
                case 7:
                	
				try {
					
					bkLst.commit();
					System.out.println("Updated_Books.txt File has been created.");
					 
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				bkLst.displayContent();
				
				break;
				
                case 8:
                	
                	System.out.println("System terminated.");
                	System.exit(8);
                	break;
                	    
            }
        }
	}
}

                    
       