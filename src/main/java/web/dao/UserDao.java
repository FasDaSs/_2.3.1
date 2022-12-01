package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void updateUser(User user);
    void deleteUser(long id);
    User getById(long id);
}
