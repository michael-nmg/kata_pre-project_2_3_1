package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.dao.UserDao;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void setUser(User user) {
        userDao.setUser(user);
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }
}
