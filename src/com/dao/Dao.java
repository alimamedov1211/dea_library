
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
}
