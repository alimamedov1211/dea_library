package com.dao;

import com.model.Book;
import com.model.Users;
import java.util.List;

public interface Dao {

    public boolean createAccount(Users users);

    public boolean checkUserbyUsername(String username);

    public Users checkUser(String username, String password);

    public List<Book> getAllBooks();

    public boolean addBook(Book newBook);

    public boolean updateBook(Book book);

    public List<Book> searchBook(String keywords);

    public List<Book> filterBookByAmount(double min, double max);

    public List<Book> filterBookByPageCount(double min, double max);

    public boolean updateBookByStatus(int selectedId);

    public boolean deleteBook(int selectedId);
    
    public List<Book> filterBookByStatus(String status);
}
