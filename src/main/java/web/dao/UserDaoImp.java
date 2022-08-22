package web.dao;

import web.model.User;

import java.util.List;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void setUser(User user) {
        entityManager.persist(user);
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getUsers() {
        return entityManager.createQuery("select usr from User usr", User.class).getResultList();
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void removeUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}