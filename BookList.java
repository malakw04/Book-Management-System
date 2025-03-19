import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;


//-----------------------------------------------------
//Assignment 4
//Part: 2 and 3
//Written by: Malak Abdelkafy(40235257)
//-----------------------------------------------------



/**
 * BookList Class
 * @author malakabdelkafy
 *
 */
public class BookList{
	
	/**
	 * Node Inner Class
	 * @author malakabdelkafy
	 *
	 */
	private class Node {

		/**
		 * attributes
		 */
		private Book book;
		private Node next;
		
		
/**
 * Parameterized constructor
 * @param book as a Book
 */
		public Node(Book book) {
			
			this.book = book;
			this.next = null;
		}
		
		
		

/**
 * Setter
 * @param b as a Book
 */
		public void setBook(Book b) {
			
			book = b;
		}
		
		/**
		 * Setter
		 * @param n as a Node
		 */
		public void setNext(Node n) {
			
			n = next;
		}
		
/**
 * Getter
 * @return a Book
 */
		public Book getBook() {
			
			return book;
		}
		
		/**
		 * Getter 
		 * @return a Node
		 */
		public Node getNext() {
			
			return next;
		}

	}
	
	/**
	 * attribute
	 */
	private Node head;
	
	
	/**
	 * default constructor
	 */
	public BookList() {
		
		head = null;
		
	}
	
  
	/**
	 * method that takes a Book object and adds it to the start of the list
	 * @param book as a Book
	 */
	public void addToStart(Book book) {
		
	Node n = new Node(book);
	
	if(head == null) {
		
		head = n;
		head.next = head;
	}
	else {
		
		Node h = head;
		
		while(h.next != head) {
			
			h = h.next;
		}
		
//		h.next = n;
//		n.next = head;
		
		n.next = head;
		head = n;
		h.next = head;
		
	}
	
	
	}

	
	/**
	 * method that takes an integer and creates a file with all the records of that year
	 * @param yr as an Integer
	 */
	public void storeRecordsByYear(int yr) {
		
		String filename = yr + ".txt";
		
		Node h = head;
		
		

		try {
			
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
			
			while(h.next != head) {
				
				if( h.book.getYear() == yr) {
					
					pw.println(h.book.toString() + "\n");
					
				}
				
				h = h.next;
			}
			
			pw.close();
			
			
		}
		catch(IOException e) {
			
			e.getMessage();
		}
		
		
				
	}
	
	/**
	 * method that takes a book object and an isbn number and adds the book object before the book with that isbn number
	 * @param isbn as a Long
	 * @param book as a Book
	 * @return a boolean value
	 */
	public boolean insertBefore(long isbn, Book book) {
		
		if(head == null) {
			
			return false;
	        
		}
		
		Node h = head;
		Node p = null;
		
		do {
			
			if(h.book.getISBN() == isbn) {
				
				Node n = new Node(book);
				n.next = h;
				
				if(p == null) {
					
					Node x = head;
					
					while(x.next != head) {
						
						x = x.next;
					}
					
					head = n;
					x.next = head;
				}
				
				else {
					
					p.next = n;
					
				}
				
				return true;
			}
			
			p = h;
			h = h.next;
		}
		
		while(h != head);
		
		return false;
			
	}
			
					
			
		

	/**
	 * method that takes a book object and 2 isbn numbers and adds the book object between the books with the corresponding isbn numbers
	 * @param isbn1 as a Long
	 * @param isbn2 as a Long
	 * @param book as a Book
	 * @return a boolean value
	 */
	public boolean insertBetween(long isbn1, long isbn2, Book book) {
		
       if (head == null) {
    	   
			return false;
		}
      
       Node h = head;
       Node p = null;
       boolean found = false;
       
       while(h.next != head) {
    	   
    	   if(h.book.getISBN() == isbn1 && h.next.book.getISBN() == isbn2) {
    		   found = true;
    		   break;
    	   }
    	   
    	   p = h;
    	   h = h.next;
       }
       
       if(!found) {
    	   
    	   return false;
       }
       
       Node n = new Node(book);
       n.book = book;
       n.next = h.next;
       h.next = n;
       return true;
	
//       do {
//    	   
//    	   if(h.book.getISBN() == isbn1 && h.next.book.getISBN() == isbn2) {
//    		   
//    		   Node n = new Node(book);
//    		   
//    		   n.next = h.next;
//    		   h.next = n;
//    		   
//    		   return true;
//    	   }
//    	   
//    	   h = h.next;
//       }
//       
//       while(h != head);
//       
//       return false;
       
	}
	
