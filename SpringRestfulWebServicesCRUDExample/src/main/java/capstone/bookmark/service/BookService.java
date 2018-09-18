package capstone.bookmark.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import capstone.bookmark.bo.Book;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class BookService {

 static HashMap<Integer,Book> BookIdMap=getBookIdMap();


 public BookService() {
  super();

  if(BookIdMap==null)
  {
   BookIdMap=new HashMap<Integer,Book>();
  // Creating some objects of Book while initializing
   Book book001=new Book(1, "Spring in Action", "Craig","Spring","",870);
   Book book002=new Book(2, "Head First Java", "Siera","Java","",550);
   Book book003=new Book(3, "Core Java", "Gary","Java","",520);
   Book book004=new Book(4, "Let us C","Kanitkar","C","",260);
   Book book005=new Book(5, "Spring and hibernate", "Santosh","Spring","",550);
   Book book006=new Book(6, "Java Complete Ref", "Schield","Java","",350);
   Book book007=new Book(7, "Understanding C", "Richard","C","",450);


   BookIdMap.put(1,book001);
   BookIdMap.put(2,book002);
   BookIdMap.put(3,book003);
   BookIdMap.put(4,book004);
   BookIdMap.put(5,book005);
   BookIdMap.put(6,book006);
   BookIdMap.put(7,book007);
  }
 }

 public List<Book> getAllBooks()
 {
  List<Book> books = new ArrayList<Book>(BookIdMap.values());
  return books;
 }

 public Book getBook(int id)
 {
  Book Book= BookIdMap.get(id);
  return Book;
 }
 
 public List<Book> getBooksByCategory(String cat)
 {
	 System.out.println("inside getBooksByCategory "+cat);
	 List<Book> books = new ArrayList<Book>(BookIdMap.values());
	 
  return books.stream().filter(book -> book.categoryMatch(cat))
			.collect(Collectors.toList());
 }
 
 public Book addBook(Book Book)
 {
  Book.setId(getMaxId()+1);
  BookIdMap.put(Book.getId(), Book);
  return Book;
 }
 
 public Book updateBook(Book Book)
 {
  if(Book.getId()<=0)
   return null;
  BookIdMap.put(Book.getId(), Book);
  return Book;

 }
 public void deleteBook(int id)
 {
  BookIdMap.remove(id);
 }

 public static HashMap<Integer, Book> getBookIdMap() {
  return BookIdMap;
 }
 

 // Utility method to get max id
 public static int getMaxId()
 {   int max=0;
 for (int id:BookIdMap.keySet()) {  
  if(max<=id)
   max=id;

 }  
 return max;
 }
}

