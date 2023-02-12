package com.example.acmegradefinalassessment.data.db.userdb;

import com.example.acmegradefinalassessment.data.model.User;

public interface UserDatabaseInterface {
    public boolean checkEmailAlreadyExists(String email);
    public void addUserToDB(User user);
}
