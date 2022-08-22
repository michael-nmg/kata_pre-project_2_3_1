package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void setUser(User user);

    User getUser(Long id);

    List<User> getUsers();

    void updateUser(User user);

    void removeUser(Long id);
}