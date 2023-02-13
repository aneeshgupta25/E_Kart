package com.example.acmegradefinalassessment.data.db.userdb;

import com.example.acmegradefinalassessment.data.model.User;

public interface UserDatabaseInterface {
    boolean checkEmailAlreadyExists(String email);
    void addUserToDB(User user);
    String getUser(String email);
}
