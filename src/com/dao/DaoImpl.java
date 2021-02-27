package com.dao;

import com.model.Book;
import com.model.Users;
import com.util.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    @Override
    public boolean createAccount(Users users) {
        boolean result = false;
        Connection c = null;  //Baza ile elaqe
        PreparedStatement ps = null;   //sql i icraya hazirlayir
        //RESULTSET  bazadan melumat getirir
        String sql = "insert into library_group1.users(name,surname,username,password,mail,address)\n"
                                      + "values ('" + users.getName() + "','" + users.getSurname() + "','" + users.getUsername() + "','" + users.getPassword() + "','" + users.getMail() + "','" + users.getAddress() + "')";

        c = DbHelper.getConnection();
        if (c != null) {
            try {
                ps = c.prepareStatement(sql);
                ps.execute();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                Utility.closeAll(c, ps, null);
            }
        } else {

            System.out.println("Not Connection");
        }
        return result;
    }

    @Override
    public boolean checkUserbyUsername(String username) {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from library_group1 .users\n"
                                      + "where username='" + username + "'";
        c = DbHelper.getConnection();
        if (c != null) {
            try {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    result = true;
                }

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                Utility.closeAll(c, ps, rs);
            }
        } else {
            System.out.println("Not Connection");
        }
        return result;
    }

    @Override
    public Users checkUser(String username, String password) {
        Users u = new Users();
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id,name,surname,username,password,mail,address from library_group1 .users\n"
                                      + "where username='" + username + "' and password = '" + password + "'";
        c = DbHelper.getConnection();
        if (c != null) {
            try {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    u.setId(rs.getInt("id"));
                    u.setName(rs.getString("name"));
                    u.setSurname(rs.getString("surname"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setMail(rs.getString("mail"));
                    u.setAddress(rs.getString("address"));
                } else {
                    u = null;
                }

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                Utility.closeAll(c, ps, rs);
            }
        } else {
            System.out.println("Not Connection");
        }
        return u;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<Book>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id,name,theme,author,page_count,amount,language,status from library_group1.book";
        c = DbHelper.getConnection();
        if (c != null) {
            try {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setName(rs.getString("name"));
                    book.setAmount(rs.getDouble("amount"));
                    book.setAuthor(rs.getString("author"));
                    book.setTheme(rs.getString("theme"));
                    book.setPageCount(rs.getInt("page_count"));
                    book.setLanguage(rs.getString("language"));
                    book.setStatus(rs.getString("status"));
                    allBooks.add(book);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                Utility.closeAll(c, ps, rs);
            }
        } else {
            System.out.println("No Connection");
        }
        return allBooks;
    }

    @Override
    public boolean addBook(Book newBook) {
    boolean result = false;
    Connection c = null;
    PreparedStatement ps = null;
     String sql = "insert into library_group1.book(name,theme,author,page_count,amount,language)\n"
     + "values ('" +newBook.getName()+ "','" +newBook.getTheme()+ "','" +newBook.getAuthor()+ "','" +newBook.getPageCount()+ "','"+newBook.getAmount()+"','"+newBook.getLanguage()+ "')";
    c = DbHelper.getConnection();
        if (c!=null) {
            try {
                ps = c.prepareStatement(sql);
                ps.execute();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                Utility.closeAll(c, ps, null);
            }
        } else {
            System.out.println("No Connection!");
        }
    return result;
    }

}
