
package Lesson09.Controller;

import Lesson09.Model.DAO.BookDAO;
import Lesson09.Model.DTO.Book;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    
    BookDAO bookDAO = new BookDAO();
    
    public ArrayList<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }
    
    public boolean addBook(Book book){
        if (bookDAO.addBook(book)) {
            return true;
        }
        return false;
    }
    
    public int deleteBook(String nameBook){
        return bookDAO.deleteBook(nameBook);
    }
    
    public int updateBook(String nameOldBook, Book newBook){
    return bookDAO.updateBook(nameOldBook, newBook);
    }
    
    public boolean isExistBook(String nameBook){
        return bookDAO.isExistBook(nameBook);
    }
    
    public Book createBook(String name, int price){
        return bookDAO.createBook(name, price);
    }
    
}
