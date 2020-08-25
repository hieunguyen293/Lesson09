package Lesson09.Model.DAO;

import Lesson09.Model.DTO.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    //Gia su no co ket noi voi DB roi
    ArrayList<Book> library = new ArrayList<>();
    //data access objects
//    public BookDAO(){
//        library.add(defaultBook);
//    }

    public ArrayList<Book> getAllBooks() {
        return library;
    }

    public boolean addBook(Book book) {
        try {
            library.add(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int deleteBook(String nameBook) {  //1 thanh cong, -1 that bai, 0 not found
        Book book = new Book();
        boolean isExistBook = false;

        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getName().equals(nameBook)) {
                book = library.get(i);
                isExistBook = true;
            }
        }
        if (isExistBook) {
            boolean resultDelete = library.remove(book);
            if (resultDelete) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public int updateBook(String nameOldBook, Book newBook) { // 1: Thanh cong, -1: Update that bai, 0: Khong tim thay sach
        int isBookExist = -1;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getName().equals(nameOldBook)) {
                isBookExist = i;
            }
        }
        if (isBookExist != -1) {
            library.set(isBookExist, newBook);
            if (library.get(isBookExist).getName().equals(newBook.getName())) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
    
    // Check Book Exist
    public boolean isExistBook(String nameBook) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getName().equals(nameBook)) {
                return true;
            }
        }
        return false;
    }
    
    // Create Book
    public Book createBook(String name, int price){
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        return book;
    }

}
