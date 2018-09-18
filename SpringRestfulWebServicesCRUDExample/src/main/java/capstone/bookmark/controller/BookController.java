package capstone.bookmark.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import capstone.bookmark.bo.Book;
import capstone.bookmark.service.BookService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookController {

	BookService bookService = new BookService();

	@RequestMapping(value = "/books", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Book> getBooks() {
		System.out.println("Fetching books");
		List<Book> listOfCountries = bookService.getAllBooks();
		return listOfCountries;
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBook(id);
	}
	@RequestMapping(value = "/bookByCategory/{cat}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Book> getBookByCategory(@PathVariable String cat) {
		return bookService.getBooksByCategory(cat);
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST, headers = "Accept=application/json")
	public Book addBook(@RequestBody Book book) {
		System.out.println(book.getName());
		return bookService.addBook(book);
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Book updateBook(@RequestBody Book book) {
		System.out.println(book.getName());
		return bookService.updateBook(book);

	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);

	}	
}
