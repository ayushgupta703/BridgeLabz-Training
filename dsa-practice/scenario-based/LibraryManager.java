package scenario_based;

import java.util.HashMap;
import java.util.LinkedList;

class Book {
	String author;
	String title;
	
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return title + " by " + author;
	}
}

public class LibraryManager {
	HashMap<String, LinkedList<Book>> libraryMap;
	
	public LibraryManager() {
		libraryMap = new HashMap<String, LinkedList<Book>>();
	}
	
	public void returnBook(Book book, String genre) {
		if (!libraryMap.containsKey(genre)) {
			LinkedList<Book> setBooks = new LinkedList<>();
			setBooks.add(book);
			libraryMap.put(genre,setBooks);
		}
		else {
			LinkedList<Book> getBooks =  libraryMap.get(genre);
			getBooks.add(book);
		}
		System.out.println("Book returned successfully under genre \"" + genre + "\"");
	}
	
	public void borrowBook(Book book, String genre) {
		if (!libraryMap.containsKey(genre)) {
			System.out.println("Genre Not Found!!");
			return;
		}
		LinkedList<Book> getBooks =  libraryMap.get(genre);
		if (!getBooks.contains(book)) {
			System.out.println("Book Not Found!!");
			return;
		} else {
			getBooks.remove(book);
			System.out.println("Book Borrowed Successfully!!");
		}
		
		if (getBooks.isEmpty()) {
			libraryMap.remove(genre);
		}
	}
	
	public void printCatalog() {
	    if (libraryMap.isEmpty()) {
	        System.out.println("Library is empty.");
	        return;
	    }

	    for (String genre : libraryMap.keySet()) {
	        System.out.println("Genre: " + genre);
	        LinkedList<Book> books = libraryMap.get(genre);

	        for (Book book : books) {
	            System.out.println("  - " + book);
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		LibraryManager lm = new LibraryManager();
		
		Book book1 = new Book("Robin", "XYZ");
		Book book2 = new Book("Thomas", "ABC");
		Book book3 = new Book("Edison", "PQR");
		Book book4 = new Book("Newton", "ASDF");
		Book book5 = new Book("Tagore", "QWERTY");
		
		lm.returnBook(book1, "Literature");
		lm.returnBook(book2, "Computer");
		lm.returnBook(book3, "Electric");
		lm.returnBook(book4, "Science");
		lm.returnBook(book5, "Literature");
		
		lm.printCatalog();
		
		lm.borrowBook(book1, "Literature");
		
		lm.printCatalog();
	}
}
