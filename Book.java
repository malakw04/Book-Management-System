

//-----------------------------------------------------
//Assignment 4
//Part: 1
//Written by: Malak Abdelkafy(40235257)
//-----------------------------------------------------


/**
 * Book Class
 * @author malakabdelkafy
 *
 */
public class Book {

	/**
	 * attributes
	 */
	private String title;
	private String author;
	private double price;
	private long ISBN;
	private String genre;
	private int year;
	
	/**
	 * default constructor
	 */
	public Book() {
		
	}
	
	/**
	 * Paramaterized constructor
	 * 
	 * @param t as a String
	 * @param a as a String
	 * @param p as a Double
	 * @param i as a Long
	 * @param g as a String
	 * @param y as a Integer
	 */
	public Book(String t, String a, double p, long i, String g, int y) {
		
		t = title;
		a = author;
		p = price;
		i = ISBN;
		g = genre;
		y = year;
		
		
	}
	
	/**
	 * Copy Constructor
	 * @param b as a Book
	 */
	public Book(Book b) {
		
		title = b.title;
		author = b.author;
		price = b.price;
		ISBN = b.ISBN;
		genre = b.genre;
		year = b.year;
		
	}
	
	/**
	 * Getter
	 * @return a String
	 */
	public String getTitle() {
        return title;
    }

	/**
	 * Setter
	 * @param title as a String
	 */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
	 * Getter
	 * @return a String
	 */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter
     * @param author as a String
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter
     * @return a Double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter
     * @param price as an Integer
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter
     * @return a Long
     */
    public long getISBN() {
        return ISBN;
    }

    /**
     * Setter
     * @param ISBN as a Long
     */
    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    /**
	 * Getter
	 * @return a String
	 */
    public String getGenre() {
        return genre;
    }

    /**
     * Setter
     * @param genre as a String
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Getter
     * @return an Integer
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter
     * @param year as a Integer
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    
   /**
    * toString method to return a string of the contents of the Book object
    */
    public String toString() {
    	
    	return  title + "," + author + "," + price + "," + ISBN + ","+ genre + "," + year;  
    	
    }
    
    /**
     * equals method to compare two Book objects
     */
    public boolean equals(Object o) {
    	
    	 if (o == null || o.getClass() != this.getClass()) {
             return false;
         }
         
         
         Book other = (Book) o;
         return this.title == other.title
             && this.author == other.author
             && this.price == other.price
             && this.ISBN == other.ISBN
             && this.genre == other.genre
             && this.year == other.year;
     }
    	
    }
    

    

	


