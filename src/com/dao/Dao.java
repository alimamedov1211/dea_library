
package com.dao;

import com.model.Users;


public interface Dao {
    public boolean createAccount(Users users);
    public boolean checkUserbyUsername(String username);
    public Users checkUser(String username, String password);
}