	/**
	 * method that displays the content of the list
	 */
	public void displayContent() {
		 
	   
		 
	    if (head == null) {
	    	
	        System.out.println("List is empty");
	        return;
	    }
	    
	    else {
	        	
	        	Node h = head;
	        	
	        	do {
	        		
	        		System.out.println(h.book.toString() + " ==> ");
	                h = h.next;
	            } 
	        	while (h != head);
	        	
	            System.out.println("===> head");
	            
	        	}
	}

	
	   
	/**
	 * method that deletes the consecutive repeated records in the list
	 * @return a boolean value
	 */
	    public boolean delConsecutiveRepeatedRecords() {
	    	   	
	    	if (head == null) {
	            return false; // Empty list
	        }

	        Node current = head;
	        do {
	            if (current.next != null && current.book.equals(current.next.book)) {
	                // Found a repeated record
	                Node nextUnique = current.next.next;
	                while (nextUnique != current && nextUnique.book.equals(current.book)) {
	                    // Skip over all the consecutive repeated records
	                    nextUnique = nextUnique.next;
	                    
	                }
	                // Remove the consecutive repeated records
	                current.next = nextUnique;
	                
	            } else {
	                current = current.next;
	            }
	        } while (current != head);

	        return true; 
	    	
	    	
	    	
	    	}

	       
	   
	/**
	 * method that takes an author name and creates a list with the records of that author
	 * @param auth as a String
	 * @return a BookList
	 */
	public BookList extractAuthList(String aut) {
		
//	    BookList authorList = new BookList();
//	    
//	    Node h = head;
//	    
//	    while (h != null) {
//	    	
//	    	if(h.book.getAuthor().equals(aut)) {
//	    		
//	    		authorList.addToStart(h.book);
//	    	}
//	    	
//	    	h = h.next;
//	    }
//
//	    authorList.displayContent();
//	    return authorList;
		
		
		BookList authList = new BookList();
	    if (head == null) {
	      System.out.println("The list is empty.");
	      return authList;
	    }
	    Node temp = head;
	    do {
	      if (temp.book.getAuthor().equals(aut)) {
	        authList.addToStart(temp.book);
	      }
	      temp = temp.getNext();
	    } while (temp != head);
	    System.out.println("List of books by " + aut + ":");
	    authList.displayContent();
	    return authList;
	    
		
	}


	

	/**
	 * method that takes two isbn numbers and swaps their corresponding records
	 * @param isbn1 as a Long
	 * @param isbn2 as a Long
	 * @return a boolean value
	 */
	public boolean swap(long isbn1, long isbn2) {
		
		if (head == null ) {
			
	        return false; 
	    }
		
	Node i = null;
	Node h = head;
	
	do {
		
		if(h.book.getISBN() == isbn1 || h.book.getISBN() == isbn2) {
			
			break;
		}
		
		i = h;
		h = h.next;
	}
	
	while(h != head);
	
	if(h == head && h.book.getISBN() != isbn1 && h.book.getISBN() != isbn2) {
		
		return false;
	}
	
	Node n1 = h;
	Node n2 = h.next;
	
	while(n2 != head) {
		
		if(n2.book.getISBN() == isbn1 || n2.book.getISBN() == isbn2) {
			
			break;
		}
		
		n1 = n2;
		n2 = n2.next;
	}
	
	if(n2 == head && n2.book.getISBN() != isbn1 && n2.book.getISBN() != isbn2) {
		
		return false;
	}
	else {
		
		head = n2;
	}
	
	if(i != null) {
		
		i.next = n1;
	}
	else {
		
		head = n1;
	}
	
	Node n = n1.next;
	n1.next = n2.next;
	n2.next = n;
	
	return true;	
		
	}
	
	
	/**
	 * method that stores the contents of the list in a file called Update_Books.txt
	 * @throws FileNotFoundException and catches it
	 */
	public void commit() throws FileNotFoundException {
		
		try(PrintWriter pw = new PrintWriter("Update_Books.txt")){
			
			if(head == null) {
				
				return;
			}
			
			Node h = head;
			
			do {
				
				pw.println(h.book.toString());
				h = h.next;
			}
			
			while(h != head);
			pw.close();
		}
		
		catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
	   
		
		
	}
	
	
//	public boolean equals(Object c) {
//		if (!(this.getClass() == c.getClass())) {
//			return false;
//		}
//		BookList p = (BookList) c;
//		if (p.head == null || this.head == null)
//			return false;
//		Node t = this.head;
//	    Node ct = p.head;
//		
//		while (t.next != null) {
//			if (!(t.book.equals(ct.book))) {
//				return false;
//			} else {
//				t = t.next;
//				ct = ct.next;
//
//			}
//
//		}
//		return true;
//
//	}

	
	
	
	
	
}
